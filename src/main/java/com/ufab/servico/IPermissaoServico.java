package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.Permissao;
import com.ufab.entidade.Usuario;
import com.ufab.enumerador.TipoPermissao;
import com.ufab.excecao.PermissaoServicoException;

public interface IPermissaoServico {

	/**
	 * Metodo utiliziado para inserir uma permissao no sistema.
	 * 
	 * @param permissao
	 *            Permissao que deseja ser inserida.
	 */
	public void inserir(Permissao permissao);

	/**
	 * Metodo utilizado para listar as permissoes do sistema.
	 * 
	 * @return Uma lista com todas a permissoes cadastradas no sistema.
	 */
	public List<Permissao> recuperarTodas();
	
	public void verificarPermissao(Usuario usuario, TipoPermissao permissao) throws PermissaoServicoException;
}
