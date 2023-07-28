package loja.prova.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import loja.prova.model.Peca;
import loja.prova.repository.PecaRepository;
import loja.prova.service.PecaService;

public class PecaServiceImplement implements PecaService{

	@Autowired
	PecaRepository pecaRepository;
	
	
	public List<Peca> findAll() {
		// TODO Auto-generated method stub
		return pecaRepository.findAll();
	}

	
	public Peca findById(Long Id) {
		// TODO Auto-generated method stub
		return pecaRepository.findById(Id).get();
	}

	
	public Peca save(Peca peca) {
		// TODO Auto-generated method stub
		return pecaRepository.save(peca);
	}

}
