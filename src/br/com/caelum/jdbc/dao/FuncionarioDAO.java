package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDAO {

	private Connection connection;

	public FuncionarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario funcionario) {

		String sql = "insert into funcionarios (nome, usuario, senha) values (?,?,?)";
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());

			stmt.execute();

		} catch (Exception e) {
			throw new DAOException();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DAOException();
			}
		}

	}

	public List<Funcionario> getFuncionarios() {
		String sql = "select * from funcionarios";

		List<Funcionario> func = new ArrayList<Funcionario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario fun = new Funcionario();

				fun.setNome(rs.getString("nome"));
				fun.setUsuario(rs.getString("usuario"));
				fun.setSenha(rs.getString("senha"));

				func.add(fun);
			}
			return func;
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
				rs.close();
				stmt.close();
				connection.close();

			} catch (SQLException e) {
				throw new DAOException();
			}

		}

	}

	public List<Funcionario> pesquisa(String nome) {
		String sql = "Select * from funcionarios where nome like '%" + nome
				+ "%'";

		List<Funcionario> listaFun = new ArrayList<Funcionario>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Funcionario func = new Funcionario();
				func.setNome(rs.getString("nome"));
				func.setUsuario(rs.getString("usuario"));
				func.setSenha(rs.getString("senha"));

				listaFun.add(func);

			}

			return listaFun;

		} catch (Exception e) {
			throw new DAOException();
		} finally {
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (Exception e2) {
				throw new DAOException();
			}
		}

	}

	public void altera(Funcionario funcionario) {
		String sql = "update funcionarios set nome=?, usuario=?, senha=? where id=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			stmt.execute();
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (Exception e2) {
				throw new DAOException(e2);
			}

		}

	}

	public void exclui(Funcionario funcionario) {
		String sql = "delete from funcionarios where id = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, funcionario.getId());
			stmt.execute();
		} catch (Exception e) {
			throw new DAOException();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DAOException();
			}

		}
	}
}
