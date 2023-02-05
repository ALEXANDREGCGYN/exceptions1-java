package model.entities;

public class Account { // Ex. Fixação Aula 178 - Tratamento de Exceções
	
	// Minha tentativa de solução
	
	private Integer number;
	private String holder;
	private Double balance = (double) 0;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double withdrawLimit, double initialBalance, double amount) {
		if (amount > getWithdrawLimit()) {
			System.out.println("Withdraw error: The amount exceeds withdraw limit");			
		}
		if (amount > initialBalance) {
			System.out.println("Withdraw error: Not enough balance");
		}
		
		this.number = number;
		this.holder = holder;
		this.withdrawLimit = withdrawLimit;
		deposit(initialBalance); // Recebe a informação do saldo inicial e insere no método depósito!
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
	// setBalance(Double balance) EXCLUÍDO!
		
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
	
	
	
	
	
}
