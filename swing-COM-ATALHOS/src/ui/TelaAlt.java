package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.Conta;

public class TelaAlt extends TelaAuxiliar {

	public TelaAlt(String nome) {
		super(nome);
		configBotaoOk();
		configCampos();
	}
	

	private void configCampos() {
		List<Conta> contas = Principal.meuBanco.listarContas();
		int j=Principal.telaPrincipal.tabela.getSelectedRow();
		campoNome.setText(contas.get(j).getNome());
		campoSaldo.setText(contas.get(j).getSaldo());
		campoCpf.setText(null);
		campoNumero.setText( contas.get(j).getNumero());
		
	}
	
	private void configBotaoOk() {
		JButton botaoOk = new JButton("guardar");
		botaoOk.setMnemonic(KeyEvent.VK_G);
		painelBotoes.add(botaoOk);
		botaoOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<Conta> contas = Principal.meuBanco.listarContas();
				String nome = campoNome.getText();
				String cpf = campoCpf.getText();
				String numero = campoNumero.getText();
				String saldo = campoSaldo.getText();
				Conta conta = new Conta(numero,saldo,nome,cpf);
				int j=Principal.telaPrincipal.tabela.getSelectedRow();
				Principal.meuBanco.alterar(conta,contas.get(j));
				
			
			}
		});
	}

}
