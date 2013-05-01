package br.com.caelum.teste.funcionario;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TesteExclui {
	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario fun = new Funcionario();
		fun.setId(Long.valueOf(1));
		dao.exclui(fun);

	}
}
