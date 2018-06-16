package com.ufab.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.IPerfilDAO;
import com.ufab.entidade.Perfil;
import com.ufab.enumerador.TipoPerfil;

@Repository
@Transactional
public class PerfilDAO extends DAO implements IPerfilDAO, Serializable {

	private static final long serialVersionUID = 8859359766103745345L;

	@Override
	public void inserir(Perfil perfil) {
		getCurrentSession().saveOrUpdate(perfil);
	}

	@Override
	public List<Perfil> recuperarTodos() {
		return getCurrentSession().createQuery("FROM perfil").list();
	}

	@Override
	public Perfil recuperarPorTipo(TipoPerfil tipoPerfil) {
		return (Perfil) getCurrentSession().createQuery("FROM perfil WHERE nome = :nome")
				.setString("nome", tipoPerfil.name()).uniqueResult();
	}

}
