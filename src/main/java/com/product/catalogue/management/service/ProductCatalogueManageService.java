package com.product.catalogue.management.service;

import java.util.List;

import com.product.catalogue.management.dto.Product;
import com.product.catalouge.management.exception.ProductNotFoundException;



public interface ProductCatalogueManageService {
	
	
	/**
	 * fetchProductsByType
	 * @param product type
	 * @return List<Product>
	 */
	List<Product> fetchProductsByType(String type);
	
	/**
	 * addProduct
	 * @param product
	 */
	void addProduct(Product product);
	
	/**
	 * removeProduct
	 * @param product id
	 */
	void removeProduct(Integer id)throws ProductNotFoundException;

}
