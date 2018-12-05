package servico;

import dao.UsuarioDAO;
import modelo.Usuario;

public abstract class AbsRegrasUsuarioControle {
	abstract void regras_adicionais(Usuario usuario, UsuarioDAO usuarioDAO);
	public void CamposVazios(Usuario usuario) throws Exception{
		if(usuario.get_cpf().isEmpty() || usuario.get_email().isEmpty() || usuario.get_matricula().isEmpty() || usuario.get_nome().isEmpty()) {
			throw new Exception("Todos os campos devem ser preenchidos");
		}
	}
	
	public void validateUsuario(Usuario usuario, UsuarioDAO usuarioDAO) throws Exception{
		CamposVazios(usuario);
		if(usuarioDAO.buscar_matricula(usuario.get_matricula()).size() > 0) {
			throw new Exception("Matricula Já cadastrada!");
		}
		regras_adicionais(usuario, usuarioDAO);
	}
}
