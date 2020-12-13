import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame fMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.fMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fMenu = new JFrame();
		fMenu.setTitle("Jogo da Velha - Menu");
		fMenu.setBounds(100, 100, 450, 300);
		fMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fMenu.getContentPane().setLayout(null);
		JButton bUm = new JButton("1 Jogador");
		bUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jogo jogo = new Jogo(0);
				jogo.fJogo.setVisible(true);
				
			}
		});
		bUm.setBounds(145, 55, 133, 34);
		fMenu.getContentPane().add(bUm);
		
		JButton bDois = new JButton("2 Jogadores");
		bDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogo jogo = new Jogo(1);
				jogo.fJogo.setVisible(true);	
			}
		});
		bDois.setBounds(145, 150, 133, 34);
		fMenu.getContentPane().add(bDois);
	}
}
