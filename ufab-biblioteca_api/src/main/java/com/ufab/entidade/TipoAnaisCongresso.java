package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * Classe de objetos do tipo "tipo Anais de Congresso" , com seus respectivos
 * valores e metodos.
 * 
 * @author Bianca
 *
 */
@Entity(name = "tipoanaiscongresso")
@Table(name = "tipoanaiscongresso")

public class TipoAnaisCongresso implements Serializable {

	private static final long serialVersionUID = -4296178742676921434L;
	@Id
	@GeneratedValue
	private int cod;
	private String nome;

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
}
