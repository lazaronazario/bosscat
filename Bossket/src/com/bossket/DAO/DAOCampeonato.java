package com.bossket.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bossket.basica.Campeonato;

public class DAOCampeonato extends DAOGenerico<Campeonato>{

	public DAOCampeonato(EntityManager em) {
		super(em);
	}
	public List<Campeonato> listar(){
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Campeonato c";  
	    TypedQuery<Campeonato> query = em.createQuery(jpql, Campeonato.class);  
	  
	    return query.getResultList();  
	
	   }
	public int consultarPorNome(String nome){
		EntityManager em = getEntityManager();
		 
		String jpql = "SELECT c FROM Campeonato c where c.nome=?1";
		TypedQuery<Campeonato> query = em.createQuery(jpql, Campeonato.class).setParameter(1, nome);
		  
		Campeonato camp = query.getSingleResult(); 
		return camp.getId();
	}
}

