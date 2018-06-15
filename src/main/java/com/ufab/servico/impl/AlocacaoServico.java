package com.ufab.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.entidade.Alocacao;
import com.ufab.repository.AlocacaoRepository;
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
	private AlocacaoRepository alocacaoRepo;

	@Override
	public void inserir(Alocacao alocacao) {
		alocacaoRepo.save(alocacao);
	}

	@Override
	public void remover(Alocacao alocacao) {
		alocacaoRepo.delete(alocacao);
	}

	@Override
	public void atualiar(Alocacao alocacao) {
		alocacaoRepo.save(alocacao);
	}

	@Override
	public List<Alocacao> recuperarTodas() {
		return alocacaoRepo.findAll();
	}

}
