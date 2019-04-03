package com.kata.bank.account.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kata.bank.account.Account;
import com.kata.bank.exception.InsufficientBalanceException;

/**
 * Implementation of customer account.
 * 
 * @author Yahya
 * @version 1.0.0
 */
public class AccountImpl implements Account {

	/**
	 * Account's balance.
	 */
	private BigDecimal balance = BigDecimal.ZERO;

	/**
	 * Operations history holder.
	 */
	private List<Operation> operationList = new ArrayList<>();

	@Override
	public void depositMoney(BigDecimal amount) throws IllegalArgumentException {
		if ((amount == null) || (amount.compareTo(BigDecimal.ZERO) == -1)) {
			throw new IllegalArgumentException("The amount to deposit must be a positive number");
		}
		balance = balance.add(amount);
		operationList.add(new Operation("+", LocalDateTime.now(), amount, balance));
	}

	@Override
	public void withdrawMoney(BigDecimal amount) throws InsufficientBalanceException, IllegalArgumentException {
		if ((amount == null) || (amount.compareTo(BigDecimal.ZERO) == -1)) {
			throw new IllegalArgumentException("The amount to withdraw must be a positive number");
		}
		if (!hasSufficientBalance(amount)) {
			throw new InsufficientBalanceException(balance, amount);
		}
		balance = balance.subtract(amount);
		operationList.add(new Operation("-", LocalDateTime.now(), amount, balance));
	}

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public boolean hasSufficientBalance(BigDecimal amount) {
		if (balance.compareTo(amount) == -1) {
			return false;
		}
		return true;
	}

	@Override
	public List<Operation> getHistory() {
		return operationList;
	}

	@Override
	public void showHistory() {
		operationList.forEach(System.out::println);

	}

}
