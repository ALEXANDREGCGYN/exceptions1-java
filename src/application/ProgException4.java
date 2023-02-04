package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation4;
import model.exceptions.DomainException;

public class ProgException4 { // Usando exceções PERSONALIZADAS - Aula 176
	
	// Solução 3b (BOA): usando as exceções personalizadas da classe DomainException.

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
			
			Reservation4 reservation = new Reservation4(roomNumber, dateIn, dateOut);
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
		
		// SOLUÇÃO BOA USANDO AS EXCEÇÕES PERSONALIZADAS *************************************
		
		catch (ParseException e) {
			System.out.println("Invalid date format!");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		/* 
		 * Ou propaga a exceção no método 'main' inserindo um 'throws DomainException' ou
		 * trata a exceção capturando no bloco 'catch'. Optou-se pela 2ª alternativa! 
		 */
		catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		/*
		 * Esse último 'catch' usa um tipo de exceção genérica para capturar qualquer
		 * outra exceção inesperada, como erros do tipo 'InputMismatchException' que 
		 * possam ocorrer ao digitar valores diferentes de números inteiros para o quarto!
		 */
		
		sc.close();
	}

}