package com.ufab.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.ICursoDAO;
import com.ufab.entidade.Curso;
@Repository
@Transactional
public class CursoDAO extends DAO implements ICursoDAO {

	@Override
	public void inserir(Curso c) {
		getCurrentSession().save(c);
	}

	@Override
	public List<Curso> recuperarTodos() {
		return getCurrentSession().createQuery("FROM curso").list();
	}

	@Override
	public Curso recuperarPorCod(int cod) {
		return (Curso) getCurrentSession().createQuery("from curso where cod = :cod").setInteger("cod", cod)
				.uniqueResult();
	}

	@Override
	public void remover(Curso curso) {
		getCurrentSession().delete(curso);
	}

	@Override
	public void atualizar(Curso curso) {
		getCurrentSession().update(curso);
	}

}
