package loja.prova.service;

import java.util.List;

import loja.prova.model.Produto;

public interface ProdutoService {

	List <Produto> findAll();
	
	Produto findById(Long Id);
	
	Produto save(Produto produto);
	
	
}
