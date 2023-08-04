package loja.prova.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import loja.prova.model.Produto;
import loja.prova.repository.ProdutoRepository;

@Controller

public class ProdutoController {

	@Autowired
    ProdutoRepository produtoRepository;
	
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
        return mav;
	}
	
}
