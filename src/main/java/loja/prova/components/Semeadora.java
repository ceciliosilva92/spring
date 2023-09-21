package loja.prova.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import loja.prova.model.Marca;
import loja.prova.repository.MarcaRepository;
import loja.prova.repository.TagRepository;
@Component
public class Semeadora implements CommandLineRunner {
	@Autowired
	MarcaRepository marcaRepository;
//	@Autowired
//	TagRepository tagRepository;

	@Override
	public void run(String... args) throws Exception {
		
		String [] marcas = {"Acer", "Samsung","LG"};
		
		for(String m: marcas) {
			
			Marca marca = marcaRepository.encontrarMarca(m);
			
			if(marca==null) {
				marca=new Marca(m);
				marcaRepository.save(marca);
			}
		}
		
	}

}
