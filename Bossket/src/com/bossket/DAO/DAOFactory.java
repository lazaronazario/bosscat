package com.bossket.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOFactory {

	private static EntityManager manager;
	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("hibernate");
		if (manager == null || !manager.isOpen()) {
			manager = factory.createEntityManager();
		}
	}

	public static DAOCampeonato getCampeonatoDAO() {
		DAOCampeonato daoCamp = new DAOCampeonato(manager);
		return daoCamp;
	}

	public static DAOPonto getPontoDAO() {
		DAOPonto DAOPonto = new DAOPonto(manager);
		return DAOPonto;
	}

	public static DAOJogador getJogadorDAO() {
		DAOJogador daoJogador = new DAOJogador(manager);
		return daoJogador;
	}

	public static DAOJogadorJogo getJogadorJogoDAO() {
		DAOJogadorJogo daoJogadorJogo = new DAOJogadorJogo(manager);
		return daoJogadorJogo;
	}

	public static DAOJogo getJogoDAO() {
		DAOJogo daoJogo = new DAOJogo(manager);
		return daoJogo;
	}

	public static DAOTime getTimeDAO() {
		DAOTime daoTime = new DAOTime(manager);
		return daoTime;
	}
}
