package com.bossket.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bossket.basica.Time;
import com.bossket.basica.Usuario;

public class DAOTime extends DAOGenerico<Time> {

	public DAOTime(EntityManager em) {
		super(em);
	}

	public List<Time> listar() {
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Time c";
		TypedQuery<Time> query = em.createQuery(jpql, Time.class);

		return query.getResultList();

	}

	public List<Time> listarPorUser(Usuario usuario) {
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Time c where c.user.id=?1";
		TypedQuery<Time> query = em.createQuery(jpql, Time.class).setParameter(1, usuario.getId());

		// List<Time> listTime = query.getResultList();
		return query.getResultList();
	}

	public int consultarPorNome(String nome) {
		EntityManager em = getEntityManager();

		String jpql = "SELECT c FROM Campeonato c where c.nome=?1";
		TypedQuery<Time> query = em.createQuery(jpql, Time.class).setParameter(1, nome);

		Time tim = query.getSingleResult();
		return tim.getId();
	}

	public List<Time> classificar(int id) {
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Time c where c.camp.id=?1 order by c.pontos desc";
		TypedQuery<Time> query = em.createQuery(jpql, Time.class).setParameter(1, id);

		return query.getResultList();
	}
}
