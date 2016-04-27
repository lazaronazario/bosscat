package com.bossket.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bossket.basica.TimeJogo;

public class DAOTimeJogo extends DAOGenerico<TimeJogo>{

	public DAOTimeJogo(EntityManager em) {
		super(em);
	}
	public List<TimeJogo> listar(){
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM TimeJogo c";  
	    TypedQuery<TimeJogo> query = em.createQuery(jpql, TimeJogo.class);  
	  
	    return query.getResultList();  
	
	   }
	public List<TimeJogo> listarVisi(){
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM TimeJogo c where c.casa=false";  
	    TypedQuery<TimeJogo> query = em.createQuery(jpql, TimeJogo.class);  
	  
	    return query.getResultList();  
	
	   }
}
