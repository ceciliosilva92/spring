package loja.prova.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import loja.prova.model.TipoPeca;
import loja.prova.repository.TipoPecaRepository;
import loja.prova.service.TipoPecaService;

public class TipoPecaServiceImplement implements TipoPecaService {

	@Autowired
	TipoPecaRepository tipoPecaRepository;
	
	public List<TipoPeca> findAll() {
		// TODO Auto-generated method stub
		return tipoPecaRepository.findAll();
	}

	
	public TipoPeca findById(Long Id) {
		// TODO Auto-generated method stub
		return tipoPecaRepository.findById(Id).get();
	}

	
	public TipoPeca save(TipoPeca tipopeca) {
		// TODO Auto-generated method stub
		return tipoPecaRepository.save(tipopeca);
	}

}
