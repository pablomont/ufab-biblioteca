package com.ufab.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.ufab.enumerador.PeriodoIngressoEnum;
import com.ufab.enumerador.TipoCursoEnum;

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
	@GeneratedValue
	@Column()
	private int id;
	
	@Column(unique = true)
	private String matricula;
	
	@Column(unique = true)
	private String naturalidade;
	
	@Column(unique = true)
	private String endereco;
	
	@Column(name = "nome_completo")
	private String nomeCompleto;
	
	@Column(unique = true, name = "cpf")
	private String cpf;
	
	@Column(unique = true, name = "rg")
	private String rg;

	@Enumerated(EnumType.STRING)
	private PeriodoIngressoEnum periodoIngresso;
	
	@Column(name = "nome_mae")
	private String nomeMae;

	@ManyToOne
    @JoinColumn(name = "curso")
	private Curso curso;
	
	@Enumerated(EnumType.STRING)
	private TipoCursoEnum tipoNivel;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoCursoEnum getTipoNivel() {
		return tipoNivel;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public PeriodoIngressoEnum getPeriodoIngresso() {
		return periodoIngresso;
	}

	public void setPeriodoIngresso(PeriodoIngressoEnum periodoIngresso) {
		this.periodoIngresso = periodoIngresso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;		
		setTipoNivel(curso.getTipo());
	}

	public void setTipoNivel(TipoCursoEnum tipoNivelAluno) {
		this.tipoNivel = tipoNivelAluno;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

}
