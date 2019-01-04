package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartDAO;
import com.ecomm.model.Cart;

public class CartDAOTestCase
{
	
static CartDAO cartDAO;

@BeforeClass

public static void executeFirst()
{
AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
context.scan("com.ecomm");
context.refresh();
cartDAO=(CartDAO)context.getBean("cartDAO");
}

@Test
public void addCartTest()
{
Cart cart=new Cart();
cart.setProductId(5);
cart.setProductName("lap");
cart.setQuantity(2);
cart.setUsername("pravee");
cart.setPrice(25000);
cart.setStatus("N");

assertTrue("Problem in adding the Item to Cart:",cartDAO.addToCart(cart));
}


@Test
public void listCartItemsTest()
{
	List<Cart> listCartItems=cartDAO.listCartItems("pravee");
	
for(Cart cart:listCartItems)
	{
		System.out.println("CartID:"+cart.getCartId());
		System.out.println("CartPrice:"+cart.getPrice());
		System.out.println("ProductName:"+cart.getProductName());
		
	}
	assertTrue ("Problem in Displaying CartItems:",listCartItems.size()>0);
	
}

@Test
public void updateCatItemTest()
{
	Cart cart=cartDAO.getCartItems(1);
	cart.setQuantity(6);
	assertTrue ("Problem in updating the CartItem:",cartDAO.updateCartItems(cart));
	
	}
}


