package com.ufab.servico.impl;

import org.springframework.stereotype.Service;


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


	@Override
	public String gerarMatricula(Aluno aluno) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(aluno.getTipoNivelAluno().getValor());
		stringBuilder.append(SEPARADOR_MATRICULA);
		stringBuilder.append(aluno.getCpf().substring(0, 4));
		return stringBuilder.toString();
	}

}
