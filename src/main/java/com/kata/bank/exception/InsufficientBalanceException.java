package com.kata.bank.exception;

import java.math.BigDecimal;

/**
 * Indicates if the account doesn't have sufficient balance for a withdrawal
 * operation.
 * 
 * @author Yahya
 * @version 1.0.0
 */
public class InsufficientBalanceException extends Exception {

	/**
	 * serial version id.
	 */
	private static final long serialVersionUID = 4877246458417536119L;

	/**
	 * Constructor.
	 * 
	 * @param currentBalance
	 *            current account balance
	 * @param amountToWithdraw
	 *            the amount to withdraw
	 */
	public InsufficientBalanceException(BigDecimal currentBalance, BigDecimal amountToWithdraw) {
		super("You can't retreive " + amountToWithdraw + " because your account balance is " + amountToWithdraw);
	}
}