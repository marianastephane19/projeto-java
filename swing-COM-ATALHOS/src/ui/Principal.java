package ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Conta;
import modelo.ContaBancaria;
import persistencia.ContasBancariasBD;
import facade.Banco;


public class Principal  {
	static Banco meuBanco;
	private ContaBancaria minhaCB;
	private ContasBancariasBD minhaCBBD;
	private JFrame janela;
	private JPanel painelBotoes;
	private JPanel painelBotoesInferior;
    static TelaAuxiliar telaAux;
    static TelaPrincipal telaPrincipal;
	static JDesktopPane jdp;
	
	public Principal(){
		minhaCBBD = new ContasBancariasBD();
		minhaCB = new ContaBancaria(minhaCBBD);
		meuBanco = new Banco(minhaCB);
	}
	
	public static void main(String[] args){
		new Principal().montaTela();
	}

	public void montaTela() {
		configJanela();
		configJdp();
		configTelaPrincipal();
		configTelaAux();
		configPainelBotoes();
		configPainelBotoesInferior();
		configBotaoCad();	
		configBotaoDel();
		configBotaoLer();
		configBotaoAlt();
		configBotaoSob();
		configBotaoRel();
		configBotaoList();
		mostraJanela();
	}

	private void configBotaoSob() {
		JButton botaoSob = new JButton("SOBRE");
		botaoSob.setMnemonic(KeyEvent.VK_S);
		painelBotoes.add(botaoSob);
		botaoSob.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				telaAux = new TelaAuxiliar("sobre");
				telaAux.janela.removeAll();
				telaAux.configJanela("sobre");
				telaAux.configPainelBotoes();
				telaAux.configBotaoSair();
				JLabel label = new JLabel("<html>"+"*       MAD SYSTEM: desenvolvido por " +
						"David, Mariana e Ailton é uma marca registrada"+"<br/>"+
				"*    com todos os direitos reservados. O uso desta cópia destina-se apenas" +
				" a fins"+"<br/>"+"*   academicos. Qualquer outra forma de uso é vedada e está" +
						" sujeita a medidas"+"<br/>"+"*  penais do K...");
				telaAux.janela.add(label);
				label.setBounds(0, 0, 500, 60);	
				jdp.add(telaAux.janela);
				telaPrincipal.janela.setVisible(false);
				telaAux.janela.setVisible(true);
			}
		});
	
	}

	private void configBotaoAlt() {
		JButton botaoAlt = new JButton("ALTERAR");
		painelBotoes.add(botaoAlt);
		botaoAlt.setMnemonic(KeyEvent.VK_A);
		botaoAlt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int j=telaPrincipal.tabela.getSelectedRow();
				if(j!= -1){
					telaAux = new TelaAlt("alterar");
					jdp.add(telaAux.janela);
					telaPrincipal.janela.setVisible(false);
					telaAux.janela.setVisible(true);
				}
		  }       
		});
		
	}

	private void configBotaoLer() {
		JButton botaoLer = new JButton("BUSCAR");
		botaoLer.setMnemonic(KeyEvent.VK_B);
		painelBotoes.add(botaoLer);
		botaoLer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(telaAux == null){
					telaAux = new TelaLer("buscar");
					jdp.add(telaAux.janela);
					telaPrincipal.janela.setVisible(false);
					telaAux.janela.setVisible(true);
				}
		  }      
		});
		
	}

	private void configBotaoDel() {
		JButton botaoDel = new JButton("EXCLUIR");
		botaoDel.setMnemonic(KeyEvent.VK_E);
		painelBotoes.add(botaoDel);
		botaoDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int j=telaPrincipal.tabela.getSelectedRow();
				if(j!= -1){
					List<Conta> contas = meuBanco.listarContas();
					meuBanco.excluirConta(contas.get(j));
					telaPrincipal.tabela.repaint();				
				}
		  }      
		});
		
	}

	private void configBotaoCad() {
		JButton botaoCad = new JButton("CADASTRAR");
		botaoCad.setMnemonic(KeyEvent.VK_C);
		painelBotoes.add(botaoCad);
		botaoCad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
	    
				if(telaAux == null){
					telaAux = new TelaCad("cadastrar");
					jdp.add(telaAux.janela);
					telaPrincipal.janela.setVisible(false);
					telaAux.janela.setVisible(true);
				}
			}
		});
		
	}
	
	private void configBotaoRel(){
		JButton botaoRel = new JButton("RELATORIO");
		botaoRel.setMnemonic(KeyEvent.VK_R);
		painelBotoesInferior.add(botaoRel);
		botaoRel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int j=telaPrincipal.tabela.getSelectedRow();
				if(j!= -1){	
					List<Conta> contas = meuBanco.listarContas();
	               try {
					meuBanco.gerarRelatorio(contas.get(j));
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
			}
		});
	}
	
	private void configBotaoList(){
		JButton botaoList = new JButton("LISTAR");
		botaoList.setMnemonic(KeyEvent.VK_L);
		painelBotoesInferior.add(botaoList);
		botaoList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
	    
			List<Conta> contas = meuBanco.listarContas();
			ContasTableModel ctm = new ContasTableModel(contas);
			telaPrincipal.tabela.setModel(ctm);
			telaPrincipal.tabela.repaint();
			}
		});
	}

	private void configPainelBotoes() {
		painelBotoes = new JPanel();
		telaPrincipal.janela.add(painelBotoes,BorderLayout.NORTH);	
	}
	
	private void configPainelBotoesInferior(){
		painelBotoesInferior = new JPanel();
		painelBotoesInferior.setSize(100, 70);
		telaPrincipal.janela.add(painelBotoesInferior,BorderLayout.SOUTH);	
	}
	
	private void configJanela(){
		janela = new JFrame("MAD SYSTEM");
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private void configJdp() {
		jdp = new JDesktopPane();
		jdp.setLayout(new BorderLayout());
		janela.add(jdp);
		
	}
	
	private void configTelaAux(){
	  telaAux = null;
	}
	
	private void configTelaPrincipal() {
		telaPrincipal = new TelaPrincipal("tabela");		
		jdp.add(telaPrincipal.janela);
	}
	

	private void mostraJanela(){
		janela.setSize(500,300);
		janela.setVisible(true);
	}

}
