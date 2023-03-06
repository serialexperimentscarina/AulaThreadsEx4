package controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.Tela;

public class ThreadCorrida extends Thread{
	
	private JButton btnCorrer;
	private JLabel carroA;
	private JLabel carroB;
	private JTextField textFieldVenc;
	private JTextField textFieldPerd;
	
	public ThreadCorrida(JButton btnCorrer, JLabel carroA, JLabel carroB, JTextField textFieldVenc, JTextField textFieldPerd) {
		this.btnCorrer = btnCorrer;
		this.carroA = carroA;
		this.carroB = carroB;
		this.textFieldVenc = textFieldVenc;
		this.textFieldPerd = textFieldPerd;
	}
	
	@Override
	public void run() {
		comecaCorrida();
		Thread sonic = new ThreadCarro(carroA);
		Thread tails = new ThreadCarro(carroB);
		sonic.start();
		tails.start();
		
		while (sonic.isAlive() && tails.isAlive()) {
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (sonic.isAlive()) {
			sonic.interrupt();
			terminaCorrida("Tails", "Sonic");
		} else {
			tails.interrupt();
			terminaCorrida("Sonic", "Tails");
		}
	}

	
	private void comecaCorrida() {
		btnCorrer.setEnabled(false);
		textFieldVenc.setText("");
		textFieldPerd.setText("");
		carroA.setIcon(new ImageIcon(Tela.class.getResource("/view/sonic-corre.gif")));
		carroB.setIcon(new ImageIcon(Tela.class.getResource("/view/tails-corre.gif")));
	}

	private void terminaCorrida(String vencedor, String perdedor) {
		carroA.setIcon(new ImageIcon(Tela.class.getResource("/view/sonic-parado.png")));
		carroB.setIcon(new ImageIcon(Tela.class.getResource("/view/tails-parado.png")));
		textFieldVenc.setText(vencedor);
		textFieldPerd.setText(perdedor);
		btnCorrer.setEnabled(true);
	}

}
