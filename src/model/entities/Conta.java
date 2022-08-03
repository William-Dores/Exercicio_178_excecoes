package model.entities;

import model.exception.DomainException;

public class Conta {
	private Integer numeroConta;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
	
	public Conta() {
		
	}
	public Conta(Integer numeroConta, String titular, Double saldo, Double limiteSaque) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}
	public Integer getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Double getSaldo() {
		return saldo;
	}
	public Double getLimiteSaque() {
		return limiteSaque;
	}
	
	public void deposito(Double valor) {
		saldo += valor;
	}
	public void saque(Double valor) {
		// DESSE JEITO TAMBÉM FUNCIONA, ENTRETANTO A MELHOR PRATICA E FAZER UM METODO QUE SE RESPOSABILIZE PELA OPERAÇÃO EM SI, E DEIXE O METODO DE SAQUE APENAS PARA SAQUE
		
		/*if (valor > saldo) {
			throw new DomainException("Saldo insuficiente para retirada");
		}
		if (valor > limiteSaque) {
			throw new DomainException("O valor excede o limite de retirada");
		} */
		
		validarSaque(valor);
		saldo -= valor;
	}
	
	private void validarSaque(Double valor) {
		if (valor > getLimiteSaque()) {
			throw new DomainException("O valor excede o limite de retirada");
		}
		if (valor > getSaldo()) {
			throw new DomainException("saldo insuficiente para retirada");
		}
		
	}

}
