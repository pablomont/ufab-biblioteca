package com.ufab.servico.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.ITipoItemDAO;
import com.ufab.entidade.TipoItem;
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
	private ITipoItemDAO iTipoItemDAO;
	

	@Override
	public void inserir(TipoItem tipoItem) {
		iTipoItemDAO.inserir(tipoItem);
	}

	@Override
	public List<TipoItem> listarTodos() {
		return iTipoItemDAO.listarTodos();
	}
	
}
