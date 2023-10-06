package loja.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import loja.prova.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

	@Query(value="select * from usuario where login= :Login",nativeQuery=true)
	Usuario encontrarLogin(String Login);
}
