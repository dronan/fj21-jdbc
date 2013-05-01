package br.com.caelum.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {

		ContatoDAO dao = new ContatoDAO();
		Contato contato = new Contato();
		
		contato.setNome("Diego");
		Calendar data = Calendar.getInstance();
		contato.setDataNascimento(data);
		contato.setEmail("dronan@gmail.com");
		contato.setEndereco("Anel Viario");
		contato.setId(Long.valueOf(3));
		
		dao.altera(contato);
		
	}

}
