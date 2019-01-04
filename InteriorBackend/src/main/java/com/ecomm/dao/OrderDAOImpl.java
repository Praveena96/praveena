package com.ecomm.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.OrderDetail;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO
{

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean paymentProcess(OrderDetail orderDetail) 
	{
	try
	{
		sessionfactory.getCurrentSession().save(orderDetail);
		return true;
	}
	catch(Exception e)
	{
	return false;	
	}
	}

	@Override
	public boolean updateCartItemsStatus(String username) 
	{
		try
		{
			Session session=sessionfactory.openSession(); 
			Query query=session.createQuery("update cart set status='P' where username=:uname");
			query.setParameter("uname",username);
			int row_eff=query.executeUpdate();
	if(row_eff>0)
			return true;
	else
		return false;
				
	     }
		catch(Exception e)
		{
		return false;	
		}
	}

}
