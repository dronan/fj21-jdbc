package br.com.caelum.teste.funcionario;

import java.util.List;

import br.com.caelum.jdbc.dao.FuncionarioDAO;
import br.com.caelum.jdbc.modelo.Funcionario;

public class TestePesquisa {
	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> pesquisaFunc = dao.pesquisa("diego");

		for (Funcionario funcionario : pesquisaFunc) {
			System.out.println("Nome:" + funcionario.getNome());
			System.out.println("Usuario: " + funcionario.getUsuario());
			System.out.println("Senha: " + funcionario.getSenha() + "\n");
		}

	}
}
