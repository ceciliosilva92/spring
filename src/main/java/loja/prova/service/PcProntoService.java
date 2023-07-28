package loja.prova.service;

import loja.prova.model.PcPronto;

import java.util.List;

public interface PcProntoService {
	
	List <PcPronto> findAll();
	
	PcPronto findById(Long Id);
	
	PcPronto save (PcPronto pc_pronto);
}
