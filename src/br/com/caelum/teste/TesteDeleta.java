package br.com.caelum.teste;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteDeleta {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setId(Long.valueOf(2));
		
		dao.remove(contato);
		
	}

}
