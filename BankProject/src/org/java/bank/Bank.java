package org.java.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank implements Transaction{
	private String bankName;
	private String ifscCode;
	private String address;

	double savingAccountBalance=0;
	double currentAccountBalance=0;
	private Map<String,AccountHolders > map= new HashMap<String,AccountHolders>();
	public Bank(String bankName,String ifscCode, String address)
	{
		this.bankName= bankName;
		this.ifscCode=ifscCode;
		this.address= address;
	}

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName=bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode=ifscCode;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}


	public void addToMap(String accountHolderName, AccountHolders accountHolders) {
		map.put(accountHolderName, accountHolders);
	}

	public Map<String, AccountHolders> getFromMap() {
		return map; 
	}

	//Method to deposit amount
	public void deposit(String userName,long accountNumber, double amount) {
		if(map.get(userName).getAccount().getAccountNumber() == accountNumber) {
			map.get(userName).getAccount().setAccountBalance(map.get(userName).getAccount().getAccountBalance()+amount);
			System.out.println("Deposited amount successfully ");
			System.out.println("Balance is: " +map.get(userName).getAccount().getAccountBalance());
		}

	}
	//Method to withdraw amount
	public void withdraw(String userName, long accountNumber, double amount) {
		if(map.get(userName).getAccount().getAccountNumber() == accountNumber ) {
			if(map.get(userName).getAccount().getAccountBalance() > amount) {
				map.get(userName).getAccount().setAccountBalance(map.get(userName).getAccount().getAccountBalance()-amount);
				System.out.println("Withdrawl amount successfully");
				System.out.println("Balance is: " +map.get(userName).getAccount().getAccountBalance());
			}
			else {
				System.out.println("Cannot withdraw money. You do not have sufficient balance");
			}
		}
	}

	//	Calculate total of savings and current accounts 
	public void calculateBalance() {
		for (Map.Entry<String, AccountHolders> entry : map.entrySet()) {
			String key = entry.getKey();
			if(map.get(key).getAccount().getAccountType().equalsIgnoreCase("saving")) {
				savingAccountBalance=savingAccountBalance + map.get(key).getAccount().getAccountBalance();
			}
			else {
				currentAccountBalance=currentAccountBalance+map.get(key).getAccount().getAccountBalance();
			}
		}
	}

	//	To show list of Savings account
	public void showListOfSavingAccounts() {
		int count = 1;
		for (Map.Entry<String, AccountHolders> entry : map.entrySet()) {
			AccountHolders eachHolder = entry.getValue();
			if(eachHolder.getAccount().getAccountType().equalsIgnoreCase("saving")) {
				System.out.println(" "+count);
				System.out.println("Account number: "+eachHolder.getAccount().getAccountNumber());
				System.out.println("Holder name: "+eachHolder.getAccountHolderName());
				System.out.println("Holder Address: "+eachHolder.getAddress());
				System.out.println("Holder Mobile number "+eachHolder.getMobileNumber());
				System.out.println("Holder Balance: "+eachHolder.getAccount().getAccountBalance());
				count++; 
			}
		}
	}

	//	To show list Of Current account
	public void showListOfCurrentAccounts() {
		int count = 1;
		for (Map.Entry<String, AccountHolders> entry : map.entrySet()) {
			AccountHolders eachHolder = entry.getValue();
			if(eachHolder.getAccount().getAccountType().equalsIgnoreCase("current")) {
				System.out.println(" "+count);
				System.out.println("Account number: "+eachHolder.getAccount().getAccountNumber());
				System.out.println("Holder name: "+eachHolder.getAccountHolderName());
				System.out.println("Holder Address: "+eachHolder.getAddress());
				System.out.println("Holder Mobile number "+eachHolder.getMobileNumber());
				System.out.println("Holder Balance: "+eachHolder.getAccount().getAccountBalance());
				count++; 
			}
		}
	}
}

