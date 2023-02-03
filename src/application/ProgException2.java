package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation2;

public class ProgException2 { // Criando exceções personalizadas - Aula 173
	
	// Solução 2 (RUIM): lógica de validação dentro da classe (método retornando uma string).

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
		
		/*
		 * 	ESTA VALIDAÇÃO AINDA FICARÁ NO PROGRAMA PRINCIPAL PARA INSTANCIAR O OBJETO 'RESERVATION2'
		 *  QUE DEVERIA SER IMPLEMENTADA NO CONSTRUTOR DO OBJETO.
		 *  PORÉM, O CONSTRUTOR NÃO RETORNA 'STRING'.
		 */
		
		if (!dateOut.after(dateIn)) { // Função de 'Date' confere se uma data vem depois da outra
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		}
		else {
			Reservation2 reservation = new Reservation2(roomNumber, dateIn, dateOut);
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

			// STRING QUE RETORNARÁ AS MENSAGENS DE POSSÍVEIS ERROS! ********************************
			
			/*
			 * REALIZADA UMA MELHORIA NO PROGRAMA PRINCIPAL ATRAVÉS DO CONCEIRO 
			 * DE *DELEGAÇÃO* ONDE A LÓGICA DE VALIDAÇÃO DAS DATAS FOI REMOVIDA 
			 * PARA O MÉTODO UPDATEDATES DA CLASSE RESERVATION2.
			 */
			
			String error = reservation.updateDates(dateIn, dateOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}

		}
		
		sc.close();
	}

}