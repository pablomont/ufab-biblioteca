package com.ufab.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.IPermissaoDAO;
import com.ufab.entidade.Permissao;
import com.ufab.entidade.Usuario;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.enumerador.TipoPermissao;
import com.ufab.excecao.PermissaoServicoException;
import com.ufab.servico.IPermissaoServico;
/***
 * Servico para tratar de todas as manipulacoes de negocio com a Permissao
 * 
 * @author Davi
 *
 */
@Service
public class PermissaoServico implements IPermissaoServico {

	@Autowired
	private IPermissaoDAO permissaoDao;

	@Override
	public void inserir(Permissao permissao) {
		permissaoDao.inserir(permissao);
	}

	@Override
	public List<Permissao> recuperarTodas() {
		return permissaoDao.recuperarTodas();
	}

	@Override
	public void verificarPermissao(Usuario usuarioRequerente, TipoPermissao permissao) throws PermissaoServicoException {
		boolean possuiPermissao = false;
		for (Permissao permissaoAtual : usuarioRequerente.getPerfil().getPermissoes()) {
			if (permissaoAtual.getTipoPermissao().equals(TipoPermissao.EXCLUIR_ALUNO)) {
				possuiPermissao = true;
			}
		}
		if (!possuiPermissao) {
			throw new PermissaoServicoException(MensagensEnum.PERMISSAO_SERVICO_USUARIO_NAO_POSSUI_PERMISSAO.getValor());
		}
	}

}
