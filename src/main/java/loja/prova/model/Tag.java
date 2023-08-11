package loja.prova.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="tag")
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@NotBlank
	private String Nome;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/DD HH:mm:ss")
	private LocalDateTime created_at;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/DD HH:mm:ss")
	private LocalDateTime updated_at;
	
	@ManyToMany(mappedBy = "tags")
	private List<Produto> produtos;
	
	//getters aqui

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

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	//setters aqui

	public void setID(Long iD) {
		ID = iD;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
