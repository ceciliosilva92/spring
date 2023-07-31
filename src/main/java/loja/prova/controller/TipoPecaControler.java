package loja.prova.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import loja.prova.model.TipoPeca;
import loja.prova.repository.TipoPecaRepository;

@Controller

public class TipoPecaControler {
	
	@Autowired
	TipoPecaRepository tipoPecaRepository;
	
	@RequestMapping(value= "/TipoPeca", method=RequestMethod.GET)
	public ModelAndView getPeca() {
		ModelAndView mav = new ModelAndView("tipoPeca");
        List<TipoPeca> tipoPeca = tipoPecaRepository.findAll();
        mav.addObject("tipoPeca", tipoPeca);
        return mav;
	}
	
	@RequestMapping(value="/tipoPeca/{id}", method=RequestMethod.GET)
	public ModelAndView getTipoPeca1(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("tipo>Peca1");
        Optional<TipoPeca> tipoPeca = tipoPecaRepository.findById(id);
        mav.addObject("nome", tipoPeca.get().getNome());
        return mav;
	}

}
