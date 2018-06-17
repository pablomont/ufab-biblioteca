package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.Item;
import com.ufab.excecao.ItemServicoException;

public interface IItemServico {

	/**
	 * Inserir um Item no sistema.
	 * 
	 * @param item
	 *            Item que deseja ser inerido
	 * @throws ItemServicoException
	 *             Caso ocorra algum erro durante a operação.
	 */
	public void inserir(Item item) throws ItemServicoException;

	/**
	 * Recuperar um Item, informando seu código.
	 * 
	 * @param codigo
	 *            Valor que será utilizado para recuperação.
	 * @return Caso encontre, retorna com um objeto do tipo Curso.
	 * @throws ItemServicoException Caso o item esteja invalido
	 */
	public Item recuperarPorCodigo(int codigo) throws ItemServicoException;

	/**
	 * Listar todos os Itens cadastrados no sistema.
	 * 
	 * @return Um List de Item.
	 */
	public List<Item> recuperarTodos();

	/**
	 * Atualizar as informações de um Item
	 * 
	 * @param item
	 *            Item que deseja ser atualizado.
	 * @throws ItemServicoException Caso o item esteja invalido
	 */
	public void atualizar(Item item) throws ItemServicoException;

	/**
	 * Remover um Item do sistema.
	 * 
	 * @param item
	 *            Item que deseja ser removido.
	 * @throws ItemServicoException Caso o item esteja invalido
	 */
	public void remover(Item item) throws ItemServicoException;
}
