package com.ufab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.TipoCurso;

@Repository
public interface TipoCursoRepository extends JpaRepository<TipoCurso,Integer>  {
	@Query("SELECT c FROM tipocurso c WHERE c.cod = :codTipoCurso")
	TipoCurso procurarPorId(@Param("codTipoCurso")Integer id);
}
