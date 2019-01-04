package com.ecomm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class OrderDetail 
{
@Id
@GeneratedValue

int OrderId;
String UserName;
Date OrderDate;
int TotalAmount;
String Paymentmode;
public int getOrderId() {
	return OrderId;
}
public void setOrderId(int orderId) {
	OrderId = orderId;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public Date getOrderDate() {
	return OrderDate;
}
public void setOrderDate(Date orderDate) {
	OrderDate = orderDate;
}
public int getTotalAmount() {
	return TotalAmount;
}
public void setTotalAmount(int totalAmount) {
	TotalAmount = totalAmount;
}
public String getPaymentmode() {
	return Paymentmode;
}
public void setPaymentmode(String paymentmode) {
	Paymentmode = paymentmode;
}
}
