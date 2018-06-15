package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/***
 * Classe para alocacao de alunos em um curso
 * 
 * @author Bianca
 *
 */
@Entity(name = "alocacao")
@Table(name = "alocacao")

public class Alocacao implements Serializable{

	private static final long serialVersionUID = 6339037942589705227L;

	@EmbeddedId
	private AlocacaoPrimaryKey id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_cpf", referencedColumnName = "usuario_cpf", nullable = false, updatable = false, insertable = false)
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_cod", referencedColumnName = "curso_cod", nullable = false, updatable = false, insertable = false)
	private Curso curso;

	public AlocacaoPrimaryKey getId() {
		return id;
	}

	public void setId(AlocacaoPrimaryKey id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
