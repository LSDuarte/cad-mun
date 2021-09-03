package br.com.lsd.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pessoa")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sobrenome")
	private String sobreNome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "idade")
	private Integer idade;

	@Column(name = "data_nasc")
	private LocalDate dataNascimento;

	@Column(name = "sexo")
	private String sexo;

	@ManyToOne
	@JoinColumn(name = "fk_endereco")
	private Endereco endereco;

	public Pessoa() {
	}

	public Pessoa(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer calcularIdade() {
		int anoAtual = (int) LocalDate.now().getYear();
		int anoNasc = (int) this.dataNascimento.getYear();
		return anoAtual - anoNasc;
	}
	
	public String nomeCompleto() {
		return this.nome + " " + this.sobreNome;
	}

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.dataNascimento = LocalDate.of(1993, 10, 11);
		System.out.println(p.calcularIdade());
	}
}