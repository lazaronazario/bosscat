package com.bossket.nogocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bossket.basica.Jogador;
import com.bossket.DAO.DAOJogador;
import com.bossket.erro.ErroConexaoException;
import com.bossket.erro.ErroSqlException;
import com.bossket.erro.GeralException;

public class RNJogador {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bossket");
	EntityManager em = emf.createEntityManager();
	DAOJogador dao;

	public RNJogador() {
		dao = new DAOJogador(em);
	}

	public void inserir(Jogador j) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.inserir(j);
	}

	public void alterar(Jogador j) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.alterar(j);
	}

	public void remover(Jogador j) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.remover(j);
	}

	public Jogador consultar(int id) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultar(id);
	}
     public int consultarPorNome(String nome) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultarPorNome(nome);
	}
	public List<Jogador> listar() throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listar();
	}
        public List<Jogador> listarNaoSupenso(int id) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listarNaoSuspenso(id);
	}
        public List<Jogador> listarPorTime(int timeid) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listarPorTime(timeid);
	}
}
