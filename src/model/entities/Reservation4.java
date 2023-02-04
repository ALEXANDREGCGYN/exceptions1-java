package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation4 { // Usando exceções PERSONALIZADAS - Aula 176
	
	// LÓGICA DE VALIDAÇÃO IMPLEMENTADA NO MÉTODO 'UPDATES()' USANDO O CONCEITO DE DELEGAÇÃO!
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation4() {
	}

	public Reservation4(Integer roomNumber, Date dateIn, Date dateOut) throws DomainException {
		Date now = new Date();
		if (dateIn.before(now) || dateOut.before(now)) { // Somente datas futuras 
			throw new DomainException("Reservation dates must be future dates!");
		} 
		if (!dateOut.after(dateIn)) { // Somente checkout posterior ao checkin
			throw new DomainException("Check-out date must be after Check-in date!");
		}
		// PROGRAMAÇÃO DEFENSIVA = INSERE O TRATAMENTO DAS EXCEÇÕES NO CONSTRUTOR (INÍCIO DO MÉTODO) 

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

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() { 
		long diff = checkOut.getTime() - checkIn.getTime();
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
		
	// LÓGICA DE VALIDAÇÃO => DELEGAÇÃO USANDO EXCEÇÕES PERSONALIZADAS **************************

	public void updateDates(Date dateIn, Date dateOut) throws DomainException { 
		Date now = new Date();
		if (dateIn.before(now) || dateOut.before(now)) { 
			throw new DomainException("Reservation dates for update must be future dates!");
		} 
		// Troca do 'IllegalArgumentException' pela EXCEÇÃO PERSONALIZADA 'DomainException'
		
		if (!dateOut.after(dateIn)) { 
			throw new DomainException("Check-out date must be after Check-in date!");
		} 
		// Troca do 'IllegalArgumentException' pela EXCEÇÃO PERSONALIZADA 'DomainException'
		
		this.checkIn = dateIn;
		this.checkOut = dateOut;
	}
	/*
	 * Ou trata a exceção no 'try-catch' ou propaga na assinatura do método com o 'throws'!
	 * 
	 *  Quem tem que tratar a exceção é o programa principal no bloco 'catch'.
	 */
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut) 
				+ ", "
				+ duration()
				+ " nights.";
	}

}