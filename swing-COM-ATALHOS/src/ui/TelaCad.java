package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.Conta;


public class TelaCad extends TelaAuxiliar {
	
	public TelaCad(String nome){
	    super(nome);	
	    configBotaoOk();
	}
	


	private void configBotaoOk() {
		JButton botaoOk = new JButton("OK");
		botaoOk.setMnemonic(KeyEvent.VK_O);
		painelBotoes.add(botaoOk);
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome = campoNome.getText();
				String cpf = campoCpf.getText();
				String numero = campoNumero.getText();
				String saldo = campoSaldo.getText();
				Conta c = new Conta(numero,saldo,nome,cpf);
				try {
					Principal.meuBanco.cadastrarConta(c);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				campoNome.setText(null);
				campoCpf.setText(null);
				campoSaldo.setText(null);
				campoNumero.setText(null);
			}
		});
	}


}
