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
@Table(name="marca")
public class Marca {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@NotBlank
	private String Nome;
	
	@OneToMany(mappedBy="marca")
	private Set<Produto>produto;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/DD \n HH:mm:ss")
	private LocalDateTime created_at;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/DD \n HH:mm:ss")
	private LocalDateTime updated_at;
	
	// getters aqui
	public Long getID() {
		return ID;
	}
	public String getNome() {
		return Nome;
	}
	
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}	
	public Set<Produto> getProduto() {
		return produto;
	}
	//setters aqui
	public void setID(Long ID) {
		this.ID = ID;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public void setProduto(Set<Produto> produto) {
		this.produto = produto;
	}
	
	
}
