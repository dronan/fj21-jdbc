package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

@SuppressWarnings("serial")
public class ContatoDAO extends DAOException {

	private Connection connection;

	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {

		String sql = "insert into contatos"
				+ " (nome, endereco, email, dataNascimento)"
				+ " values (?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEndereco());
			stmt.setString(3, contato.getEmail());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public List<Contato> getLista() {
		String sql = "select * from contatos where email like 'bla%'";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			List<Contato> contatos = new ArrayList<Contato>();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}

			rs.close();
			stmt.close();
			connection.close();

			return contatos;
		} catch (SQLException e) {
			throw new DAOException(e);// RuntimeException(e);
		}

	}

	public List<Contato> pesquisar(int id){
		String sql = "Select * from contatos where id="+id;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Contato> contatos = new ArrayList<Contato>();
			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			connection.close();
			
			return contatos;
			
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	public void altera(Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Alterado!");
			
		} catch (Exception e) {
			throw new DAOException();
		}
	}
	
	public void remove(Contato contato){
		String sql = "delete from contatos where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			
			System.out.println("Excluido");
			
		} catch (Exception e) {
			throw new DAOException();
		}
	}
	
}
