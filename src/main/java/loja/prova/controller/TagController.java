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
import loja.prova.model.Tag;
import loja.prova.repository.TagRepository;

@Controller

public class TagController {

	@Autowired
    TagRepository tagRepository;
	
	@RequestMapping(value="/tag", method=RequestMethod.GET)
	public ModelAndView getTeg() {
		ModelAndView mav = new ModelAndView("Tag/tag");
        List<Tag> tag = tagRepository.findAll();
        mav.addObject("tags", tag);
        return mav;
	}
	
	@RequestMapping(value="/tag/{id}", method=RequestMethod.GET)
	public ModelAndView getTag(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("Tag/tag1");
        Optional<Tag> tag = tagRepository.findById(id);
        mav.addObject("nome", tag.get().getNome());
        return mav;
	}
	
	@RequestMapping(value="/tag", method=RequestMethod.POST)
	public String postTag(@Valid Tag tag, BindingResult result, RedirectAttributes atribute) {
		
		if(result.hasErrors()) {
			atribute.addFlashAttribute("msg", "Campo Obrigatorio vacio");
			return "redirect:/tag";
		}
		atribute.addFlashAttribute("Sucess", "Cadatrada com Sucesso");
		
		tag.setCreated_at(LocalDateTime.now());
		tag.setUpdated_at(LocalDateTime.now());
		
		tagRepository.save(tag);
		
		return "redirect:/tag";
	}
	@RequestMapping(value="/tag/{id}", method=RequestMethod.POST)
	public String updateTag(Tag tag, RedirectAttributes atribute ) {
		
		Tag tagBase = tagRepository.findById(tag.getID()).orElse(null);
		tagBase.setNome(tag.getNome());
		tagBase.setUpdated_at(LocalDateTime.now());
		
		tagRepository.save(tagBase);
		
		atribute.addFlashAttribute("Sucess","atualizada com sucesso");
		
		return "redirect:/tag";
		
	}
	@RequestMapping(value = "/tag/{Id}/delete", method =RequestMethod.GET)
	public String deleteTag(@PathVariable("Id")long id, RedirectAttributes atribute) {
		tagRepository.deleteById(id);
		atribute.addFlashAttribute("Sucess","Deletado com sucesso");
		return "redirect:/tag";
		
	}
	
	
	
	
	
	
}
