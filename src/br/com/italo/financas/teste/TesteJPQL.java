package br.com.italo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.italo.financas.modelo.Movimentacao;
import br.com.italo.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String query = "select m from Movimentacao m where m.conta.id= 1";
		Query q = em.createQuery(query);
		
		List<Movimentacao> resultados = q.getResultList();
		
		for(Movimentacao m: resultados)
		{
			System.out.println(m.getDescricao());
			System.out.println(m.getId());
		}		
		em.getTransaction().commit();
		em.close();
	}

}
