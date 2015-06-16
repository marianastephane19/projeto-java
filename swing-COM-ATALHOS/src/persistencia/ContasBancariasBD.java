package persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Conta;

public class ContasBancariasBD implements IContasBancarias {
     

	public void adicionar(Conta conta) throws SQLException {
	try{	
	    Connection con = Conexao.conexao();
	    String sql = "insert into contas(numero,saldo,nome,cpf)" +
	      "values(?,?,?,?)";
	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setString(1,conta.getNumero());
	    stmt.setString(2,conta.getSaldo());
	    stmt.setString(3,conta.getNome());
	    stmt.setString(4,conta.getCpf());
	    stmt.execute();
	    
	    JOptionPane.showMessageDialog(null,"conta cadastrada com sucesso");
	    stmt.close();
	    con.close();
	   }
	
	catch(SQLException e){
		JOptionPane.showMessageDialog(null,e.getMessage());
	}

	}

	@Override
	public List<Conta> listar() {
		List<Conta> contas = new ArrayList<Conta>(); 
		try{	
		    Connection con = Conexao.conexao();
		    PreparedStatement stmt = con.prepareStatement("select * from contas");
		    ResultSet rs = stmt.executeQuery();
		    while(rs.next()){
		    	Conta conta = new Conta(rs.getString("numero"),
		    	rs.getString("saldo"),rs.getString("nome"),rs.getString("cpf"),
		    	rs.getInt("CodC"));
		    	
		    	contas.add(conta);
		    }
		    stmt.close();
		    con.close();
		    return contas;
		  
		   }
		
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
			return null;
		}
	}
	
	public void excluir(Conta conta){
		try{	
		    Connection con = Conexao.conexao();
		    PreparedStatement stmt = con.prepareStatement("delete from contas where CodC=?");
		    stmt.setInt(1,conta.getCodC());
		    stmt.execute();
		    stmt.close();
		    con.close();
		    JOptionPane.showMessageDialog(null, "cadastro excluido com sucesso");
		   }
		
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public void alterar(Conta conta, Conta conta2){
		String sql ="update contas set nome=?," +
				 "numero=?,saldo=? where CodC=?";
		try{	
		    Connection con = Conexao.conexao();
		    PreparedStatement stmt = con.prepareStatement(sql);
		    stmt.setString(1,conta.getNome());
		    stmt.setString(2,conta.getNumero());
		    stmt.setString(3,conta.getSaldo());
		    stmt.setInt(4,conta2.getCodC());
		    stmt.execute();
		    stmt.close();
		    con.close();
		    JOptionPane.showMessageDialog(null, "cadastro alterado com sucesso");
		   }
		
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
	}
	
	public Conta buscar(String numero){ 
		Conta conta=null;
	try{	
	    Connection con = Conexao.conexao();
	    PreparedStatement stmt = con.prepareStatement("select * from contas " +
	    		"where numero = ?");
	    stmt.setString(1,numero);
	    ResultSet rs = stmt.executeQuery();
	    while(rs.next()){
	        conta = new Conta(rs.getString("numero"),
	    	rs.getString("saldo"),rs.getString("nome"),
	    	rs.getString("cpf"),rs.getInt("CodC"));
	    }
	    stmt.close();
	    con.close();
	    return conta;
	  
	   }
	
	catch(SQLException e){
		JOptionPane.showMessageDialog(null,e.getMessage());
		return null;
	}
  }
	
	public void gerarRelatorio(Conta conta) throws IOException{
		try{
		  FileWriter filer = new FileWriter("C:\\Users\\david\\" +
				"Documents\\relatorios\\"+conta.getNome()+".txt");;
		  PrintWriter printer= new PrintWriter(filer);
		  printer.printf("-----------RELATORIO DE CONTA BANCARIA---------%n");
		  printer.printf("%n");
		  printer.printf("  NOME: %s %n",conta.getNome());
		  printer.printf("  CPF: %s %n",conta.getCpf());
		  printer.printf("  NUMERO DA CONTA: %s %n",conta.getNumero());
		  printer.printf("  SALDO: %s %n",conta.getSaldo());
		  printer.printf("-----------------------------------------------");
		  filer.close();
		  JOptionPane.showMessageDialog(null,"relatorio gerado com sucesso");
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
}
