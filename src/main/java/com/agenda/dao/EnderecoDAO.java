package com.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agenda.model.Endereco;
import com.agenda.util.ConnectionFactory;
import com.mysql.jdbc.Connection;

public class EnderecoDAO {

	private Connection connection;

	public void cadastrar(Endereco endereco) {

		String SQL = "insert into pessoas (email, telefone) values (?,?)";

		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getLougra());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Endereco> buscarContatos() {

		String SQL = "select * from enderecos";

		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			List<Endereco> endereco = new ArrayList<Endereco>();

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Endereco endereco1 = new Endereco();
				endereco1.setIdEndereco(rs.getLong("id"));
				endereco1.setCep(rs.getString("cep"));
			
			}

			stmt.close();
			this.connection.close();
			return endereco;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remover(Endereco endereco) {

		String SQL = "delete from pessoas where id=?";

		try {
			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.setLong(1, endereco.getIdEndereco());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Endereco endereco) {
		
	    String SQL = "update pessoas set email=?, telefone=? where id=?";
	    
	    try {
	    	
	    	this.connection = new ConnectionFactory().getConnection();
	        PreparedStatement stmt = this.connection.prepareStatement(SQL);
	        
	        stmt.setString(1, endereco.getCep());
	        
	        stmt.setLong(5, endereco.getIdEndereco());
	        stmt.execute();
	        stmt.close();
	        
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

}