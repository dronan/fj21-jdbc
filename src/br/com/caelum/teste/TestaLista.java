package br.com.caelum.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getLista();	
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Contato contato : contatos) {
			System.out.println("Nome: "+contato.getNome());
			System.out.println("Email: "+contato.getEmail());
			System.out.println("Endereço: "+contato.getEndereco());	
			System.out.println("Data nascimento: "+ formatador.format(contato.getDataNascimento().getTime()) +"\n");
		}
	}

}
