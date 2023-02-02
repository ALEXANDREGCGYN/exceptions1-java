package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class ProgException1 { // Criando exceções personalizadas - Aula 173
	
	// Solução 1 (MUITO RUIM): lógica de validação dentro do programa principal.

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date dateIn = sdf.parse(sc.next());
		// Recebe a data em formato de texto 'sc.next()' e o 'sdf.parse' converte em 'Date'
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date dateOut = sdf.parse(sc.next());
		
		if (!dateOut.after(dateIn)) { // Função de 'Date' confere se uma data vem depois da outra
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, dateIn, dateOut);
			// Instancia a reserva caso as datas de entrada e saída estejam na ordem correta!
			
			System.out.println("Reservation: " + reservation);
			// Imprime na tela a confirmação dos dados da reserva que foram informados!
			
			// ATUALIZANDO AS DATAS ************************************************************
						
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			dateIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			dateOut = sdf.parse(sc.next());

			// LÓGICA DE VALIDAÇÃO DAS DATAS *************************************************
			
			Date now = new Date();
			if (dateIn.before(now) || dateOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates!");
				
			}
			else if (!dateOut.after(dateIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date!");
				
			}
			else {
				reservation.updateDates(dateIn, dateOut);
				System.out.println("Reservation: " + reservation);
			}

		}
		
		sc.close();
	}

}