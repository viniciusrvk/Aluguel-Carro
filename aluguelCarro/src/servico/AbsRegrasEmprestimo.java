package servico;

import dao.EmprestimoDAO;
import modelo.Material;
import modelo.Usuario;
/* This is an implementation of template method */

public abstract class AbsRegrasEmprestimo {
	public abstract boolean regras_adicionais(Usuario usuario, Material material, EmprestimoDAO emprestimoDAO);
	public abstract void calc_param(Usuario usuario, Material material);
	public boolean check_emprestimo(Usuario usuario, Material material, EmprestimoDAO emprestimoDAO) {
		if(emprestimoDAO.get_emprestado_material(material.get_id()) > 0) {
			return false;
		}
		return regras_adicionais(usuario, material, emprestimoDAO); 
		
	}
}
