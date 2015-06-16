package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.Conta;

public class TelaLer extends TelaAuxiliar {

	public TelaLer(String nome) {
		super(nome);
		configLabel();
        configBotaoOk();
	}
	
	private void configBotaoOk() {
		JButton botaoOk = new JButton("OK");
		botaoOk.setMnemonic(KeyEvent.VK_K);
		painelBotoes.add(botaoOk);
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String numero = campoNumero.getText();
		        Conta conta = 
		        		Principal.meuBanco.buscar(numero);
				campoNome.setText(conta.getNome());
				campoSaldo.setText(conta.getSaldo());
				campoCpf.setText(conta.getCpf());
			}
		});
	}
  
	private void configLabel(){
		JLabel label = new JLabel();
		label.setText("para buscar, digite o numero da conta" );
		label.setBounds(135,150,215,20);
		janela.add(label);
	}
}
