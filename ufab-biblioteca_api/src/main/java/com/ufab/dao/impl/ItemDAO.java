package com.ufab.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.IItemDAO;
import com.ufab.entidade.Item;
import com.ufab.excecao.ItemServicoException;
@Repository
@Transactional
public class ItemDAO extends DAO implements IItemDAO {

	@Override
	public void inserir(Item item) throws ItemServicoException {
		getCurrentSession().save(item);
	}

	@Override
	public Item recuperarPorCodigo(int codigo) {
		return (Item) getCurrentSession().createQuery("FROM item WHERE codigo = :cod").setInteger("cod", codigo)
				.uniqueResult();
	}

	@Override
	public List<Item> recuperarTodos() {
		return getCurrentSession().createQuery("FROM item").list();
	}

	@Override
	public void atualizar(Item item) throws ItemServicoException {
		getCurrentSession().update(item);
	}

	@Override
	public void remover(Item item) {
		getCurrentSession().delete(item);
	}

}
