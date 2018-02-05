/**
 * 
 */
package com.product.catalogue.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.catalogue.management.dto.Product;
import com.product.catalogue.management.service.ProductCatalogueManageService;

/**
 * @author M1032933
 *
 */
@RestController
@RequestMapping("/productcatalogue")
public class ProductCatalogueManageController {

		Logger logger = LoggerFactory.getLogger(ProductCatalogueManageController.class);
		
		@Autowired
		ProductCatalogueManageService productCatManageService;
		
		
		/**
		 * getUserHomePage
		 * @return index page
		 */
		@RequestMapping(value="/home")
		public String getProductHomePage(){
			logger.info("Return Request summary Page View ");
			return "index";
		}
		
		/**
		 * fetchProductsByType - to fetch a products by given type
		 * @return product 
		 */
		@RequestMapping(value = "/getProduct/{type}", method=RequestMethod.GET)
		public ResponseEntity<List<Product>> fetchProductsByType(@PathVariable String type) {
			logger.debug("Inside fetchProductsByType method ");
			List<Product> products = productCatManageService.fetchProductsByType(type);
			logger.debug("ProductCatalogueManageController - fetch products by given type completed successfully");
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
			
			
		}
		
		/**
		 * addProduct - used to save a new product
		 * @param product
		 */
		@RequestMapping(value = "/addProduct", method=RequestMethod.POST)
		public ResponseEntity<Product> addProduct(@RequestBody Product product) {
			logger.debug("Inside addProduct method execution starts ");
			productCatManageService.addProduct(product);
			logger.debug("Inside addProduct method execution completed ");
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		
		
		
		/**
		 * removeProduct - used to deleted a specific product
		 * @param product
		 */
		@RequestMapping(value = "/removeProduct/{id}", method=RequestMethod.DELETE)
		public ResponseEntity removeProduct(@PathVariable Integer id) {
			logger.debug("Inside removeProduct method execution starts ");
			productCatManageService.removeProduct(id);
			logger.debug("Inside removeProduct method execution completed ");
			return new ResponseEntity(HttpStatus.OK);	
		}
		
	
	
}
