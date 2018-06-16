package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.Curso;

public interface ICursoDAO {
	public void inserir(Curso c);

	public List<Curso> recuperarTodos();

	public Curso recuperarPorCod(int cod);

	public void remover(Curso curso);

	public void atualizar(Curso curso);
}
