package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="Material")
public class MaterialConc extends Material{
	
	@Column
	String tipo;
	
	public MaterialConc () {}
	
	public MaterialConc (int id) {
		set_id(id);
	}
	
	public MaterialConc(int id, String nome) {
		set_id(id);
		set_nome(nome);
	}
	public float getValorDiaria() {
		return 20;
	}
}
