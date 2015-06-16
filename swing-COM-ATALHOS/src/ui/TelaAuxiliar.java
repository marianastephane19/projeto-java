package ui;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TelaAuxiliar {
	
	JInternalFrame janela;
	JPanel painelBotoes;
	JTextField campoNome;
	JTextField campoSaldo;
	JTextField campoCpf;
	JTextField campoNumero;
	
	public TelaAuxiliar(String nome){
	    montaTela(nome);	
	}
	
	private void montaTela(String nome){
		configJanela(nome);
		configcampoNome();
		configCampoCpf();
		configCampoSaldo();
		configCampoNumero();
		configPainelBotoes();	
		configBotaoSair();
   }

	public void configPainelBotoes() {
	   painelBotoes = new JPanel();
	   painelBotoes.setLayout(new GridLayout(1,2));
	   painelBotoes.setBounds(150,200,160,30);
	   janela.add(painelBotoes);	
	}

	private void configCampoCpf() {
		JLabel labelCpf = new JLabel("insira CPF");
		labelCpf.setBounds(10,80,200,20);
		janela.add(labelCpf);
		campoCpf = new JTextField();
		campoCpf.setBounds(10,105,200,20);
		janela.add(campoCpf);
		
	}

	private void configcampoNome() {
		JLabel labelNome = new JLabel("insira nome");
		labelNome.setBounds(10,30,200,20);
		janela.add(labelNome);
	    campoNome = new JTextField();
		campoNome.setBounds(10,55,200,20);
		janela.add(campoNome);
		
	}
	
	private void configCampoSaldo(){
		JLabel labelSaldo = new JLabel("insira saldo");
		labelSaldo.setBounds(270,30,200,20);
		janela.add(labelSaldo);
	    campoSaldo = new JTextField();
		campoSaldo.setBounds(270,55,200,20);
		janela.add(campoSaldo);
	}
	
	private void configCampoNumero(){
		JLabel labelNumero = new JLabel("insira numero");
		labelNumero.setBounds(270,80,200,20);
		janela.add(labelNumero);
		campoNumero = new JTextField();
		campoNumero.setBounds(270,105,200,20);
		janela.add(campoNumero);
	}

	public void configJanela(String nome) {
		janela = new JInternalFrame(nome);
		janela.setResizable(false);
		janela.setLayout(null);
		janela.setSize(485,440);
		janela.setClosable(false);	
		janela.setVisible(true);
	}
	
	public void configBotaoSair(){
		JButton botaoCancel = new JButton("voltar");
		botaoCancel.setMnemonic(KeyEvent.VK_V);
		painelBotoes.add(botaoCancel);
		botaoCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				campoNome.setText(null);
				campoCpf.setText(null);
				Principal.jdp.remove(janela);
				Principal.telaAux = null;
			    Principal.telaPrincipal.janela.setVisible(true);
			}
		});
	}

}
