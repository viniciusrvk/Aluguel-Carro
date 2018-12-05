package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import javax.persistence.Query;

import modelo.Usuario;

public class UsuarioDAO {
	EntityManagerFactory emf;
	EntityManager em;
	
	public UsuarioDAO() {
		emf = Persistence.createEntityManagerFactory("banco");
		em = emf.createEntityManager();
	}
	
	public void cadastrar (Usuario usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		emf.close();
	}
	
	public List<Usuario> buscar_matricula(String matricula) {
		em.getTransaction().begin();
		Query q =  em.createQuery("select usuario from Usuario usuario where matricula = " + matricula);
		List<Usuario> l = q.getResultList();
		em.getTransaction().commit();
		emf.close();
		return l;
	}
	
	public List<Usuario> buscar_CPF(String CPF) {
		em.getTransaction().begin();
		Query q =  em.createQuery("select usuario from Usuario usuario where CPF = " + CPF);
		List<Usuario> l = q.getResultList();
		em.getTransaction().commit();
		emf.close();
		return l;
	}
	
	public List<Usuario> buscar() {
		em.getTransaction().begin();
		Query q =  em.createQuery("select usuario from Usuario usuario");
		List<Usuario> l = q.getResultList();
		em.getTransaction().commit();
		emf.close();
		return l;
	}
	
	public boolean remover_matricula(String matricula) {
		List <Usuario> lista = buscar_matricula(matricula);
		if(lista.isEmpty()) {
			return false;
		}
		em.getTransaction().begin();
		Query q = em.createNativeQuery("DELETE Usuario FROM Usuario WHERE matricula = " + matricula);
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
		return true;
	}
}