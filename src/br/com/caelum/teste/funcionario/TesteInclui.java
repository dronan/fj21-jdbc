package br.com.caelum.teste.funcionario;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TesteInclui {

	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario fun = new Funcionario();

		fun.setNome("Diego");
		fun.setUsuario("dronan");
		fun.setSenha("diego123");

		dao.adiciona(fun);

	}

}
