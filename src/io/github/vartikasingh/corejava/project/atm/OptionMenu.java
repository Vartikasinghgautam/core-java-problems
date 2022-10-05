package io.github.vartikasingh.corejava.project.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account { // as we can see OptionMenu class is extending the accounts class so
											// INHERITANCE is being used here
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat(" '$'###,##0.00");

	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>(); // storing the value for the account numbers

	public void getLogin() throws IOException {
		int x = 1;
		do {
			try {
				data.put(952141, 191904); // 1st is customer number and 2nd is the associated pin number with that
											// number
				data.put(989947, 71976);

				System.out.println("Welcome to the ATM Project!");
				System.out.println("Enter the customer number:");
				setCustomerNumber(menuInput.nextInt());

				System.out.println("Enter your PIN Number:");
				setPinNumber(menuInput.nextInt());
			} catch (Exception e) {
				System.out.println("\n" + "Invalid character(s). Only Numbers." + " \n");
				x = 2;
			}

			/*
			 * for(Map.Entry<Integer, Integer> it: data.entrySet()){
			 * if(it.getKey()==getCustomerNumber() && it.getValue()==getPinNumber){
			 * getAccountType();}}
			 */
			int cn = getCustomerNumber(); // declaring the variables
			int pn = getPinNumber();
			if (data.containsKey(cn) && data.get(cn) == pn) { // checking if the entered customer number and pin number
																// is correct or not
				getAccountType(); // if both are correct , fetching the account type
			} else
				System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n"); // else printing the message
		} while (x == 1);
	}

	public void getAccountType() { // providing options for accounts
		System.out.println("Select the Account you want to Access: ");
		System.out.println("Type 1 - Current Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");

		int selection = menuInput.nextInt();// to give input for selection

		switch (selection) {
		case 1:
			getCurrent();
			break;

		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thanks for using this ATM, bye. \n ");
			break;

		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
		}
	}

	public void getCurrent() {
		System.out.println("Current Account:");
		System.out.println("Type 1: View Balance");
		System.out.println("Type 2: Withdraw funds");
		System.out.println("Type 3: Deposit Funds");
		System.out.println("Type 4: Exit");
		System.out.println("Choice: ");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
			getAccountType();
			break;

		case 2:
			getCurrentWithdrawInput();
			getAccountType();
			break;

		case 3:
			getCurrentDepositInput();
			getAccountType();
			break;

		case 4:
			System.out.println("Thanks for using this ATM, bye. \n ");
			break;

		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
		}
	}

	public void getSaving() {
		System.out.println("Saving Account:");
		System.out.println("Type 1: View Balance");
		System.out.println("Type 2: Withdraw Fund");
		System.out.println("Type 3: Deposit Fund");
		System.out.println("Type 4: Exit");
		System.out.println("Choice: ");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;

		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;

		case 3:
			getSavingDepositInput();
			getAccountType();
			break;

		case 4:
			System.out.println("Thanks for using this ATM, bye");
			break;

		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
		}
	}

}
