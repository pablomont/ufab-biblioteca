package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.Locacao;

public interface ILocacaoDAO {
	public void inserir(Locacao locacao);

	public void remover(Locacao locacao);

	public List<Locacao> listarTodas();

	public void atualizar(Locacao locacao);
}
