package br.edu.ifal.proo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContaDAO {
	public void patrimonio(int id) {
		String sql = "select sum(saldo) from conta where idUsuario = ?";
		
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://192.168.29.125/banco", "usuario", "usuario");
			PreparedStatement prep =  conexao.prepareStatement(sql);
			prep.setInt(1, id);
			
			float valor = 0;
			ResultSet r = prep.executeQuery();
			while(r.next()) {
				System.out.println(r.getFloat("sum(saldo)"));
			}
			
			System.out.println("O Patrimônio dele é"+valor);
			
			r.close();
			prep.close();
			conexao.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}