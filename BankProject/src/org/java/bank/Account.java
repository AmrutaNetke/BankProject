package org.java.bank;

public class Account {
	private  long accountNumber;
	private  String accountType;
	private  double accountBalance;
	private long trasactionID;
	public Account(long accountNumber,String accountType,double accountBalance){
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber=accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType=accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance=accountBalance;
	}

	public long getTrasactionID() {
		return trasactionID;
	}
	public void setTransactionID(long accountBalance) {
		this.trasactionID=trasactionID;
	}


}
