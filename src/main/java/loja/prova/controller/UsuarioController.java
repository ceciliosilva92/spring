package loja.prova.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import loja.prova.model.Usuario;
import loja.prova.repository.UsuarioRepository;
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
    UsuarioRepository usuarioRepository;
	
	@GetMapping
	public String getUsuario(Model mav) {
	    List<Usuario> usuario = usuarioRepository.findAll();
        mav.addAttribute("usuarios", usuario);
        return "usuario/index";
	}
	
	@GetMapping("/cadastro")
	public String CreatUsuario(Model mav) {
		return "usuario/cadastro";
	}
	
	@GetMapping("/{id}")
	public String getUsuario(Model mav, @PathVariable("id")Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
        mav.addAttribute("usuario", usuario.get());
        return "usuario/usuarioid";
	}
	@PostMapping
	public String postUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			attribute.addFlashAttribute("erro", "Algum campo com Erro");
			return "redirect:/usuario/cadastro";
		}
		
		BCryptPasswordEncoder kripto = new BCryptPasswordEncoder();
		usuario.setSenha(kripto.encode(usuario.getSenha()));
		usuario.setRole("vendedor");
		usuario.setCreated_at(LocalDateTime.now());
		usuario.setUpdated_at(LocalDateTime.now());
		
		usuarioRepository.save(usuario);
		
		return"redirect/usuario";
	}
	
	@PutMapping("/{id}")
	public String putUsuario(Usuario usuario, String senha, BindingResult result, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			attribute.addFlashAttribute("erro", "Algum campo com Erro");
			return "redirect:/usuario/cadastro";
		}
		Usuario usuarioBase =usuarioRepository.findById(usuario.getID()).orElse(null);
		usuarioBase.setNome(usuario.getNome());
		usuarioBase.setLogin(usuario.getLogin());
		if(!senha.equals("")) {
			BCryptPasswordEncoder krypto = new BCryptPasswordEncoder();
			usuario.setSenha(krypto.encode(senha));
		}
		usuarioBase.setUpdated_at(LocalDateTime.now());
		
		usuarioRepository.save(usuarioBase);
		
		attribute.addFlashAttribute("Sucess","Atualizado com suceso");
		
		return "redirect/usuario";
	}
	@GetMapping("/{id}/delete")
	public String deleteusuario(@PathVariable("id") Long id, RedirectAttributes atribute) {
		usuarioRepository.deleteById(id);
		atribute.addFlashAttribute("Sucess","Deletado com sucesso");
		return "redirect:/usuario";
	}	
	
	
	
}
