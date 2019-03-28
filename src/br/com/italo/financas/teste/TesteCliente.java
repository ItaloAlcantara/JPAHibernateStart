package br.com.italo.financas.teste;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.italo.financas.modelo.Categoria;
import br.com.italo.financas.modelo.Cliente;
import br.com.italo.financas.modelo.Conta;
import br.com.italo.financas.modelo.Movimentacao;
import br.com.italo.financas.modelo.TipoMovimentacao;
import br.com.italo.financas.util.JPAUtil;


public class TesteCliente {

	public static void main(String[] args) {
		
		Movimentacao mov = new Movimentacao();
				
		Conta conta = new Conta();
		conta.setAgencia("1549");
		conta.setBanco("Inter");
		conta.setNumero("15954");
		conta.setTitular("Antonio Bandeiras");
		
		Categoria c1 = new Categoria("Viagem");
		Categoria c2 = new Categoria("Negocios");
		
		Cliente c = new Cliente(); 
		 
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		
		
		//POPULAR CONTA
		
		em.persist(conta);
		
		
		//COPULAR CATEGORIA
		
		em.persist(c1);
		em.persist(c2);
		
		//Movimentacao
		
		mov.setCategoria(Arrays.asList(em.find(Categoria.class, 1)));
		mov.setConta(em.find(Conta.class, 1));
		mov.setData(Calendar.getInstance());
		mov.setTipo(TipoMovimentacao.SAIDA);
		mov.setConta(em.find(Conta.class,1));
		
		//--Popular cliente
		
		 c.setConta(em.find(Conta.class, 25));
		 c.setEndereco("Rua Hum apa 425 Bloco: B");
		 c.setName(em.find(Conta.class, 25).getTitular());
		 c.setProfissao("Analista de Sistemas Jr.");
			 
		
		em.persist(c);
		 
		
		em.getTransaction().commit();
		
		em.close();
		

	}

}
