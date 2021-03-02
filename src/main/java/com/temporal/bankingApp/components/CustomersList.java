package com.temporal.bankingApp.components;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomersList {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomersList.class);
	Map<String, CustomerAccount> customersMap = new HashMap<String, CustomerAccount>();

	public CustomersList() {
		LOGGER.info("Creating Customers");
		init();
	}
	
	
	@PostConstruct
	public void init() {
		customersMap.put("A", new CustomerAccount("A", 1000.00));
		customersMap.put("B", new CustomerAccount("B", 20000.28));
		customersMap.put("C", new CustomerAccount("C", 3000.99));
		customersMap.put("D", new CustomerAccount("D", 10000.20));

	}

	/**
	 * @return the customersMap
	 */
	public Map<String, CustomerAccount> getCustomersMap() {
		return customersMap;
	}
	
}
