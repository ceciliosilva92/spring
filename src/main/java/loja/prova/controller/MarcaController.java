package loja.prova.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import loja.prova.model.Marca;
import loja.prova.repository.MarcaRepository;

@Controller
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
    MarcaRepository marcaRepository;
	
	@GetMapping
	public String getMarca(Model mav) {
	
		List<Marca> marca = marcaRepository.findAll();
        mav.addAttribute("marcas", marca);
        return "marca/index";
	}
	
	@GetMapping("/{id}")
	public ModelAndView getMarcaid(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("marca1");
        Optional<Marca> marca = marcaRepository.findById(id);
        mav.addObject("nome", marca.get().getNome());
        mav.addObject("id", marca.get().getID());
        return mav;
	}
	
	@PostMapping
	public String postMarca(@Valid Marca marca, BindingResult result, RedirectAttributes atribute) {
		
		if(result.hasErrors()) {
			atribute.addFlashAttribute("msg", "Campo Obrigatorio vacio");
			return "redirect:marca/index";
		}
		atribute.addFlashAttribute("Sucess", "Cadatrada com Sucesso");
		
		marca.setCreated_at(LocalDateTime.now());
		marca.setUpdated_at(LocalDateTime.now());
		
		marcaRepository.save(marca);
		
		return "redirect:/marca";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteMarca(@PathVariable("Id")long id, RedirectAttributes atribute) {
		marcaRepository.deleteById(id);
		atribute.addFlashAttribute("Sucess","Deletado com sucesso");
		return "redirect:/marca";
		
	}
	
	@PutMapping("/{id}")
	public String putMarca( Marca marca, BindingResult result, RedirectAttributes atribute) {
		System.out.println("por fin");
		if (result.hasErrors()) {
			atribute.addFlashAttribute("error", "Algum campo deve ser obrigatório!");
			return "redirect: /marca/"+ marca.getID();
		}
		Marca marcaBase = marcaRepository.findById(marca.getID()).orElse(null);
		marcaBase.setNome(marca.getNome());
		marcaBase.setUpdated_at(LocalDateTime.now());
		
		marcaRepository.save(marcaBase);
		
		atribute.addFlashAttribute("Sucess","atualizada com sucesso");
		
		return "redirect:/marca";
		
	}

}
