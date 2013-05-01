package br.com.caelum.teste.funcionario;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TesteAltera {
	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario func = new Funcionario();

		func.setNome("Diego Ronan");
		func.setUsuario("dronan123");
		func.setSenha("novasenha");
		func.setId(Long.valueOf(1));

		dao.altera(func);
	}

}
