package servico;

import java.io.IOException;

import dao.LoginDAO;
import dao.LoginDAOSemBanco;

import lixo.UsuarioNaoCadastradoClass;


public class LoginControle {
	
	public boolean PodeEntrar (String usuario, String senha) throws IOException {
		
		LoginDAO veri = new LoginDAOSemBanco();
		
		if (veri.temUsuario(usuario) && veri.getSenha(usuario).equals(senha)) {

			return true;
		}
		else {			
			new UsuarioNaoCadastradoClass().open();
			return false;
		}
	}
	
//	public boolean PodeEntrar (String usuario, String senha) throws IOException
//	{
//		LoginDAO veri = new LoginDAOSemBanco();
//		
//		if (veri.temUsuario(usuario) && veri.getSenha(usuario).equals(senha))
//		{
//			return true;
//		}
//		else 
//		{
//			return false;
//		}
//	}
	
}	
