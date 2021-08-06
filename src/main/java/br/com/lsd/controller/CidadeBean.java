package br.com.lsd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lsd.dao.CidadeDao;
import br.com.lsd.model.Cidade;
import br.com.lsd.util.JSFUtil;

@Named
@ViewScoped
@ManagedBean(name = "cidadeBean")
public class CidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cidade cidade;
	private List<Cidade> cidades = new ArrayList<>();
	@Inject
	private CidadeDao cidadeDao;

	public List<Cidade> getListarCidades() {
		return cidadeDao.listar();
	}

	@PostConstruct
	public void init() {
		this.cidade = new Cidade();
		this.cidades = new ArrayList<Cidade>();
		this.cidadeDao = new CidadeDao();
	}

	public void salvarCidade() {
		try {
			cidadeDao.save(cidade);
			JSFUtil.adicionarMensagemSucesso("Sucesso", "Salvo com Sucesso!");
			limparTela();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro", "Erro ao realizar o cadastro!");
		}
	}

	private void limparTela() {
		this.cidade = new Cidade();
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

}