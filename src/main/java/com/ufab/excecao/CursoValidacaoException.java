package com.ufab.excecao;

/**
 * Responsavel por estourar os erros de validacao de um curso.
 * @author Davi
 *
 */
public class CursoValidacaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1538019432769012470L;

	public CursoValidacaoException(String msg) {
		super(msg);
 }
}
