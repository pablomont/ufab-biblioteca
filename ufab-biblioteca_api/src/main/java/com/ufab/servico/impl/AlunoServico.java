package com.ufab.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.IAlunoDAO;
import com.ufab.entidade.Aluno;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.AlunoServicoException;
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
	
	@Autowired
	private IAlunoDAO alunoDao;

	@Override
	public void validarAluno(Aluno aluno) throws AlunoValidacaoException {
		if (aluno.getMatricula() == null) {
			throw new AlunoValidacaoException(MensagensEnum.ALUNO_SERVICO_ERRO_AO_VALIDAR_MATRICULA.getValor());
		}
		if (aluno.getTipoNivel() == null) {
			throw new AlunoValidacaoException(MensagensEnum.ALUNO_SERVICO_ERRO_AO_VALIDAR_NIVEL.getValor());
		}
	}

	@Override
	public String gerarMatricula(Aluno aluno) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(aluno.getTipoNivel().toString().charAt(0));
		stringBuilder.append(SEPARADOR_MATRICULA);
		stringBuilder.append(aluno.getCpf().substring(0, 4));
		return stringBuilder.toString();
	}

	@Override
	public void remover(Integer id) throws AlunoServicoException {
		Aluno aluno = recuperarPorId(id);
		if(aluno == null)
			throw new AlunoServicoException(MensagensEnum.USUARIO_SERVICO_ERRO_AO_REMOVER.getValor());
		
		alunoDao.remover(id); //detached
		
	}


	@Override
	public Aluno recuperarPorId(int id) {
		return alunoDao.recuperarPorId(id);
	}


	@Override
	public List<Aluno> recuperarTodos() {
		return alunoDao.recuperarTodos();
	}


	@Override
	public Aluno recuperarPorMatricula(String matricula) {
		return alunoDao.recuperarPorMatricula(matricula);
	}


	@Override
	public void inserir(Aluno aluno) throws AlunoServicoException {
		try {
			aluno.setMatricula(gerarMatricula(aluno));
			validarAluno(aluno);
			
			alunoDao.inserir(aluno);
		} catch (AlunoValidacaoException e) {
			throw new AlunoServicoException("Erro ao validar aluno");
		}
		
	}

	@Override
	public void atualizar(Aluno aluno) throws AlunoServicoException {
		try {
			validarAluno(aluno);
			
			alunoDao.atualizar(aluno);
		} catch (AlunoValidacaoException e) {
			throw new AlunoServicoException("Erro ao validar aluno");
		}
	}	
}
