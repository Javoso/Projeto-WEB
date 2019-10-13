package br.com.projetoWEB.controller;

import java.io.Serializable;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.FileUploadEvent;

import br.com.projetoWEB.dao.GenericDAO;
import br.com.projetoWEB.model.Permissao;
import br.com.projetoWEB.model.Usuario;
import br.com.projetoWEB.model.enumerated.Status;
import br.com.projetoWEB.util.jsf.FacesUtil;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -2437633336322408321L;
	private static final String DATA_BASE64 = "data:image/png;base64,";

	private String base64;
	private Long idUsuario;
	private Usuario usuario;

	@Inject
	private GenericDAO<Usuario> daoUsuario;

	@Inject
	private GenericDAO<Permissao> daoPermissao;

	public UsuarioController() {
	}

	@PostConstruct
	public void iniciar() {
		this.usuario = new Usuario();
	}

	public void prepararParaEditar() {
		if (idUsuario != null) {
			usuario = daoUsuario.findById(Usuario.class, idUsuario);
		}
	}

	public List<Usuario> usuariosPorNome(String nome) {
		return daoUsuario.findByAtributeList(Usuario.class, nome, "nome");
	}

	public void cadastrar() {
		if (StringUtils.isNotBlank(this.usuario.getNome()) && StringUtils.isNotBlank(base64)) {
			this.usuario.setImagem(base64);
			this.usuario.setStatus(Status.ATIVADO);
			daoUsuario.salvar(this.usuario);
			FacesUtil.addMensagem().info("Cadastrado com sucesso!").para("msg");
		} else {
			FacesUtil.addMensagem().error("", "", "Erro ao concluir cadastrado").para("msg");
		}
		this.usuario = new Usuario();
	}

	public List<Usuario> getUsuarios() {
		return daoUsuario.findByAtributeList(Usuario.class, "status", Status.ATIVADO);
	}

	public void excluir() {
		this.usuario.setStatus(Status.DESATIVADO);
		daoUsuario.editar(usuario);
		FacesUtil.addMensagem().warn("Excluído com sucesso!").para("msg");
		this.usuario = new Usuario();
	}

	public String editar() {
		if (StringUtils.isNotBlank(this.usuario.getNome())) {
			if (StringUtils.isNotBlank(base64)) {
				this.usuario.setImagem(base64);
			}
			FacesUtil.addMensagem().info("Editado com sucesso!").para("msg").mantendoMensagemAposRedirect();
			daoUsuario.editar(usuario);
			usuario = new Usuario();
		}
		return "/pages/exibir/atores?faces-redirect=true";
	}

	public void handleFileUpload(FileUploadEvent event) {
		this.base64 = getEncodedContent(event.getFile().getContents());
	}

	public String getEncodedContent(byte[] arquivo) {
		return DATA_BASE64.concat(Base64.getEncoder().encodeToString(arquivo));
	}

	public List<Permissao> getPermissoes() {
		return daoPermissao.findAll(Permissao.class);
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
