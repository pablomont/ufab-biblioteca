package com.ufab.servico.test;

import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ufab.entidade.Alocacao;
import com.ufab.entidade.AlocacaoPrimaryKey;
import com.ufab.entidade.Aluno;
import com.ufab.entidade.Curso;
import com.ufab.entidade.Jornal;
import com.ufab.entidade.Locacao;
import com.ufab.entidade.Perfil;
import com.ufab.entidade.TipoCurso;
import com.ufab.entidade.TipoItem;
import com.ufab.enumerador.TipoNivelAluno;
import com.ufab.enumerador.TipoPerfil;
import com.ufab.excecao.CursoServicoException;
import com.ufab.excecao.ItemServicoException;
import com.ufab.excecao.UfabUtilidadeException;
import com.ufab.excecao.UsuarioServicoException;
import com.ufab.servico.IAlocacaoServico;
import com.ufab.servico.IAlunoServico;
import com.ufab.servico.ICursoServico;
import com.ufab.servico.IItemServico;
import com.ufab.servico.ILocacaoServico;
import com.ufab.servico.IPerfilServico;
import com.ufab.servico.IUsuarioServico;
import com.ufab.util.UfabUtilidade;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LocacaoServicoTest {

	@Autowired
	private ILocacaoServico locacaoServico;

	@Autowired
	private IItemServico itemServico;

	@Autowired
	private IUsuarioServico usuarioServico;

	@Autowired
	private IPerfilServico perfilServico;

	@Autowired
	private IAlunoServico alunoServico;

	@Autowired
	private IAlocacaoServico alocacaoServico;

	@Autowired
	private ICursoServico cursoServico;

	@Test
	public void emprestarItem() {
		Jornal j1 = new Jornal();
		j1.setNome("Jornal Teste 1");
		j1.setData(new Date());
		j1.setEdicao("Edicao Teste");
		j1.setQuantMax(50);
		j1.setTipoItem(TipoItem.JORNAL);
		j1.setTitulo("Titulo do Jornal Teste");

		try {
			itemServico.inserir(j1);
		} catch (ItemServicoException e) {
			assertTrue(false);
		}
		// Inserir o aluno
		Aluno a = new Aluno();
		a.setCpf("117726994635");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setDataCadastro(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("Endereco Teste para Locacao");
		a.setFone("2134213123");
		a.setNaturalidade("Brasileiro");
		a.setNomeCompleto("Nome Completo");
		a.setRg("3423423");
		a.setSenha("senhateste");
		a.setTipoNivelAluno(TipoNivelAluno.GRADUACAO);

		// Gerear alocacao pra matricula
		Alocacao alocacao = new Alocacao();
		alocacao.setAluno(a);
		Curso c = null;

		try {
			c = cursoServico.recuperarTodos().get(0);
		} catch (IndexOutOfBoundsException e) {
			c = new Curso();
			c.setArea("Saude");
			c.setNome("Fisio");
			c.setTag("FI");

			TipoCurso tp = new TipoCurso();
			tp.setNome("Graduacao");

			c.setTipoCurso(tp);
			try {
				cursoServico.inserir(c);
			} catch (CursoServicoException e1) {
				assertTrue(false);
			}
		} finally {
			alocacao.setCurso(c);
		}
		alocacao.setId(new AlocacaoPrimaryKey("2018", "2", c.getCod(), a.getCpf()));

		String matricula = alunoServico.gerarMatricula(alocacao);
		a.setMatricula(matricula);

		Perfil p = null;
		try {
			List<Perfil> listaPerfil = perfilServico.recuperarTodos();
			if (listaPerfil.size() == 0) {
				throw new Exception();
			}
			for (Perfil perfil : listaPerfil) {
				if (perfil.getTipoPerfil().equals(TipoPerfil.ALUNO)) {
					p = perfil;
				}
			}
		} catch (Exception e) {
			p = new Perfil();
			p.setTipoPerfilNome(TipoPerfil.ALUNO);
			perfilServico.inserir(p);
		} finally {
			a.setPerfil(p);
		}
		try {
			usuarioServico.inserir(a);
		} catch (UsuarioServicoException e) {
			assertTrue(false);
		}
		alocacaoServico.inserir(alocacao);

		// Inserir a locacao
		Locacao locacao = new Locacao();
		locacao.setAluno(a);
		locacao.setDevolvido(false);
		try {
			locacao.setDt_devolucao(UfabUtilidade.gerarDataPorString("21/06/2018"));
			locacao.setDt_locacao(Calendar.getInstance().getTime());
		} catch (UfabUtilidadeException e) {
			assertTrue(false);
		}
		locacao.setItem(j1);
		locacao.setRenovado(false);
	}
}
