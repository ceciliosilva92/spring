package loja.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import loja.prova.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

//	Marca findByNome(String marca);
	@Query(value="select * from marca where nome= :Nome",nativeQuery=true)
	Marca encontrarMarca(String Nome);
}
