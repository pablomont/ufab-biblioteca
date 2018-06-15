package com.ufab.servico.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.IItemDAO;
import com.ufab.entidade.Item;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.ItemServicoException;
import com.ufab.excecao.ItemValidacaoException;
import com.ufab.servico.IItemServico;

/***
 * Servico para tratar de todas as manipulacoes de negocio com o Item
 * 
 * @author Bianca
 *
 */

@Service
public class ItemServico implements IItemServico {

	private final Logger LOGGER = Logger.getLogger(ItemServico.class);

	@Autowired
	private IItemDAO itemDao;

	@Override
	public void inserir(Item item) throws ItemServicoException {
		try {
			validar(item);
			itemDao.inserir(item);
		} catch (ItemValidacaoException e) {
			LOGGER.error(MensagensEnum.ITEM_SERVICO_ERRO_AO_VALIDAR_ITEM.getValor(), e);
			throw new ItemServicoException(MensagensEnum.ITEM_SERVICO_ERRO_AO_VALIDAR_ITEM.getValor());
		} catch (Exception e) {
			LOGGER.error(MensagensEnum.ITEM_SERVICO_ERRO_DESCONHECIDO.getValor(), e);
			throw new ItemServicoException(MensagensEnum.ITEM_SERVICO_ERRO_DESCONHECIDO.getValor());
		}

	}

	@Override
	public Item recuperarPorCodigo(int codigo) throws ItemServicoException {
		return itemDao.recuperarPorCodigo(codigo);

	}

	@Override
	public List<Item> recuperarTodos() {
		return itemDao.recuperarTodos();
	}

	@Override
	public void atualizar(Item item) throws ItemServicoException {
		if (item == null) {
			throw new ItemServicoException(MensagensEnum.ITEM_SERVICO_ERRO_PARAMETRO_ITEM_NULO.getValor());
		}
		try {
			validar(item);
			itemDao.atualizar(item);
		} catch (ItemValidacaoException e) {
			LOGGER.error(MensagensEnum.ITEM_SERVICO_ERRO_AO_VALIDAR_ITEM.getValor(), e);
			throw new ItemServicoException(MensagensEnum.ITEM_SERVICO_ERRO_AO_VALIDAR_ITEM.getValor());
		}

	}

	@Override
	public void remover(Item item) throws ItemServicoException {
		if (item == null) {
			throw new ItemServicoException(MensagensEnum.ITEM_SERVICO_ERRO_PARAMETRO_ITEM_NULO.getValor());
		}
		itemDao.remover(item);
	}

	/**
	 * Validar os parametros de um item, para verificar se os mesmos estao validos
	 * para utilizacao.
	 * 
	 * @author Bianca
	 * 
	 * @param item
	 *            Item recebido para validacao
	 * @throws ItemValidacaoException
	 *             Caso seja detectado que o item esta invalido para insercao, uma
	 *             exception como esta sera disparada.
	 */
	private void validar(Item item) throws ItemValidacaoException {
		if (item == null) {
			throw new ItemValidacaoException(MensagensEnum.ITEM_SERVICO_O_ITEM_NAO_PODE_SER_NULO.getValor());
		} else if (item.getNome() == null) {
			throw new ItemValidacaoException(MensagensEnum.ITEM_SERVICO_O_NOME_PODE_NAO_SER_NULO.getValor());
		} else if (item.getTipoItem() == null) {
			throw new ItemValidacaoException(MensagensEnum.ITEM_SERVICO_O_TIPO_DE_ITEM_NAO_PODE_SER_NULO.getValor());
		} else if (item.getTitulo() == null) {
			throw new ItemValidacaoException(MensagensEnum.ITEM_SERVICO_O_TITULO_PODE_NAO_SER_NULO.getValor());
		}
	}

}
