package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Supplier;
@Repository("supplierDAO")
@Transactional

public class SupplierDAOImpl implements SupplierDAO
{
@Autowired
SessionFactory sessionFactory;
	public boolean add(Supplier supplier)
	{
		try
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
			
		}
	}

	public boolean delete(Supplier supplier) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
			
		}
	}

	public boolean update(Supplier supplier)
	{
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
			
		}		
	}

	public List<Supplier> listsupplier()
	{
		Session session =sessionFactory.openSession();
		Query<Supplier> query=session.createQuery("from Supplier");
		List<Supplier> listSuppliers=query.list();
		return listSuppliers;
		
	}

	public Supplier getSupplier(int supplierId)
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
		session.close();
		return supplier;

	}

	
}
