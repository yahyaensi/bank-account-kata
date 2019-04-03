package com.kata.bank.account;

import java.math.BigDecimal;

/**
 * Customer account contract.
 * 
 * @author Yahya
 * @version 1.0.0
 */
public interface Account {

	/**
	 * Adds money to the account.
	 * 
	 * @param amount
	 *            the money to add
	 */
	public void depositMoney(BigDecimal amount);

	/**
	 * Withdraws money from the account.
	 * 
	 * @param amount
	 *            the money to withdraw
	 */
	public void withdrawMoney(BigDecimal amount);

	/**
	 * Gets the account balance.
	 * 
	 * @return the account's balance
	 */
	public BigDecimal getBalance();
	
    /**
     * Checks if the account has a sufficient balance
     * 
	 * @param amount
	 *            the money to withdraw
     */
    boolean hasSufficientBalance(BigDecimal amount);
    
    /**
     * 
     */
    void showHistory();

}
