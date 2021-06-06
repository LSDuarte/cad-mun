package br.com.lsd.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<E> extends Serializable {
	public E save(E entity);
	public List<E> saveAll(List<E> entities);
	public void remove(Long id);
	public void removeAll(List<E> entities);
	public List<E> listar();
}