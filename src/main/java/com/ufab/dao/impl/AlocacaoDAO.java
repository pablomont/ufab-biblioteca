package com.ufab.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.IAlocacaoDAO;
import com.ufab.entidade.Alocacao;

@Repository
@Transactional
public class AlocacaoDAO extends DAO implements IAlocacaoDAO {

	@Override
	public void inserir(Alocacao alocacao) {
		getCurrentSession().save(alocacao);
	}

	@Override
	public void remover(Alocacao alocacao) {
		getCurrentSession().delete(alocacao);
	}

	@Override
	public void atualizar(Alocacao alocacao) {
		getCurrentSession().update(alocacao);
	}

	@Override
	public List<Alocacao> recuperarTodas() {
		return getCurrentSession().createQuery("FROM alocacao").list();
	}

}
