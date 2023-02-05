package model.entities;

public class Account3 { // Ex. Fixação Aula 178 - Tratamento de Exceções
	
	// Resolvido com solução RAZOÁVEL - Implementação no com função "gambiarra"!
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account3() {
	}

	public Account3(Integer number, String holder, Double balance, Double withdrawLimit) {
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
	
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	
	// SOLUÇÃO "GAMBIARRA" **********************************************************
	
	public String withdrawalValidator(double amount) {
		if (amount > getWithdrawLimit()) {
			return "Withdraw error: The amount exceeds withdraw limit";
		} 
		
		if(amount > getBalance()) {
			return "Withdraw error: Not enough balance";
		}
		return null;
		
		/* 
		 * A gambiarra está no fato de que a função deixa de ser 'void' pra ser uma
		 * 'String' que testará as 2 condições. Caso os dois 'if' testem verdadeiro,
		 * vão retornar as respectivas mensagens!
		 * Caso testem FALSO para os 2 'if', ou seja, o valor a ser sacado NÃO É MAIOR
		 * que o limite ou o saldo, então está tudo OK e a função retornará NULO!
		 */
	}
	
}
