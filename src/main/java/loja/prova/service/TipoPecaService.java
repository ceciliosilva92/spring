package loja.prova.service;

import java.util.List;

import loja.prova.model.TipoPeca;

public interface TipoPecaService {
	
	List<TipoPeca> findAll();
	
	TipoPeca findById(Long Id);
	
	TipoPeca save(TipoPeca tipopeca);

}
