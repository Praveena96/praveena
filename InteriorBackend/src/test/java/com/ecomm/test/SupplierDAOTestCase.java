package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Supplier;

public class SupplierDAOTestCase
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		
}
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(3);
		supplier.setSupplierName("praveena");
		supplier.setSupplierAddr("chennai");
		assertTrue("problem in adding the supplier:",supplierDAO.add(supplier));
		
	}
	
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(3);
		supplier.setSupplierName("tamil");
		supplier.setSupplierAddr("ond");
		assertTrue("Problem in updating the supplier",supplierDAO.update(supplier));
		
	}
	
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(3);
		assertTrue("Problem in deleting the supplier",supplierDAO.delete(supplier));
		
	}
	
	@Test
	public void listSuppliersTest()	
	{
		List<Supplier> listSupplier=supplierDAO.listsupplier();
		assertTrue("problem in listing categories",listSupplier.size()>0);
		for(Supplier supplier :listSupplier)
		{
			System.out.print(supplier.getSupplierId()+"::");
			System.out.print(supplier.getSupplierName()+"::");
			System.out.print(supplier.getAddr()+"::");
			
	
	}
	}
}