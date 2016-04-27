package com.bossket.nogocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bossket.basica.Campeonato;
import com.bossket.DAO.DAOCampeonato;
import com.bossket.erro.ErroConexaoException;
import com.bossket.erro.ErroSqlException;
import com.bossket.erro.GeralException;

public class RNCampeonato {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bossket");
	EntityManager em = emf.createEntityManager();
	DAOCampeonato dao;

	public RNCampeonato() {
		dao = new DAOCampeonato(em);
	}

	public void inserir(Campeonato c) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.inserir(c);
	}

	public void alterar(Campeonato c) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.alterar(c);
	}

	public void remover(Campeonato c) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.remover(c);
	}

	public Campeonato consultar(int id) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultar(id);
	}
        public int consultarPorNome(String nome) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultarPorNome(nome);
	}

	public List<Campeonato> listar() throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listar();
	}

}
