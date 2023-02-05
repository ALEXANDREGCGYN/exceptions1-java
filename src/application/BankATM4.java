package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account4;
import model.exceptions.ATMExceptions;

public class BankATM4 { // Ex. Fixação Aula 178 - Tratamento de Exceções
	
	// Resolvido com solução BOA - Criação de função personalizada de Exceções!

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

		Account4 account = new Account4(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
	// SOLUÇÃO ADEQUADA = CHAMA A FUNÇÃO QUE RETORNA OS VALORES E AS MENSAGENS DE ERRO!
		
		try {
			account.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		} 
		catch (ATMExceptions e) {
			System.out.println(e.getMessage());
		}
		/* O bloco 'try' executa a função 'withdraw()' e, caso ocorra um erro e dispare
		 * uma exceção, o bloco 'catch' captura essa exceção na variável 'e' e imprime!
		 */
		
		sc.close();
	}

}