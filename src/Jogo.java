import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jogo {

	public JFrame fJogo;
	JogoModel jogo = new JogoModel();
	ArrayList<ArrayList<JButton>> botoes = new ArrayList<ArrayList<JButton>>();
	int modo = 0;//0 joga com cpu e 1 joga com player
	int vez = 0;//0 vez do jogador e 1 vez da cpu.
	
	
	public Jogo(int modo) {
		this.modo = modo;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fJogo = new JFrame();
		fJogo.setTitle("Jogo da Velha - Jogo");
		fJogo.setBounds(100, 100, 450, 300);
		fJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fJogo.getContentPane().setLayout(new GridLayout(3, 3, 0, 0));
		fJogo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JButton b00 = new JButton("");
		b00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = jogo.adiciona(0, 0);
				b00.setText(s);
				if (jogo.checaAcabou()) {
					JOptionPane.showMessageDialog(fJogo, jogo.getVitoria());
					fJogo.dispose();
				} else {
					cpuJoga();
				}
					
			}
		});
		b00.setFont(new Font("Tahoma", Font.PLAIN, 36));
		fJogo.getContentPane().add(b00);
		
		JButton b10 = new JButton("");
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = jogo.adiciona(1, 0);
				b10.setText(s);
				if (jogo.checaAcabou()) {
					JOptionPane.showMessageDialog(fJogo, jogo.getVitoria());
					fJogo.dispose();
				} else {
					cpuJoga();
				}
			}
		});
		b10.setFont(new Font("Tahoma", Font.PLAIN, 36));
		fJogo.getContentPane().add(b10);
		
		JButton b20 = new JButton("");
		b20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = jogo.adiciona(2, 0);
				b20.setText(s);
				if (jogo.checaAcabou()) {
					JOptionPane.showMessageDialog(fJogo, jogo.getVitoria());
					fJogo.dispose();
				} else {
					cpuJoga();
				}
			}
		});
		b20.setFont(new Font("Tahoma", Font.PLAIN, 36));
		fJogo.getContentPane().add(b20);
		
		JButton b01 = new JButton("");
		b01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = jogo.adiciona(0, 1);
				b01.setText(s);
				if (jogo.checaAcabou()) {
					JOptionPane.showMessageDialog(fJogo, jogo.getVitoria());
					fJogo.dispose();
				} else {
					cpuJoga();
				}
			}
		});
		b01.setFont(new Font("Tahoma", Font.PLAIN, 36));
		fJogo.getContentPane().add(b01);
		
		JButton b11 = new JButton("");
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = jogo.adiciona(1, 1);
				b11.setText(s);
				if (jogo.checaAcabou()) {
					JOptionPane.showMessageDialog(fJogo, jogo.getVitoria());
					fJogo.dispose();
				} else {
					cpuJoga();
				}
			}
		});
		b11.setFont(new Font("Tahoma", Font.PLAIN, 36));
		fJogo.getContentPane().add(b11);
		
		JButton b21 = new JButton("");
		b21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = jogo.adiciona(2, 1);
				b21.setText(s);
				if (jogo.checaAcabou()) {
					JOptionPane.showMessageDialog(fJogo, jogo.getVitoria());
					fJogo.dispose();
				} else {
					cpuJoga();
				}
			}
		});
		b21.setFont(new Font("Tahoma", Font.PLAIN, 36));
		fJogo.getContentPane().add(b21);
		
		JButton b02 = new JButton("");
		b02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = jogo.adiciona(0, 2);
				b02.setText(s);
				if (jogo.checaAcabou()) {
					JOptionPane.showMessageDialog(fJogo, jogo.getVitoria());
					fJogo.dispose();
				} else {
					cpuJoga();
				}
			}
		});
		b02.setFont(new Font("Tahoma", Font.PLAIN, 36));
		fJogo.getContentPane().add(b02);
		
		JButton b12 = new JButton("");
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = jogo.adiciona(1, 2);
				b12.setText(s);
				if (jogo.checaAcabou()) {
					JOptionPane.showMessageDialog(fJogo, jogo.getVitoria());
					fJogo.dispose();
				} else {
					cpuJoga();
				}
			}
		});
		b12.setFont(new Font("Tahoma", Font.PLAIN, 36));
		fJogo.getContentPane().add(b12);
		
		JButton b22 = new JButton("");
		b22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = jogo.adiciona(2, 2);
				b22.setText(s);
				if (jogo.checaAcabou()) {
					JOptionPane.showMessageDialog(fJogo, jogo.getVitoria());
					fJogo.dispose();
				} else {
					cpuJoga();
				}
			}
		});
		b22.setFont(new Font("Tahoma", Font.PLAIN, 36));
		fJogo.getContentPane().add(b22);
		

		botoes.add(new ArrayList<JButton>(Arrays.asList(b00,b10,b20)));
		botoes.add(new ArrayList<JButton>(Arrays.asList(b01,b11,b21)));
		botoes.add(new ArrayList<JButton>(Arrays.asList(b02,b12,b22)));
		
		
	}

	public void cpuJoga() {
		if (modo == 0) {
			if (vez == 0) {//cpu só joga no modo 0; e na vez dele
				vez = 1;
				ArrayList<Integer> pos = jogo.cpuAdiciona();
				botoes.get(pos.get(1)).get(pos.get(0)).doClick();
			} else {
				vez = 0;
			}
		}
	}
}
