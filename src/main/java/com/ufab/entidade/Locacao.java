package com.ufab.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "locacao")
@Table(name = "locacao")
public class Locacao implements Serializable {

	private static final long serialVersionUID = -2699079820964753856L;

	@Id
	@GeneratedValue
	private int cod_locacao;

	private Date dt_locacao;

	private Date dt_devolucao;

	private boolean renovado;

	private boolean devolvido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_cpf", referencedColumnName = "usuario_cpf", nullable = false, updatable = false, insertable = false)
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo", referencedColumnName = "codigo", nullable = false, updatable = false, insertable = false)
	private Item item;

	public int getCod_locacao() {
		return cod_locacao;
	}

	public void setCod_locacao(int cod_locacao) {
		this.cod_locacao = cod_locacao;
	}

	public Date getDt_locacao() {
		return dt_locacao;
	}

	public void setDt_locacao(Date dt_locacao) {
		this.dt_locacao = dt_locacao;
	}

	public Date getDt_devolucao() {
		return dt_devolucao;
	}

	public void setDt_devolucao(Date dt_devolucao) {
		this.dt_devolucao = dt_devolucao;
	}

	public boolean isRenovado() {
		return renovado;
	}

	public void setRenovado(boolean renovado) {
		this.renovado = renovado;
	}

	public boolean isDevolvido() {
		return devolvido;
	}

	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
	
}
