package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.Reserva;
import com.ufab.excecao.ReservaServicoException;
import com.ufab.excecao.ReservaValidacaoException;

public interface IReservaServico {

	/**
	 * Inserir reserva no sistema.
	 * 
	 * @param reserva
	 *            Reserva que deseja ser inserida.
	 * @throws ReservaServicoException
	 *             Casso ocorra algum erro durante o processo.
	 */
	public void inserir(Reserva reserva) throws ReservaServicoException;

	/**
	 * Uma lista de todas as reservas do sistema
	 * 
	 * @return Uma lista de Reservas
	 */
	public List<Reserva> recuperarTodos();

	/**
	 * Remover uma reserva do sistema
	 * 
	 * @param reserva
	 *            Reserva que deseja ser removida
	 */
	public void remover(Reserva reserva);

	/**
	 * Atualizar as informacoes de uma reserva do sistema.
	 * 
	 * @param reserva
	 *            Reserva que deseja ser alterada.
	 * @throws ReservaServicoException
	 *             Caso ocorra algum erro no processo.
	 */
	public void atualizar(Reserva reserva) throws ReservaServicoException;

	/**
	 * Validar as informacoes de uma reserva.
	 * 
	 * @param reserva
	 *            Reserva que deseja ser validada.
	 * @throws ReservaValidacaoException
	 *             Caso a reserva informada esteja inválida.
	 */
	public void validarReserva(Reserva reserva) throws ReservaValidacaoException;
}
