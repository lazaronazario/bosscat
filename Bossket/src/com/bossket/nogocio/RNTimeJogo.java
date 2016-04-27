package com.bossket.nogocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bossket.basica.TimeJogo;
import com.bossket.DAO.DAOTimeJogo;
import com.bossket.erro.ErroConexaoException;
import com.bossket.erro.ErroSqlException;
import com.bossket.erro.GeralException;

public class RNTimeJogo {

	DAOTimeJogo dao;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bossket");
	EntityManager em = emf.createEntityManager();
	public RNTimeJogo() {
		dao = new DAOTimeJogo(em);
	}

	public void inserir(TimeJogo jj) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.inserir(jj);
	}

	public void alterar(TimeJogo jj) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.alterar(jj);
	}

	public void remover(TimeJogo jj) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.remover(jj);
	}

        public TimeJogo consultar(int id) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultar(id);
	}

	public List<TimeJogo> listar() throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listar();
	}
       public List<TimeJogo> listarVisi() throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listarVisi();
	}
	
}
