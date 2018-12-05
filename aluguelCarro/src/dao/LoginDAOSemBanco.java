package dao;

import java.util.HashMap;
import java.util.Map;

public class LoginDAOSemBanco implements LoginDAO
{
	
	Map <String, String> banco = new HashMap();
	boolean jaPopulou = false; 
	
	private void Popular ()
	{
		if (jaPopulou)
			return;
		jaPopulou = true;
		banco.put("admin", "admin");
	}
	
	@Override
	public boolean temUsuario (String usuario) 
	{
		Popular ();
		return banco.containsKey (usuario);
	}

	@Override
	public String getSenha (String usuario) 
	{
		return banco.get (usuario);
	}
}
