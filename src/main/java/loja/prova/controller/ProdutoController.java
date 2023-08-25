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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import loja.prova.model.Marca;
import loja.prova.model.PcPronto;
import loja.prova.model.Peca;
import loja.prova.model.Produto;
import loja.prova.model.Tag;
import loja.prova.model.TipoPeca;
import loja.prova.model.Usuario;
import loja.prova.repository.ProdutoRepository;
import loja.prova.repository.MarcaRepository;
import loja.prova.repository.PcProntoRepository;
import loja.prova.repository.PecaRepository;
import loja.prova.repository.TagRepository;
import loja.prova.repository.TipoPecaRepository;
import loja.prova.repository.UsuarioRepository;

@Controller

public class ProdutoController {

	@Autowired
    ProdutoRepository produtoRepository;
	@Autowired 
	MarcaRepository marcaRepository;
	@Autowired 
	TagRepository tagRepository;
	@Autowired 
	TipoPecaRepository tipoPecaRepository;
	@Autowired 
	PecaRepository pecaRepository;
	@Autowired 
	PcProntoRepository pcProntoRepository;
	@Autowired 
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/produto", method=RequestMethod.GET)
	public ModelAndView getProduto() {
		ModelAndView mav = new ModelAndView("produto");
        List<Produto> produto = produtoRepository.findAll();
        mav.addObject("produtos", produto);
        return mav;
	}
	@RequestMapping(value="/produto/{id}", method=RequestMethod.GET)
	public ModelAndView getProduto1(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("produto1");
		Optional<Produto> produto = produtoRepository.findById(id);
        mav.addObject("nome", produto.get().getPrecCusto());
        mav.addObject("precCusto", produto.get().getPrecCusto());
        return mav;
	}
	@RequestMapping(value = "/produto/{Id}/delete", method =RequestMethod.GET)
	public String deleteMarca(@PathVariable("Id")long id, RedirectAttributes atribute) {
		produtoRepository.deleteById(id);
		atribute.addFlashAttribute("Sucess","Deletado com sucesso");
		return "redirect:/produto";
		
	}
	
	@GetMapping("/produto/cadastro")
	public String createProduto(Model mav) {
		List<Marca> marcalist = marcaRepository.findAll();
		List<TipoPeca> tpecalist = tipoPecaRepository.findAll();
		List<Tag> taglist = tagRepository.findAll();
		mav.addAttribute("mar", marcalist);
		mav.addAttribute("tag", taglist);
		mav.addAttribute("tip", tpecalist);
		return "produto2";
		
	}
	@RequestMapping(value="/Produto/{id}", method=RequestMethod.POST)
	public String updateProduto(Produto produto, RedirectAttributes atribute ) {
		
		Produto produtoBase = produtoRepository.findById(produto.getID()).orElse(null);
		produtoBase.setPrecCusto(produto.getPrecCusto());
		produtoBase.setUpdated_at(LocalDateTime.now());
		
		produtoRepository.save(produtoBase);
		
		atribute.addFlashAttribute("Sucess","atualizada com sucesso");
		
		return "redirect:/produto";
		
	}

	@RequestMapping(value="/produto", method=RequestMethod.POST)
	public String postProduto(Produto produto, BindingResult result, RedirectAttributes atribute, String is_pc_pronto, PcPronto pcPronto, Peca peca) {
		
		if(result.hasErrors()) {
			atribute.addFlashAttribute("msg", "Campo Obrigatorio vacio");
//			return "redirect:/produto/cadastro";
			System.out.println(result.getAllErrors());
		}
	
		atribute.addFlashAttribute("Sucess", "Cadatrada com Sucesso");
		
		if(is_pc_pronto.equals("pc_pronto")) {
			pcPronto.setCreated_at(LocalDateTime.now());
			
			produto.setPc_pronto(pcProntoRepository.save(pcPronto));
			produto.setPcPronto(true);
		}else {
			peca.setCreated_at(LocalDateTime.now());
			pecaRepository.save(peca);
			produto.setPeca(peca);
			produto.setPcPronto(false);
		}
		Usuario usuarioBase = usuarioRepository.findById((long) 1).get();
		produto.setUsuario(usuarioBase);
		produto.setCreated_at(LocalDateTime.now());
		produtoRepository.save(produto);
		
		return "redirect:/produto";
	}
	
}
