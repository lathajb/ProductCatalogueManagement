/**
 * 
 */
package com.product.catalogue.management.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.catalogue.management.dto.Product;
import com.product.catalogue.management.repository.ProductCatalogueManageRepository;
import com.product.catalogue.management.service.ProductCatalogueManageService;
import com.product.catalouge.management.exception.ProductNotFoundException;


/**
 * @author M1032933
 * ProductCatalogueManageServiceImpl
 */
@Service
public class ProductCatalogueManageServiceImpl implements ProductCatalogueManageService {

	Logger logger = LoggerFactory.getLogger(ProductCatalogueManageServiceImpl.class);
	
	@Autowired
	ProductCatalogueManageRepository productCatManageRepo;
	
	/** 
	 * fetchProductsByType
	 */
	@Override
	public List<Product> fetchProductsByType(String type) {
		
		List<Product> lists = null; 
		
		try{
			lists = productCatManageRepo.fetchProductsByType(type);
		}catch(Exception ex){
			logger.error("Exception occured inside fetchProductsByType method ");	
			
		}
		
		return lists;
		
	}

	/**
	 * addProduct
	 */
	@Override
	public void addProduct(Product product) {
		productCatManageRepo.addProduct(product);
	}

	/**
	 * removeProduct
	 */
	@Override
	public void removeProduct(Integer id) throws ProductNotFoundException{
		try{
			productCatManageRepo.removeProduct(id);
		}catch(Exception e){
			throw new ProductNotFoundException(e.getMessage())	;
		}
	}

}
