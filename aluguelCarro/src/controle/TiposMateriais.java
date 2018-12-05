package controle;

import java.util.ArrayList;

public class TiposMateriais implements ITiposMaterial{
	@Override
	public ArrayList<String> getTipos() {
		ArrayList<String> ans = new ArrayList<String>();
		ans.add("Sedan");
		ans.add("Hatch");
		ans.add("4X4");
		ans.add("Van");
		return ans;
	}
}
