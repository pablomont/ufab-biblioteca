package com.ufab.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/***
 * Classe de objetos do tipo Revista, que herdam as caracteristicas do Item,
 * com valores e metodos dos mesmos.
 * @author Bianca
 *
 */
@Entity(name = "revista")
@Table(name = "revista")
@PrimaryKeyJoinColumn(name = "FK_Item_cod")

public class Revista extends Item implements Serializable{
	

	private static final long serialVersionUID = -1075557342519416764L;

	@Column(name = "nmr_pagina")
	private int nmrPagina;
	@Column(name = "data_publicacao")
	private Date dataPublicacao;
	private String edicao;
	private String editora;

	public int getNmrPagina() {
		return nmrPagina;
	}

	public void setNmrPagina(int nmrPagina) {
		this.nmrPagina = nmrPagina;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

}
