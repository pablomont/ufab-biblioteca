package com.ufab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao,Integer> {
	@Query("SELECT c FROM locacao c WHERE c.cod = :codLocacao")
	Locacao procurarPorId(@Param("codLocacao")Integer id);
}
