package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation { // Criando exceções personalizadas - Aula 173
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/*
	 *  Instanciado 'static' para que não seja instanciado um novo 'SimpleDateFormat' para
	 *  cada objeto 'Reservation' que a aplicação tiver!!!
	 */

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
		
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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