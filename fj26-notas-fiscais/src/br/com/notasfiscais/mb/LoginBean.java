/**
 * 
 */
package br.com.notasfiscais.mb;

import java.security.NoSuchAlgorithmException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

/**
 * @author jsf3313
 *
 */
@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuario = new Usuario();

	public String efetuarLogin() throws NoSuchAlgorithmException{
		UsuarioDAO dao = new UsuarioDAO();
		if(dao.existe(usuario)){
			return "index?faces-redirect=true";
		}
		return "login";
		
	}
	public boolean isLogado(){
		return usuario.getLogin() != null;
	}
	public String logout(){
		this.usuario = new Usuario();
		return "/login?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
