package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation3;

public class ProgException3 { // Usando exceções do JAVA - Aula 176
	
	// Solução 3a (BOA): limpando os 'if' e 'else' do código (usando 'try-catch').

	public static void main(String[] args) {

		// RETIRADA TODA A LÓGICA DE VALIDAÇÃO TORNANDO O PROGRAMA MAIS LIMPO E ORGANIZADO.

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date dateIn = sdf.parse(sc.next()); // O compilador obriga a tratar o 'parse'
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date dateOut = sdf.parse(sc.next());
			
			Reservation3 reservation = new Reservation3(roomNumber, dateIn, dateOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			dateIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			dateOut = sdf.parse(sc.next());
			
			reservation.updateDates(dateIn, dateOut);
			System.out.println("Reservation: " + reservation);
		}
		
		// SOLUÇÃO BOA MAS AINDA USANDO AS EXCEÇÕES DO JAVA *************************************
		
		catch (ParseException e) { // Tratamento do 'parse' das linhas 25 e 27.
			System.out.println("Invalid date format!");
		}
		catch (IllegalArgumentException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		// O TRECHO DE CÓDIGO FICOU LINEAR (SEM A COMPLEXIDADE DE 'IF-ELSE')
		
		/*
		 * O 'TRY' EXECUTA OS COMANDOS COMO SE NÃO HOUVESSE ERRO. CASO HAJA ALGUM, A
		 * EXECUÇÃO SERÁ INTERROMPIDA E CAIRÁ NOS BLOCOS 'CATCH'.
		 */
		
		
		sc.close();
	}

}