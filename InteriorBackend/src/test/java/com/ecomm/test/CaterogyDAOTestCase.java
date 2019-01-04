package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CaterogyDAOTestCase
{
 static CategoryDAO categoryDAO;


@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ecomm");
	context.refresh();
	categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	
}

@Test
public void addCategoryTest()
{
	Category category=new Category();
	category.setCategoryName("washing machine");
	category.setCategoryDesc("corner flower pots");
	assertTrue ("Problem in adding the Category",categoryDAO.add(category));
	
}


@Test
public void updateCategoryTest()
{
	Category category=categoryDAO.getCategory(125);
	category.setCategoryName("LC");
	category.setCategoryDesc("mobile");
	assertTrue ("Problem in updating the Category",categoryDAO.update(category));
}

@Test
public void deleteCategoryTest()
{
	
	Category category=categoryDAO.getCategory(121);
	category.setCategoryName("washing machine");
	category.setCategoryDesc("corner flower pots");
	assertTrue ("Problem in deleting the Category",categoryDAO.delete(category));
	
}
public void ListCategoriesTest()
{
	List<Category> listCategories=categoryDAO.listCategories();
	assertTrue ("Problem in list the Category",listCategories.size()>0);
	for(Category category:listCategories)
	{
		System.out.println("Category ID:"+category.getCategoryId());
		System.out.println("Category Name:"+category.getCategoryName());
		System.out.println("Category Desc:"+category.getCategoryDesc());
		
	}
} 
}
