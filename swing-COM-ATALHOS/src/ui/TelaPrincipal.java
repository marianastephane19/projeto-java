package ui;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class TelaPrincipal{
	
	 JInternalFrame janela;
	 JTable tabela;

		public TelaPrincipal(String nome){
		 montaTela();	
	}
	
	private void montaTela(){
		configJanela();
		configTab();  
		configScroll();
		mostraJanela();
	}

	private void configTab() {
		ContasTableModel ctm = new ContasTableModel();
	    tabela = new JTable();
	    tabela.setModel(ctm);
		tabela.setBorder(new LineBorder(Color.black));
		tabela.setGridColor(Color.black);
		tabela.setShowGrid(true);
	}
	
	private void configScroll(){
		JScrollPane scroll = new JScrollPane(tabela);
		//scroll.setSize(300, 100);
		janela.add(scroll,BorderLayout.CENTER);
	}

	private void configJanela() {
		janela = new JInternalFrame();
	    janela.setResizable(false);
		janela.setClosable(false);
	}
	
/*	public void configImagem(){
		
		Icon imagem = new ImageIcon("C:\\Users\\david\\Pictures\\MAD.png");
		JLabel label = new JLabel(imagem);
		label.setSize(500,300);
		janela.add(label,BorderLayout.CENTER);
	}*/

	
	private void mostraJanela(){
		//janela.setSize(495,475);
		janela.setVisible(true);
	}

}
