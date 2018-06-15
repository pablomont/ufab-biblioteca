package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ufab.enumerador.TipoPermissao;


/***
 *  Classe que define a permissao para os perfis do sistema
 * @author Bianca
 *
 */
@Entity(name = "permissao")
@Table(name = "permissao")
public class Permissao implements Serializable {

	private static final long serialVersionUID = -5184051873377181177L;
	@Id
	@GeneratedValue
	private int cod;

	@Enumerated(EnumType.STRING)
	@Column(unique = true, name = "nome")
	private TipoPermissao tipoPermissaoNome;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public TipoPermissao getTipoPermissao() {
		return tipoPermissaoNome;
	}

	public void setTipoPermissao(TipoPermissao nome) {
		this.tipoPermissaoNome = nome;
	}

}
