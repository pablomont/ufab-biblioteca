package com.ufab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.Aluno;
import com.ufab.entidade.Curso;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Integer> {
	@Query("SELECT c FROM aluno c WHERE c.cod = :codAluno")
	Curso procurarPorId(@Param("codAluno")Integer id);
}
