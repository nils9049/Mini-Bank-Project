package com.account.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountMain {

	static Map credentials = new HashMap();

	public static void main(String[] args) {

		SBIBankAccount accountOne = new SBIBankAccount(1234, "Nilesh", 100, 50000.0);
		SBIBankAccount accountTwo = new SBIBankAccount(5678, "Vishal", 200, 80000.0);
		credentials.put(accountOne.getUserName(), accountOne);
		credentials.put(accountTwo.getUserName(), accountTwo);

		while (true) {
			System.out.println("Login Screen:");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter username:");
			String userName = sc.next();
			System.out.println("Enter password:");
			int passcode = sc.nextInt();

			SBIBankAccount tempCred = (SBIBankAccount) credentials.get(userName);

			if (tempCred != null && passcode == tempCred.getPassword()) {
				boolean login = true;
				while(login) {
					System.out.println("Enter your choice:");
					System.out.println("1.Check Balance");
					System.out.println("2.Send Money");
					System.out.println("3.Exit");
					int choice = sc.nextInt();
				
					switch(choice) {
						case 1:
						{
							System.out.println("Balance:" + tempCred.getAmount());
							break;
						}
						case 2: 
						{
							System.out.println("Enter Receiver Username:");
							String receiverUserName = sc.next();
							SBIBankAccount receiverCred = (SBIBankAccount) credentials.get(receiverUserName);
							if (receiverCred != null) {
								System.out.println("Enter transfer amount:");
								double amount = sc.nextDouble(); // 100
								receiverCred.setAmount(receiverCred.getAmount() + amount);	
								credentials.put(receiverUserName, receiverCred);
								tempCred.setAmount(tempCred.getAmount() - amount);
								credentials.put(tempCred.getUserName(), tempCred);
					            System.out.println("Ammount transfered successfully...!!");
							}
							break;
						}
						case 3:
						{
							login = false;
							break;
						}
					}
				}
			} else {
				System.out.println("Invalid Credentials, Please try again!");
			}
		}
	}
}
