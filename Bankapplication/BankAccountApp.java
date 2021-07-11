package Bankapplication;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		List<Account> accounts = new LinkedList<Account>();
		
		
		
		
		/*
		Checking account1 = new Checking("Tom samuel", "345673289", 1500);
		Savings account2 = new Savings("Rich lowe", "346787678", 2500);
	
		account2.showInfo();
		System.out.println("****************");
		account1.showInfo();
		account1.compound();
		*/
	
		//Read a CSV File then create new accounts based on that data
		String file = "NewBankAccounts.txt";
		List<String[]> newAccountHolder = Utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolder) {
			System.out.println("NEW ACCOUNT");
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			//System.out.println(name + " " + sSN + " " + accountType + " $" + initDeposit);
			if(accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
			}
			else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, sSN, initDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		//accounts.get(5).showInfo();
		
		for (Account acc : accounts) {
			System.out.println("\r************");
			acc.showInfo();
		}

	}

}
