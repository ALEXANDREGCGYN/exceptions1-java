package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account2;

public class BankATM2 { // Ex. Fixação Aula 178 - Tratamento de Exceções
	
	// Exercício resolvido com solução RUIM - Implementação das condições no código principal

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
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		Account2 account = new Account2(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		if (amount > account.getWithdrawLimit()) {
			System.out.println("Withdraw error: The amount exceeds withdraw limit");
		} else if(amount > account.getBalance()) {
			System.out.println("Withdraw error: Not enough balance");
		} else {
			account.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		
		sc.close();
	}

}
