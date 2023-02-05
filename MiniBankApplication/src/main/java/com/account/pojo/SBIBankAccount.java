package com.account.pojo;

public class SBIBankAccount {

	private int accountNumber;
	private String userName;
	private long password;
	private double amount;
	
	public SBIBankAccount(int accountNumber, String userName, long password, double amount) {
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.password = password;
		this.amount = amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getPassword() {
		return password;
	}

	public void setPassword(long password) {
		this.password = password;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
}
