package br.com.caelum.teste.funcionario;

import java.util.List;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestaLista {

	public static void main(String[] args) {

		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> func = dao.getFuncionarios();

		for (Funcionario fun : func) {
			System.out.println("nome:" + fun.getNome());
			System.out.println("usuario" + fun.getUsuario());
			System.out.println("senha" + fun.getSenha() + "\n");

		}
	}
}
