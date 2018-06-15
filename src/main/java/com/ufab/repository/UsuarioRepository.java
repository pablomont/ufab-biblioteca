package com.ufab.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	@Query("SELECT c FROM usuario c WHERE c.cod = :codUsuario")
	Usuario procurarPorId(@Param("codUsuario")Integer id);

	Usuario recuperarPorCpf(String cpf);
}
