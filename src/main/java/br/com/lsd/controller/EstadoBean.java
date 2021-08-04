package br.com.lsd.controller;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lsd.dao.EstadoDao;
import br.com.lsd.model.Estado;
import br.com.lsd.util.JSFUtil;

@Named
@ViewScoped
@ManagedBean(name = "estadoBean")
public class EstadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Estado estado;
	private List<Estado> estados;

	@Inject
	private EstadoDao estadoDao;

	public List<Estado> getListarEstados() {
		return estadoDao.listar();
	}

	@PostConstruct
	public void init() {
		this.estado = new Estado();
		this.estados = new ArrayList<Estado>();
		this.estadoDao = new EstadoDao();
	}

	public void salvarEstado() {
		try {
			estadoDao.save(estado);
			JSFUtil.adicionarMensagemSucesso("Sucesso", "Salvo com Sucesso!");
			limparTela();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro", "Erro ao realizar a Inclusão!");
		}
	}

	public void excluirEstado(ActionEvent event) {
		try {
			estadoDao.remove(estado.getId());
			estadoDao.listar();
			JSFUtil.adicionarMensagemSucesso("Sucesso", "Exclusão Realizada com Sucesso!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro", "Erro ao realizar a Exclusão!");
		}
	}

	public void prepararNovo() {
		estado = new Estado();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public void limparTela() {
		estado = new Estado();
	}

}