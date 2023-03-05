package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ThreadCorrida;

import javax.swing.JSeparator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Tela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldVenc;
	private JTextField textFieldPerd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 130, 800, 2);
		contentPane.add(separator);
		
		JLabel carroA = new JLabel("CARRO A");
		carroA.setBounds(50, 60, 70, 15);
		contentPane.add(carroA);
		
		JLabel carroB = new JLabel("CARRO B");
		carroB.setBounds(50, 210, 70, 15);
		contentPane.add(carroB);
		
		JLabel lblVencedor = new JLabel("Vencedor:");
		lblVencedor.setBounds(660, 290, 70, 15);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor:");
		lblPerdedor.setBounds(660, 350, 70, 15);
		contentPane.add(lblPerdedor);
		
		textFieldVenc = new JTextField();
		textFieldVenc.setEnabled(false);
		textFieldVenc.setEditable(false);
		textFieldVenc.setBounds(765, 285, 90, 20);
		contentPane.add(textFieldVenc);
		textFieldVenc.setColumns(10);
		
		textFieldPerd = new JTextField();
		textFieldPerd.setEnabled(false);
		textFieldPerd.setEditable(false);
		textFieldPerd.setColumns(10);
		textFieldPerd.setBounds(765, 345, 90, 20);
		contentPane.add(textFieldPerd);
		
		JButton btnCorrer = new JButton("Correr!");
		btnCorrer.setBounds(50, 320, 90, 25);
		btnCorrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread threadCorrida = new ThreadCorrida(btnCorrer, carroA, carroB, textFieldVenc, textFieldPerd);
				threadCorrida.start();
			}
		});
		contentPane.add(btnCorrer);
	}
}
