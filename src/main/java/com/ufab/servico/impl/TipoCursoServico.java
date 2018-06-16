package com.ufab.servico.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.ITipoCursoDAO;
import com.ufab.entidade.TipoCurso;
import com.ufab.servico.ITipoCursoServico;
/***
 * Servico para tratar de todas as manipulacoes de negocio com o Tipo de curso
 * 
 * @author Davi
 *
 */
@Service
@Transactional
public class TipoCursoServico implements ITipoCursoServico {

	@Autowired
	private ITipoCursoDAO iTipoCursoDAO;

	@Override
	public void inserir(TipoCurso tipoCurso) {
		iTipoCursoDAO.inserir(tipoCurso);
	}

	@Override
	public List<TipoCurso> listarTodos() {
		return iTipoCursoDAO.listarTodos();
	}

	@Override
	public TipoCurso recuperarPorCodigo(int tipoCursoCodigo) {
		
		return iTipoCursoDAO.recuperarPorCodigo(tipoCursoCodigo);
	}
}
