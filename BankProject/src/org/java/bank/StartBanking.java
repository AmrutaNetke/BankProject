package org.java.bank;
/*
Use case number 15 => Display the list of savings, 
current account and display consolidated available amount in savings
and current amount
 */

import java.util.Random;
import java.util.Scanner;

public class StartBanking {

	public static void main(String[] args) {
		Bank bank= new Bank("State bank of India","SBI123054","India");
		Scanner sc= new Scanner(System.in);
		int input=0;

		do {
			System.out.println("Enter number as per action you want to perform ");
			System.out.println("Enter 1 to Open Account\r\n"
					+"Enter 2 to Deposit Amount\r\n"
					+"Enter 3 to Withdraw Amount\r\n"
					+ "Press 7 to exit");

			input=sc.nextInt();

			switch(input) {
			case 1:
				System.out.println("Proceed further to create an account:");
				System.out.println("Please Enter your Name");
				sc.nextLine();
				String accountHolderName=sc.nextLine();

				System.out.println("Please Enter your mobile number");
				long mobileNumber=sc.nextLong();

				sc.nextLine();
				System.out.println("Please Enter your User Address");
				String address=sc.nextLine();

				System.out.println("Please Enter your Pan number");
				String panNumber=sc.nextLine();

				System.out.println("Enter Account Type you want to create");
				String accountType=sc.nextLine();

				System.out.println("Enter initial amount you want to deposit");
				double initialAmount = sc.nextDouble();

				Random random= new Random();
				int accountNumber=Math.abs(random.nextInt());
				Account account=new Account(accountNumber,accountType,initialAmount);
				AccountHolders accountHolder = new AccountHolders(accountHolderName, mobileNumber, address, panNumber,account);

				bank.addToMap(accountHolderName,accountHolder);
				System.out.println("Created account successfully ");
				System.out.println("Your Balance is: "+ bank.getFromMap().get(accountHolderName).getAccount().getAccountBalance());
				System.out.println("Account Number is: "+bank.getFromMap().get(accountHolderName).getAccount().getAccountNumber());
				break;

			case 2:
				System.out.println("Enter Your Name");
				sc.nextLine();
				String accountHolderName2=sc.nextLine();

				System.out.println("Enter Your Account Number");
				long accountNumber2=sc.nextLong();

				System.out.println("Enter Amount to deposit");
				double amountToDeposit = sc.nextDouble();

				bank.deposit(accountHolderName2, accountNumber2, amountToDeposit);
				break;

			case 3:
				System.out.println("Enter Your Name");
				sc.nextLine();
				String accountHolderName3 = sc.nextLine();

				System.out.println("Enter Your Account Number");
				long accountNumber3=sc.nextLong();

				System.out.println("Enter Amount to withdraw");
				double amountToWithdraw = sc.nextDouble();

				bank.withdraw(accountHolderName3,accountNumber3, amountToWithdraw);
				System.out.println();
				break;

			}
		}while(input!=7);
		bank.calculateBalance();
		System.out.println("* Total of Saving account = "+bank.savingAccountBalance);
		System.out.println("List of Savings account=>  ");
		bank.showListOfSavingAccounts();

		System.out.println("* Total of Current account = "+bank.currentAccountBalance);
		System.out.println("List of Current account=>  ");
		bank.showListOfCurrentAccounts();
	}
}








