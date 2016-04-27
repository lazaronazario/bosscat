package com.bossket.nogocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bossket.basica.Ponto;
import com.bossket.DAO.DAOPonto;
import com.bossket.erro.ErroConexaoException;
import com.bossket.erro.ErroSqlException;
import com.bossket.erro.GeralException;

public class RNPonto {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bossket");
	EntityManager em = emf.createEntityManager();
	DAOPonto dao;

	public RNPonto() {
		dao = new DAOPonto(em);
	}

	public void inserir(Ponto g) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.inserir(g);
	}

	public void alterar(Ponto g) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.alterar(g);
	}

	public void remover(Ponto g) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.remover(g);
	}

	public Ponto consultar(int id) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultar(id);
	}

	public List<Ponto> listar() throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listar();
	}

}
