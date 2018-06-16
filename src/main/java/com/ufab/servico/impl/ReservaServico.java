package com.ufab.servico.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.IReservaDAO;
import com.ufab.entidade.Reserva;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.ReservaServicoException;
import com.ufab.excecao.ReservaValidacaoException;
import com.ufab.servico.IReservaServico;

@Service
public class ReservaServico implements IReservaServico {

	static final Logger LOGGER = Logger.getLogger(ReservaServico.class);

	@Autowired
	private IReservaDAO reservaDao;

	@Override
	public void inserir(Reserva reserva) throws ReservaServicoException {
		try {
			validarReserva(reserva);
			reserva.setDt_reserva(new Date(Calendar.getInstance().getTime().getTime()));
			reservaDao.inserir(reserva);
		} catch (ReservaValidacaoException e) {
			LOGGER.error(MensagensEnum.RESERVA_SERVICO_ERRO_AO_VALIDAR.getValor());
			throw new ReservaServicoException(e.getMessage());
		}

	}

	@Override
	public List<Reserva> recuperarTodos() {
		return reservaDao.recuperarTodos();
	}

	@Override
	public void remover(Reserva reserva) {
		reservaDao.remover(reserva);
	}

	@Override
	public void atualizar(Reserva reserva) throws ReservaServicoException {
		try {
			validarReserva(reserva);
			reservaDao.atualizar(reserva);
		} catch (ReservaValidacaoException e) {
			LOGGER.error(MensagensEnum.RESERVA_SERVICO_ERRO_AO_VALIDAR.getValor());
			throw new ReservaServicoException(e.getMessage());
		}
	}

	@Override
	public void validarReserva(Reserva reserva) throws ReservaValidacaoException {
		if (reserva == null) {
			throw new ReservaValidacaoException(MensagensEnum.RESERVA_SERVICO_VALIDACAO_NULL.getValor());
		}
		if (reserva.getDt_reserva() == null) {
			throw new ReservaValidacaoException(MensagensEnum.RESERVA_SERVICO_VALIDACAO_DT_RESERVA.getValor());
		}
		if (reserva.getAluno() == null) {
			throw new ReservaValidacaoException(MensagensEnum.RESERVA_SERVICO_VALIDACAO_ALUNO.getValor());
		}
		if (reserva.getItem() == null) {
			throw new ReservaValidacaoException(MensagensEnum.RESERVA_SERVICO_VALIDACAO_ITEM.getValor());
		}
	}

}
