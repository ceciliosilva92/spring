package loja.prova.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="peca")
public class Peca {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@ManyToOne
	@JoinColumn(name = "tipo_peca_id",  nullable = false)
	private TipoPeca tipo_peca;
	
	@OneToMany(mappedBy = "peca")
	private Set<Produto> produto;
	
	@NotBlank
	private double Capacidade;
	
	@NotBlank
	private String UniMedida;
	
	@NotBlank
	private int Quantidade;
	
	@NotBlank
	private String Nome;
	
	@NotBlank
	@Lob
	private String Descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/DD HH:mm:ss")
	private LocalDateTime created_at;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/DD HH:mm:ss")
	private LocalDateTime updated_at;

	
	
	public Long getID() {
		return ID;
	}

	public double getCapacidade() {
		return Capacidade;
	}

	public String getUniMedida() {
		return UniMedida;
	}

	public int getQuantidade() {
		return Quantidade;
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

	public LocalDateTime getUpdatre_at() {
		return updated_at;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public void setCapacidade(double capacidade) {
		Capacidade = capacidade;
	}

	public void setUniMedida(String uniMedida) {
		UniMedida = uniMedida;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdatre_at(LocalDateTime updatre_at) {
		this.updated_at = updatre_at;
	}
	
}
