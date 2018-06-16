package com.ufab.servico.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.ILocacaoDAO;
import com.ufab.entidade.Locacao;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.LocacaoServicoException;
import com.ufab.excecao.LocacaoValidacaoException;
import com.ufab.servico.ILocacaoServico;

@Service
public class LocacaoServico implements ILocacaoServico {

	static final Logger LOGGER = Logger.getLogger(LocacaoServico.class);

	@Autowired
	private ILocacaoDAO locacaoDao;

	@Override
	public void inserir(Locacao locacao) throws LocacaoServicoException {
		try {
			validarLocacao(locacao);
			locacao.setDt_locacao(new Date(Calendar.getInstance().getTime().getTime()));
			locacaoDao.inserir(locacao);
		} catch (LocacaoValidacaoException e) {
			LOGGER.error(MensagensEnum.LOCACAO_SERVICO_ERRO_AO_VALIDAR.getValor());
			throw new LocacaoServicoException(e.getMessage());
		}
	}

	@Override
	public void remover(Locacao locacao) {
		locacaoDao.remover(locacao);
	}

	@Override
	public List<Locacao> listarTodas() {
		return locacaoDao.listarTodas();
	}

	@Override
	public void atualizar(Locacao locacao) throws LocacaoServicoException {
		try {
			validarLocacao(locacao);
			locacaoDao.atualizar(locacao);
		} catch (LocacaoValidacaoException e) {
			LOGGER.error(MensagensEnum.LOCACAO_SERVICO_ERRO_AO_VALIDAR.getValor());
			throw new LocacaoServicoException(e.getMessage());
		}

	}

	@Override
	public void validarLocacao(Locacao locacao) throws LocacaoValidacaoException {
		if (locacao == null) {
			throw new LocacaoValidacaoException(MensagensEnum.LOCACAO_SERVICO_VALIDACAO_NULL.getValor());
		}
		if (locacao.getDt_locacao() == null) {
			throw new LocacaoValidacaoException(MensagensEnum.LOCACAO_SERVICO_VALIDACAO_DT_LOCACAO.getValor());
		}
		if (locacao.getDt_devolucao() == null) {
			throw new LocacaoValidacaoException(MensagensEnum.LOCACAO_SERVICO_VALIDACAO_DT_DEVOLUCAO.getValor());
		}
		if (locacao.getAluno() == null) {
			throw new LocacaoValidacaoException(MensagensEnum.LOCACAO_SERVICO_VALIDACAO_ALUNO.getValor());
		}
		if (locacao.getItem() == null) {
			throw new LocacaoValidacaoException(MensagensEnum.LOCACAO_SERVICO_VALIDACAO_ITEM.getValor());
		}
	}

}
