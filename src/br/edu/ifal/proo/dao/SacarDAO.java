package br.edu.ifal.proo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.ifal.proo.modelos.*;


public class SacarDAO {
	public void saque(Saque d) {
		String sql = "insert into saque values (?,?,?)";
		
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://192.168.29.125/banco", "usuario", "usuario");
			PreparedStatement prep =  conexao.prepareStatement(sql);
			
			prep.setInt(1,d.getId());
			prep.setInt(2, d.getId_conta());
			prep.setFloat(3, d.getValor());
			
			prep.execute();
		
			prep.close();
			conexao.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://192.168.29.125/banco", "usuario", "usuario");
			
			String esse = "select saldo from conta where id = ?";
			
			PreparedStatement p = conexao.prepareStatement(esse);
			p.setInt(1, d.getId_conta());
			ResultSet r = p.executeQuery();
			
			
			float valor = 0;
			while(r.next()) {
				valor = r.getFloat("saldo");
			}
		
			String sql2 = "update conta set saldo = ? where id  = ?";
			PreparedStatement prep =  conexao.prepareStatement(sql2);
			
		
			Float valor2 = valor - d.getValor();
			
			prep.setFloat(1, valor2);
			prep.setInt(2, d.getId_conta());
			
			prep.execute();
			
			prep.close();
			conexao.close();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
