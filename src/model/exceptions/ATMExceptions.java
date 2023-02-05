package model.exceptions;

public class ATMExceptions extends RuntimeException{ // Ex. Fixação Aula 178 - Tratamento de Exceções
	
	// Resolvido com solução BOA - Criação de função personalizada de Exceções!
	
	private static final long serialVersionUID = 1L;

	public ATMExceptions(String msg) {
		super(msg);
	}
	/* Armazena na String 'msg', a mensagem passada ao instanciar a 'ATMExceptions'
	 * na função 'withdrawalValidator()' da classe 'Account4'.
	 * 
	 * Será capturada com o 'catch' do programa principal...
	 */

}
