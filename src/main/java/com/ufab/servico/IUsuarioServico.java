package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.Usuario;
import com.ufab.excecao.UsuarioServicoException;

public interface IUsuarioServico {

	/**
	 * Metodo utilizado para inserir um usuário no sistema.
	 * 
	 * @param usuario
	 *            Usuario que deseja ser inserido
	 * @throws UsuarioServicoException
	 *             Caso o usuário informado esteja inválido
	 */
	public void inserir(Usuario usuario) throws UsuarioServicoException;

	/**
	 * Metodo utilizado para listar todos os usuários que estao cadatrados no
	 * sistema.
	 * 
	 * @return Uma lista de usuários
	 */
	public List<Usuario> recuperarTodos();

	/**
	 * Metodo utilizado para recuperar um usuario do sistema, informando seu CPF
	 * 
	 * @param cpf
	 *            CPF do usuário que deseja ser recuperado.
	 * @return Um Usuario que possui o CPF informado
	 */
	public Usuario recuperarPorCpf(String cpf);

	/**
	 * Metodo utilizado para atualizar as informações de um usuário no sistema.
	 * 
	 * @param usuario
	 *            Usuario que deseja ser atualizado
	 * @throws UsuarioServicoException
	 *             Caso o usuário informado esteja inválido
	 */
	public void atualizar(Usuario usuario) throws UsuarioServicoException;

	/**
	 * Metodo utilizado para remover um usuário do sistema.
	 * 
	 * @param usuarioRequerente
	 *            Usuario que esta chamando a acao
	 * @param usuarioARemover
	 *            Usuario que deseja ser removido
	 * @exception UsuarioServicoException
	 *                Caso o usuário requerente não possua permissao para a acao de
	 *                remover.
	 */
	public void remover(Usuario usuarioRequerente, Usuario usuarioARemover) throws UsuarioServicoException;
	
	/**
	 * Metodo utilizado para retornar um usuario autenticado, caso exista.
	 * @return Usuario autenticado.
	 */
	public Usuario recuperarUsuarioAutenticado();
	
}
