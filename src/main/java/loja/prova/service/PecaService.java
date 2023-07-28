package loja.prova.service;

import java.util.List;

import loja.prova.model.Peca;

public interface PecaService {
	
	List <Peca> findAll();
	Peca findById(Long Id);
	Peca save(Peca peca);
	

}
