package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

public class ProductDAOTestCase
{
static ProductDAO productDAO;
@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ecomm");
	context.refresh();
	productDAO=(ProductDAO)context.getBean("productDAO");
}

@Test
public void addProductTestCase()
{
	Product product=new Product();
	product.setProductName("dress");
	product.setProductDesc("look  very nice");
    product.setPrice(2500);
    product.setStock(150);
    product.setSupplierId(123);
    product.setCategoryId(1);  
     assertTrue ("problem in adding the Product",productDAO.addProduct(product));
}

@Test
public void updateCategoryTest()
{
	Product product=productDAO.getProduct(2);
	product.setProductName("LC");
	product.setProductDesc("mobile");
	assertTrue ("Problem in updating the Category",productDAO.updateProduct(product));
}
@Test
public void deleteCategoryTest()
{
	Product product=productDAO.getProduct(133);
	product.setProductName("LC");
	product.setProductDesc("mobile");
	assertTrue ("Problem in deleting the Category",productDAO.deleteProduct(product));
}


@Test
public void listProductTestCase()
{
List<Product> listProduct=productDAO.listProduct();
assertTrue("problem in listing Products",listProduct.size()>0);
for(Product product :listProduct)
{
	System.out.println(product.getProductId()+"::");
	System.out.println(product.getProductName()+"::");
	System.out.println(product.getPrice()+"::");
	System.out.println(product.getStock()+"::");
	System.out.println(product.getCategoryId()+"::");
	System.out.println(product.getSupplierId()+"::");
	System.out.println(product.getProductDesc()+"::");
	
	
}
}
}
