package controle;

import java.util.ArrayList;

public class TiposUsuarios implements ITiposUsuario{

	@Override
	public ArrayList<String> getTipos() {
		ArrayList<String> ans = new ArrayList<String>();
		ans.add("Cliente");
		return ans;
	}
	
}
