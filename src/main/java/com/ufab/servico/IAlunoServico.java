package com.ufab.servico;


import com.ufab.entidade.Aluno;
import com.ufab.excecao.AlunoValidacaoException;

public interface IAlunoServico {

	/**
	 * Metodo utilizado para validar um aluno
	 * 
	 * @param aluno
	 *            Aluno que deseja ser Validado
	 * @throws AlunoValidacaoException
	 *             Caso o aluno informado esteja inválido
	 */
	public void validarAluno(Aluno aluno) throws AlunoValidacaoException;

	
	
	/**
	 * Metodo utilizado para gerar a matricula do aluno, dinamicamente e unica
	 * 
	 * @param alocacao
	 *            ALocacao necessaria pra criar a matricula
	 * @param aluno
	 *            Aluno que deseja receber a nova matricula
	 * @return Uma String com a matricula
	 */
	public String gerarMatricula(Aluno aluno);
}
