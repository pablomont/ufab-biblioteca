package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.Permissao;

public interface IPermissaoDAO {
	public void inserir(Permissao permissao);

	public List<Permissao> recuperarTodas();
}
