package model.entities;

import model.exceptions.ATMExceptions;

public class Account4 { // Ex. Fixação Aula 178 - Tratamento de Exceções
	
	// Resolvido com solução BOA - Criação de função personalizada de Exceções!
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account4() {
	}

	public Account4(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}

	// SOLUÇÃO ADEQUADA **********************************************************

	public void withdraw(double amount) {
		withdrawalValidator(amount);
		this.balance -= amount;
		/* 
		 * Fazendo a integração da validação com a função de saque que será responsável
		 * pelo lançamento da exceção!
		 * 
		 * A função 'whitdrawalValidator()' se torna 'private' não sendo visível para
		 * outras partes do programa ou classes!
		 */
	}
	
	private void withdrawalValidator(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new ATMExceptions("Withdraw error: The amount exceeds withdraw limit");
		} 
		
		if(amount > getBalance()) {
			throw new ATMExceptions("Withdraw error: Not enough balance");
		}
		/* 
		 * A função volta a ser 'void' que vai lançar a função de exceção capturando
		 * possíveis erros e retornando as respectivas mensagens!
		 */
	}
	
}