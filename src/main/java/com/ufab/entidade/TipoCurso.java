package com.ufab.entidade;

import javax.persistence.Column;
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

	@Column
	private String tipo;

	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

 

}
