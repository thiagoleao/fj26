/**
 * 
 */
package br.com.caelum.notasfiscais.testes;

import javax.persistence.EntityManager;

import br.com.caelum.notasfiscais.dao.JPAUtil;

/**
 * @author ThiagoLećo
 *
 */
public class Teste {
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
	}
}
