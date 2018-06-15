package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.Locacao;
import com.ufab.excecao.LocacaoServicoException;
import com.ufab.excecao.LocacaoValidacaoException;

public interface ILocacaoServico {

	/**
	 * Inserir uma locacao no sistema.
	 * @param locacao Locacao que deseja ser inserida
	 * @throws LocacaoServicoException Caso a locacao informada esteja inválida.
	 */
	public void inserir(Locacao locacao) throws LocacaoServicoException;

	/**
	 * Remover uma locacao do sistema.
	 * @param locacao Locacao que deseja ser removida.
	 */
	public void remover(Locacao locacao);

	/**
	 * Listar todas as locacoes.
	 * @return Retorna uma lista com todas as locacoes do sistema.
	 */
	public List<Locacao> listarTodas();

	/**
	 * Altualizar uma locacao
	 * @param locacao Locacao que deseja ser atualizada.
	 * @throws LocacaoServicoException Caso a locacao informada esteja inválida.
	 */
	public void atualizar(Locacao locacao) throws LocacaoServicoException;

	/**
	 * Validar uma locacao
	 * @param locacao Locacao que deseja ser validada.
	 * @throws LocacaoValidacaoException Caso a locacao informada esteja inválida.
	 */
	public void validarLocacao(Locacao locacao) throws LocacaoValidacaoException;

}
