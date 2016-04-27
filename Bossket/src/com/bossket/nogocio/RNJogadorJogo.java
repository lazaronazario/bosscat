package com.bossket.nogocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bossket.basica.JogadorJogo;
import com.bossket.DAO.DAOJogadorJogo;
import com.bossket.erro.ErroConexaoException;
import com.bossket.erro.ErroSqlException;
import com.bossket.erro.GeralException;

public class RNJogadorJogo {

	DAOJogadorJogo dao;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bossket");
	EntityManager em = emf.createEntityManager();
	public RNJogadorJogo() {
		dao = new DAOJogadorJogo(em);
	}

	public void inserir(JogadorJogo jj) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.inserir(jj);
	}

	public void alterar(JogadorJogo jj) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.alterar(jj);
	}

	public void remover(JogadorJogo jj) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.remover(jj);
	}

	public JogadorJogo consultar(int id) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultar(id);
	}

	public List<JogadorJogo> listar() throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listar();
	}
	
}
