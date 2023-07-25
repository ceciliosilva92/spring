package loja.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import loja.prova.model.Peca;


public interface PecaRepository extends JpaRepository<Peca, Long> {

}
