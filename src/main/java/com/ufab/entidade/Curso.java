package com.ufab.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Classe par objetos do tipo Curso, com valores e metodos para os mesmos.
 * 
 * @author Bianca
 *
 */
@Entity(name = "curso")
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 3059184459770169333L;
	@Id
	@GeneratedValue
	@Column(name = "curso_cod")
	private int cod;

	@Column(unique = true)
	private String nome;

	private String area;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_TipoCurso_cod")
	private TipoCurso tipoCurso;

	@OneToMany(mappedBy = "curso")
	private List<Alocacao> alocacoes;


	private String tag;

	public TipoCurso getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(TipoCurso tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public List<Alocacao> getAlocacoes() {
		return alocacoes;
	}

}
