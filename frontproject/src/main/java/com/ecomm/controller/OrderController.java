package com.ecomm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.OrderDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.UserDetail;

@Controller
public class OrderController
{
@Autowired
CartDAO cartDAO;

@Autowired
OrderDAO orderDAO;

@Autowired
UserDAO userDAO;

@RequestMapping(value="/payment")
public String PaymentProcess(@RequestParam("paymentmode")String Paymentmode,Model m,HttpSession session)
{
	
	String username=(String)session.getAttribute("username");
	List<Cart> listCartItems=cartDAO.listCartItems(username);
	
	OrderDetail orderDetail=new OrderDetail();
	orderDetail.setUserName(username);
	orderDetail.setOrderDate(new Date());
	orderDetail.setPaymentmode(Paymentmode);
	orderDetail.setTotalAmount(this.calcGrandTotalPrice(cartDAO.listCartItems(username)));
	m.addAttribute("cartItems",cartDAO.listCartItems(username));
	m.addAttribute("PaymentDetail",orderDetail);
	
	if(orderDAO.updateCartItemsStatus(username))
	{
		orderDAO.paymentProcess(orderDetail);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("Paymentdetail",orderDetail);
		UserDetail userdetail=userDAO.getUser(username);
		m.addAttribute("userdetail",userdetail);
	}
	return "Receipt";
	}
public int calcGrandTotalPrice(List<Cart> listCartitems)
{
	int GrandTotal=0;
	int count=0;
	while(count<listCartitems.size())
	{
		Cart cart=listCartitems.get(count);
		GrandTotal=GrandTotal+(cart.getQuantity()*cart.getPrice());
		count++;
	}
	return GrandTotal;
}
}
