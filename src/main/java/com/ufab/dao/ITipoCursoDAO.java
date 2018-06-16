package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.TipoCurso;

public interface ITipoCursoDAO {
	public void inserir(TipoCurso tipoCurso);
	public List<TipoCurso> listarTodos();
	public TipoCurso recuperarPorCodigo(int tipoCursoCodigo);
}
