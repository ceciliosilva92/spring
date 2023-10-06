package loja.prova.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import loja.prova.model.Marca;
import loja.prova.model.Usuario;
import loja.prova.repository.MarcaRepository;
//import loja.prova.repository.TagRepository;
import loja.prova.repository.UsuarioRepository;
@Component
public class Semeadora implements CommandLineRunner {
	@Autowired
	MarcaRepository marcaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
//	TagRepository tagRepository;

	@Override
	public void run(String... args) throws Exception {
		
		String [] marcas = {"Acer", "Samsung","LG","Kingston"};
		
		for(String m: marcas) {
			
			Marca marca = marcaRepository.encontrarMarca(m);
			
			if(marca==null) {
				marca=new Marca(m);
				marcaRepository.save(marca);
			}
		}
		Usuario user = usuarioRepository.encontrarLogin("admin");
				
				if(user==null) {
					user=new Usuario("admin", "53036777", "cecilio");
					usuarioRepository.save(user);
				}
		
	}

}
