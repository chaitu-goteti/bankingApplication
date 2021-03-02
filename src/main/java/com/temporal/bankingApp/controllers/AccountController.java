package com.temporal.bankingApp.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temporal.bankingApp.service.AccountService;

@RestController
public class AccountController {

	public static final Logger LOGGER = Logger.getLogger(AccountController.class);
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/getBalance", method = RequestMethod.POST)
	public double getBalance(@RequestParam(value="custId") String custId) {
		
		return accountService.getBalance(custId);
	}
}
