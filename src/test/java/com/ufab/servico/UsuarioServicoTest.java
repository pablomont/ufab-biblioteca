package com.ufab.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.TemporalAccessorParser;
import com.ufab.entidade.Alocacao;
import com.ufab.entidade.AlocacaoPrimaryKey;
import com.ufab.entidade.Aluno;
import com.ufab.entidade.Curso;
import com.ufab.entidade.Funcionario;
import com.ufab.entidade.Perfil;
import com.ufab.entidade.Permissao;
import com.ufab.entidade.TipoCurso;
import com.ufab.enumerador.TipoNivelAluno;
import com.ufab.enumerador.TipoPerfil;
import com.ufab.enumerador.TipoPermissao;
import com.ufab.excecao.CursoServicoException;
import com.ufab.excecao.UsuarioServicoException;
import com.ufab.servico.IAlocacaoServico;
import com.ufab.servico.IAlunoServico;
import com.ufab.servico.ICursoServico;
import com.ufab.servico.IPerfilServico;
import com.ufab.servico.IUsuarioServico;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServicoTest {
	private static boolean dataLoaded = false;

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

	@Before
	public void config() {
		if (!dataLoaded) {
			// Perfil do adm
			Perfil perfil = new Perfil();
			perfil.setTipoPerfilNome(TipoPerfil.ADMINISTRADOR);

			List<Permissao> permissoesAdm = new ArrayList<Permissao>();
			Permissao p1_adm = new Permissao();
			p1_adm.setTipoPermissao(TipoPermissao.EXCLUIR_ALUNO);

			Permissao p2_adm = new Permissao();
			p2_adm.setTipoPermissao(TipoPermissao.LISTAR_ALUNO);

			permissoesAdm.add(p1_adm);
			permissoesAdm.add(p2_adm);

			perfil.setPermissoes(permissoesAdm);

			perfilServico.inserir(perfil);

			// Perfil do aluno
			Perfil p2 = new Perfil();
			p2.setTipoPerfilNome(TipoPerfil.ALUNO);
			perfilServico.inserir(p2);

			// Perfil do aluno
			Perfil p3 = new Perfil();
			p3.setTipoPerfilNome(TipoPerfil.FUNCIONARIO);
			perfilServico.inserir(p3);

			dataLoaded = true;
		}

	}

	@Test(expected = UsuarioServicoException.class)
	public void inserirUsuarioNull() throws UsuarioServicoException {
		usuarioServico.inserir(null);
	}

	@Test(expected = UsuarioServicoException.class)
	public void testarEstouroDeCPF() throws UsuarioServicoException {
		Aluno a = new Aluno();
		usuarioServico.inserir(a);
	}

	@Test(expected = UsuarioServicoException.class)
	public void testarEstouroDeDataNascimento() throws UsuarioServicoException {
		Aluno a = new Aluno();
		a.setCpf("11772699454");
		usuarioServico.inserir(a);
	}

	@Test(expected = UsuarioServicoException.class)
	public void testarEstouroDeEndereco() throws UsuarioServicoException {
		Aluno a = new Aluno();
		a.setCpf("11772699454");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		usuarioServico.inserir(a);
	}

	@Test(expected = UsuarioServicoException.class)
	public void testarEstouroDeTelefone() throws UsuarioServicoException {
		Aluno a = new Aluno();
		a.setCpf("11772699454");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		usuarioServico.inserir(a);
	}

	@Test(expected = UsuarioServicoException.class)
	public void testarEstouroDeNaturalidade() throws UsuarioServicoException {
		Aluno a = new Aluno();
		a.setCpf("11772699454");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("546546546");
		usuarioServico.inserir(a);
	}

	@Test(expected = UsuarioServicoException.class)
	public void testarEstouroDeNomeCompleto() throws UsuarioServicoException {
		Aluno a = new Aluno();
		a.setCpf("11772699454");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("546546546");
		a.setNaturalidade("anasdasdasd");
		usuarioServico.inserir(a);
	}

	@Test(expected = UsuarioServicoException.class)
	public void testarEstouroDeRg() throws UsuarioServicoException {
		Aluno a = new Aluno();
		a.setCpf("11772699454");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("546546546");
		a.setNaturalidade("anasdasdasd");
		a.setNomeCompleto("Nomecasdasdas");
		usuarioServico.inserir(a);
	}

	@Test(expected = UsuarioServicoException.class)
	public void testarEstouroDeSenha() throws UsuarioServicoException {
		Aluno a = new Aluno();
		a.setCpf("11772699454");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("546546546");
		a.setNaturalidade("anasdasdasd");
		a.setNomeCompleto("Nomecasdasdas");
		a.setRg("65165687");
		usuarioServico.inserir(a);
	}

	@Test(expected = UsuarioServicoException.class)
	public void testarEstouroDePerfil() throws UsuarioServicoException {
		Aluno a = new Aluno();
		a.setCpf("11772699454");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("546546546");
		a.setNaturalidade("anasdasdasd");
		a.setNomeCompleto("Nomecasdasdas");
		a.setRg("65165687");
		a.setSenha("asdasdasasdas");
		usuarioServico.inserir(a);
	}

	@Test
	public void inserirAluno() {
		Aluno a = new Aluno();
		a.setCpf("11772699454");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setDataCadastro(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("546546546");
		a.setNaturalidade("anasdasdasd");
		a.setNomeCompleto("Nomecasdasdas");
		a.setRg("65165687");
		a.setSenha("asdasdasasdas");
		a.setTipoNivelAluno(TipoNivelAluno.DOUTORADO);

		// Gerear alocacao pra matricula
		Alocacao alocacao = new Alocacao();
		alocacao.setAluno(a);
		Curso c = null;

		try {
			c = cursoServico.recuperarTodos().get(0);
		} catch (IndexOutOfBoundsException e) {
			c = new Curso();
			c.setArea("Exatas");
			c.setNome("Fisica");
			c.setTag("FS");

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
		alocacao.setId(new AlocacaoPrimaryKey("2017", "1", c.getCod(), a.getCpf()));

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
	}

	@Test(expected = UsuarioServicoException.class)
	public void inserirAlunoSemParametroNivel() throws UsuarioServicoException {
		Aluno a = new Aluno();
		a.setCpf("3123213231");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setDataCadastro(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("546546546");
		a.setNaturalidade("anasdasdasd");
		a.setNomeCompleto("Nomecasdasdas");
		a.setRg("65165687");
		a.setSenha("asdasdasasdas");
		// Gerear alocacao pra matricula
		Alocacao alocacao = new Alocacao();
		alocacao.setAluno(a);
		Curso c = null;

		try {
			c = cursoServico.recuperarTodos().get(0);
		} catch (IndexOutOfBoundsException e) {
			c = new Curso();
			c.setArea("Exatas");
			c.setNome("Fisica-3");
			c.setTag("FS");

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
		alocacao.setId(new AlocacaoPrimaryKey("2017", "1", c.getCod(), a.getCpf()));
		a.setTipoNivelAluno(TipoNivelAluno.DOUTORADO);
		String matricula = alunoServico.gerarMatricula(alocacao, a);
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
		a.setTipoNivelAluno(null);
		usuarioServico.inserir(a);
		alocacaoServico.inserir(alocacao);
	}

	@Test(expected = UsuarioServicoException.class)
	public void inserirAlunoSemParametroMatricula() throws UsuarioServicoException {
		Aluno a = new Aluno();
		a.setCpf("565474767566");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setDataCadastro(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("546546546");
		a.setNaturalidade("anasdasdasd");
		a.setNomeCompleto("Nomecasdasdas");
		a.setRg("65165687");
		a.setSenha("asdasdasasdas");
		a.setTipoNivelAluno(TipoNivelAluno.DOUTORADO);
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
		usuarioServico.inserir(a);
	}

	@Test
	public void removerUsuario() {
		// Insere o primeiro Usuario
		Funcionario a = new Funcionario();
		a.setCpf("984156516516");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setDataCadastro(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("3424234233");
		a.setNaturalidade("anasdasdasd");
		a.setNomeCompleto("Nomecasdasdas");
		a.setRg("3412321");
		a.setSenha("sdnasenjasna");
		Perfil p = null;
		try {
			List<Perfil> listaPerfil = perfilServico.recuperarTodos();
			if (listaPerfil.size() == 0) {
				throw new Exception();
			}
			for (Perfil perfil : listaPerfil) {
				if (perfil.getTipoPerfil().equals(TipoPerfil.FUNCIONARIO)) {
					p = perfil;
				}
			}
		} catch (Exception e) {
			p = new Perfil();
			p.setTipoPerfilNome(TipoPerfil.FUNCIONARIO);
			perfilServico.inserir(p);
		} finally {
			a.setPerfil(p);
		}
		try {
			usuarioServico.inserir(a);
		} catch (UsuarioServicoException e) {
			assertTrue(false);
		}

		// Insere o segundo Usuario
		Funcionario b = new Funcionario();
		b.setCpf("96513516516");
		b.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		b.setDataCadastro(new Date(Date.from(Instant.now()).getTime()));
		b.setEndereco("EnderecoTeste");
		b.setFone("1232132111");
		b.setNaturalidade("anasdasdasd");
		b.setNomeCompleto("Nomecasdasdas");
		b.setRg("3412321");
		b.setSenha("asfdasggfamsasd");
		Perfil p1 = null;
		try {
			List<Perfil> listaPerfil = perfilServico.recuperarTodos();
			if (listaPerfil.size() == 0) {
				throw new Exception();
			}
			for (Perfil perfil : listaPerfil) {
				if (perfil.getTipoPerfil().equals(TipoPerfil.FUNCIONARIO)) {
					p1 = perfil;
				}
			}
		} catch (Exception e) {
			p1 = new Perfil();
			p1.setTipoPerfilNome(TipoPerfil.FUNCIONARIO);
			perfilServico.inserir(p1);
		} finally {
			b.setPerfil(p1);
		}
		try {
			usuarioServico.inserir(b);
		} catch (UsuarioServicoException e) {
			assertTrue(false);
		}

		try {
			usuarioServico.remover(a, b);
		} catch (Exception e) {
			assertTrue(false);
		}

		// Testar se foi removido
		assertEquals(null, usuarioServico.recuperarPorCpf(b.getCpf()));
	}

	@Test(expected = UsuarioServicoException.class)
	public void usuarioSemPermissaoremoverAluno() throws UsuarioServicoException {
		// Insere o primeiro Usuario
		Funcionario a = new Funcionario();
		a.setCpf("64964654655");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setDataCadastro(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("3424234233");
		a.setNaturalidade("anasdasdasd");
		a.setNomeCompleto("Nomecasdasdas");
		a.setRg("3412321");
		a.setSenha("sdnasenjasna");
		Perfil p = null;
		try {
			List<Perfil> listaPerfil = perfilServico.recuperarTodos();
			if (listaPerfil.size() == 0) {
				throw new Exception();
			}
			for (Perfil perfil : listaPerfil) {
				if (perfil.getTipoPerfil().equals(TipoPerfil.FUNCIONARIO)) {
					p = perfil;
				}
			}
		} catch (Exception e) {
			p = new Perfil();
			p.setTipoPerfilNome(TipoPerfil.FUNCIONARIO);
			perfilServico.inserir(p);
		} finally {
			a.setPerfil(p);
		}
		try {
			usuarioServico.inserir(a);
		} catch (UsuarioServicoException e) {
			assertTrue(false);
		}

		// Insere o segundo Usuario
		Aluno b = new Aluno();
		b.setCpf("964615614651");
		b.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		b.setDataCadastro(new Date(Date.from(Instant.now()).getTime()));
		b.setEndereco("EnderecoTeste");
		b.setFone("1232132111");
		b.setNaturalidade("anasdasdasd");
		b.setNomeCompleto("Nomecasdasdas");
		b.setRg("342132132112321");
		b.setSenha("asdasdasdasd");
		b.setTipoNivelAluno(TipoNivelAluno.MESTRADO);
		// Gerear alocacao pra matricula
		Alocacao alocacao = new Alocacao();
		alocacao.setAluno(b);
		Curso c = null;

		try {
			c = cursoServico.recuperarTodos().get(0);
		} catch (IndexOutOfBoundsException e) {
			c = new Curso();
			c.setArea("Exatas");
			c.setNome("Fisica-4");
			c.setTag("FS");

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
		alocacao.setId(new AlocacaoPrimaryKey("2017", "1", c.getCod(), b.getCpf()));

		String matricula = alunoServico.gerarMatricula(alocacao, b);
		b.setMatricula(matricula);
		Perfil p1 = null;
		try {
			List<Perfil> listaPerfil = perfilServico.recuperarTodos();
			if (listaPerfil.size() == 0) {
				throw new Exception();
			}
			for (Perfil perfil : listaPerfil) {
				if (perfil.getTipoPerfil().equals(TipoPerfil.ALUNO)) {
					p1 = perfil;
				}
			}
		} catch (Exception e) {
			p1 = new Perfil();
			p1.setTipoPerfilNome(TipoPerfil.ALUNO);
			perfilServico.inserir(p1);
		} finally {
			b.setPerfil(p1);
		}
		try {
			usuarioServico.inserir(b);
			alocacaoServico.inserir(alocacao);
		} catch (UsuarioServicoException e) {
			assertTrue(false);
		}
		usuarioServico.remover(a, b);
	}

	@Test
	public void usuarioComPermissaoRemoverAluno() throws UsuarioServicoException {
		// Insere o primeiro Usuario
		Funcionario a = new Funcionario();
		a.setCpf("5477568967856");
		a.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		a.setDataCadastro(new Date(Date.from(Instant.now()).getTime()));
		a.setEndereco("EnderecoTeste");
		a.setFone("3424234233");
		a.setNaturalidade("anasdasdasd");
		a.setNomeCompleto("Nomecasdasdas");
		a.setRg("3412321");
		a.setSenha("sdnasenjasna");
		Perfil p = null;
		try {
			List<Perfil> listaPerfil = perfilServico.recuperarTodos();
			if (listaPerfil.size() == 0) {
				throw new Exception();
			}
			for (Perfil perfil : listaPerfil) {
				if (perfil.getTipoPerfil().equals(TipoPerfil.ADMINISTRADOR)) {
					p = perfil;
				}
			}
		} catch (Exception e) {
			p = new Perfil();
			p.setTipoPerfilNome(TipoPerfil.ADMINISTRADOR);
			List<Permissao> permissoesAdm = new ArrayList<Permissao>();

			Permissao p1_adm = new Permissao();
			p1_adm.setTipoPermissao(TipoPermissao.EXCLUIR_ALUNO);

			Permissao p2_adm = new Permissao();
			p2_adm.setTipoPermissao(TipoPermissao.LISTAR_ALUNO);

			permissoesAdm.add(p1_adm);
			permissoesAdm.add(p2_adm);

			p.setPermissoes(permissoesAdm);

			perfilServico.inserir(p);
		} finally {
			a.setPerfil(p);
		}
		try {
			usuarioServico.inserir(a);
		} catch (UsuarioServicoException e) {
			assertTrue(false);
		}

		// Insere o segundo Usuario
		Aluno b = new Aluno();
		b.setCpf("453463467634");
		b.setDataNascimento(new Date(Date.from(Instant.now()).getTime()));
		b.setDataCadastro(new Date(Date.from(Instant.now()).getTime()));
		b.setEndereco("EnderecoTeste");
		b.setFone("1232132111");
		b.setNaturalidade("anasdasdasd");
		b.setNomeCompleto("Nomecasdasdas");
		b.setRg("342132132112321");
		b.setSenha("asdasdasdasd");
		b.setTipoNivelAluno(TipoNivelAluno.GRADUACAO);
		// Gerear alocacao pra matricula
		Alocacao alocacao = new Alocacao();
		alocacao.setAluno(b);
		Curso c = null;

		try {
			c = cursoServico.recuperarTodos().get(0);
		} catch (IndexOutOfBoundsException e) {
			c = new Curso();
			c.setArea("Exatas");
			c.setNome("Fisica");
			c.setTag("FS");

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
		alocacao.setId(new AlocacaoPrimaryKey("2017", "1", c.getCod(), b.getCpf()));

		String matricula = alunoServico.gerarMatricula(alocacao, b);
		b.setMatricula(matricula);
		Perfil p1 = null;
		try {
			List<Perfil> listaPerfil = perfilServico.recuperarTodos();
			if (listaPerfil.size() == 0) {
				throw new Exception();
			}
			for (Perfil perfil : listaPerfil) {
				if (perfil.getTipoPerfil().equals(TipoPerfil.ALUNO)) {
					p1 = perfil;
				}
			}
		} catch (Exception e) {
			p1 = new Perfil();
			p1.setTipoPerfilNome(TipoPerfil.ALUNO);
			perfilServico.inserir(p1);
		} finally {
			b.setPerfil(p1);
		}
		try {
			usuarioServico.inserir(b);
			alocacaoServico.inserir(alocacao);
		} catch (UsuarioServicoException e) {
			assertTrue(false);
		}
		try {
			usuarioServico.remover(a, b);
		} catch (Exception e) {
			assertTrue(false);
		}
		// Testar se foi removido
		assertEquals(null, usuarioServico.recuperarPorCpf(b.getCpf()));
	}

}
