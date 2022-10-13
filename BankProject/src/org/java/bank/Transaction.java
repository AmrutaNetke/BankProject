package org.java.bank;

public interface Transaction {
	public abstract void deposit(String userName,long accountNumber, double amount);
	public abstract void withdraw(String userName,long accountNumber, double amount);
}
