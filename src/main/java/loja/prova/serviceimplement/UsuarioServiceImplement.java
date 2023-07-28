package loja.prova.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import loja.prova.model.Usuario;
import loja.prova.repository.UsuarioRepository;
import loja.prova.service.UsuarioService;

public class UsuarioServiceImplement implements UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long Id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(Id).get();
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

}
