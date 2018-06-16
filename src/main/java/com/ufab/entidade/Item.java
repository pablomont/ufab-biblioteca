package com.ufab.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/***
 * Classe de objetos do tipo Item, com valores e metodos dos mesmos.
 * 
 * @author Bianca
 *
 */
@Entity(name = "item")
@Table(name = "item")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item implements Serializable {

	private static final long serialVersionUID = -2445630987238795469L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(unique = true)
	private String titulo;
	private String nome;
	@Column(name = "quant_max_locacao")
	private int quantMax;

	@Enumerated(EnumType.STRING)
	private TipoItem tipoItem;

	@OneToMany(mappedBy = "item")
	private List<Locacao> locacoes;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantMax() {
		return quantMax;
	}

	public void setQuantMax(int quantMax) {
		this.quantMax = quantMax;
	}

}
