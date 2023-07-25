package loja.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import loja.prova.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

}
