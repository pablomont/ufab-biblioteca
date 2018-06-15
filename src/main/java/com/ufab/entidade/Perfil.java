package com.ufab.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ufab.enumerador.TipoPerfil;

/**
 * Representa todos os perfis do sistema.
 * 
 * @author Davi
 *
 */
@Entity(name = "perfil")
@Table(name = "perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1790049006756602158L;
	@Id
	@GeneratedValue
	private int cod;

	@Enumerated(EnumType.STRING)
	@Column(unique = true, name = "nome")
	private TipoPerfil tipoPerfilNome;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "perfil_permissao", joinColumns = { @JoinColumn(name = "perfil_cod") }, inverseJoinColumns = {
			@JoinColumn(name = "permissao_cod") })
	private List<Permissao> permissoes;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public TipoPerfil getTipoPerfil() {
		return tipoPerfilNome;
	}

	public void setTipoPerfilNome(TipoPerfil tipoPerfilNome) {
		this.tipoPerfilNome = tipoPerfilNome;
	}
}
