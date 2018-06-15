package com.ufab.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Representa os funcionarios do sistema
 * 
 * @author Davi
 *
 */
@Entity(name = "funcionario")
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "FK_Usuario_cpf")
public class Funcionario extends Usuario {

	private static final long serialVersionUID = -2678352636915558732L;

	@Column(name = "nome_usuario", unique = true)
	private String nomeUsuario;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
}
