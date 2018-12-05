package servico;

import java.util.List;

import dao.UsuarioDAO;
import modelo.Usuario;

/*
 *  Essa Classe é responsável por todo o Controle sob as operações de Usuário
 */

public final class UsuarioControle {
	/*
	 * Singlenton Pattern
	 */
	private static UsuarioControle instance;
	public static UsuarioControle getInstance() {
		if(instance == null) {
			instance = new UsuarioControle();
		}
		return instance;
	}
	private UsuarioControle () {}

	/*
	 * Cadastra um usuario.
	 * Método completo com lançamento de exceção.
	 */
	public void cadastrar(Usuario usuario) throws Exception {
		AbsRegrasUsuarioControle regras = new RegrasUsuarioControle();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		regras.validateUsuario(usuario, usuarioDAO);
		usuarioDAO.cadastrar(usuario);
	}
	
	public List<Usuario> buscar_matricula(String matricula) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscar_matricula(matricula);
	}
	
	public List<Usuario> buscar_CPF(String CPF) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscar_CPF(CPF);
	}
	
	public List<Usuario> buscar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.buscar();
	}
	
	public void remover_matricula(String matricula) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.remover_matricula(matricula);
	}
}
