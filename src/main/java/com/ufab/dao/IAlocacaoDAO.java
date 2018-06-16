package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.Alocacao;

public interface IAlocacaoDAO {

	public void inserir(Alocacao alocacao);

	public void remover(Alocacao alocacao);

	public void atualizar(Alocacao alocacao);
	
	public List<Alocacao> recuperarTodas();
	
}
