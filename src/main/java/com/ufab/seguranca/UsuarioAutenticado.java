package com.ufab.seguranca;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ufab.entidade.Usuario;

public class UsuarioAutenticado implements UserDetails {

	private static final long serialVersionUID = 1128807830189252057L;
	private Usuario user;

	public UsuarioAutenticado(Usuario usuario) {
		this.user = usuario;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public String getUsername() {
		return user.getCpf();
	}

	@Override
	public String getPassword() {
		return user.getSenha();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
		auths.add(new SimpleGrantedAuthority(user.getPerfil().getTipoPerfil().toString()));
		return auths;
	}

	public Usuario getUsuario() {
		return this.user;
	}
}
