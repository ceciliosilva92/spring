package loja.prova.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@PutMapping("/{id}")
	public String putPcPronto(PcPronto pcPronto, RedirectAttributes atribute, BindingResult result ) {
		
		if (result.hasErrors()) {
			atribute.addFlashAttribute("error", "Algum campo deve ser obrigatório!");
			return "redirect: /produto/"+ pcPronto.getID();
		}
		
		PcPronto pcProntoBase = pcProntoRepository.findById(pcPronto.getID()).orElse(null);
		pcProntoBase.setNome(pcPronto.getNome());
		pcProntoBase.setUpdated_at(LocalDateTime.now());
		
		pcProntoRepository.save(pcProntoBase);
		
		atribute.addFlashAttribute("Sucess","atualizada com sucesso");
		
		return "redirect:/pcPronto";
		
	}
}
