package loja.prova.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="produto")
public class Produto { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy'MM'DD HH:mm:ss")
	private LocalDateTime created_at;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy'MM'DD HH:mm:ss")
	private LocalDateTime updatre_at;

	@NotBlank
	private Double PrecCusto;
	
	@NotBlank
	private boolean PcPronto;
	
	@ManyToOne
	@JoinColumn(name = "peca_id",  nullable = true)
	private Peca peca;
	
	@ManyToOne
	@JoinColumn(name = "pc_pronto_id",  nullable = true)
	private PcPronto pc_pronto;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id",  nullable = false)
	private Usuario usuario;

	public Long getID() {
		return ID;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public LocalDateTime getUpdatre_at() {
		return updatre_at;
	}

	public Double getPrecCusto() {
		return PrecCusto;
	}

	public boolean isPcPronto() {
		return PcPronto;
	}

	public Peca getPeca() {
		return peca;
	}

	public PcPronto getPc_pronto() {
		return pc_pronto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setUpdatre_at(LocalDateTime updatre_at) {
		this.updatre_at = updatre_at;
	}

	public void setPrecCusto(Double precCusto) {
		PrecCusto = precCusto;
	}

	public void setPcPronto(boolean pcPronto) {
		PcPronto = pcPronto;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public void setPc_pronto(PcPronto pc_pronto) {
		this.pc_pronto = pc_pronto;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
