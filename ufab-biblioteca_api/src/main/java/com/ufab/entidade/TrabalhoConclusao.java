package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/***
 * Classe de objetos do tipo "trabalhoConclusao", que herdam as caracteristicas
 * de Item. Com seus respectivos valores e metodos.
 * 
 * @author Bianca
 *
 */
@Entity(name = "trabalhoconclusao")
@Table(name = "trabalhoconclusao")
@PrimaryKeyJoinColumn(name = "FK_Item_cod")
public class TrabalhoConclusao extends Item implements Serializable {

	private static final long serialVersionUID = -4654520096435655910L;
	private String orientador;
	private String autor;
	private int anoDefesa;
	private String local;

	@ManyToOne
	@JoinColumn(name = "FK_TipoTrabalhoConclusao_cod")
	private TipoTrabalhoConclusao tipoTrabalhoConclusao;

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnoDefesa() {
		return anoDefesa;
	}

	public void setAnoDefesa(int anoDefesa) {
		this.anoDefesa = anoDefesa;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
