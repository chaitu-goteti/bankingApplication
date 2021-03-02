package com.temporal.bankingApp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temporal.bankingApp.components.CustomerAccount;
import com.temporal.bankingApp.components.CustomersList;

@Service
public class AccountService {

	@Autowired
	CustomersList customers;
	
	public double getBalance(String custId) {

		Map<String, CustomerAccount> accountsMap = customers.getCustomersMap();
		double balance;
		switch (custId) {
		case "A":
			balance =  accountsMap.get(custId).getBalance();
			break;
		case "B":
			balance =  accountsMap.get(custId).getBalance();
			break;
		case "C":
			balance =  accountsMap.get(custId).getBalance();
			break;
		case "D":
			balance =  accountsMap.get(custId).getBalance();
			break;
		default:
			balance = -1;
		}
		return balance;
	}

	public void updateBalance(String custId, double amt) {
		CustomerAccount custAccount = customers.getCustomersMap().get(custId);
		custAccount.setBalance(custAccount.getBalance()+amt);
		customers.getCustomersMap().put(custId, custAccount);
	}
}
