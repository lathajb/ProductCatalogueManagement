package com.product.catalouge.management.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.product.catalogue.management.ProductCatalogueManagementApplication;
import com.product.catalogue.management.controller.ProductCatalogueManageController;
import com.product.catalogue.management.dto.Product;

import com.product.catalogue.management.service.ProductCatalogueManageService;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.List;




@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProductCatalogueManagementApplication.class)
@WebMvcTest(ProductCatalogueManageController.class)
public class ProductCatalogueManageControllerTests {

	@Autowired
    MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
    @MockBean
    ProductCatalogueManageService productCatalogueManageServiceMock;
    
    List<Product> list = null;
    @Before
    public void setUp() {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
    @Test
    public void testProductCreate() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.post("/productcatalogue/addProduct")
    	        .contentType(MediaType.APPLICATION_JSON)
    	        .content("{\"id\" : \"5\", \"productName\" : \"bottles\",\"productType\" : \"packed\" }")
    			.accept(MediaType.APPLICATION_JSON))
    			.andExpect(jsonPath("$.id").exists())
    			.andDo(print());
    	
    }
    
    @Test
    public void testRemoveProduct() throws Exception{
    	mockMvc.perform(MockMvcRequestBuilders.delete("/productcatalogue/removeProduct/9").accept(MediaType.APPLICATION_JSON))
		.andDo(print());
    }
    
    @Test
    public void testFetchProductByType() throws Exception{
    	 mockMvc.perform(MockMvcRequestBuilders.get("/productcatalogue/getProduct/packed")
    			 .accept(MediaType.APPLICATION_JSON))
    	 		 .andDo(print());	
    }
	
	
}
