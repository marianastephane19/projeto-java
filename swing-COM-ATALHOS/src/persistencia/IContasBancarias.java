package persistencia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import modelo.Conta;

public interface IContasBancarias {
	
//	declarações do métodos de persistência.
	
	public void adicionar(Conta conta) throws SQLException;
	public void excluir(Conta conta);
	public List<Conta> listar();
	public void alterar(Conta conta, Conta conta2);
//	...
	public Conta buscar(String numero);
	public void gerarRelatorio(Conta conta) throws IOException;

}
