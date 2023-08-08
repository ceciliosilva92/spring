package loja.prova.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
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
        mav.addObject("id", marca.get().getID());
        return mav;
	}
	
	@RequestMapping(value="/marca", method=RequestMethod.POST)
	public String postMarca(@Valid Marca marca, BindingResult result, RedirectAttributes atribute) {
		
		if(result.hasErrors()) {
			atribute.addFlashAttribute("msg", "Campo Obrigatorio vacio");
			return "redirect:/marca";
		}
		atribute.addFlashAttribute("Sucess", "Cadatrada com Sucesso");
		
		marca.setCreated_at(LocalDateTime.now());
		marca.setUpdated_at(LocalDateTime.now());
		
		marcaRepository.save(marca);
		
		return "redirect:/marca";
	}
	@RequestMapping(value = "/marca/{Id}/delete", method =RequestMethod.GET)
	public String deleteMarca(@PathVariable("Id")long id, RedirectAttributes atribute) {
		marcaRepository.deleteById(id);
		atribute.addFlashAttribute("Sucess","Deletado com sucesso");
		return "redirect:/marca";
		
	}
	@RequestMapping(value="/marca/{id}", method=RequestMethod.POST)
	public String updateMarca(Marca marca, RedirectAttributes atribute ) {
		
		Marca marcaBase = marcaRepository.findById(marca.getID()).orElse(null);
		marcaBase.setNome(marca.getNome());
		marcaBase.setUpdated_at(LocalDateTime.now());
		
		marcaRepository.save(marcaBase);
		
		atribute.addFlashAttribute("Sucess","atualizada com sucesso");
		
		return "redirect:/marca";
		
	}

}
