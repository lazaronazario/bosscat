package com.bossket.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bossket.basica.Jogador;

public class DAOJogador extends DAOGenerico<Jogador> {
	private Session session;

	public DAOJogador(EntityManager em) {
		super(em);
	}

	public List<Jogador> listar() {
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Jogador c";
		TypedQuery<Jogador> query = em.createQuery(jpql, Jogador.class);

		return query.getResultList();

	}

	public List<Jogador> listarPorTime(int id) {
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Jogador c where c.time.id=?1";
		TypedQuery<Jogador> query = em.createQuery(jpql, Jogador.class).setParameter(1, id);

		return query.getResultList();
	}

	public List<Jogador> listarNaoSuspenso(int id) {
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Jogador c where c.time.id=?1 and c.suspenso=:false";

		TypedQuery<Jogador> query = em.createQuery(jpql, Jogador.class).setParameter(1, id);

		return query.getResultList();

	}

	public int consultarPorNome(String nome) {
		EntityManager em = getEntityManager();

		String jpql = "SELECT c FROM Jogador c where c.nome=?1";
		TypedQuery<Jogador> query = em.createQuery(jpql, Jogador.class).setParameter(1, nome);

		Jogador jog = query.getSingleResult();
		return jog.getId();
	}

}

