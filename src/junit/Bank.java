/*
 * Jacob Richardson
 * CSC 429 Spring 2019
 * Final Exam.
 */

package junit;

public class Bank 
{

	public long accno;
	public double amount;
	public double withdraw;
	
	public double depositeMoney(long accountno, double amount) 
	{
		this.accno=accountno;
		this.amount+=amount;
		return amount;
	}
	
	public double withdraweMoney(long accountno, double amount) throws InvalidFundsException 
	{
		this.accno=accountno;

		if (this.amount>= amount) 
		{
	       this.amount-=amount;
		}
		else
		{
			throw new InvalidFundsException("Insufficient Balance");
		}

		return this.amount;
	}
	
	public double checkBalance() 
	{
	
		return this.amount;
	}

}