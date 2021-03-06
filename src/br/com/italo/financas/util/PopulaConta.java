package br.com.italo.financas.util;

import javax.persistence.EntityManager;

import br.com.italo.financas.modelo.Conta;

public class PopulaConta {

	public static void main(String[] args) {

		EntityManager emf = new JPAUtil().getEntityManager();
		emf.getTransaction().begin();

		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		Conta conta4 = new Conta();
		Conta conta5 = new Conta();
		
		conta1.setBanco("001 - BANCO DO BRASIL");
		conta1.setNumero("16987-8");
		conta1.setAgencia("6543");
		conta1.setTitular("Maria dos Santos");

		conta2.setBanco("237 - BANCO BRADESCO");
		conta2.setNumero("86759-1");
		conta2.setAgencia("1745");
		conta2.setTitular("Paulo Roberto Souza");

		conta3.setBanco("341 - BANCO ITAU UNIBANCO");
		conta3.setNumero("46346-3");
		conta3.setAgencia("4606");
		conta3.setTitular("Antonio Duraes");

		conta4.setBanco("033 - BANCO SANTANDER");
		conta4.setNumero("12345-6");
		conta4.setAgencia("9876");
		conta4.setTitular("Leandra Marques");

		conta5.setBanco("104 - CAIXA ECONOMICA FEDERAL");
		conta5.setNumero("98654-3");
		conta5.setAgencia("1234");
		conta5.setTitular("Alexandre Duarte");

		// Criar persistencia no banco

		emf.persist(conta1);
		emf.persist(conta2);
		emf.persist(conta3);
		emf.persist(conta4);
		emf.persist(conta5);

		emf.getTransaction().commit();

		emf.close();

	}

}
