package br.edu.ifal.proo.dao;
import java.sql.*;
import br.edu.ifal.proo.modelos.*;


public class TransferenciaDAO {
	public void transferencia(Transferencia t) {
		String sql = "insert into transferencia values (?,?,?)";
		
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://192.168.29.125/banco", "usuario", "usuario");
			PreparedStatement prep =  conexao.prepareStatement(sql);
			
			prep.setInt(1,t.getId());
			
			prep.setInt(2, t.getId_conta_origem());
			prep.setInt(3, t.getId_conta_destino());
			prep.setFloat(4, t.getValor());
			
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
			p.setInt(1, t.getId_conta_origem());
			ResultSet r = p.executeQuery();
			
			
			float valor = 0;
			while(r.next()) {
				valor = r.getFloat("saldo");
			}
		
			String sql2 = "update conta set saldo = ? where id  = ?";
			PreparedStatement prep =  conexao.prepareStatement(sql2);
			
		
			Float valor2 = valor - t.getValor();
			
			prep.setFloat(1, valor2);
			prep.setInt(2, t.getId_conta_origem());
			
			prep.execute();
			
			prep.close();
			conexao.close();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://192.168.29.125/banco", "usuario", "usuario");
			PreparedStatement prep =  conexao.prepareStatement(sql);
			
			prep.setInt(1,t.getId());
			prep.setInt(2, t.getId_conta_destino());
			prep.setFloat(3, t.getValor());
			
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
			p.setInt(1, t.getId_conta_destino());
			
			ResultSet r = p.executeQuery();
			
			float valor = 0;
			while(r.next()) {
				valor = r.getFloat("saldo");
			}
			
		
			String sql2 = "update conta set saldo = ? where id  = ?";
			PreparedStatement prep =  conexao.prepareStatement(sql2);
			
		
			Float valor2 = t.getValor() + valor;
			
			prep.setFloat(1, valor2);
			prep.setInt(2, t.getId_conta_destino());
			
			prep.execute();
			
			prep.close();
			conexao.close();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void todas(int id1, int id2) {
		String sql = "select id_conta_origem, id_conta_destino, valor from transferencia";
		
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://192.168.29.125/banco", "usuario", "usuario");
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			
			ResultSet r = prep.executeQuery();
			
			
			
			while(r.next()) {
				
				String sql2 = "select * from conta where idBanco = ?, id = ?";
				PreparedStatement e = conexao.prepareStatement(sql2);
				e.setInt(1, id1);
				e.setInt(2, r.getInt("id_conta_origem"));
				ResultSet r1 = e.executeQuery();
				
				System.out.println("esse");
				
				String sql3 = "select * from conta where idBanco = ?, id = ?";
				PreparedStatement e2 = conexao.prepareStatement(sql3);
				
				e2.setInt(1, id2);
				e.setInt(2, r.getInt("id_conta_destino"));
				
				ResultSet r2 = e2.executeQuery();
				float valor = 0;
				
				if(r1.next()) {
					if(r2.next()) {
						valor = valor + r.getFloat("valor");
					}
				}
				System.out.println(valor);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	

}
