package br.edu.ifal.proo.modelos;

public class Transferencia {
	private int id;
	private int id_conta_origem;
	private int id_conta_destino;
	private float valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_conta_origem() {
		return id_conta_origem;
	}
	public void setId_conta_origem(int id_conta_origem) {
		this.id_conta_origem = id_conta_origem;
	}
	public int getId_conta_destino() {
		return id_conta_destino;
	}
	public void setId_conta_destino(int id_conta_destino) {
		this.id_conta_destino = id_conta_destino;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	

}
