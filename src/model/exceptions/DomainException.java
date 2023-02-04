package model.exceptions;

public class DomainException extends Exception { // Poder ser extensão de 'Exception' ou 'RunTimeException' 
	private static final long serialVersionUID = 1L; // O java já indica a versão 'serializable' 
	// Exceção lançada por algum erro na entidade de domínio 'Reservation'
	
	public DomainException(String msg) {
		super(msg); // Repassa a mensagem para o construtor da superclasse
	}
	/*
	 * Permite instanciar a exceção personalizada passando uma mensagem '(String msg)'
	 * que ficará armazenada dentro da exceção!
	 */
}
