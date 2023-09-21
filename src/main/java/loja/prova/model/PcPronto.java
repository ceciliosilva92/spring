package loja.prova.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="pc_pronto")
public class PcPronto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ID;
	
	@OneToMany(mappedBy = "pc_pronto")
	private Set<Produto> produto;
	
	@NotBlank
	private String Nome;
	
	@NotBlank
	@Lob
	private String Descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy'MM'DD HH:mm:ss")
	private LocalDateTime created_at;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy'MM'DD HH:mm:ss")
	private LocalDateTime updated_at;

	public Long getID() {
		return ID;
	}

	public String getNome() {
		return Nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	

}
