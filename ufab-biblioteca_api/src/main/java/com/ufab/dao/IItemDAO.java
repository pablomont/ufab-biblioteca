package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.Item;
import com.ufab.excecao.ItemServicoException;

public interface IItemDAO {

	public void inserir(Item item) throws ItemServicoException;

	public Item recuperarPorCodigo(int codigo);

	public List<Item> recuperarTodos();

	public void atualizar(Item item) throws ItemServicoException;

	public void remover(Item item);
}
