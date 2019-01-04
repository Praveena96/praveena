package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

@Controller
public class ProductController 
{
@Autowired
ProductDAO productDAO;

@Autowired
CategoryDAO categoryDAO;

@Autowired
SupplierDAO supplierDAO;

@RequestMapping(value="/product")
public String showProductPage(Model m)
{
List<Product> listProducts=productDAO.listProduct();
m.addAttribute("prodtt",listProducts);

Product product=new Product();
m.addAttribute("product",product);

m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
m.addAttribute("supplierList",this.getSupplier(supplierDAO.listsupplier()));

return "Product";
}
@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile prodImage,Model m)
{
	
	System.out.println("Product Name:"+product.getProductName());
	System.out.println("Product Desc:"+product.getProductDesc());
	System.out.println("Category ID:"+product.getCategoryId());
	System.out.println("Price:"+product.getPrice());
	System.out.println("Stock:"+product.getStock());
	productDAO.addProduct(product);
	

	
	
	String path="D:\\devops proj\\frontproject\\src\\main\\webapp\\resources\\images\\";
	
	path=path+String.valueOf(product.getProductId())+".jpg";
	
	File imageFile=new File(path);
	
	if(!prodImage.isEmpty())
	{
		try
		{
			byte[] buffer=prodImage.getBytes();
			FileOutputStream fos=new FileOutputStream(imageFile);
			BufferedOutputStream bs=new BufferedOutputStream(fos);
			bs.write(buffer);
			bs.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			m.addAttribute("Error","Exception Occured during the Image Uploading"+e);	
		}
	}
	else
	{
		System.out.println("error occured");
		m.addAttribute("Error","Error Occured during the Image Uploading");
	}
	
	Product product1=new Product();
	m.addAttribute(product1);
	
	List<Product> listProducts=productDAO.listProduct();
	m.addAttribute("prodtt", listProducts);
	
	m.addAttribute("categoryList", this.getCategoryList(categoryDAO.listCategories()));
	m.addAttribute("supplierList",this.getSupplier(supplierDAO.listsupplier()));

	return "Product";
}
@RequestMapping(value="/editproduct/{productId}",method=RequestMethod.GET)
public String editCategory(@PathVariable("productId")long productId,Model m)
{

                 Product product=productDAO.getProduct(productId);
                 m.addAttribute("product",product);
                 
                 return "UpdateProduct";
}
@RequestMapping(value="/updateproduct",method=RequestMethod.GET)
public String updateProductDetail(@PathVariable("productId")long productId,@RequestParam("productName")String productName,@RequestParam("price")int price,Model m)
{


                Product product=productDAO.getProduct(productId);
                product.setProductName(productName);
                product.setPrice(price);

                productDAO.updateProduct(product);  

                List<Product> listProducts=productDAO.listProduct();
         	    m.addAttribute("prodtt",listProducts);
         	   
         	   return "Product";
         	
     
}



@RequestMapping(value="/deleteProduct/{productId}")
public String deleteProduct(@PathVariable("productId")long productId,Model m)
{
	Product product=productDAO.getProduct(productId);
	productDAO.deleteProduct(product);
	
	Product product1=new Product();
	m.addAttribute("product",product1);
	
	   List<Product> listProducts=productDAO.listProduct();
	   m.addAttribute("prodtt",listProducts);
	   
	   return "Product";
	
}
public LinkedHashMap<Integer,String> getCategoryList(List<Category> listCategory)
{
	LinkedHashMap<Integer,String> listCategories=new LinkedHashMap<Integer,String>();
	
		for(Category category:listCategory)
		{
			listCategories.put(category.getCategoryId(),category.getCategoryName());
			
		}
		return listCategories;
}
public LinkedHashMap<Integer,String> getSupplier(List<Supplier> listSupplier)
{
	LinkedHashMap<Integer,String> listsupplier=new LinkedHashMap<Integer,String>();
	
		for(Supplier supplier:listSupplier)
		{
			listsupplier.put(supplier.getSupplierId(),supplier.getSupplierName());
			
		}
		return listsupplier;
	
}
@RequestMapping(value="/showproduct")
public String ShowProduct(Model m)
{
	   List<Product> listProducts=productDAO.listProduct();
	   m.addAttribute("prodtt",listProducts);
	   
	   return "ShowProduct";	
}
@RequestMapping(value="/totalshowproduct/{productId}")
public String TotalShowProduct(@PathVariable("productId") long productId,Model m)
{
Product product=productDAO.getProduct(productId);
m.addAttribute("prodtt",product);

  return "TotalShowProduct";
}
}