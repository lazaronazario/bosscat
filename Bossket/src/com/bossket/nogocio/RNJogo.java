package com.bossket.nogocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bossket.basica.Jogo;
import com.bossket.DAO.DAOJogo;
import com.bossket.erro.ErroConexaoException;
import com.bossket.erro.ErroSqlException;
import com.bossket.erro.GeralException;

public class RNJogo {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bossket");
	EntityManager em = emf.createEntityManager();
	DAOJogo dao;

	public RNJogo() {
		dao = new DAOJogo(em);
	}

	public void inserir(Jogo j) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.inserir(j);
	}

	public void alterar(Jogo j) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.alterar(j);
	}

	public void remover(Jogo j) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.remover(j);
	}

	public Jogo consultar(int id) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultar(id);
	}
     public int consultarUltimo() throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultarUltimo();
	}

	public List<Jogo> listar() throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listar();
	}
       public List<Jogo> listarPorCamp(int campid) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listarPorCamp(campid);
	}

}

