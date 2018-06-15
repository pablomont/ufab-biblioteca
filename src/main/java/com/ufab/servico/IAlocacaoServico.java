package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.Alocacao;

public interface IAlocacaoServico {

	/**
	 * Metodo utilizado para inserir uma alocacao no sistema.
	 * 
	 * @param alocacao
	 *            Alocacao que deseja ser inserida
	 */
	public void inserir(Alocacao alocacao);

	/**
	 * Metodo utilizado para remover uma alocacao do sistema.
	 * 
	 * @param alocacao
	 *            Alocacao que deseja ser removida
	 */
	public void remover(Alocacao alocacao);

	/**
	 * Metodo para atualizar uma alocacao
	 * 
	 * @param alocacao
	 *            Alocacao que deseja ser atualizada
	 */
	public void atualiar(Alocacao alocacao);

	/**
	 * Metodo para listar todas as alocacoes do sistema
	 * 
	 * @return Lista de alocacoes cadastradas
	 */
	public List<Alocacao> recuperarTodas();
}
