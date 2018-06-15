package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.TipoItem;

/**
 * @author Davi
 *
 *@deprecated Com a retidada da entidade TipoItem, a classe de servico ficou desuso.
 */
public interface ITipoItemServico {
	/**
	 * @param tipoItem
	 *            Tipo de item que deseja ser cadastrado.
	 */
	public void inserir(TipoItem tipoItem);

	/**
	 * @return Uma lista de todos os tipos de item do sistema.
	 */
	public List<TipoItem> listarTodos();
}
