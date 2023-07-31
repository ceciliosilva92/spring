package loja.prova.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import loja.prova.model.Peca;
import loja.prova.repository.PecaRepository;

@Controller

public class PecaController {
	
	@Autowired
	PecaRepository pecaRepository;
	
	@RequestMapping(value="/peca", method=RequestMethod.GET)
	public ModelAndView getMarca() {
		ModelAndView mav = new ModelAndView("peca");
        List<Peca> peca = pecaRepository.findAll();
        mav.addObject("pecas", peca);
        return mav;
	}
	@RequestMapping(value="/peca/{id}", method=RequestMethod.GET)
	public ModelAndView getPeca1(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("peca1");
        Optional<Peca> peca = pecaRepository.findById(id);
        mav.addObject("nome", peca.get().getNome());
        return mav;
	}

}
