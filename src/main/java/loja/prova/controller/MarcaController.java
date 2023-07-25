package loja.prova.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import loja.prova.model.Marca;
import loja.prova.repository.MarcaRepository;

@Controller

public class MarcaController {
	
	@Autowired
    MarcaRepository marcaRepository;
	
	@RequestMapping(value="/marca", method=RequestMethod.GET)
	public ModelAndView getMarca() {
		ModelAndView mav = new ModelAndView("marca");
        List<Marca> marca = marcaRepository.findAll();
        mav.addObject("marcas", marca);
        return mav;
	}
	@RequestMapping(value="/marca/{id}", method=RequestMethod.GET)
	public ModelAndView getMarca1(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("marca1");
        Optional<Marca> marca = marcaRepository.findById(id);
        mav.addObject("nome", marca.get().getNome());
        return mav;
	}

}
