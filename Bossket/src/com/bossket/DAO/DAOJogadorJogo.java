package com.bossket.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bossket.basica.JogadorJogo;

public class DAOJogadorJogo extends DAOGenerico<JogadorJogo>{

	public DAOJogadorJogo(EntityManager em) {
		super(em);
	}
	public List<JogadorJogo> listar(){
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM JogadorJogo c";  
	    TypedQuery<JogadorJogo> query = em.createQuery(jpql, JogadorJogo.class);  
	  
	    return query.getResultList();  
	
	   }


}

