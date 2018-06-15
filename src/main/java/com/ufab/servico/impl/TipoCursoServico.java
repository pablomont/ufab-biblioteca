package com.ufab.servico.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.entidade.TipoCurso;
import com.ufab.repository.TipoCursoRepository;
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
	private TipoCursoRepository tipoCursoRepository;

	@Override
	public void inserir(TipoCurso tipoCurso) {
		tipoCursoRepository.save(tipoCurso);
	}

	@Override
	public List<TipoCurso> listarTodos() {
		return tipoCursoRepository.findAll();
	}

	@Override
	public TipoCurso recuperarPorCodigo(Integer tipoCursoCodigo) {
		return tipoCursoRepository.procurarPorId(tipoCursoCodigo);
	}
}
