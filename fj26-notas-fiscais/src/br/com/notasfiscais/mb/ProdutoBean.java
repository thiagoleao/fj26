/**
 * 
 */
package br.com.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

/**
 * @author jsf3313
 *
 */
@ManagedBean
@ViewScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public void grava(){
		System.out.println("Será?");
		DAO<Produto> dao = new DAO<>(Produto.class);
		if(this.produto.getId() == null){
			dao.adiciona(produto);
		}else{
			dao.atualiza(produto);
		}
		this.produto = new Produto();
		this.produtos = dao.listaTodos();
	}
	
	public void remove(Produto produto){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}


	public List<Produto> getProdutos() {
			if(this.produtos == null){
				System.out.println("Carregando produtos...");
				this.produtos = new DAO<Produto>(Produto.class).listaTodos();
			}
			return produtos;
	}
	public void limpaFormulario(){
		this.produto = new Produto();
	}




	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}
