package com.ufab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {
	@Query("SELECT c FROM permissao c WHERE c.cod = :codReserva")
	Reserva procurarPorId(@Param("codReserva")Integer id);
}
