package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="Usuario")
public class UsuarioConc extends Usuario{
	
	@Column
	private String numCNH;
	
	
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

	public String getNumCNH() {
		return numCNH;
	}

	public void setNumCNH(String numCNH) {
		this.numCNH = numCNH;
	}

}
