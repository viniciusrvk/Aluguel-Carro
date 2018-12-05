package dao;

import modelo.Usuario;
import modelo.Material;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Emprestimo;
/*import objeto.modelo.Material;
import objeto.modelo.Usuario;
Isso é um teste
*/
public class EmprestimoDAO {

	EntityManagerFactory emf;
	EntityManager em;
	
	public EmprestimoDAO () {
		emf = Persistence.createEntityManagerFactory("banco");
		em = emf.createEntityManager();
	}
	
	public void cadastrar(Emprestimo emprestimo) {
		em.getTransaction().begin();
		em.merge(emprestimo);
		em.getTransaction().commit();
		emf.close();
	}
	
	public int get_por_id_usuario(int id) {
		em.getTransaction().begin();
		Query q =  em.createQuery("select emprestimo from Emprestimo emprestimo where usuario = " + id + "AND status = 1");
		List<Emprestimo> l = q.getResultList();
		em.getTransaction().commit();
		emf.close();
		return l.size();
	}
	
	public int get_emprestado_material(int id) {
		em.getTransaction().begin();
		Query q =  em.createQuery("select emprestimo from Emprestimo emprestimo where material = " + id + "AND status = 1");
		List<Emprestimo> l = q.getResultList();
		em.getTransaction().commit();
		emf.close();
		int ans = 0;
		for (int i = 0; i < l.size(); i++) {
			ans += l.get(i).get_status();
		}
		return ans; 
	}
	
	public List<Emprestimo> get_emprestimos() {
		em.getTransaction().begin();
		Query q =  em.createQuery("select emprestimo from Emprestimo emprestimo");
		List<Emprestimo> l = q.getResultList();
		em.getTransaction().commit();
		emf.close();
		return l;
	}
	
	public void remover(Usuario usuario, Material material) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery("UPDATE Emprestimo SET status = " + 0 + " WHERE usuario = " + usuario.get_id() + " AND material = " + material.get_id());
		//Query q = em.createNativeQuery("DELETE Emprestimo FROM Emprestimo WHERE usuario = " + usuario.get_matricula());
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
	}
}
