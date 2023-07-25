package loja.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import loja.prova.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
	//pode da pau no id da model
}
