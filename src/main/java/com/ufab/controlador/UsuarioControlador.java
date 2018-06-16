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

import com.ufab.entidade.Curso;
import com.ufab.entidade.Usuario;
import com.ufab.excecao.UsuarioServicoException;
import com.ufab.servico.IUsuarioServico;


/***
 * Classe controladora de Usu rio que possui m todos que s o a  es no sistema
 * @author Bianca
 *
 */
@RestController
public class UsuarioControlador {

	@Autowired
	private IUsuarioServico usuarioServico;

	private Logger LOGGER = Logger.getLogger(UsuarioControlador.class);
	
	/** Recupera Todos Usuários **/
    @RequestMapping(value = "/usuario/", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listAllUsers() {
        List<Usuario> users = usuarioServico.recuperarTodos();
        if(users.isEmpty()){
            return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
    }
	
	
    /** Recuperar um usuário por cpf **/ 
    @RequestMapping(value = "/usuario/{cpf}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> getUser(@PathVariable("cpf") String cpf) {
        System.out.println("Fetching User with cpf " + cpf);
        Usuario usuario = usuarioServico.recuperarPorCpf(cpf);
        if (usuario == null) {
            System.out.println("User with cpf " + cpf + " not found");
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
	
    /** Criar um usuário **/
    @RequestMapping(value = "/usuario/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Usuario user, UriComponentsBuilder ucBuilder) {
 
        if (usuarioServico.recuperarPorCpf(user.getCpf())  != null) {
            System.out.println("A User with name " + user.getNomeCompleto() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        try {
			usuarioServico.inserir(user);
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/usuario/{cpf}").buildAndExpand(user.getCpf()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (UsuarioServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
    }
    

    /** Atualizar um usuário **/
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> updateUser(@PathVariable("id") Integer id, @RequestBody Usuario user) {
        
         
        Usuario currentUser = usuarioServico.recuperarPorId(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setNomeCompleto(user.getNomeCompleto());
        currentUser.setCpf(user.getCpf());
        currentUser.setDataCadastro(user.getDataCadastro());
        currentUser.setDataNascimento(user.getDataNascimento());
        currentUser.setEndereco(user.getEndereco());
        currentUser.setFone(user.getFone());
        currentUser.setNaturalidade(user.getNaturalidade());
        currentUser.setRg(user.getRg());
        currentUser.setSenha(user.getSenha());
        currentUser.setTipo(user.getTipo());
         
        try {
			usuarioServico.atualizar(currentUser);
			return new ResponseEntity<Usuario>(currentUser, HttpStatus.OK);
		} catch (UsuarioServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return new ResponseEntity<Usuario>(currentUser, HttpStatus.INTERNAL_SERVER_ERROR);
		}
       
    }
    
    /** Deleta o usuário informado **/
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> deleteUser(@PathVariable("id") Integer id) {

    	try {
			usuarioServico.remover(id);
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		} catch (UsuarioServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Usuario>(usuarioServico.recuperarPorId(id), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }

}
