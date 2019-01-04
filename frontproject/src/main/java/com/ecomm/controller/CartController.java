package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;

@Controller
public class CartController 
{
@Autowired	
CartDAO cartDAO;

@Autowired
ProductDAO productDAO;



@RequestMapping(value="/cart")
public String showCart(Model m,HttpSession session)
{
        String  username=(String)session.getAttribute("username");
        
         List<Cart> listCartItems=cartDAO.listCartItems(username);
         m.addAttribute("cartItems",listCartItems);
         m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
         
          return "Cart";
}


@RequestMapping(value="/addToCart/{productId}")
public String addToCart(@PathVariable("productId") int productId,@RequestParam("quantity") int quantity,Model m,HttpSession session)
{
	Cart cart=new Cart();
	String username=(String)session.getAttribute("username");
	
	
	
	Product product=productDAO.getProduct(productId);
	cart.setProductId(productId);
	cart.setPrice(product.getPrice());
	cart.setProductName(product.getProductName());
	cart.setQuantity(quantity);
	cart.setStatus("N");
	cart.setUsername(username);
	
	
	cartDAO.addToCart(cart);
	
	
	List<Cart> listCartItems=cartDAO.listCartItems(username);
	m.addAttribute("cartItems",listCartItems);
	m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
	return "Cart";
}
public int calcGrandTotalPrice(List<Cart> listCartItems)
{
	int grandTotal=0;
	int count=0;
	
	while(count<listCartItems.size())
	{
		Cart cart=listCartItems.get(count);
		grandTotal=grandTotal+(cart.getQuantity()*cart.getPrice());
		count++;
		
	}
	      return grandTotal;
	      
}

@RequestMapping(value="/updateCartItems/{cartId}")
public String updateCartItems(@PathVariable("cartId")int cartId,@RequestParam("quantity") int quantity,Model m,HttpSession session)
{
	String  username=(String)session.getAttribute("praveena");
       
	Cart cart=cartDAO.getCartItems(cartId);
	cart.setQuantity(quantity);
	
	cartDAO.updateCartItems(cart);
	
	List<Cart> listCartItems=cartDAO.listCartItems(username);
	m.addAttribute("cartItems",listCartItems);
	m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
	return "Cart";
}

@RequestMapping(value="/deleteCartItems/{cartId}")
public String deleteCartItems(@PathVariable("cartId")int cartId,Model m,HttpSession session)
{
	
    String  username=(String)session.getAttribute("praveena");
       
	Cart cart=cartDAO.getCartItems(cartId);
	cartDAO.deleteItemFromCart(cart);
	
	List<Cart> listCartItems=cartDAO.listCartItems(username);
	m.addAttribute("cartItems",listCartItems);
	m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
	
	return "Cart";
}
@RequestMapping(value="/checkout")
public String checkout(Model m,HttpSession session)
{
	String username=(String)session.getAttribute("username");
	List<Cart> listCartItems=cartDAO.listCartItems(username);
	m.addAttribute("lablecart",listCartItems);
	m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
	
	return  "OrderConfirm";
}
}
