package br.com.lsd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_estado", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_estado", length = 100, nullable = false)
	private String nome;

	@Column(name = "sigla", length = 2, nullable = false)
	private String sigla;

	public Estado() {
	}

	public Estado(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}