package facade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import modelo.Conta;
import modelo.ContaBancaria;

/**
 * Classe Facade para Contas Bancárias.
 * @author jefferson
 * @date 
 */
public class Banco {
	
	private ContaBancaria contaBancaria;
	
	public Banco(ContaBancaria bancaria) {
		this.contaBancaria = bancaria;
	}
	
	public void cadastrarConta(Conta conta) throws SQLException {
		contaBancaria.cadastrarConta(conta);
	}
	
	public void excluirConta(Conta conta){
		contaBancaria.excluirConta(conta);
	}
	
	public List<Conta> listarContas() {
		return contaBancaria.listarConta();
	}
	
	public void alterar(Conta conta,Conta conta2){
		contaBancaria.alterar(conta,conta2);
	}

	public Conta buscar(String numero) {
		return contaBancaria.buscar(numero);
	}
	
	public void gerarRelatorio(Conta conta) throws IOException{
		contaBancaria.gerarRelatorio(conta);
	}
}
