package com.ufab.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/***
 * Classe que define o tipo do Curso.
 * 
 * @author Bianca
 *
 */
@Entity(name = "tipocurso")
@Table(name = "tipocurso")
public class TipoCurso {

	@Id
	@GeneratedValue
	private long cod;

	private String nomeCurso;

	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nomeCurso;
	}

	public void setNome(String nome) {
		this.nomeCurso = nome;
	}

}
