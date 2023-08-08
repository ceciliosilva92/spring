package loja.prova.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@OneToMany(mappedBy = "usuario")
	private Set<Produto> produto;
	
	@NotBlank
	private String Nome;
	
	@NotBlank
	private String Login;
	
	@NotBlank
	private String Senha;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/M/M/DD HH:mm:ss")
	private LocalDateTime created_at;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/DD HH:mm:ss")
	private LocalDateTime updated_at;

	public Long getID() {
		return ID;
	}

	public String getNome() {
		return Nome;
	}

	public String getLogin() {
		return Login;
	}

	public String getSenha() {
		return Senha;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public LocalDateTime getUpdatre_at() {
		return updated_at;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdatre_at(LocalDateTime updatre_at) {
		this.updated_at = updatre_at;
	}
	
	
}
