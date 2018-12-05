package modelo;

import javax.persistence.Entity;

@Entity(name="Usuario")
public class UsuarioConc extends Usuario{
	public UsuarioConc () {
		
	}
	
	// Construtor
	public UsuarioConc(String matricula, String cpf, String nome, String email) {
		super();
		set_matricula(matricula);
		set_cpf(cpf);
		set_nome(nome);
		set_email(email);
		
	}

}
