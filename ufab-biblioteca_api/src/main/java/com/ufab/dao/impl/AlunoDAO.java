package com.ufab.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.IAlunoDAO;
import com.ufab.entidade.Aluno;

@Repository
@Transactional
public class AlunoDAO extends DAO implements IAlunoDAO {

	@Override
	public void inserir(Aluno aluno) {
		getCurrentSession().save(aluno);	
	}

	@Override
	public List<Aluno> recuperarTodos() {
		return getCurrentSession().createQuery("FROM aluno").list();
	}

	@Override
	public Aluno recuperarPorMatricula(String matricula) {
		return (Aluno) getCurrentSession().createQuery("FROM aluno WHERE matricula = :matricula").setString("matricula", matricula)
				.uniqueResult();
	}

	@Override
	public Aluno recuperarPorId(int id) {
		return (Aluno) getCurrentSession().createQuery("FROM aluno WHERE id = :id").setInteger("id", id)
				.uniqueResult();
	}

	@Override
	public void atualizar(Aluno aluno) {
		getCurrentSession().update(aluno);
	}

	@Override
	public void remover(int aluno) {
		getCurrentSession().delete(recuperarPorId(aluno));
	}

}
