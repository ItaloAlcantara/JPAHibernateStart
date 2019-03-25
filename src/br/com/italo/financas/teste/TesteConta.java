package br.com.italo.financas.teste;

import java.util.Arrays;

import javax.persistence.EntityManager;

import br.com.italo.financas.modelo.Categoria;
import br.com.italo.financas.modelo.Cliente;
import br.com.italo.financas.modelo.Conta;
import br.com.italo.financas.modelo.Movimentacao;
import br.com.italo.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		Categoria c1 = new Categoria("Viagem");
		Categoria c2 = new Categoria("Negocios");
		
		Cliente c = new Cliente(); 
		 
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		 c.setConta(em.find(Conta.class, 25));
		 c.setEndereco("Rua Hum apa 425 Bloco: B");
		 
		 c.setName(em.find(Conta.class, 25).getTitular());
		 c.setProfissao("Analista de Sistemas Jr.");
			 
		
		em.persist(c);
		 
		
		em.getTransaction().commit();
		
		em.close();
		

	}

}
