package lixo;
/*
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import javax.persistence.Query;

public class AlunoDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public  AlunoDAO() {
		emf = Persistence.createEntityManagerFactory("banco");
		em = emf.createEntityManager();
	}
	public void cadastrar(Aluno a) {
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		emf.close();
	}
	public Aluno buscar(String matricula) {
		Aluno ret;
		em.getTransaction().begin();
		Query q =  em.createQuery("select aluno from Aluno aluno where matricula = " + matricula);
		List<Aluno> l = q.getResultList();
		System.out.println(l.size());
		if(l.size() == 0)
			return null;
		ret = l.get(0);
		em.getTransaction().commit();
		emf.close();
		
		return ret;
	}
	
	public boolean remover(String matricula) {
		Aluno al = buscar(matricula);
		if(al == null) 
			return false;
		em.getTransaction().begin();
		Query q = em.createNativeQuery("DELETE Aluno FROM Aluno WHERE matricula = " + al.getMatricula());
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
		return true;
	}
	
}
*/