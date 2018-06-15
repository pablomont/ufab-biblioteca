package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.Perfil;
import com.ufab.enumerador.TipoPerfil;

public interface IPerfilServico {
	/**
	 * Metodo utiliziado para inserir um perfil no sistema.
	 * 
	 * @param perfil
	 *            Perfil que deseja ser inserido.
	 */
	public void inserir(Perfil perfil);

	/**
	 * Metodo utilizado para listar os perfis do sistema.
	 * 
	 * @return Uma lista com todas os perfis cadastrados no sistema.
	 */
	public List<Perfil> recuperarTodos();

	/**
	 * Metodo utilizado para buscar um Perfil de acordo com seu tipo
	 * @param tipoPerfil Tipo de perfil que deseja ser fitlrado
	 * @return Retorna o Perfil de acordo o tipo de perfil informado
	 */
	public Perfil recuperarPorTipo(TipoPerfil tipoPerfil);

}
