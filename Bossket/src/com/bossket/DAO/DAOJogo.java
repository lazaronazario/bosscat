package com.bossket.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bossket.basica.Jogo;

public class DAOJogo extends DAOGenerico<Jogo>{

	public DAOJogo(EntityManager em) {
		super(em);
	}
	public List<Jogo> listar(){
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Jogo c";  
	    TypedQuery<Jogo> query = em.createQuery(jpql, Jogo.class);  
	  
	    return query.getResultList();  
	
	   }
	public int consultarUltimo(){
		EntityManager em = getEntityManager();
		 
		String jpql = "SELECT c FROM Jogo c ORDER BY c.id DESC LIMIT 1";
		TypedQuery<Jogo> query = em.createQuery(jpql, Jogo.class);
		  
		Jogo jog = query.getSingleResult(); 
		return jog.getId();
	}
	public List<Jogo> listarPorCamp(int id){
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Jogo c where c.camp.id=?1";  
	    TypedQuery<Jogo> query = em.createQuery(jpql, Jogo.class).setParameter(1, id);
	  
	    return query.getResultList();  	
	   }
}
