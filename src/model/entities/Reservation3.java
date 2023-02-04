package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation3 { // Usando exceções do JAVA - Aula 176
	
	// LÓGICA DE VALIDAÇÃO IMPLEMENTADA NO MÉTODO 'UPDATES()' USANDO O CONCEITO DE DELEGAÇÃO!
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/*
	 *  Instanciado 'static' para que não seja instanciado um novo 'SimpleDateFormat' para
	 *  cada objeto 'Reservation' que a aplicação tiver!!!
	 */

	public Reservation3() {
	}

	public Reservation3(Integer roomNumber, Date dateIn, Date dateOut) {
		this.roomNumber = roomNumber;
		this.checkIn = dateIn;
		this.checkOut = dateOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	// public void setCheckIn(Date checkIn) { 
	// Excluído para que as datas não sejam modificadas arbitrariamente


	public Date getCheckOut() {
		return checkOut;
	}

	// setCheckOut(Date checkOut) { 
	// Excluído para que as datas não sejam modificadas arbitrariamente
	
	public long duration() { // Para cálculo de diferença entre datas, melhor usar 'long'
		long diff = checkOut.getTime() - checkIn.getTime();
		// 'diff' receberá a diferença das datas em milisegundos para depois converter em dias!
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		/*
		 *  'TimeUnit' consegue converter a diferença do 'checkOut' com o 'checkIn' que
		 *  era em milisegundos para dias!
		 */
	}
		
	// LÓGICA DE VALIDAÇÃO => DELEGAÇÃO USANDO EXCEÇÕES DO JAVA ***********************************

	public void updateDates(Date dateIn, Date dateOut) { // Volta a ser 'void'
		Date now = new Date();
		if (dateIn.before(now) || dateOut.before(now)) { 
			throw new  IllegalArgumentException("Reservation dates for update must be future dates!");
		} 
		if (!dateOut.after(dateIn)) { 
			throw new IllegalArgumentException("Check-out date must be after Check-in date!");
		} 
		this.checkIn = dateIn;
		this.checkOut = dateOut;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn) // Atributo de data da classe no formato instanciado acima
				+ ", check-out: "
				+ sdf.format(checkOut) // Atributo de data da classe no formato instanciado acima
				+ ", "
				+ duration() // Metodo implementado dentro da própria classe
				+ " nights.";
	}

}