package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String matricula;
	@Column
	private String cpf;
	@Column
	private String nome;
	@Column
	private String email;	
	@Column
	private String tipo;
	
	
	
	public Usuario () {
		
	}
	
	// Construtor
	public Usuario(String matricula, String cpf, String nome, String email) {
		super();
		
		this.matricula = matricula;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		
	}


	public String get_cpf() {
		return cpf;
	}
	public void set_cpf(String cpf) {
		this.cpf = cpf;
	}
	public int get_id() {
		return id;
	}
	public String get_nome() {
		return nome;
	}
	public void set_nome(String nome) {
		this.nome = nome;
	}
	public String get_email() {
		return email;
	}
	public void set_email(String email) {
		this.email = email;
	}
	public String get_matricula() {
		return matricula;
	}
	public void set_matricula(String matricula) {
		this.matricula = matricula;
	}
	public String get_tipo() {
		return tipo;
	}
	public void set_tipo(String tipo) {
		this.tipo = tipo;
	}
	
}