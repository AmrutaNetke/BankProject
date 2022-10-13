package org.java.bank;

public class AccountHolders {
	private String accountHolderName;
	private long mobileNumber;
	private String address;
	private String panNumber;
	private Account account;

	public AccountHolders(String accountHolderName,long mobileNumber,String address, String panNumber, Account account){
		this.accountHolderName=accountHolderName;
		this.mobileNumber= mobileNumber;
		this.address=address;
		this.panNumber= panNumber;
		this.account=account;

	}

	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName=accountHolderName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long  mobileNumber) {
		this.mobileNumber=mobileNumber;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}

	public String getPanNumber() {
		return accountHolderName;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber=panNumber;
	}


	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account=account;
	}
}

