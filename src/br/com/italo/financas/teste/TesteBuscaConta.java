package br.com.italo.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.italo.financas.modelo.Conta;
import br.com.italo.financas.modelo.Movimentacao;
import br.com.italo.financas.modelo.TipoMovimentacao;
import br.com.italo.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		Movimentacao m = new Movimentacao();
		EntityManager em = new JPAUtil().getEntityManager();
		m.setData(Calendar.getInstance());
		m.setDescricao("Conta de luz - ABRIL/2012");
		m.setValor(new BigDecimal("135.0"));
		m.setTipo(TipoMovimentacao.SAIDA);
		m.setConta(em.find(Conta.class, 25));
		em.getTransaction().begin();
		
		em.persist(m);
		
		em.getTransaction().commit();
		em.close();
	}

}
