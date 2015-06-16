package modelo;

public class Conta {
	private String nome;
	private String numero;
	private String saldo;
	private String cpf;
	private int codC;
	
	public Conta(String numero, String saldo, String nome,String cpf) {
		this.numero = numero;
		this.saldo = saldo;
		this.nome = nome;
		this.cpf = cpf;
	}
	public Conta(String numero, String saldo, String nome,String cpf,int codC) {
		this.numero = numero;
		this.saldo = saldo;
		this.nome = nome;
		this.codC=codC;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public int getCodC() {
		return codC;
	}

	public void setCodC(int codC) {
		this.codC = codC;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
