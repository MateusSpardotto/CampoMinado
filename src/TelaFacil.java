import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaFacil extends JFrame {
	TelaFacil frame;
	private GeraTelaFacil jogo = null;

	private JPanel panel;
	ArrayList<JButton> buttons;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFacil frame = new TelaFacil();
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
	public TelaFacil() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Inicio");

		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new TelaFacil();
				frame.dispose();
			}
		});

		menuBar.add(mnNewMenu);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(new GridLayout(8, 10, 0, 0));

		buttons = new ArrayList<JButton>();

		jogo = new GeraTelaFacil(this, 1);

		gerarBotoes(1, jogo);

		jogo.preencherCampo();

	}

	public void gerarBotoes(int dificuldade, GeraTelaFacil jogo) {
		int nBotoes = 0;

		nBotoes = 80;

		JButton btn = null;

		for (int idx = 1; idx <= nBotoes; idx++) {

			btn = new JButton();
			btn.addActionListener(jogo);
			btn.setActionCommand(idx + "");

			buttons.add(btn);

			panel.add(btn);
		}
	}

}
