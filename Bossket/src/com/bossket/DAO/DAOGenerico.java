package com.bossket.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.hibernate.Session;

public class DAOGenerico<T> {

	private EntityManager entityManager;
	private Class<T> classPersistence;
	private Session session;

	@SuppressWarnings("unchecked")
	public DAOGenerico(EntityManager em) {
		this.setEntityManager(em);
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		classPersistence = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	public void inserir(T obj) {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			getEntityManager().persist(obj);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
		}
	}

	public T alterar(T obj) {
		EntityTransaction tx = getEntityManager().getTransaction();
		tx.begin();

		obj = getEntityManager().merge(obj);
		tx.commit();

		return obj;
	}

	public void remover(T obj) {
		EntityTransaction tx = getEntityManager().getTransaction();
		tx.begin();

		obj = getEntityManager().merge(obj);
		getEntityManager().remove(obj);
		tx.commit();
	}

	public final T consultar(Serializable key) {
		T instance = null;
		try {
			instance = (T) getEntityManager().find(getClassPersistence(), key);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return instance;
	}
	
	public final void refresh(T obj) {
		getEntityManager().refresh(obj);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	protected final Class<T> getClassPersistence() {
		return classPersistence;
	}

}

