package com.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agenda.model.Contato;
import com.agenda.util.ConnectionFactory;
import com.mysql.jdbc.Connection;

public class ContatoDAO {

	private Connection connection;

	public void cadastrar(Contato contato) {

		String SQL = "insert into pessoas (email, telefone) values (?,?)";

		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			stmt.setString(1, contato.getEmail());
			stmt.setString(2, contato.getTel());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Contato> buscarContatos() {

		String SQL = "select * from contatos";

		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			List<Contato> contatos = new ArrayList<Contato>();

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setEmail(rs.getString("nome"));
			
			}

			stmt.close();
			this.connection.close();
			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remover(Contato contato) {

		String SQL = "delete from pessoas where id=?";

		try {
			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Contato contato) {
		
	    String SQL = "update contatos set email=?, telefone=? where id=?";
	    
	    try {
	    	
	    	this.connection = new ConnectionFactory().getConnection();
	        PreparedStatement stmt = this.connection.prepareStatement(SQL);
	        
	        stmt.setString(1, contato.getEmail());
	        
	        stmt.setLong(5, contato.getId());
	        stmt.execute();
	        stmt.close();
	        
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

}