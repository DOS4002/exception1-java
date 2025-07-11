package model.entities;
import java.util.Scanner;
import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {

		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(Double amount) {
		balance += amount;
	}
	

	public void withdraw(Double amount) throws DomainException {
		if (withdrawLimit < amount) {
			throw new DomainException("The amount exceeds withdraw limit");
		} else if (balance < amount) {
			throw new DomainException("Not enough balance");
		} else {
			balance -= amount;
		}
	}
	
	public void condition(char response) throws DomainException{
		if(response != 'y' && response != 'n') {
			throw new DomainException("Invalid response");
		} 
		if(response == 'y') {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter amount for withdraw: ");
			Double a = sc.nextDouble();
			sc.nextLine();
			withdraw(a);
		} 
	}
	
	@Override
	public String toString() {
		return "Total balance: " + String.format("%.2f", balance);
	}

}
