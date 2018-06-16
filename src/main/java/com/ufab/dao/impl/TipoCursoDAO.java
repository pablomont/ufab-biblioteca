package com.ufab.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.ITipoCursoDAO;
import com.ufab.entidade.TipoCurso;

@Repository
@Transactional
public class TipoCursoDAO extends DAO implements ITipoCursoDAO {

	@Override
	public void inserir(TipoCurso tipoCurso) {
		getCurrentSession().save(tipoCurso);
	}

	@Override
	public List<TipoCurso> listarTodos() {
		return getCurrentSession().createQuery("from tipocurso").list();
	}

	@Override
	public TipoCurso recuperarPorCodigo(int tipoCursoCodigo) {

		return (TipoCurso) getCurrentSession().createQuery("FROM tipocurso WHERE cod = :cod")
				.setInteger("cod", tipoCursoCodigo).uniqueResult();
	}

}
