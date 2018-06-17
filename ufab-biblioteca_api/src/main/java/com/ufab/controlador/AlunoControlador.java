package com.ufab.controlador;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufab.entidade.Aluno;
import com.ufab.excecao.AlunoServicoException;
import com.ufab.servico.IAlunoServico;

@RestController
@RequestMapping("/aluno")
public class AlunoControlador {
	
	@Autowired
	private IAlunoServico alunoServico;
	
	private Logger LOGGER = Logger.getLogger(UsuarioControlador.class);
	
	/** Recupera Todos Alunos **/
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Aluno>> listAllAlunos() {
        List<Aluno> alunos = alunoServico.recuperarTodos();
        if(alunos.isEmpty()){
            return new ResponseEntity<List<Aluno>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/{matricula}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> getAluno(@PathVariable("matricula") String matricula) {
        System.out.println("Fetching User with matricula " + matricula);
        Aluno aluno = alunoServico.recuperarPorMatricula(matricula);
        if (aluno == null) {
            System.out.println("aluno with matricula " + matricula + " not found");
            return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
    }
	
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createAluno(@RequestBody Aluno aluno, UriComponentsBuilder ucBuilder) {
 
        if (alunoServico.recuperarPorMatricula(aluno.getMatricula())  != null) {
            System.out.println("Alunor with name " + aluno.getNomeCompleto() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        try {
        	alunoServico.inserir(aluno);
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/aluno/{matricula}").buildAndExpand(aluno.getMatricula()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (AlunoServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Aluno> updateUser(@PathVariable("id") Integer id, @RequestBody Aluno aluno) {
        
         
        Aluno currentAluno = alunoServico.recuperarPorId(id);
         
        if (currentAluno==null) {
            System.out.println("Aluno with id " + id + " not found");
            return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
        }
 
        currentAluno.setNomeCompleto(aluno.getNomeCompleto());
        currentAluno.setCpf(aluno.getCpf());
        currentAluno.setNomeMae(aluno.getNomeMae());
        currentAluno.setTipoNivel(aluno.getTipoNivel());
         
        try {
			alunoServico.atualizar(currentAluno);
			return new ResponseEntity<Aluno>(currentAluno, HttpStatus.OK);
		} catch (AlunoServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return new ResponseEntity<Aluno>(currentAluno, HttpStatus.INTERNAL_SERVER_ERROR);
		}
       
    }
    
    @RequestMapping(value = "/{matricula}", method = RequestMethod.DELETE)
    public ResponseEntity<Aluno> deleteAluno(@PathVariable("matricula") String matricula) {

    	int id = 0;
    	try {
    		id = alunoServico.recuperarPorMatricula(matricula).getId();
    		alunoServico.remover(id);
			return new ResponseEntity<Aluno>(HttpStatus.NO_CONTENT);
		} catch (AlunoServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Aluno>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }


}
