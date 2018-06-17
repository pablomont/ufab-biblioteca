package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.TipoItem;

public interface ITipoItemDAO {
	public void inserir(TipoItem tipoItem);
	public List<TipoItem> listarTodos();
}
