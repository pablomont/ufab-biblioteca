package com.ufab.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.IUsuarioDAO;
import com.ufab.entidade.Usuario;

@Repository
@Transactional
public class UsuarioDAO extends DAO implements Serializable, IUsuarioDAO {

	private static final long serialVersionUID = -349866179996575245L;

	@Override
	public void inserir(Usuario usuario) {
		getCurrentSession().save(usuario);
	}

	@Override
	public List<Usuario> recuperarTodos() {
		return getCurrentSession().createQuery("FROM usuario").list();
	}

	@Override
	public Usuario recuperarPorCpf(String cpf) {
		return (Usuario) getCurrentSession().createQuery("FROM usuario WHERE cpf = :cpf").setString("cpf", cpf)
				.uniqueResult();
	}

	@Override
	public void atualizar(Usuario usuario) {
		getCurrentSession().update(usuario);
	}

	@Override
	public void remover(Usuario usuario) {
		getCurrentSession().delete(usuario);
	}

}
