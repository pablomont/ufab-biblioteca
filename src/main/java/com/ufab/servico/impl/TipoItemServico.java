package com.ufab.servico.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.entidade.TipoItem;
import com.ufab.repository.TipoItemRepository;
import com.ufab.servico.ITipoItemServico;
/***
 * Servico para tratar de todas as manipulacoes de negocio com o Tipo de item
 * 
 * @author Davi
 *
 */
@Service
@Transactional
public class TipoItemServico implements ITipoItemServico {
	
	@Autowired
	private TipoItemRepository iTipoItemRepo;
	

	@Override
	public void inserir(TipoItem tipoItem) {
		iTipoItemRepo.save(tipoItem);
	}

	@Override
	public List<TipoItem> listarTodos() {
		return iTipoItemRepo.findAll();
	}
	
}
