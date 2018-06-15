package com.ufab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.TipoItem;

@Repository
public interface TipoItemRepository extends JpaRepository<TipoItem,Integer> {
	@Query("SELECT c FROM tipoItem c WHERE c.cod = :codTipoItem")
	TipoItem procurarPorId(@Param("codTipoitem")Integer id);
}
