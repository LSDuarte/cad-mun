package br.com.lsd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lsd.dao.EnderecoDao;
import br.com.lsd.model.Endereco;
import br.com.lsd.util.JSFUtil;

@Named
@ViewScoped
@ManagedBean(name = "enderecoBean")
public class EnderecoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Endereco endereco;
	private List<Endereco> enderecos = new ArrayList<>();
	@Inject
	private EnderecoDao enderecoDao;

	@PostConstruct
	public void init() {
		this.endereco = new Endereco();
		this.enderecos = new ArrayList<Endereco>();
		this.enderecoDao = new EnderecoDao();
	}
	
	public List<Endereco> getListarEnderecos() {
		return enderecoDao.listar();
	}

	public void salvarEndereco() {
		try {
			enderecoDao.save(endereco);
			JSFUtil.adicionarMensagemSucesso("Sucesso!", "Registro salvo com sucesso.");
			limparTela();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro", "Erro ao realizar o cadastro!");
		}
	}

	private void limparTela() {
		endereco = new Endereco();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}