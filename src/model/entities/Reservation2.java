package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation2 { // Criando exceções personalizadas - Aula 173
	
	// Solução 2 (RUIM): lógica de validação dentro da classe (método retornando uma string).

	// LÓGICA DE VALIDAÇÃO IMPLEMENTADA NO MÉTODO 'UPDATES()' USANDO O CONCEITO DE DELEGAÇÃO!
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/*
	 *  Instanciado 'static' para que não seja instanciado um novo 'SimpleDateFormat' para
	 *  cada objeto 'Reservation' que a aplicação tiver!!!
	 */

	public Reservation2() {
	}

	public Reservation2(Integer roomNumber, Date dateIn, Date dateOut) {
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
		
	// LÓGICA DE VALIDAÇÃO IMPLEMENTADA NO MÉTODO UPDATEDATES => DELEGAÇÃO **************************

	/* 
	 * Parâmetros 'dateIn' e 'dateOut' do método trazidos do 'ProgException1' original foram 
	 * aqui alteradas para coincidir com as variáveis da validação (if) e evitar erro de compilação!
	 */
	
	public String updateDates(Date dateIn, Date dateOut) { // Deixa de ser 'void' p/ser 'String'
		Date now = new Date();
		if (dateIn.before(now) || dateOut.before(now)) { // Se as datas forem anteriores, retorna msg
			return "Reservation dates for update must be future dates!";
		} 
		// Não necessita do 'else' pois se o 1º 'if' for verdadeiro, a validação não entra no 2º 'if'!
		if (!dateOut.after(dateIn)) { // Se saída for anterior à entrada, retorna msg
			return "Check-out date must be after check-in date!";
		} // Caso não haja nenhum erro, o código atualiza as datas com 'checkIn' e 'checkOut'!
		this.checkIn = dateIn;
		this.checkOut = dateOut;
		return null; // Retorna nulo caso não haja nenhum erro! Caso haja erro, retorna as mensagens!
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