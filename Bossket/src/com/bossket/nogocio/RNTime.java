package com.bossket.nogocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bossket.basica.Time;
import com.bossket.basica.Usuario;
import com.bossket.DAO.DAOTime;
import com.bossket.erro.ErroConexaoException;
import com.bossket.erro.ErroSqlException;
import com.bossket.erro.GeralException;

public class RNTime {

	DAOTime dao;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bossket");
	EntityManager em = emf.createEntityManager();
	public RNTime() {
		dao = new DAOTime(em);
	}

	public void inserir(Time t) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.inserir(t);
	}

	public void alterar(Time t) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.alterar(t);
	}

	public void remover(Time t) throws GeralException, ErroConexaoException, ErroSqlException {
		dao.remover(t);
	}

	public Time consultar(int id) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultar(id);
	}
	public int consultarPorNome(String nome) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.consultarPorNome(nome);
	}
	public List<Time> listar() throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listar();
	}
	public List<Time> listarPorUsuario(Usuario usuario) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.listarPorUser(usuario);
	}
    public List<Time> classificar(int campid) throws GeralException, ErroConexaoException, ErroSqlException {
		return dao.classificar(campid);
	}

	
}
