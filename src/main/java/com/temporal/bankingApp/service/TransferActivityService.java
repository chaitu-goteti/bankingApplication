package com.temporal.bankingApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temporal.activity.AccountActivity;
import com.temporal.bankingApp.components.CustomerAccount;
import com.temporal.bankingApp.components.CustomersList;
import com.temporal.service.AccountActivityImpl;

@Service
public class TransferActivityService implements AccountActivity {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountActivityImpl.class);

	@Autowired
	public CustomersList customersList;

	@Override
	public void withdraw(String accountId, String referenceId, double amount) {

		CustomerAccount fromCustomer = customersList.getCustomersMap().get(accountId);
		if (fromCustomer.getBalance() > amount) {
			fromCustomer.setBalance(fromCustomer.getBalance() - amount);
		}

		LOGGER.info("Withdrawing ${} from account {}. ReferenceId: {}", amount, accountId, referenceId);
	}

	@Override
	public void deposit(String accountId, String referenceId, double amount) {

		CustomerAccount toCustomer = customersList.getCustomersMap().get(accountId);
		toCustomer.setBalance(toCustomer.getBalance() + amount);
		LOGGER.info("Depositing ${} into account {}. ReferenceId: {}", amount, accountId, referenceId);
	}

}
