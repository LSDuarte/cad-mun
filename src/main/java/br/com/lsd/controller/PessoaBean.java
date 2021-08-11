package br.com.lsd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lsd.dao.PessoaDao;
import br.com.lsd.model.Pessoa;
import br.com.lsd.util.JSFUtil;

@Named
@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private List<Pessoa> pessoas = new ArrayList<>();
	@Inject
	private PessoaDao pessoaDao;

	public List<Pessoa> getListarPessoas() {
		return new PessoaDao().listar();
	}

	@PostConstruct
	public void init() {
		this.pessoa = new Pessoa();
		this.pessoaDao = new PessoaDao();
		this.pessoas = new ArrayList<Pessoa>();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void salvarPessoa() {
		if (pessoa == null) {
			pessoa = new Pessoa();
			try {
				pessoaDao.save(pessoa);
				JSFUtil.adicionarMensagemSucesso("Sucesso.", this.pessoa.getNome() + " salvo com sucesso!");
				limparTela();
			} catch (Exception e) {
				e.printStackTrace();
				JSFUtil.adicionarMensagemErro("Erro.", "Erro ao tentar salvar " + this.pessoa.getNome());
			}
		}
	}

	private void limparTela() {
		this.pessoa = new Pessoa();
	}

	public void deletarPessoa(Long id) {

	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}