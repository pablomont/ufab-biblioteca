package com.ufab.servico.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.entidade.Perfil;
import com.ufab.enumerador.TipoPerfil;
import com.ufab.repository.PerfilRepository;
import com.ufab.servico.IPerfilServico;
/***
 * Servico para tratar de todas as manipulacoes de negocio com o Perfil
 * 
 * @author Davi
 *
 */
@Service
public class PerfilServico implements IPerfilServico {

	@Autowired
	private PerfilRepository perfilRepo;

	@Override
	public void inserir(Perfil perfil) {
		perfilRepo.save(perfil);
	}

	@Override
	public List<Perfil> recuperarTodos() {
		return perfilRepo.findAll();
	}

	@Override
	public Perfil recuperarPorTipo(TipoPerfil tipoPerfil) {
		
		return perfilRepo.recuperarPorTipo(tipoPerfil);
	}

}
