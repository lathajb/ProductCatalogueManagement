package com.product.catalogue.management.repository;

import java.util.List;

import com.product.catalogue.management.dto.Product;


/**
 * 
 * @author M1032933
 * ProductCatalogueManageRepository
 */
public interface ProductCatalogueManageRepository {
	
	
	
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
	void removeProduct(Integer id);
	
	/**
	 * getNextSequenceNumber
	 * @param key
	 * @return
	 */
	Integer getNextSequenceNumber(String key);

}
