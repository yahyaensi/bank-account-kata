package com.kata.bank.account.impl;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

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
        fail("not yet implemented");
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        fail("not yet implemented");
    }
    
    /**
     * Checks that we cannot add a null amount.
     */
    @Test
    public void testAddNullAmount() {
    	fail("not yet implemented");
    }
    
    /**
     * Checks that we cannot add a null amount.
     */
    @Test
    public void testAddNegativeAmount() {
    	fail("not yet implemented");
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     */
    @Test
    public void testWithdrawAnAmountGreaterThanBalanceException() {
    	fail("not yet implemented");
    }
    
    /**
     * Withdraws money from the account and checks that the new balance is as expected.
     */
    @Test
    public void testWithdrawAnAmountSmallerThanBalance() {
    	fail("not yet implemented");
    }
    
    /**
     * Tests that after a successful withdrawal the operation is saved.
     */
    @Test
    public void testOperationSavedAfterSuccessfulWithdrawal() {
    	fail("not yet implemented");
    }
    
    /**
     * Tests that after a successful deposit the operation is saved.
     */
    @Test
    public void testOperationSavedAfterSuccessfulDeposit() {
    	fail("not yet implemented");
    }
    
    /**
     * Tests that after a successful deposit the operation is saved.
     */
    @Test
    public void testOperationNotSavedAfterIllegalWithdrawal() {
    	fail("not yet implemented");
    }

}
