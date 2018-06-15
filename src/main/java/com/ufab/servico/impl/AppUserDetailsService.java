package com.ufab.servico.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ufab.dao.IUsuarioDAO;
import com.ufab.entidade.Usuario;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.seguranca.UsuarioAutenticado;

@Service
public class AppUserDetailsService implements UserDetailsService {

	protected final Logger LOGGER = Logger.getLogger(UserDetailsService.class);

	@Autowired
	IUsuarioDAO userDao;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Usuario user = userDao.recuperarPorCpf(username);
		if (user == null) {
			throw new UsernameNotFoundException(MensagensEnum.USUARIO_NAO_EXISTE.getValor());
		}
		return new UsuarioAutenticado(user);
	}

}