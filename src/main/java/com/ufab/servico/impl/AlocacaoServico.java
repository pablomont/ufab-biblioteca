package com.ufab.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.IAlocacaoDAO;
import com.ufab.entidade.Alocacao;
import com.ufab.servico.IAlocacaoServico;
/***
 * Servico para tratar de todas as manipulacoes de negocio com a Alocacao
 * 
 * @author Davi
 *
 */
@Service
public class AlocacaoServico implements IAlocacaoServico {

	@Autowired
	private IAlocacaoDAO alocacaoDao;

	@Override
	public void inserir(Alocacao alocacao) {
		alocacaoDao.inserir(alocacao);
	}

	@Override
	public void remover(Alocacao alocacao) {
		alocacaoDao.remover(alocacao);
	}

	@Override
	public void atualiar(Alocacao alocacao) {
		alocacaoDao.atualizar(alocacao);
	}

	@Override
	public List<Alocacao> recuperarTodas() {
		return alocacaoDao.recuperarTodas();
	}

}
