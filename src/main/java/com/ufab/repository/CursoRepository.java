package com.ufab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer> {
	@Query("SELECT c FROM curso c WHERE c.id = :idCurso")
	Curso procurarPorId(@Param("idCurso")Integer id);
}
