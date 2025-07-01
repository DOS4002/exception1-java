package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contributor;
import entities.LegalEntity;
import entities.NaturalPerson;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Contributor> listContributors = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		sc.nextLine();

		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------");
		for (int i = 0; i < n; i++) {
			final String BOLD = "\033[1m";
			final String RESET = "\033[0m";
			System.out.println(BOLD + "Tax payer # " + (1 + i) + " data:" + RESET);
			System.out.print("Individual or company (i/c)? ");
			char response = sc.next().charAt(0);
			sc.nextLine();
			while (response != 'i' && response != 'c') {
				System.out.print(BOLD + "ERROR. TRY AGAIN (i/c): " + RESET);
				response = sc.next().charAt(0);
				sc.nextLine();
			}
			if (response == 'i') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				Double anualIncome = sc.nextDouble();
				sc.nextLine();
				System.out.print("Health expenditures: ");
				Double healthExtenses = sc.nextDouble();
				listContributors.add(new NaturalPerson(name, anualIncome, healthExtenses));
			} else {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				Double anualIncome = sc.nextDouble();
				sc.nextLine();
				System.out.print("Number of employees: ");
				Integer quantityEmployee = sc.nextInt();
				listContributors.add(new LegalEntity(name, anualIncome, quantityEmployee));

			}
			System.out.println("---------------------------------------------------------------------------------------");
		}
		System.out.println();
		System.out.println("TAXES PAID:");
		Double sum = 0.0; 
		for(Contributor c : listContributors) {
			System.out.println(c.getName() + ": $" + String.format("%.2f", c.taxCalculation()));
			sum += c.taxCalculation();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $" + sum);

	}
}
