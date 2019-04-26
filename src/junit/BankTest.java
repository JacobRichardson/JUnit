/*
 * Jacob Richardson
 * CSC 429 Spring 2019
 * Final Exam.
 */

package junit;

//JUnit Imports.
import org.junit.*;
import static org.junit.Assert.*;

public class BankTest 
{

	@Test
	public void testDeposit()
	{
		//Create a new bank object.
		Bank b = new Bank();
		
		//Variable for the account number.
		int accountNo = 1;
		
		//Variable for the amount to be deposited into the account.
		double amount = 25;
		
		//Deposit 25 dollars into account 1 and store the result into new amount.
		double newTotal = b.depositeMoney(accountNo, amount);
		
		//Make sure the amount and new total are equal.
		assertEquals(amount, newTotal, 0);
	}
	
	@Test (expected = Exception.class)
	public void testInvalidWithdrawl() throws Exception
	{
		//Create a new bank object.
		Bank b = new Bank();
		
		//Variable for the amount to be withdrawn from the account.
		double amount = 100;
		
		//Make sure the account has less than the desired amount to be withdraw to make sure an exception occurs.
		assertTrue(b.checkBalance() < amount);
		
		//Withdraw the amount to cause an exception.
		b.withdraweMoney(1, 100);
		
	}
	
	@Test
	public void testValidWithdrawl() throws InvalidFundsException
	{
		//Create a new bank object.
		Bank b = new Bank();
		
		//Variable for the account number.
		int accountNo = 1;
		
		//Variable for the amount to be withdrawn into the account.
		double withdrawAmount = 100;
		
		//Variable for inital account balance.
		double initalAccountBalance = 200;
		
		//Deposit the inital amount balance into the account.
		b.depositeMoney(accountNo, initalAccountBalance);
		
		//Make sure the account has more than the desired amount to be withdraw to make sure an exception does not occur.
		assertTrue(b.checkBalance() > withdrawAmount);
		
		//Withdraw the amount from the account.
		b.withdraweMoney(accountNo, withdrawAmount);
		
	}
	
    public static junit.framework.Test suite() 
    {
        return new junit.framework.JUnit4TestAdapter(BankTest.class);
    }
    
    public static void main(String args[]) 
    {
    	org.junit.runner.JUnitCore.main("BankTest");
    }

}