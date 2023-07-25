package loja.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import loja.prova.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
