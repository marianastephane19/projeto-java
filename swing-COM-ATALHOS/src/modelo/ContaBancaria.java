package modelo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import persistencia.IContasBancarias;

public class ContaBancaria {
	
	IContasBancarias persistencia;
	
	public ContaBancaria(IContasBancarias persitencia) {
		this.persistencia = persitencia;
	}
	
	public void cadastrarConta(Conta conta) throws SQLException {
		persistencia.adicionar(conta);
	}
	
	public void excluirConta(Conta conta){
		persistencia.excluir(conta);
	}
	
	public List<Conta> listarConta() {
		return persistencia.listar();
	}

	public void alterar(Conta conta,Conta conta2) {
		persistencia.alterar(conta,conta2);
		
	}

	public Conta buscar(String numero) {
       return persistencia.buscar(numero);
	}

	public void gerarRelatorio(Conta conta) throws IOException {
        persistencia.gerarRelatorio(conta);
	}
	
}
