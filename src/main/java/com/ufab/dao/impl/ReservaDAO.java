package com.ufab.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.IReservaDAO;
import com.ufab.entidade.Reserva;

@Repository
@Transactional
public class ReservaDAO implements IReservaDAO {

	@Override
	public void inserir(Reserva reserva) {
		
	}

	@Override
	public List<Reserva> recuperarTodos() {
		return null;
	}

	@Override
	public void remover(Reserva reserva) {
		

	}

	@Override
	public void atualizar(Reserva reserva) {
		

	}

}
