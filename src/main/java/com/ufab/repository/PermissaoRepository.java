package com.ufab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.Alocacao;
import com.ufab.entidade.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao,Integer> {
	@Query("SELECT c FROM permissao c WHERE c.cod = :codPermissao")
	Alocacao procurarPorId(@Param("codPermissao")Integer id);
}
