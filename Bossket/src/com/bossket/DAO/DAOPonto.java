package com.bossket.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bossket.basica.Ponto;

public class DAOPonto extends DAOGenerico<Ponto>{

	public DAOPonto(EntityManager em) {
		super(em);
	}
	public List<Ponto> listar(){
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Gol c";  
	    TypedQuery<Ponto> query = em.createQuery(jpql, Ponto.class);  
	  
	    return query.getResultList();  
	
	   }

}
