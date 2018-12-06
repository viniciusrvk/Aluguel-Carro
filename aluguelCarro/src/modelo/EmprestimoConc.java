package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity(name="Emprestimo")  
public class EmprestimoConc extends Emprestimo{
	
	@Column
	private boolean estaSegurado;
	
	
	public EmprestimoConc () {}
	public EmprestimoConc (Usuario usuario, Material material, Date inicio, int prazo, 
			int status, boolean estaSegurado) 
	{
		this.usuario = usuario;
		this.material = material;
		this.inicio = inicio;
		this.prazo = prazo;
		this.status = status;
		this.estaSegurado = estaSegurado;
	}
}
