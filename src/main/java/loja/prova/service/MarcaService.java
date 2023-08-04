package loja.prova.service;

import java.util.List;

import loja.prova.model.Marca;

public interface MarcaService {
	List<Marca> findAll();
	Marca findById(Long Id);
	Marca Save(Marca marca);
	Marca deleteById(Long Id);
}
