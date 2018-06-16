package com.ufab.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.ufab.enumerador.TipoNivelAluno;

/**
 * Representa os Alunos do sistemaa
 * 
 * @author Davi
 *
 */
@Entity(name = "aluno")
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "FK_Usuario_cpf")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 2739350983865960294L;

	@Id
	@Column(unique = true)
	private String matricula;
	
	@Column(name = "aluno_cpf")
	private String cpf;

	@Enumerated(EnumType.STRING)
	private TipoNivelAluno tipoNivelAluno;

	@Column(name = "nome_mae")
	private String nomeMae;


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoNivelAluno getTipoNivelAluno() {
		return tipoNivelAluno;
	}

	public void setTipoNivelAluno(TipoNivelAluno tipoNivelAluno) {
		this.tipoNivelAluno = tipoNivelAluno;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

}
