package loja.prova.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy'MM'DD HH:mm:ss")
	private LocalDateTime created_at;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy'MM'DD HH:mm:ss")
	private LocalDateTime updatre_at;

	public Long getID() {
		return ID;
	}

	public String getNome() {
		return Nome;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public LocalDateTime getUpdatre_at() {
		return updatre_at;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdatre_at(LocalDateTime updatre_at) {
		this.updatre_at = updatre_at;
	}
	
}
