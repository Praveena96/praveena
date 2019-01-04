package com.ecomm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;
@Controller
public class CategoryController
{
@Autowired
CategoryDAO categoryDAO;


@RequestMapping(value="/category")
public String showCategory(Model m)
{

         List<Category> listCategories=categoryDAO.listCategories();
         m.addAttribute("listCategories",listCategories);
          return "Category";
}

@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategoryDetail(@RequestParam("categoryName")String CategoryName,@RequestParam("categoryDesc")String CategoryDesc,Model m)
	{
		Category category=new Category();
		category.setCategoryName(CategoryName);
		category.setCategoryDesc(CategoryDesc);

		        
                List<Category> listCategories=categoryDAO.listCategories();
                m.addAttribute("listCategories",listCategories);
                categoryDAO.add(category);
		        return "Category";
		
	}


@RequestMapping(value="/deleteCategory/{categoryId}")
public String deleteCategory(@PathVariable("categoryId") int CategoryId,Model m)
{
                  Category category=categoryDAO.getCategory(CategoryId);
                  categoryDAO.delete(category);

                 List<Category> listCategories=categoryDAO.listCategories();
                  m.addAttribute("listCategories",listCategories);
		         
		          return "Category";

	
}

@RequestMapping(value="/editCategory/{categoryId}",method=RequestMethod.POST)
public String editCategory(@PathVariable("categoryId") int CategoryId,Model m)
{

                 Category category=categoryDAO.getCategory(CategoryId);
                 m.addAttribute("category",category);
                 
                 return "UpdateCategory";
}
@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
public String updateCategoryDetail(@RequestParam("categoryId")int CategoryId,@RequestParam("categoryDesc")String CategoryDesc,@RequestParam("categoryName")String CategoryName,Model m)
{


                Category category=categoryDAO.getCategory(CategoryId);
                category.setCategoryName(CategoryName);
                category.setCategoryDesc(CategoryDesc);

                categoryDAO.update(category);  


                List<Category> listCategories=categoryDAO.listCategories();
                m.addAttribute("listCategories",listCategories);
		
		        return "Category";
}

}