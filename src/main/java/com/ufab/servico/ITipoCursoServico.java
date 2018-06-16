package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.TipoCurso;

public interface ITipoCursoServico {

	/**
	 * Metodo utilizado para inserir um curso no sistema.
	 * 
	 * @param tipoCurso
	 *            Tipo de curso que deseja ser inserido
	 */
	public void inserir(TipoCurso tipoCurso);

	/**
	 * Metodo utilizado para listar os tipos de curso
	 * 
	 * @return Uma lista com todos os tipos de curso cadastrados no sistema.
	 */
	public List<TipoCurso> listarTodos();

	/**Metodo utilizado para recuperar o tipo de curso pelo codigo
	 * @param tipoCursoCodigo Codigo do Tipo
	 * @return TipoCurso que contem o codigo informado.
	 */
	public TipoCurso recuperarPorCodigo(int tipoCursoCodigo);
}
