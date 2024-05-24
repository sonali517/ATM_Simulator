package atmSimulator;

import java.util.Scanner;

class ATM{
	private long accountNo;
	private int pin;
	private double balance;

//	getter and setter method to get or change values
	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNO(long accountNO) {
		this.accountNo = accountNO;
	}
	
	public int getPin() {
		return pin;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
//	sign up method for new user to set there pin
	public void signUp(TranscationManager tManager) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your account Number: ");
		accountNo = sc.nextLong();
		
		System.out.println("Enter pin: ");
		pin = sc.nextInt();
		System.out.println("Renter pin: ");
		int pin = sc.nextInt();
		
	    // Validate PIN length and equality
	    if (String.valueOf(pin).length() == 4 && this.pin == pin) {
	        System.out.println("Pin set Successfully....:)");
	        login(tManager);
	    } else {
	        System.err.println("Invalid PIN. Please enter a 4-digit PIN and make sure both entries match.");
	        signUp(tManager); // Re-prompt for sign up if there's an error
	    }
	}
	
//	login method 
	public void login(TranscationManager tManager) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*************************      Welcome to ATM     **************************");
		System.out.println("Enter Card / Account Number: ");
		long accountNo = sc.nextLong();
		
		System.out.println("Enter pin: ");
		int pin = sc.nextInt();
		
//		pin validation
		
		if (this.accountNo == accountNo && this.pin == pin) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("**************** Successful.......Proceed further ******************");
			tManager.showMenu();
		} else {
			System.err.println("Wrong Account Number or Pin....Please try again :(");
			login(tManager);
		}
		sc.close();
	}

}


// driver class
public class Main {

	public static void main(String[] args) {
		ATM atm = new ATM();
		TranscationManager tManager = new TranscationManager(atm);
		
		atm.signUp(tManager);
		atm.login(tManager);
		
	}

}

