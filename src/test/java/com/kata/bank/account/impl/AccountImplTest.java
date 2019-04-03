package com.kata.bank.account.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.*;

import com.kata.bank.exception.InsufficientBalanceException;

public class AccountImplTest {

	AccountImpl customerAccount;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		customerAccount = new AccountImpl();
	}

	/**
	 * Empty account has a 0.0 balance.
	 */
	@Test
	public void testEmptyAccountHasZeroBalance() {
		assertNotNull("An empty account must have a not null balance", customerAccount.getBalance());
		assertEquals("An empty account must have a balance of 0.0", BigDecimal.ZERO, customerAccount.getBalance());
	}

	/**
	 * Adds money to the account and checks that the new balance is as expected.
	 */
	@Test
	public void testDepositPositiveAmount() {
		BigDecimal amountToDeposit = new BigDecimal("10");
		customerAccount.depositMoney(amountToDeposit);
		assertEquals("The balance must be 10", amountToDeposit, customerAccount.getBalance());
	}

	/**
	 * Checks that we cannot deposit a null amount.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDepositNullAmount() {
		customerAccount.depositMoney(null);
	}

	/**
	 * Checks that we cannot deposit a null amount.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDepositNegativeAmount() {
		customerAccount.depositMoney(new BigDecimal("-5"));
	}

	/**
	 * Checks that we cannot withdraw a null amount.
	 * 
	 * @throws InsufficientBalanceException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawNullAmount() throws InsufficientBalanceException {
		customerAccount.withdrawMoney(null);
	}

	/**
	 * Checks that we cannot withdraw a null amount.
	 * 
	 * @throws InsufficientBalanceException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawNegativeAmount() throws InsufficientBalanceException {
		customerAccount.withdrawMoney(new BigDecimal("-5"));
	}

	/**
	 * Tests that an illegal withdrawal throws the expected exception.
	 * 
	 * @throws InsufficientBalanceException
	 */
	@Test(expected = InsufficientBalanceException.class)
	public void testWithdrawAnAmountGreaterThanBalanceException() throws InsufficientBalanceException {
		customerAccount.depositMoney(new BigDecimal("10"));
		customerAccount.withdrawMoney(new BigDecimal("20"));
	}

	/**
	 * Withdraws money from the account and checks that the new balance is as
	 * expected.
	 * 
	 * @throws InsufficientBalanceException
	 */
	@Test
	public void testWithdrawAnAmountSmallerThanBalance() throws InsufficientBalanceException {
		customerAccount.depositMoney(new BigDecimal("20.66"));
		customerAccount.withdrawMoney(new BigDecimal("20"));
		assertEquals("The account must cotains 0.66 after withdrawal", new BigDecimal("0.66"),
				customerAccount.getBalance());
	}

	/**
	 * Tests that after a successful deposit the operation is saved.
	 */
	@Test
	public void testOperationSavedAfterSuccessfulDeposit() {
		BigDecimal amountToDeposit = new BigDecimal("20.66");
		customerAccount.depositMoney(new BigDecimal("20.66"));
		assertEquals("The saved operation type must be a +", "+", customerAccount.getHistory().get(0).getType());
		assertEquals("The saved operation amount must be a 20.66", amountToDeposit,
				customerAccount.getHistory().get(0).getAmount());
		assertEquals("The saved operation balance must be a 20.66", amountToDeposit,
				customerAccount.getHistory().get(0).getBalance());
	}

	/**
	 * Tests that after a successful withdrawal the operation is saved.
	 * 
	 * @throws InsufficientBalanceException
	 */
	@Test
	public void testOperationSavedAfterSuccessfulWithdrawal() throws InsufficientBalanceException {
		customerAccount.depositMoney(new BigDecimal("20.66"));
		customerAccount.withdrawMoney(new BigDecimal("20"));
		assertEquals("The saved withdrawal operation type must be a -", "-",
				customerAccount.getHistory().get(1).getType());
		assertEquals("The saved withdrawal operation amount must be a 20", new BigDecimal("20"),
				customerAccount.getHistory().get(1).getAmount());
		assertEquals("The saved withdrawal operation balance must be a 0.66", new BigDecimal("0.66"),
				customerAccount.getHistory().get(1).getBalance());
	}

	/**
	 * Tests that after a successful deposit the operation is saved.
	 */
	@Test
	public void testOperationNotSavedAfterIllegalWithdrawal() {
		customerAccount.depositMoney(new BigDecimal("10"));
		try {
			customerAccount.withdrawMoney(new BigDecimal("20"));
		} catch (InsufficientBalanceException e) {
			assertEquals("The saved deposit operation type must be a +", "+",
					customerAccount.getHistory().get(0).getType());
			assertEquals("The saved withdrawal operation is not saved", 1, customerAccount.getHistory().size());
		}
	}

	/**
	 * Tests show history.
	 * 
	 * @throws InsufficientBalanceException
	 * @throws InterruptedException
	 */
	@Test
	public void testShowHistory() throws InsufficientBalanceException, InterruptedException {
		customerAccount.depositMoney(new BigDecimal("30.658"));
		Thread.sleep(2000);
		customerAccount.withdrawMoney(new BigDecimal("20.44"));
		customerAccount.showHistory();
	}

}
