package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Cart;

public interface CartDAO 
{
  public boolean addToCart(Cart cart);
  public boolean deleteItemFromCart(Cart cart);
  public boolean updateCartItems(Cart cart);
  public Cart getCartItems(int cartId);
  public List<Cart> listCartItems(String username);
  public boolean updateCartItems(String username);
}

