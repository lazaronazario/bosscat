package com.bossket.nogocio;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bossket.DAO.DAOUsuario;
import com.bossket.basica.Usuario;
import com.bossket.erro.ErroConexaoException;
import com.bossket.erro.ErroSqlException;
import com.bossket.erro.GeralException;

public class RNUsuario {

	DAOUsuario dao;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bossket");
	EntityManager em = emf.createEntityManager();

	public RNUsuario() {
		dao = new DAOUsuario(em);
	}

	public void inserir(Usuario u) throws GeralException, ErroConexaoException,
			ErroSqlException {
		dao.inserir(u);
	}

	public void alterar(Usuario u) throws GeralException, ErroConexaoException,
			ErroSqlException {
		dao.alterar(u);
	}

	public void remover(Usuario u) throws GeralException, ErroConexaoException,
			ErroSqlException {
		dao.remover(u);
	}

	public Usuario consultar(int id) throws GeralException,
			ErroConexaoException, ErroSqlException {
		return dao.consultar(id);
	}

	public List<Usuario> listar() throws GeralException, ErroConexaoException,
			ErroSqlException {
		return dao.listar();
	}

	public List<Usuario> listarVisi() throws GeralException,
			ErroConexaoException, ErroSqlException {
		return dao.listar();
	}

	public Usuario verificaUsuario(Usuario usuario){
		return dao.verificarUsuario(usuario);
	}

	private String convertStringToMd5(String valor) {
		MessageDigest mDigest;
		try {
			// Instanciamos o nosso HASH MD5, poderíamos usar outro como
			// SHA, por exemplo, mas optamos por MD5.
			mDigest = MessageDigest.getInstance("MD5");
			// Convert a String valor para um array de bytes em MD5
			byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

			// Convertemos os bytes para hexadecimal, assim podemos salvar
			// no banco para posterior comparação se senhas
			StringBuffer sb = new StringBuffer();
			for (byte b : valorMD5) {
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
