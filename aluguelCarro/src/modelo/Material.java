package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;



@MappedSuperclass
public abstract class Material {
	@Id
	@Column
	private int id; // numero de tombamento
	@Column
	String nome;
	@Column
	String serial; 
	@Column
	String descricao;
	
	public Material () {}
	public Material (int id) {
		this.id = id;
	}
	
	public Material(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public String get_nome() {
		return nome;
	}
	public int get_id() {
		return id;
	}
	public String get_serial() {
		return serial;
	}
	public String get_descricao() {
		return descricao;
	}
	public void set_id(int idd) {
		this.id = idd;
	}
	
	public void set_nome(String nome) {
		this.nome = nome;
	}
	
	public void set_serial(String serial) {
		this.serial = serial;
	}
	

	public void set_descricao(String descricao) {
		this.descricao = descricao;
	}
	
}
