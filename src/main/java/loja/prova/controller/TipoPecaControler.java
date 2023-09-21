package loja.prova.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import loja.prova.model.TipoPeca;
import loja.prova.repository.TipoPecaRepository;

@Controller
@RequestMapping("/tipoPeca")
public class TipoPecaControler {
	
	@Autowired
	TipoPecaRepository tipoPecaRepository;
	
	@GetMapping
	public ModelAndView getPeca() {
		ModelAndView mav = new ModelAndView("/TipoPeca/tipoPeca");
        List<TipoPeca> tipoPeca = tipoPecaRepository.findAll();
        mav.addObject("tipoPeca", tipoPeca);
        return mav;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView getEditar(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("/TipoPeca/editar");
        Optional<TipoPeca> tipoPeca = tipoPecaRepository.findById(id);
        mav.addObject("nome", tipoPeca.get().getNome());
        return mav;
	}
	@PostMapping
	public String postTipoPeca(TipoPeca tipoPeca, BindingResult result, RedirectAttributes atribute) {
		
		if(result.hasErrors()) {
			atribute.addFlashAttribute("msg", "Campo Obrigatorio vacio");
			return "redirect:TipoPeca/tipoPeca";
			}
		atribute.addFlashAttribute("Sucess", "Cadatrada com Sucesso");
		
		tipoPeca.setCreated_at(LocalDateTime.now());
		tipoPeca.setUpdated_at(LocalDateTime.now());
		
		tipoPecaRepository.save(tipoPeca);
		
		return "redirect:/tipoPeca";
	}
	@GetMapping("/{id}/delete")
	public String deleteTipoPeca(@PathVariable("id")long id, RedirectAttributes atribute) {
		tipoPecaRepository.deleteById(id);
		atribute.addFlashAttribute("Sucess","Deletado com sucesso");
		return "redirect:/tipoPeca";
		
	}
	
	@PostMapping("/{id}")
	public String putMarca( @Valid TipoPeca tipoPeca, BindingResult result, RedirectAttributes atribute) {
		System.out.println("por fin");
		if (result.hasErrors()) {
			atribute.addFlashAttribute("error", "Algum campo deve ser obrigatório!");
			return "redirect: /tipoPeca/"+ tipoPeca.getID();
		}
		TipoPeca tPeacBASE = tipoPecaRepository.findById(tipoPeca.getID()).orElse(null);
		tPeacBASE.setNome(tipoPeca.getNome());
		tPeacBASE.setUpdated_at(LocalDateTime.now());
		
		tipoPecaRepository.save(tPeacBASE);
		
		atribute.addFlashAttribute("Sucess","atualizada com sucesso");
		
		return "redirect:/tipoPeca";
		
	}

}
