package com.ufab.servico.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ufab.entidade.Curso;
import com.ufab.entidade.TipoCurso;
import com.ufab.excecao.CursoServicoException;
import com.ufab.servico.ICursoServico;
import com.ufab.servico.ITipoCursoServico;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoServicoTest {

	@Autowired
	private ICursoServico cursoServico;

	@Autowired
	private ITipoCursoServico tipoCursoServico;

	@Test
	public void listarCursos() {
		assertTrue(cursoServico.recuperarTodos() != null);
	}

	@Test(expected = CursoServicoException.class)
	public void inserirNulo() throws CursoServicoException {
		cursoServico.inserir(null);
	}

	@Test(expected = CursoServicoException.class)
	public void atualizarNulo() throws CursoServicoException {
		cursoServico.atualizar(null);
	}

	@Test
	public void atualizarInvalido() {
		Curso c = new Curso();
		// Sem nome
		try {
			cursoServico.atualizar(c);
		} catch (CursoServicoException e) {
			assertTrue(true);
		}
		// Sem area
		c.setNome("CursoTeste");
		try {
			cursoServico.atualizar(c);
		} catch (CursoServicoException e) {
			assertTrue(true);
		}
		// Sem Tipo
		c.setTipoCurso(new TipoCurso());
		try {
			cursoServico.atualizar(c);
		} catch (CursoServicoException e) {
			assertTrue(true);
		}

	}

	@Test(expected = CursoServicoException.class)
	public void removerNulo() throws CursoServicoException {
		cursoServico.remover(null);
	}

	@Test
	public void inserirRecuperarCurso() {
		Curso c1;
		TipoCurso t1;
		t1 = new TipoCurso();
		t1.setTipo("Graduação");
		tipoCursoServico.inserir(t1);

		c1 = new Curso();
		c1.setArea("Exatas");
		c1.setTipoCurso(t1);
		c1.setNome("Computação");

		c1.setTag("CC");
		c1.setCod(-1);
		try {
			cursoServico.inserir(c1);
			Curso c = cursoServico.recuperarPorCod(c1.getCod());
			assertEquals(c.getCod(), c1.getCod());
		} catch (CursoServicoException e) {
			assertTrue(false);
		}

	}

	@Test(expected = CursoServicoException.class)
	public void inserirCursoDuplicado() throws CursoServicoException {
		Curso curso = new Curso();

		// Verificar caso algum teste ja tenha inserido um TipoDeCurso

		TipoCurso tipoCurso = null;
		try {
			tipoCurso = tipoCursoServico.listarTodos().get(0);
		} catch (IndexOutOfBoundsException e) {
			// Precisa criar, não existe na base
			tipoCurso = new TipoCurso();
			tipoCurso.setTipo("Graduação");
			tipoCursoServico.inserir(tipoCurso);
		}

		// Inserir um Curso qualquer
		curso.setNome("Medicina");
		curso.setArea("Saude");
		curso.setTipoCurso(tipoCurso);

		cursoServico.inserir(curso);
		cursoServico.inserir(curso);

	}


	@Test
	public void testAtualizarCurso() {
		Curso curso = new Curso();

		// Verificar caso algum teste ja tenha inserido um TipoDeCurso

		TipoCurso tipoCurso = null;
		try {
			tipoCurso = tipoCursoServico.listarTodos().get(0);
		} catch (IndexOutOfBoundsException e) {
			// Precisa criar, não existe na base
			tipoCurso = new TipoCurso();
			tipoCurso.setTipo("Graduação");
			tipoCursoServico.inserir(tipoCurso);
		}

		// Inserir um Curso qualquer
		curso.setNome("Matematica");
		curso.setArea("Exatas");
		curso.setTipoCurso(tipoCurso);
		curso.setTag("MT");
		try {
			cursoServico.inserir(curso);
		} catch (CursoServicoException e) {
			assertTrue(false);
		}
		String novoNome = "Estatistica";
		curso.setNome(novoNome);

		try {
			cursoServico.atualizar(curso);
			Curso c2 = cursoServico.recuperarPorCod(curso.getCod());
			assertEquals(c2.getNome(), novoNome);
		} catch (CursoServicoException e) {
			assertTrue(false);
		}

	}

}
