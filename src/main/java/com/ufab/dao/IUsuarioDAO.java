package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.Usuario;

public interface IUsuarioDAO {

	public void inserir(Usuario usuario);

	public List<Usuario> recuperarTodos();

	public Usuario recuperarPorCpf(String cpf);

	public void atualizar(Usuario usuario);
	
	public void remover(Usuario usuario);
}
