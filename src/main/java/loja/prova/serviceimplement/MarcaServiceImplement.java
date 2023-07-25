package loja.prova.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import loja.prova.model.Marca;
import loja.prova.repository.MarcaRepository;
import loja.prova.service.MarcaService;

public class MarcaServiceImplement implements MarcaService{

	@Autowired
    MarcaRepository marcaRepository;
	
	@Override
	public List<Marca> findAll() {
		// TODO Auto-generated method stub
		return marcaRepository.findAll();
	}

	@Override
	public Marca findById(Long Id) {
		// TODO Auto-generated method stub
		return marcaRepository.findById(Id).get();
	}

	@Override
	public Marca Save(Marca marca) {
		// TODO Auto-generated method stub
		return marcaRepository.save(marca);
	}
	

}
