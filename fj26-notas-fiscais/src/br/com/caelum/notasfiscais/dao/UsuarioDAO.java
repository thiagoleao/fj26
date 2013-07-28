package br.com.caelum.notasfiscais.dao;

import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.utils.CriptografiaUtil;

public class UsuarioDAO {

	public boolean existe(Usuario usuario) throws NoSuchAlgorithmException {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		CriptografiaUtil criptografiaUtil = new CriptografiaUtil();
		usuario.setSenha(criptografiaUtil.criptografa(usuario.getSenha()));
		Query query = em.createQuery("from Usuario where login = :login and senha = :senha")
						.setParameter("login", usuario.getLogin())
						.setParameter("senha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();
		em.getTransaction().commit();
		em.close();

		return encontrado;
	}
}