package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class BankATM { // Ex. Fixação Aula 178 - Tratamento de Exceções
	
	// Minha tentativa de solução

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine(); // Consumir a quebra de linha... 
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		double amount = 0;
		Account account = new Account(number, holder, withdrawLimit, initialBalance, amount);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		amount = sc.nextDouble();
		account = new Account(number, holder, withdrawLimit, initialBalance, amount);

		account.withdraw(amount);
		
		System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		
		
		
		
		
		sc.close();
	}

}
