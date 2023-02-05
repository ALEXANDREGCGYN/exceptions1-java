package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account3;

public class BankATM3 { // Ex. Fixação Aula 178 - Tratamento de Exceções
	
	// Resolvido com solução RAZOÁVEL - Implementação no com função "gambiarra"!

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

		Account3 account = new Account3(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		// "GAMBIARRA" = CONDIÇÃO NO PROGRAMA PRINCIPAL + FUNÇÃO RETORNANDO STRING
		
		String error = account.withdrawalValidator(amount);
		if (error != null) {
			System.out.println(error);
		} else {
			account.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		
		sc.close();
	}

}
