package loja.prova.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import loja.prova.model.Produto;
import loja.prova.repository.ProdutoRepository;
import loja.prova.service.ProdutoService;

public class ProdutoServiceImplement implements ProdutoService{

	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return produtoRepository.findAll();
	}

	
	public Produto findById(Long Id) {
		// TODO Auto-generated method stub
		return produtoRepository.findById(Id).get();
	}

	
	public Produto save(Produto produto) {
		// TODO Auto-generated method stub
		return produtoRepository.save(produto);
	}
}
