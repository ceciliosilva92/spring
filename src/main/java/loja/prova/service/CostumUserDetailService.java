package loja.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import loja.prova.model.Usuario;
import loja.prova.repository.UsuarioRepository;
import loja.prova.serviceimplement.CostumUserDetailServiceImplement;

@Service
public class CostumUserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRep;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario user = userRep.encontrarLogin(username);
		if (user == null)throw new UsernameNotFoundException("Erro de Usuario");
		return new CostumUserDetailServiceImplement(user);
	}

}
