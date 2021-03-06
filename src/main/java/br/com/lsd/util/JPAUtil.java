package br.com.lsd.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JPAUtil {

	private static JPAUtil instance;

	private EntityManagerFactory entityManagerFactory;

	public JPAUtil() {
	}

	public static JPAUtil getInstance() {
		if (instance == null) {
			instance = new JPAUtil();
		}
		return instance;
	}

	public void createEntityManagerFactory() {
		if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
			entityManagerFactory = Persistence.createEntityManagerFactory("default");
		}
	}

	public EntityManager getEntityManager() {
		try {
			createEntityManagerFactory();
			return entityManagerFactory.createEntityManager();
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao criar um EntityManager.", e);
		}
	}

	public void destroy() {
		if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
			entityManagerFactory.close();
		}
		entityManagerFactory = null;
		instance = null;
	}

	public static void main(String[] args) {
		JPAUtil.getInstance().getEntityManager();
	}
}