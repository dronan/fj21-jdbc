package br.com.caelum.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class TestaConexao {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conex‹o Aberta!");
		connection.close();

	}

}
