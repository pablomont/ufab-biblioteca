package com.ufab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.Perfil;
import com.ufab.enumerador.TipoPerfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Integer> {
	@Query("SELECT c FROM perfil c WHERE c.cod = :codPerfil")
	Perfil procurarPorId(@Param("codPerfil")Integer id);

	Perfil recuperarPorTipo(TipoPerfil tipoPerfil);
}
