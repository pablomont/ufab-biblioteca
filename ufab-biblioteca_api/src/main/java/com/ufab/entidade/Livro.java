package com.ufab.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/***
 * Classe de objetos do tipo Livro, que herdam as caracteristicas do Item, com
 * valores e metodos dos mesmos.
 * 
 * @author Bianca
 *
 */
@Entity(name = "livro")
@Table(name = "livro")
@PrimaryKeyJoinColumn(name = "FK_Item_cod")

public class Livro extends Item implements Serializable {

	private static final long serialVersionUID = 505142922211968398L;
	private String autor;
	private String isbn;
	private String tema;
	private String editora;
	@Column(name = "ano_publicacao")
	private Date anoPublicacao;
	private String edicao;
	@Column(name = "nmr_pagina")
	private int nmrPagina;
	private String area;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Date getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Date anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public int getNmrPagina() {
		return nmrPagina;
	}

	public void setNmrPagina(int nmrPagina) {
		this.nmrPagina = nmrPagina;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
