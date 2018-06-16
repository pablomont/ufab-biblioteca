package com.ufab.servico.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.ICursoDAO;
import com.ufab.entidade.Curso;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.CursoServicoException;
import com.ufab.excecao.CursoValidacaoException;
import com.ufab.servico.ICursoServico;

/***
 * Servico para tratar de todas as manipulacoes de negocio com o Curso
 * 
 * @author Davi
 *
 */
@Service
public class CursoServico implements ICursoServico {

	private static final int TAMANHO_MAXIMO_DA_TAG = 2;

	private final Logger LOGGER = Logger.getLogger(CursoServico.class);

	@Autowired
	private ICursoDAO cursoDao;

	@Override
	public List<Curso> recuperarTodos() {
		return cursoDao.recuperarTodos();
	}

	@Override
	public void inserir(Curso curso) throws CursoServicoException {
		try {
			validar(curso);
			cursoDao.inserir(curso);
		} catch (CursoValidacaoException e) {
			LOGGER.error(MensagensEnum.CURSO_SERVICO_ERRO_AO_VALIDAR_CURSO.getValor(), e);
			throw new CursoServicoException(MensagensEnum.CURSO_SERVICO_ERRO_AO_VALIDAR_CURSO.getValor());
		} catch (Exception e) {
			LOGGER.error(MensagensEnum.CURSO_SERVICO_ERRO_DESCONHECIDO.getValor(), e);
			throw new CursoServicoException(MensagensEnum.CURSO_SERVICO_ERRO_DESCONHECIDO.getValor());
		}
	}

	@Override
	public Curso recuperarPorCod(int cod) throws CursoServicoException {
		return cursoDao.recuperarPorCod(cod);
	}

	@Override
	public void remover(Curso curso) throws CursoServicoException {
		if (curso == null) {
			throw new CursoServicoException(MensagensEnum.CURSO_SERVICO_ERRO_PARAMETRO_CURSO_NULO.getValor());
		}
		cursoDao.remover(curso);
	}

	@Override
	public void atualizar(Curso curso) throws CursoServicoException {
		if (curso == null) {
			throw new CursoServicoException(MensagensEnum.CURSO_SERVICO_ERRO_PARAMETRO_CURSO_NULO.getValor());
		}
		try {
			validar(curso);
			cursoDao.atualizar(curso);
		} catch (CursoValidacaoException e) {
			LOGGER.error(MensagensEnum.CURSO_SERVICO_ERRO_AO_VALIDAR_CURSO.getValor(), e);
			throw new CursoServicoException(MensagensEnum.CURSO_SERVICO_ERRO_AO_VALIDAR_CURSO.getValor());
		}
	}

	/**
	 * Validar os parametros de um curso, para verificar se o mesmo está válido par
	 * utilização.
	 * 
	 * @param curso
	 *            Curso recebido para validacao
	 * @throws CursoValidacaoException
	 *             Caso seja detectado que o curso esta invalido para inser , uma
	 *             exception como esta sera disparada.
	 */
	private void validar(Curso curso) throws CursoValidacaoException {
		if (curso == null) {
			throw new CursoValidacaoException(MensagensEnum.CURSO_SERVICO_O_CURSO_NAO_PODE_SER_NULO.getValor());
		} else if (curso.getNome() == null) {
			throw new CursoValidacaoException(MensagensEnum.CURSO_SERVICO_O_NOME_PODE_NAO_SER_NULO.getValor());
		} else if (curso.getTipoCurso() == null) {
			throw new CursoValidacaoException(MensagensEnum.CURSO_SERVICO_O_TIPO_DE_CURSO_NAO_PODE_SER_NULO.getValor());
		} else if (curso.getArea() == null) {
			throw new CursoValidacaoException(MensagensEnum.CURSO_SERVICO_A_AREA_PODE_NAO_SER_NULO.getValor());
		} else if (curso.getTag() == null) {
			throw new CursoValidacaoException(MensagensEnum.CURSO_SERVICO_TAG_NULO.getValor());
		} else if (curso.getTag().length() > TAMANHO_MAXIMO_DA_TAG) {
			throw new CursoValidacaoException(MensagensEnum.CURSO_SERVICO_TAG_INVALIDA.getValor());
		}
	}

}