package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/***
 * Classe para objetos do tipo Anais de Congresso que herdam de item suas
 * caracteristicas, com valores e metodos para os mesmos.
 * 
 * @author Bianca
 */
@Entity(name = "anaiscongresso")
@Table(name = "anaiscongresso")
@PrimaryKeyJoinColumn(name = "FK_Item_cod")
public class AnaisCongresso extends Item implements Serializable {

	private static final long serialVersionUID = -4450914185431808017L;
	@Column(name = "nome_congresso")
	private String nomeCongresso;

	@Column(name = "ano_publicacao")
	private int anoPublicacao;

	private String autor;
	private String local;

	@ManyToOne
	@JoinColumn(name = "FK_TipoAnaisCongresso_cod")
	private TipoAnaisCongresso tipoAnaisCongresso;

	public TipoAnaisCongresso getTipoAnaisCongresso() {
		return tipoAnaisCongresso;
	}

	public void setTipoAnaisCongresso(TipoAnaisCongresso tipoAnaisCongresso) {
		this.tipoAnaisCongresso = tipoAnaisCongresso;
	}

	public String getNomeCongresso() {
		return nomeCongresso;
	}

	public void setNomeCongresso(String nomeCongresso) {
		this.nomeCongresso = nomeCongresso;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
