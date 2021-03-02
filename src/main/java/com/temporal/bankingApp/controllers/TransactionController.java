package com.temporal.bankingApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temporal.bankingApp.workers.MoneyTransferWorker;
import com.temporal.service.InitiateMoneyTransfer;

@RestController
public class TransactionController {
	
	@Autowired
	MoneyTransferWorker moneyTransferWorker;
	
	@RequestMapping(value = "/initiateTransfer", method = RequestMethod.POST)
	public void initiateTransfer(@RequestParam(value = "fromAccount") String fromAccount,
			@RequestParam(value = "toAccount") String toAccount, 
			@RequestParam(value = "amount") double amount) {

		try {
			new InitiateMoneyTransfer().initiateMoneyTransfer(fromAccount, toAccount, amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/approveTransfer", method=RequestMethod.GET)
	public void approveTransfer() {
		moneyTransferWorker.approveTransactions();
	}
}
