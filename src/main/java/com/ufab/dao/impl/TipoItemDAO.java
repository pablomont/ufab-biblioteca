package com.ufab.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ufab.dao.ITipoItemDAO;
import com.ufab.entidade.TipoItem;

@Repository
public class TipoItemDAO extends DAO implements ITipoItemDAO {
	

	@Override
	public void inserir(TipoItem tipoItem) {
		getCurrentSession().save(tipoItem);
	}

	@Override
	public List<TipoItem> listarTodos() {
		return getCurrentSession().createQuery("from tipocurso").list();
	}

}
