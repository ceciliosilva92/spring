package loja.prova.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/produto")
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
	
	@GetMapping
	public String getProduto(Model mav) {
		
        List<Produto> produto = produtoRepository.findAll();
        mav.addAttribute("produtos", produto);
        return "produto/index";
	}
	@GetMapping("/{Id}")
	public String getedit(Model mav, @PathVariable("Id") Long id) {
		List<Marca> marcalist = marcaRepository.findAll();
		List<TipoPeca> tpecalist = tipoPecaRepository.findAll();
		List<Tag> taglist = tagRepository.findAll();
		Produto produto = produtoRepository.findById(id).get();
		mav.addAttribute("produto", produto);
		mav.addAttribute("marca", marcalist);
        mav.addAttribute("tag", taglist);
        mav.addAttribute("tpeca", tpecalist);
        return "/produto/editar";
	}
	@GetMapping("/{Id}/delete")
	public String deleteProduto(@PathVariable("Id")long id, RedirectAttributes atribute) {
		produtoRepository.deleteById(id);
		atribute.addFlashAttribute("Sucess","Deletado com sucesso");
		return "redirect:/produto";
		
	}
	
	@GetMapping("/cadastro")
	public String createProduto(Model mav) {
		List<Marca> marcalist = marcaRepository.findAll();
		List<TipoPeca> tpecalist = tipoPecaRepository.findAll();
		List<Tag> taglist = tagRepository.findAll();
		mav.addAttribute("mar", marcalist);
		mav.addAttribute("tag", taglist);
		mav.addAttribute("tip", tpecalist);
		return "produto/cadastro";
		
	}
	@PostMapping("/{Id}")
	public String putProduto(String is_pc_pronto, Produto produto, Peca peca ,PcPronto pcPronto, BindingResult result, RedirectAttributes atribute) {
		System.out.println("por fin");
		if (result.hasErrors()) {
			atribute.addFlashAttribute("error", "Algum campo deve ser obrigatório!");
			return  "redirect:/produto/"+ produto.getID();
		}
		Produto produtoBase = produtoRepository.findById(produto.getID()).orElse(null);
		if(is_pc_pronto.equals("pc_pronto")) {
			
			if (produtoBase.getPc_pronto() == null) {

				pcPronto.setCreated_at(LocalDateTime.now());
				pcPronto.setUpdated_at(LocalDateTime.now());
				
				produtoBase.setPc_pronto((pcProntoRepository.save(pcPronto)));
				produtoBase.setPeca(null);
				
			} else {

				PcPronto pcProntoBase = pcProntoRepository.findById(produtoBase.getPc_pronto().getID()).get();
				
				pcProntoBase.setUpdated_at(LocalDateTime.now());
				pcProntoBase.setNome(pcPronto.getNome());
				pcProntoBase.setDescricao(pcPronto.getDescricao());
			}
			
			produtoBase.setPcPronto(true);
			
		} else {

			if (produtoBase.getPeca() == null) {

				peca.setCreated_at(LocalDateTime.now());
				peca.setUpdated_at(LocalDateTime.now());
				
				produtoBase.setPeca(pecaRepository.save(peca));
				produtoBase.setPc_pronto(null);
				
			} else {
				
				Peca pecaBase = pecaRepository.findById(produtoBase.getPeca().getID()).get();
			
				pecaBase.setUpdated_at(LocalDateTime.now());
				pecaBase.setCapacidade(peca.getCapacidade());
				pecaBase.setUniMedida(peca.getUniMedida());
				pecaBase.setQuantidade(peca.getQuantidade());
				pecaBase.setTipo_peca(peca.getTipo_peca());
				pecaBase.setNome(peca.getNome());
				pecaBase.setDescricao(peca.getDescricao());
			
			}
			
			produtoBase.setPcPronto(false);
		}
		System.out.println("por fin");
		produtoBase.setPrecCusto(produto.getPrecCusto());
		produtoBase.setUpdated_at(LocalDateTime.now());
		produtoBase.setMarca(produto.getMarca());
		produtoBase.setTags(produto.getTags());
		
		produtoRepository.save(produtoBase);
		
		atribute.addFlashAttribute("Sucess","atualizada com sucesso");
		
		return "redirect:/produto";
		
	}

	@PostMapping
	public String postProduto(String is_pc_pronto, Produto produto, PcPronto pc_pronto, 
			 Peca peca, BindingResult result, RedirectAttributes atribute) {
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			atribute.addFlashAttribute("msg", "Campo Obrigatorio vacio");
			return "redirect:/produto/cadastro";
		}
	
		atribute.addFlashAttribute("Sucess", "Cadatrada com Sucesso");
		
		if(is_pc_pronto.equals("pc_pronto")) {
			pc_pronto.setCreated_at(LocalDateTime.now());
			
			produto.setPc_pronto(pcProntoRepository.save(pc_pronto));
			produto.setPcPronto(true);
		}else {
			peca.setCreated_at(LocalDateTime.now());
			pecaRepository.save(peca);
			produto.setPeca(peca);
			produto.setPcPronto(false);
		}
		Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
		Usuario usuarioBase = usuarioRepository.encontrarLogin(authentication.getName());
		produto.setUsuario(usuarioBase);
		produto.setCreated_at(LocalDateTime.now());
		produtoRepository.save(produto);
		
		return "redirect:/produto";
	}
	
}
