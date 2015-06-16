package ui;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import modelo.Conta;

public class ContasTableModel extends AbstractTableModel{
	
	List<Conta> contas;
	
	public ContasTableModel(){
		contas = null;
	}
	
	public ContasTableModel(List<Conta> contas){
		this.contas = contas;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		if(contas==null)
		return 0;
		else
			return contas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
	//	if(contas!=null){
		Conta c = contas.get(rowIndex);
		switch(colIndex){
		case 0 : return c.getNumero();
		case 1 : return c.getNome();
		case 2 : return c.getSaldo();
		}
		return null;
//	 }
//		return null;
	}
	
	  public String getColumnName(int column) {
		    switch (column) {
		   case 0:
		      return "número";
		    case 1:
		     return "nome";
		    case 2:
		      return "saldo";
		   }
		   return "";
		 }

}
