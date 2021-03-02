package com.temporal.bankingApp.components;

import org.springframework.stereotype.Component;

@Component
public class CustomerAccount {

	private String customerId;
	
	private double balance;
	
	public CustomerAccount() {
		
	}
	
	public CustomerAccount(String customerId, Double balance) {
		this.customerId = customerId;
		this.balance = balance;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {	
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "CustomerAccount [customerId=" + customerId + ", balance=" + balance + "]";
	}

	
}
