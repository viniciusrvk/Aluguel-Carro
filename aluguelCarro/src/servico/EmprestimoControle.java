package servico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import dao.EmprestimoDAO;
import dao.UsuarioDAO;
import modelo.Emprestimo;
import modelo.EmprestimoConc;
import modelo.Material;
import modelo.Usuario;


// abstract
// This abstract class has the validation function using template method pattern
public class EmprestimoControle {
	
	private boolean pode_fazer_emprestimo(Usuario usuario) {
		if(usuario.get_tipo() == "Aluno") {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			return (usuarioDAO.buscar_matricula(usuario.get_matricula()).size() == 0);
		}
		return true;
	}
	
	
	public void cadastrar(String usuario_id, String material_id, int prazo, String segurado) {
		
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		
		UsuarioControle usuario_controle = UsuarioControle.getInstance();
		List<Usuario> lst_usuario = usuario_controle.buscar_matricula(usuario_id);
		Usuario usuario = lst_usuario.get(0);
		MaterialControle material_controle = MaterialControle.getInstance();
		Material material = material_controle.buscar_id(Integer.parseInt(material_id));
		Boolean estaSegurado = segurado == "SIM" ? true : false;

		AbsRegrasEmprestimo regras = new RegrasEmprestimo();
		if(regras.check_emprestimo(usuario, material, emprestimoDAO) == false) {
			System.out.println("Emprestimo nao pode ser realizado\n");
			return;
		}
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Date date = new Date();
		Emprestimo emprestimo = new EmprestimoConc(usuario, material, date, prazo, 1, estaSegurado);
	
		emprestimoDAO.cadastrar(emprestimo);
		System.out.println("email");
		// enviando um email comprovante
		new Email(usuario, material, "Aluguel").sendEmail();
	}
	
	
	public void remover(String matricula, String id_material) {
		MaterialControle material_controle = MaterialControle.getInstance();
		Material material = material_controle.buscar_id(Integer.parseInt(id_material));
		Usuario usuario;
		UsuarioControle usuario_controle = UsuarioControle.getInstance();
		List<Usuario> lst_usuario = usuario_controle.buscar_matricula(matricula);
		usuario = lst_usuario.get(0);
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.remover(usuario, material);
		
		new Email(usuario, material, "Devolução").sendEmail();
	}
	
}
