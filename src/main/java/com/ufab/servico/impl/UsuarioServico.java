package com.ufab.servico.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.IUsuarioDAO;
import com.ufab.entidade.Aluno;
import com.ufab.entidade.Usuario;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.enumerador.TipoPerfil;
import com.ufab.enumerador.TipoPermissao;
import com.ufab.excecao.AlunoValidacaoException;
import com.ufab.excecao.PermissaoServicoException;
import com.ufab.excecao.UsuarioServicoException;
import com.ufab.excecao.UsuarioValidacaoException;
import com.ufab.servico.IAlunoServico;
import com.ufab.servico.IPermissaoServico;
import com.ufab.servico.IUsuarioServico;

/***
 * Servico para tratar de todas as manipulacoes de negocio com o Usuario
 * 
 * @author Davi
 *
 */
@Service
@Transactional
public class UsuarioServico implements IUsuarioServico {

	private Logger LOGGER = Logger.getLogger(UsuarioServico.class);

	@Autowired
	private IUsuarioDAO usuarioDao;

	@Autowired
	private IAlunoServico alunoServico;

	@Autowired
	private IPermissaoServico permissaoServico;

	@Override
	public void inserir(Usuario usuario) throws UsuarioServicoException {
		try {
			validarUsuario(usuario);
			if (usuario.getPerfil().getTipoPerfil().equals(TipoPerfil.ALUNO)) {
				alunoServico.validarAluno((Aluno) usuario);
			}
			usuarioDao.inserir(usuario);
		} catch (UsuarioValidacaoException e) {
			LOGGER.error(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_USUARIO.getValor(), e);
			throw new UsuarioServicoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_INSERIR.getValor());
		} catch (AlunoValidacaoException e) {
			LOGGER.error(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_USUARIO_ALUNO.getValor(), e);
			throw new UsuarioServicoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_INSERIR.getValor());
		}

	}

	@Override
	public List<Usuario> recuperarTodos() {
		return usuarioDao.recuperarTodos();
	}

	@Override
	public Usuario recuperarPorCpf(String cpf) {
		return usuarioDao.recuperarPorCpf(cpf);
	}

	@Override
	public void atualizar(Usuario usuario) throws UsuarioServicoException {
		try {
			validarUsuario(usuario);
			if (usuario.getPerfil().getTipoPerfil().equals(TipoPerfil.ALUNO)) {
				alunoServico.validarAluno((Aluno) usuario);
			}
			usuarioDao.atualizar(usuario);
		} catch (UsuarioValidacaoException e) {
			LOGGER.error(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_USUARIO.getValor(), e);
			throw new UsuarioServicoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_ATUALIZAR.getValor());
		} catch (AlunoValidacaoException e) {
			LOGGER.error(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_USUARIO_ALUNO.getValor(), e);
			throw new UsuarioServicoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_INSERIR.getValor());
		}
	}

	private void validarUsuario(Usuario usuario) throws UsuarioValidacaoException {
		if (usuario == null) {
			throw new UsuarioValidacaoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_USUARIO_NULO.getValor());
		}
		if (usuario.getCpf() == null) {
			throw new UsuarioValidacaoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_CPF_NULO.getValor());
		}
		if (usuario.getDataNascimento() == null) {
			throw new UsuarioValidacaoException(
					MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_DATA_NASCIMENTO_NULO.getValor());
		}
		if (usuario.getEndereco() == null) {
			throw new UsuarioValidacaoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_ENDERECO_NULO.getValor());
		}
		if (usuario.getFone() == null) {
			throw new UsuarioValidacaoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_TELEFONE_NULO.getValor());
		}
		if (usuario.getNaturalidade() == null) {
			throw new UsuarioValidacaoException(
					MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_NATURALIDADE_NULO.getValor());
		}
		if (usuario.getNomeCompleto() == null) {
			throw new UsuarioValidacaoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_NOME_NULO.getValor());
		}
		if (usuario.getRg() == null) {
			throw new UsuarioValidacaoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_RG_NULO.getValor());
		}
		if (usuario.getSenha() == null) {
			throw new UsuarioValidacaoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_SENHA_NULO.getValor());
		}
		if (usuario.getPerfil() == null) {
			throw new UsuarioValidacaoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_VALIDAR_PERFIL_NULO.getValor());
		}
	}

	@Override
	public void remover(Usuario usuarioRequerente, Usuario usuarioARemover) throws UsuarioServicoException {
		try {
			if (usuarioARemover.getPerfil().getTipoPerfil().equals(TipoPerfil.ALUNO)) {
				permissaoServico.verificarPermissao(usuarioRequerente, TipoPermissao.EXCLUIR_ALUNO);
			}
			usuarioDao.remover(usuarioARemover);
		} catch (PermissaoServicoException e) {
			LOGGER.error(e);
			throw new UsuarioServicoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_REMOVER.getValor());
		}

	}
}
