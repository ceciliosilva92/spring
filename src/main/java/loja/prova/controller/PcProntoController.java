package loja.prova.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import loja.prova.model.PcPronto;
import loja.prova.repository.PcProntoRepository;

@Controller

public class PcProntoController {

	@Autowired
    PcProntoRepository pcProntoRepository;
	
	@RequestMapping(value="/pcPronto", method=RequestMethod.GET)
	public ModelAndView getPcPronto() {
		ModelAndView mav = new ModelAndView("pcPronto");
		List<PcPronto> pcPronto = pcProntoRepository.findAll();
        mav.addObject("pcPronto", pcPronto);
        return mav;
	}
	@RequestMapping(value="/pcPronto/{id}", method=RequestMethod.GET)
	public ModelAndView getPcPronto(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("pcPronto");
        Optional<PcPronto> pcPronto = pcProntoRepository.findById(id);
        mav.addObject("nome",pcPronto.get().getNome());
        return mav;
	}
}
