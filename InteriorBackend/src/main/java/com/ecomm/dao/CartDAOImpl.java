package com.ecomm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO
{

	@Autowired
	SessionFactory sessionfactory;
	
	public boolean addToCart(Cart cart) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised");
			return false;
		}
	}
	
	public boolean updateCartItems(Cart cart) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised");
			return false;
		}
	}
	
	@Override
	public boolean deleteItemFromCart(Cart cart) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised");
			return false;
		}	
	}

	@Override
	public boolean updateCartItems(String username)
	{
		try
		{
			Session session=sessionfactory.openSession();
			Query query=session.createQuery("upadte Cart set status='p' where usernsme=:unmae");
			query.setParameter("uname",username);
			int row_eff=query.executeUpdate();
			if(row_eff>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised");
			return false;
		}	
	}

	
	public Cart getCartItems(int cartId) 
	{
		Session session=sessionfactory.openSession();
		Cart cart=session.get(Cart.class, cartId);
		session.close();
		return cart;
		
	}

	
	
	public List<Cart> listCartItems(String username)
	{

		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("from Cart where username=:uname and status='N'");
		query.setParameter("uname",username);
        List<Cart> listCartItems=query.list();
		return listCartItems;
		
	}

}
