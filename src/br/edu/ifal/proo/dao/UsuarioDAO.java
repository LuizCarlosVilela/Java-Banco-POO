package br.edu.ifal.proo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UsuarioDAO {
	public void buscar(int id) {
		String sql = "select sum(saldo) from conta where idUsuario = ?";
		
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://192.168.29.125/banco", "usuario", "usuario");
			PreparedStatement prep =  conexao.prepareStatement(sql);
			

			
			prep.execute();
		
			prep.close();
			conexao.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

