package com.ufab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
	@Query("SELECT c FROM item c WHERE c.cod = :codItem")
	Item procurarPorId(@Param("codItem")Integer id);
}
