package atmSimulator;

import java.util.Scanner;

public class TranscationManager {
	private ATM atm;
	
//	constructor to initialize with atm instance
	TranscationManager(ATM atm){
		this.atm = atm;
	}
	
//	display menu option after successfull login
	public void showMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("------------------------------------------- Main Menu ----------------------------------------------");
		System.out.println();
		System.out.println("1. Check Balance \n"
				+ "2. Withdraw\n"
				+ "3. Deposite\n"
				+ "4. Change Pin\n"
				+ "5. Exit");
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------");
		switch (choice) {
		case 1: {
			checkBalnce();
			break;
		}
		case 2: {
			withdrawAmount();
			break;
		}
		case 3: {
			depositeAmount();
			break;
		}
		case 4: {
			changePin();
			break;
		}
		case 5: {
			System.exit(0);
		}
		default:
			System.err.println("Invalid Choice...Please Re-enter!");
			showMenu();
		}
		sc.close();
	}

//	menu methods
	public void checkBalnce() {
		System.out.println("Your Balance: " + atm.getBalance());
		showMenu();
	}
	
	public void withdrawAmount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to withdraw: ");
		double withdrawAmount = sc.nextInt();
		
//		to check if user had enough balance to withdraw
		if (withdrawAmount <= atm.getBalance()) {
			atm.setBalance(atm.getBalance() - withdrawAmount);
			System.out.println("Withdrawal successful.");
		} else {
			System.err.println("Insufficient Balance :(");
		}
		
		showMenu();
	}
	
	public void depositeAmount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to deposite: ");
		double depositeAmount = sc.nextDouble();
		atm.setBalance(atm.getBalance() + depositeAmount);
        System.out.println("Deposit successful.");
		showMenu();
	}
	
	public void changePin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter old pin: ");
		int oPin = sc.nextInt();
		
		System.out.println("Enter new pin: ");
		int nPin = sc.nextInt();
		
		if (oPin == atm.getPin()) {
			atm.setPin(nPin);
		} else {
			System.err.println("Entered old pin is wrong !!! /nPlease try again");
			changePin();
		}
		showMenu();
	}
}
