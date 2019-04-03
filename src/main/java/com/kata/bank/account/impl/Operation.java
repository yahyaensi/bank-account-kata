package com.kata.bank.account.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents an account operation.
 * 
 * @author Yahya
 * @version 1.0.0
 */
public class Operation {
	
	/**
	 * Either 'deposit(+)' or 'withdrawal (-)'
	 */
	private String type;
	
	/**
	 * Operation date.
	 */
	private LocalDateTime dateTime;
	
	/**
	 * Operation amount.
	 */
	private BigDecimal amount;
	
	/**
	 * Account balance after operation success.
	 */
	private BigDecimal balance;

	/**
	 * @return the operation type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the operation type to set
	 */
	public void setOperation(String type) {
		this.type = type;
	}

	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	

}
