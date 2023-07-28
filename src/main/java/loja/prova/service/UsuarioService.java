package loja.prova.service;

import java.util.List;

import loja.prova.model.Usuario;

public interface UsuarioService {

	List <Usuario> findAll();
	
	Usuario findById(Long Id);
	
	Usuario save(Usuario usuario);
}
