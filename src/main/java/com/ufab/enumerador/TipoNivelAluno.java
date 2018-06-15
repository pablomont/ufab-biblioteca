package com.ufab.enumerador;

public enum TipoNivelAluno {
	GRADUACAO("G"), MESTRADO("M"), ESPECIALIZACAO("E"), DOUTORADO("D");

	private String valor;

	private TipoNivelAluno(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}
}
