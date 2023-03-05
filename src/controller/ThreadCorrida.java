package controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		btnCorrer.setEnabled(false);
		textFieldVenc.setText("");
		textFieldPerd.setText("");
		Thread threadCarroA = new ThreadCarro(carroA);
		Thread threadCarroB = new ThreadCarro(carroB);
		threadCarroA.start();
		threadCarroB.start();
		
		while (threadCarroA.isAlive() && threadCarroB.isAlive()) {
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (threadCarroA.isAlive()) {
			threadCarroA.interrupt();
			textFieldVenc.setText("Carro B");
			textFieldPerd.setText("Carro A");
		} else {
			threadCarroB.interrupt();
			textFieldVenc.setText("Carro A");
			textFieldPerd.setText("Carro B");
		}
		btnCorrer.setEnabled(true);
	}

}
