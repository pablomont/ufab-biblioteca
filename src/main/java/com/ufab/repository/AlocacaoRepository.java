package com.ufab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.Alocacao;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao,Integer> {
	@Query("SELECT c FROM alocacao c WHERE c.cod = :codAlocacao")
	Alocacao procurarPorId(@Param("codAlocacao")Integer id);
}
