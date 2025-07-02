package application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
		System.out.println("Enter account data: ");
		System.out.println();
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		sc.nextLine();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		sc.nextLine();

		Account account = new Account(number, holder, balance, withdrawLimit);

		System.out.print("Enter amount for withdraw: ");
		Double amount = sc.nextDouble();
		sc.nextLine();
		account.withdraw(amount);
		System.out.println("-----------------------------------------------------------");
		System.out.println(account);
		System.out.println("------------------------------------------------------------");
		System.out.println("Do you want to make another withdrawal?");
		char response = sc.next().charAt(0);
		account.condition(response);
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (Exception e) {
			final String BOLD = "\033[1m";
			final String RESET = "\033[0m";
			System.out.println( BOLD + "Unexpected error." + RESET);
		}
		sc.close();
	}
}
