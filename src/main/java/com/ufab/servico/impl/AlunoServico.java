package com.ufab.servico.impl;

import org.springframework.stereotype.Service;

import com.ufab.entidade.Alocacao;
import com.ufab.entidade.Aluno;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.AlunoValidacaoException;
import com.ufab.servico.IAlunoServico;

/***
 * Servico para tratar de todas as manipulacoes de negocio com o Aluno
 * 
 * @author Davi
 *
 */
@Service
public class AlunoServico implements IAlunoServico {

	private static final Object SEPARADOR_MATRICULA = "-";

	@Override
	public void validarAluno(Aluno aluno) throws AlunoValidacaoException {
		if (aluno.getMatricula() == null) {
			throw new AlunoValidacaoException(MensagensEnum.ALUNO_SERVICO_ERRO_AO_VALIDAR_MATRICULA.getValor());
		}
		if (aluno.getTipoNivelAluno() == null) {
			throw new AlunoValidacaoException(MensagensEnum.ALUNO_SERVICO_ERRO_AO_VALIDAR_NIVEL.getValor());
		}
	}

	// TODO: Reafatorar esse metodo, estranho ter q usar a alocacao(que ja possui um
	// aluno) e o Aluno para receber uma matricula.
	@Override
	public String gerarMatricula(Alocacao alocacao, Aluno aluno) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(aluno.getTipoNivelAluno().getValor());
		stringBuilder.append(alocacao.getCurso().getTag());
		stringBuilder.append(SEPARADOR_MATRICULA);
		stringBuilder.append(alocacao.getId().getAno().substring(2, 4));
		stringBuilder.append(alocacao.getId().getPeriodo());
		stringBuilder.append(aluno.getCpf().substring(0, 4));
		return stringBuilder.toString();
	}

	@Override
	public String gerarMatricula(Alocacao alocacao) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(alocacao.getAluno().getTipoNivelAluno().getValor());
		stringBuilder.append(alocacao.getCurso().getTag());
		stringBuilder.append(SEPARADOR_MATRICULA);
		stringBuilder.append(alocacao.getId().getAno().substring(2, 4));
		stringBuilder.append(alocacao.getId().getPeriodo());
		stringBuilder.append(alocacao.getAluno().getCpf().substring(0, 4));
		return stringBuilder.toString();
	}

}
