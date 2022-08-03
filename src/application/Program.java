package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Entre com os dados da conta");
		System.out.print("Numero: ");
		int numeroConta = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteSaque = sc.nextDouble();
		
		Conta conta = new Conta(numeroConta, titular, saldo, limiteSaque);
		
		
		System.out.print("Valor para saque: ");
		double valorSaque = sc.nextDouble();
		
		try {
			
			conta.saque(valorSaque);
			System.out.print("Novo saldo: " +conta.getSaldo());	
		} 
		catch (DomainException e) {
			System.out.println("Erro ao sacar: " + e.getMessage());
		}
		
		
		
		sc.close();
	}

}
