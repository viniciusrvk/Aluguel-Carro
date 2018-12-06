package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="Material")
public class MaterialConc extends Material{
	
	@Column
	String tipo;   // Hatch, Sedan, 4x4, Van ...
	@Column
	String montadora; // FIAT, VOLKSWAGEM, CHEVROLET, ...
	@Column
	String modelo;
	
	public MaterialConc () {}
	
	public MaterialConc (int id) {
		set_id(id);
	}
	
	public MaterialConc(int id, String nome) {
		set_id(id);
		set_nome(nome);
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getValorDiaria() {
		// Verifica qual o tipo do carro e aplica a diária de acordo com o tipo.
		return 20;
	}
	
}
