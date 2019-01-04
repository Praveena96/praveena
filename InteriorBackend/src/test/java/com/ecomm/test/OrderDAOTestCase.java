package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.OrderDAO;
import com.ecomm.model.OrderDetail;

public class OrderDAOTestCase
{
	static OrderDAO orderDAO;
	
@BeforeClass
public static void executeFirst()
{
   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
   context.scan("com.ecomm");
   context.refresh();
    orderDAO=(OrderDAO)context.getBean("orderDAO");
}

@Test
public void paymentProcessTest()
{
	OrderDetail orderDetail=new OrderDetail();
	 orderDetail.setUserName("ammu");
	 orderDetail.setOrderDate(new Date());
	 orderDetail.setPaymentmode("CC");
	 orderDetail.setTotalAmount(7500);
 assertTrue("Problem in entering Payment:",orderDAO.paymentProcess(orderDetail));
   
}

@Test
public void updateCartTest()
{
	
	assertTrue("Problem in entering Payment:",orderDAO.updateCartItemsStatus("pravee"));
	

}
}
