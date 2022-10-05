package io.github.vartikasingh.corejava.project.atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

	private int customerNumber;
	private int pinNumber;
	private double currentBalance = 0;
	private double savingBalance = 0;

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat(" '$'###, ##0.00");

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int setCustomerNumber(int customerNumber) { // setCustomerNumber have return so the return type is changed to
														// its datatype.
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	/*
	 * no getter and setters bcz we need calculate the amount , they can just return
	 * the value
	 */
	public double getCurrentBalance() {
		return currentBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public double calcCurrentWithdraw(double amount) {
		currentBalance = (currentBalance - amount);
		return currentBalance;
	}

	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;

	}

	public double calcCurrentDeposit(double amount) {
		currentBalance = (currentBalance - amount);
		return currentBalance;

	}

	public double calcSavingtDeposit(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;

	}

	public void getCurrentWithdrawInput() { // business logic
		System.out.println("Current Account Balance:" + moneyFormat.format(currentBalance));
		System.out.println("Amount you want to withdraw from current account:");
		double amount = input.nextDouble(); // converting the amount into double

		if ((currentBalance - amount) >= 0) { // checking the new balance amount after deducting the amount that was
												// withdrawn
			/*
			 * This method is being used here public double calcCurrentWithdraw(double
			 * amount) { currentBalance = (currentBalance - amount); return currentBalance;
			 * }
			 */
			calcCurrentWithdraw(amount);
			System.out.println("New Current Account Balance: " + moneyFormat.format(currentBalance));
		} else {
			System.out.println("Balance Cannot be negative." + "\n");
		}

	}

	public void getCurrentDepositInput() {
		System.out.println("Current Account Balance: " + moneyFormat.format(currentBalance));
		System.out.println("Amount you want to deposit from the Current Account: ");
		double amount = input.nextDouble();

		if ((currentBalance + amount) >= 0) {
			/*
			 * public double calcCurrentDeposit(double amount) { currentBalance =
			 * (currentBalance - amount); return currentBalance;
			 * 
			 * }
			 */
			calcCurrentDeposit(amount);
			System.out.println("New Current Amount Balance: " + moneyFormat.format(currentBalance));
		} else {
			System.out.println("Balance cannot be Negative." + "\n");
		}
	}

	public void getSavingDepositInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.println("Amount you want to deposit into saving account: ");
		double amount = input.nextDouble();

		if ((savingBalance + amount) >= 0) {
			/*
			 * public double calcSavingtDeposit(double amount) { savingBalance =
			 * (savingBalance - amount); return savingBalance;
			 * 
			 * }
			 */
			calcSavingtDeposit(amount);
			System.out.println("New saving amount balance: " + moneyFormat.format(savingBalance));
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}

	public void getSavingWithdrawInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.println("Amount you want to withdraw from saving account: ");
		double amount = input.nextDouble();

		if ((savingBalance - amount) >= 0) {
			/*
			 * public double calcSavingWithdraw(double amount) { savingBalance =
			 * (savingBalance - amount); return savingBalance;
			 * 
			 * }
			 */
			calcSavingWithdraw(amount);
			System.out.println("New Saving Balance: " + moneyFormat.format(savingBalance));
		}else {
			System.out.println("Balance cannot be Negative." + "\n");
		}
	}

}
