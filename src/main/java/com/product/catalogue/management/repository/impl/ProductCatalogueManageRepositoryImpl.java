package com.product.catalogue.management.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.product.catalogue.management.dto.Product;
import com.product.catalogue.management.repository.ProductCatalogueManageRepository;
import com.product.catalogue.management.util.SequenceId;

/**
 * ProductCatalogueManageRepositoryImpl  - Data access layer
 * 
 * @author M1032933
 *
 */
@Repository
public class ProductCatalogueManageRepositoryImpl implements ProductCatalogueManageRepository{

	@Autowired
    MongoTemplate mongoTemplate;
	
	@Autowired
	MongoOperations mongoOperation;
	
	
	
	
	/**
	 * fetchProductsByType - To fetch all products
	 * @return List<Product>
	 */
	@Override
	public List<Product> fetchProductsByType(String type) {
		Query query3 = new Query();
		query3.addCriteria(Criteria.where("productType").in(type));
		List<Product> products = mongoTemplate.find(query3, Product.class);
		return products;
		
	}
	

	/**
	 * removeProduct - To delete a specific product
	 */
	public void removeProduct(Integer id) {
		Product product = new Product();
		product.setId(id);
		mongoTemplate.remove(product);	
		
	}

	
	/**
	 * getNextSequenceNumber - to generate next sequence number
	 */
	public Integer getNextSequenceNumber(String key) {
		Query query = new Query(Criteria.where("_id").is(key));
		Update update = new Update();
		update.inc("seq", 1);
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		SequenceId seqId = (SequenceId) mongoOperation.findAndModify(query, update, options, SequenceId.class);
		return seqId.getSeq();		
	}

	
	/**
	 * addProduct - To add a new product
	 */
	public void addProduct(Product product) {
		product.setId(getNextSequenceNumber("_id"));
		mongoTemplate.save(product);
	}

	
}
