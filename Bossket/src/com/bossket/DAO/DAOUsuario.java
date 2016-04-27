package com.bossket.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bossket.basica.Usuario;

public class DAOUsuario extends DAOGenerico<Usuario> {

	public DAOUsuario(EntityManager em) {
		super(em);
	}

	public List<Usuario> listar() {
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Usuario c";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);

		return query.getResultList();

	}
	
	public Usuario verificarUsuario(Usuario usuario){
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Usuario c where c.login=?1 and c.senha=?2";
		
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class).setParameter(1, usuario.getLogin()).setParameter(2, usuario.getSenha());
		List<Usuario> listUser = query.getResultList();
		
		try {
			return listUser.get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	/*
	public Usuario verificarUsuario(Usuario usuario){
		EntityManager em = getEntityManager();
		String jpql = "SELECT c FROM Usuario c where c.login=?1 and c.senha=?2";
		
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class).setParameter(1, login.toLowerCase().trim()).setParameter(2, senha.toLowerCase().trim());
			
		Usuario u = query.getSingleResult(); 
		
		return (Usuario) query.getResultList();
	}
*/

}

