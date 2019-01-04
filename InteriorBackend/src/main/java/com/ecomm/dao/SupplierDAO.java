package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Supplier;;

public interface SupplierDAO
{
	public boolean add(Supplier supplier);
	public boolean delete(Supplier supplier);
	public boolean update(Supplier supplier);
	public List<Supplier> listsupplier();
	public Supplier getSupplier(int supplierId);
	}



