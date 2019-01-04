package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category 
{
    @Id
   @GeneratedValue
   int CategoryId;
   String CategoryName;
   String CategoryDesc;
   
   public Category()
   {
   
   }

public int getCategoryId() {
	return CategoryId;
}
public void setCategoryId(int categoryId) {
	CategoryId = categoryId;
}
public String getCategoryName() {
	return CategoryName;
}
public void setCategoryName(String categoryName) {
	CategoryName = categoryName;
}
public String getCategoryDesc() {
	return CategoryDesc;
}
public void setCategoryDesc(String categoryDesc) {
	this.CategoryDesc = categoryDesc;
}

}
