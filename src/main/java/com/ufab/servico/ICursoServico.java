package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.Curso;
import com.ufab.excecao.CursoServicoException;

public interface ICursoServico {

	/***
	 * Metodo para listar todos os cursos cadastrados no sistema.
	 * 
	 * @return Retorna um List com os cursos.
	 */
	public List<Curso> recuperarTodos();

	/**
	 * Inserir um Curso no sistema
	 * 
	 * @param curso
	 *            Curso que deseja ser inserido no sistema.
	 * @throws CursoServicoException
	 *             Caso ocorra algum erro ao inserir, seja por validação ou outro
	 *             tipo.
	 */
	public void inserir(Curso curso) throws CursoServicoException;

	/**
	 * Recuperar um curso de acordo com seu codigo.
	 * 
	 * @param cod
	 *            Codigo do Curso que deseja recuperar
	 * @return Encontrando retorna com o objeto Curso, que contém o codigo
	 *         especificado
	 * @exception CursoServicoException
	 *                Caso ocorra algum erro com o código do Curso
	 */
	public Curso recuperarPorCod(int cod) throws CursoServicoException;

	/**
	 * Remover um curso informando seu codigo.
	 * 
	 * @param curso
	 *            Curso que existe no sistema, e deseja ser removido
	 * @exception CursoServicoException
	 *                Caso ocorra algum erro com o Curso informado
	 */
	public void remover(Curso curso) throws CursoServicoException;

	/**
	 * Atualizar os dados de um curso, sendo ele informado via parametro para o
	 * metodo.
	 * 
	 * @param curso
	 *            O Curso que deseja ser atualizado.
	 * @throws CursoServicoException
	 *             Lanca excecao caso ocorra um erro na validacao do Curso
	 */
	public void atualizar(Curso curso) throws CursoServicoException;

}
