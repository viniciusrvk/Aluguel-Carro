package servico;

import dao.MaterialDAO;
import modelo.Material;

public final class MaterialControle {
	private static MaterialControle instance;
	public static MaterialControle getInstance() {
		if(instance == null) {
			instance = new MaterialControle();
		}
		return instance;
	}
	public void cadastrar(Material material) {
		MaterialDAO materialDAO = new MaterialDAO();
		if(materialDAO.buscar_id(material.get_id()).size() > 0) {
			System.out.println("Não é possível cadastrar com mesmo id");
			return;
		}
		materialDAO.cadastrar(material);
	}
	public Material buscar_id(int id) {
		MaterialDAO materialDAO = new MaterialDAO();
		//TODO THROWS
		return materialDAO.buscar_id(id).get(0);
	}
	public Material buscar_matricula(String matricula) {
		MaterialDAO materialDAO = new MaterialDAO();
		//TODO THROWS
		return materialDAO.buscar_matricula(matricula).get(0);
	}
}
