package com.ufab.controlador;

import java.util.List;

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
import com.ufab.excecao.CursoServicoException;
import com.ufab.servico.ICursoServico;


/***
 *  Classe controladora de curso que possui m todos que s o a  es no sistema.
 * @author Bianca
 *
 */
@RestController
public class CursoControlador {

	@Autowired
	private ICursoServico cursoServico;

	@RequestMapping(value = "/curso/", method = RequestMethod.POST)
	public ResponseEntity<Void> inserirCurso(@RequestBody Curso curso, UriComponentsBuilder ucBuilder) {
		HttpHeaders headers = new HttpHeaders();
		
        try {
			cursoServico.inserir(curso);
	        headers.setLocation(ucBuilder.path("/curso/{cod}").buildAndExpand(curso.getCod()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (CursoServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    return new ResponseEntity<Void>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	/***
	 * @return  - retorna todos os cursos
	 */

	@RequestMapping(value = "/curso/", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listAll() {
		
		 List<Curso> cursos = cursoServico.recuperarTodos();
	        if(cursos.isEmpty()){
	            return new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);//Você pode decidir retornar HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
		
	}
	
	/***
	 * @param cod - par metro 
	 * @return curso
	 */

	@RequestMapping(value = "/curso/{tag}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Curso> getCurso(@PathVariable("tag") String tag){
		 Curso curso;
		try {
			curso = cursoServico.recuperarPorTag(tag);
			if (curso == null) {
	            System.out.println("Curso with tag " + tag + " not found");
	            return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Curso>(curso, HttpStatus.OK);
		} catch (CursoServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}       
	}
	

	 @RequestMapping(value = "/curso/{cod}", method = RequestMethod.PUT)
	public ResponseEntity<Curso> atualizarCurso(@PathVariable("cod") Integer cod, @RequestBody Curso curso){

		 	Curso currentCurso = null;
	        try {
	        	currentCurso = cursoServico.recuperarPorCod(cod);
		        if (currentCurso==null) {
		            System.out.println("Curso with id " + cod + " not found");
		            return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		        }
		        
		        currentCurso.setArea(curso.getArea());
		        currentCurso.setNome(curso.getNome());
		        currentCurso.setTag(curso.getTag());
		        currentCurso.setTipoCurso(curso.getTipoCurso());
				cursoServico.atualizar(currentCurso);
			} catch (CursoServicoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	        return new ResponseEntity<Curso>(currentCurso, HttpStatus.OK);
	}
	 
	 @RequestMapping(value = "/curso/{cod}", method = RequestMethod.DELETE)
	    public ResponseEntity<Curso> deleteCurso(@PathVariable("cod") Integer cod) {
	       
		 	try {
				cursoServico.remover(cod);
				return new ResponseEntity<Curso>(HttpStatus.NO_CONTENT);
			} catch (CursoServicoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	        
	    }
}