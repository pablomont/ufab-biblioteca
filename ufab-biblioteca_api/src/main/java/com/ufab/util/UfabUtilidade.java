package com.ufab.util;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ufab.excecao.UfabUtilidadeException;

public class UfabUtilidade {
	private static final String DATA_INVALIDA = "A data informada está inválida, a mesma deve possuir esse formato ##/##/###";

	private static final String DATA_INVALIDA_DIA = "O dia informado na data, está inválido.";

	private static final String DATA_INVALIDA_MES = "O mês informado na data, está inválido.";

	private static final String DATA_INVALIDA_ANO = "O ano informado na data, está inválido.";

	private static Logger LOGGER = Logger.getLogger(UfabUtilidade.class);

	/**
	 * Metodo utilizado para gerar um a data a partir de uma String no formato
	 * ##/##/###
	 * 
	 * @return Um Objeto Date, com base na String que foi informada.
	 * @throws UfabUtilidadeException
	 */
	public static Date gerarDataPorString(String dataString) throws UfabUtilidadeException {
		try {
			validarData(dataString);
			String[] dataSplit = dataString.split("/");
			Calendar cal = Calendar.getInstance();
			cal.set(Integer.parseInt(dataSplit[2]), Integer.parseInt(dataSplit[1]) - 1, Integer.parseInt(dataSplit[0]));
			return cal.getTime();
		} catch (UfabUtilidadeException e) {
			LOGGER.error(e.getMessage(), e);
			throw new UfabUtilidadeException(DATA_INVALIDA);
		}
	}

	public static boolean validarData(String dataStr) throws UfabUtilidadeException {
		try {
			String[] strTest = dataStr.split("/");
			int dia = Integer.parseInt(strTest[0]);
			int mes = Integer.parseInt(strTest[1]);
			int ano = Integer.parseInt(strTest[2]);

			if (dia < 0 || dia > 31) {
				throw new UfabUtilidadeException(DATA_INVALIDA_DIA);
			}
			if (mes < 0 || mes > 12) {
				throw new UfabUtilidadeException(DATA_INVALIDA_MES);
			}
			if (ano < 0) {
				throw new UfabUtilidadeException(DATA_INVALIDA_ANO);
			}

		} catch (IndexOutOfBoundsException e) {
			throw new UfabUtilidadeException(DATA_INVALIDA);
		} catch (NumberFormatException e) {
			throw new UfabUtilidadeException(DATA_INVALIDA);
		}

		return false;
	}
}
