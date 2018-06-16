package com.ufab.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.IPermissaoDAO;
import com.ufab.entidade.Permissao;
@Repository
@Transactional
public class PermissaoDAO extends DAO implements Serializable, IPermissaoDAO {

	private static final long serialVersionUID = 7598035985379286215L;

	@Override
	public void inserir(Permissao permissao) {
		getCurrentSession().saveOrUpdate(permissao);
	}

	@Override
	public List<Permissao> recuperarTodas() {
		return getCurrentSession().createQuery("FROM permissao").list();
	}

}
