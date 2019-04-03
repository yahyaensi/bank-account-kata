package com.kata.bank.account.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.kata.bank.account.Account;

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
	
	private List<Operation> operationList = new ArrayList<>();

	@Override
	public void depositMoney(BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawMoney(BigDecimal amount) {
		// TODO Auto-generated method stub
	}

	@Override
	public BigDecimal getBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasSufficientBalance(BigDecimal amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Operation> getHistory() {
		// TODO Auto-generated method stub
		return null;
	}

}
