package br.edu.ifal.proo.tela;
import br.edu.ifal.proo.dao.ContaDAO;
import br.edu.ifal.proo.dao.DepositoDAO;
import br.edu.ifal.proo.dao.SacarDAO;
import br.edu.ifal.proo.dao.TransferenciaDAO;
import br.edu.ifal.proo.modelos.*;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int op = 0;
		
		while(op != 6) {
			System.out.println("1 - Deposita");
			System.out.println("2 - Sacar");
			System.out.println("3 - Transferência");
			System.out.println("4 - Recuperar Patrimônio de um usuário");
			System.out.println("5 - Recuperar o valume de transações realizadas entre os dois bancos");
			System.out.println("6 - Sair");
			
			System.out.print("Opção:");
			op = teclado.nextInt();
			teclado.nextLine();
			
			if(op == 1) {
				Deposito d  = new Deposito();
				
				System.out.print("ID do deposito:");
				d.setId(teclado.nextInt());
				teclado.nextLine();
				
				System.out.print("Id Da conta:");
				d.setId_conta(teclado.nextInt());
				teclado.nextLine();
				
				System.out.print("Valor Do Depósito");
				d.setValor(teclado.nextFloat());
				teclado.nextLine();
				
				DepositoDAO a = new DepositoDAO();
				a.depositar(d);
				
				System.out.println("Deposito Feito");
			}
			else if(op == 2) {
				Saque d  = new Saque();
				
				System.out.print("ID do Saque:");
				d.setId(teclado.nextInt());
				teclado.nextLine();
				
				System.out.print("Id Da Conta:");
				d.setId_conta(teclado.nextInt());
				teclado.nextLine();
				
				System.out.print("Valor Do Saque:");
				d.setValor(teclado.nextFloat());
				teclado.nextLine();
				
				SacarDAO a = new SacarDAO();
				a.saque(d);	
				System.out.println("Saque Feito");
			}
			
			else if(op == 3) {
				Transferencia t = new Transferencia();
				
				
				System.out.println("ID Da conta de Origem:");
				t.setId_conta_origem(teclado.nextInt());
				teclado.nextLine();
				
				System.out.println("ID Da conta de Destino:");
				t.setId_conta_destino(teclado.nextInt());
				teclado.nextLine();
				
				
				System.out.println("ID Da Transferência:");
				t.setId(teclado.nextInt());
				teclado.nextLine();
				
				System.out.println("Valor");
				t.setValor(teclado.nextFloat());
				teclado.nextLine();
				
				TransferenciaDAO e = new TransferenciaDAO();
				e.transferencia(t);
			}
			else if(op == 4) {
				
				System.out.println("ID Usuário:");
				int id = teclado.nextInt();
				ContaDAO c = new ContaDAO();
				c.patrimonio(id);
			}
			else if(op == 5) {
				System.out.println("ID Banco 1:");
				int id = teclado.nextInt();
				teclado.nextLine();
				
				System.out.println("ID Banco 2:");
				int id2 = teclado.nextInt();
				teclado.nextLine();
				
				TransferenciaDAO t = new TransferenciaDAO();
				t.todas(id, id2);
			}
		}
	}

}
