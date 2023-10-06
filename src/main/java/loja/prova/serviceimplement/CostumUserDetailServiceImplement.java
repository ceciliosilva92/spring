package loja.prova.serviceimplement;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import loja.prova.model.Usuario;

public class CostumUserDetailServiceImplement implements UserDetails{

	private static final long serialVersionUID = 1L;
private Usuario usuario;
public CostumUserDetailServiceImplement(Usuario usuario) {
	super();
	this.usuario = usuario;
}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority(usuario.getRole()));
	}

	@Override
	public String getPassword() {
		
		return usuario.getSenha();
	}

	@Override
	public String getUsername() {
		
		return usuario.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
