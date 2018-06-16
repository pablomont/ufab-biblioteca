package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/***
 * Classe que define a chave primaria da entidade Alocacao
 * 
 * @author Bianca
 * 
 * @param ano
 *            - Ano de ingresso no curso
 * @param periodo
 *            - Periodo de ingresso
 * @param codCurso
 *            - Codigo de identificacao do curso
 * @param cpfAlu
 *            - Cfp do aluno como chave de identificacao
 */

@Embeddable
public class AlocacaoPrimaryKey implements Serializable {

	private static final long serialVersionUID = -4575425848885346079L;

	public AlocacaoPrimaryKey(String ano, String periodo, int codCurso, String cpfAlu) {
		super();
		this.ano = ano;
		this.periodo = periodo;
		this.codCurso = codCurso;
		this.cpfAlu = cpfAlu;
	}

	@Column(name = "ano_ingresso", nullable = false)
	private String ano;

	@Column(name = "periodo_ingresso", nullable = false)
	private String periodo;

	@Column(name = "curso_cod")
	private int codCurso;

	@Column(name = "usuario_cpf")
	private String cpfAlu;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
