package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.Reserva;

public interface IReservaDAO{
	public void inserir(Reserva reserva);

	public List<Reserva> recuperarTodos();

	public void remover(Reserva reserva);

	public void atualizar(Reserva reserva);
}
