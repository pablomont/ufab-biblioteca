package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.Perfil;
import com.ufab.enumerador.TipoPerfil;

public interface IPerfilDAO {

	public void inserir(Perfil perfil);

	public List<Perfil> recuperarTodos();

	public Perfil recuperarPorTipo(TipoPerfil tipoPerfil);

}
