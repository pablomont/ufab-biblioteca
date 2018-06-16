package com.ufab.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.ILocacaoDAO;
import com.ufab.entidade.Locacao;

@Repository
@Transactional
public class LocacaoDAO extends DAO implements ILocacaoDAO {

	@Override
	public void inserir(Locacao locacao) {
		getCurrentSession().save(locacao);

	}

	@Override
	public void remover(Locacao locacao) {
		getCurrentSession().delete(locacao);
	}

	@Override
	public List<Locacao> listarTodas() {
		return getCurrentSession().createQuery("FROM locacao").list();
	}

	@Override
	public void atualizar(Locacao locacao) {
		getCurrentSession().update(locacao);

	}

}
