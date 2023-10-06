package loja.prova.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
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
public Usuario() {}
	
	public Usuario(String Login, String Senha,String Nome) {
		super();
		this.Nome = Nome;
		this.created_at= LocalDateTime.now();
		this.updated_at= LocalDateTime.now();
		this.Login = Login;
		BCryptPasswordEncoder kripto = new BCryptPasswordEncoder();
		this.Senha=kripto.encode(Senha);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ID;
	
	@OneToMany(mappedBy = "usuario")
	private Set<Produto> produto;
	
	@NotBlank
	private String Nome;
	
	@NotBlank
	@Column(unique=true)
	private String Login;
	
	@NotBlank
	private String Senha;
	
	private String role;
	
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

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	
	public String getRole() {
		return role;
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

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
}
