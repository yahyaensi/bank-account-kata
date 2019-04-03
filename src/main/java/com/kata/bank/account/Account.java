package com.kata.bank.account;

import java.math.BigDecimal;
import java.util.List;

import com.kata.bank.account.impl.Operation;
import com.kata.bank.exception.InsufficientBalanceException;

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
	public void depositMoney(BigDecimal amount) throws IllegalArgumentException;

	/**
	 * Withdraws money from the account.
	 * 
	 * @param amount
	 *            the money to withdraw
	 */
	public void withdrawMoney(BigDecimal amount) throws InsufficientBalanceException, IllegalArgumentException;

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
	 * Returns account operations history.
	 */
	List<Operation> getHistory();

	/**
	 * Shows account operations history.
	 */
	void showHistory();

}
