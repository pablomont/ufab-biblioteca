package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.Aluno;


public interface IAlunoDAO {

	public void inserir(Aluno aluno);

	public List<Aluno> recuperarTodos();

	public Aluno recuperarPorMatricula(String matricula);

	public Aluno recuperarPorId(int id);
	
	public void atualizar(Aluno aluno);
	
	public void remover(Aluno aluno);
	
}
