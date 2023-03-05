package controller;

import java.awt.Rectangle;

import javax.swing.JLabel;

public class ThreadCarro extends Thread{
	
	private static final int VEL_MAX = 5;
	private static final int DIST_MAX = 7500;
	private JLabel carro;
	
	public ThreadCarro(JLabel carro) {
		this.carro = carro;
	}
	
	@Override
	public void run() {
		int distPercorrida = 0;
		int vel = 1;
		Rectangle posicao = carro.getBounds();
		
		try {
			while (distPercorrida < DIST_MAX) {
				for (int i = 1; i <= 100; i++) {
					distPercorrida = (distPercorrida + vel) < DIST_MAX ? distPercorrida + vel : DIST_MAX;
					posicao.x = 50 + (distPercorrida / 10);
					carro.setBounds(posicao);
					if (distPercorrida == DIST_MAX) {
						break;
					}
					sleep(1);
				}
				vel += (int) (Math.random() * (VEL_MAX + 1));
				
			}
		} catch (InterruptedException ex) {
			
		}
	}

}
