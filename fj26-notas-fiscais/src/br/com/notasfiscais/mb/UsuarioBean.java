/**
 * 
 */
package br.com.notasfiscais.mb;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.utils.CriptografiaUtil;

/**
 * @author jsf3313
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	public void grava() throws NoSuchAlgorithmException{
		
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		CriptografiaUtil criptografiaUtil = new CriptografiaUtil();
		this.usuario.setSenha(criptografiaUtil.criptografa(this.usuario.getSenha()));
		if(this.usuario.getId() == null){
			dao.adiciona(usuario);
		}else{
			dao.atualiza(usuario);
		}
		this.usuario = new Usuario();
		this.usuarios = dao.listaTodos();
	}
	
	public void remove(Usuario usuario){
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		dao.remove(usuario);
		this.usuarios = dao.listaTodos();
	}


	public List<Usuario> getUsuarios() {
			if(this.usuarios == null){
				System.out.println("Carregando usuarios...");
				this.usuarios = new DAO<Usuario>(Usuario.class).listaTodos();
			}
			return usuarios;
	}
	public void limpaFormulario(){
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}





	
	

}
