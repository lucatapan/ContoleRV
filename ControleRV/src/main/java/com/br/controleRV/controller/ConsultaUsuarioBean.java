package com.br.controleRV.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.controleRV.model.Usuario;
import com.br.controleRV.repository.Usuarios;
import com.br.controleRV.services.CadastroUsuario;

@Named
@ViewScoped
public class ConsultaUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuariosRepository;

	@Inject
	private CadastroUsuario cadastro;

	private Usuario usuarioSelecionado;

	public void excluir() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			this.cadastro.excluir(this.usuarioSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage("Usuário excluido com sucesso!"));

		} catch (Exception e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);

		}
	}

	private List<Usuario> usuarios;

	public void consultar() {

		this.usuarios = usuariosRepository.todos();

	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getUsuario() {
		return usuarios;
	}

}
