import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;

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

		jogo = new GeraTelaFacil(this, GeraTelaFacil.FACIL);

		gerarBotoes(GeraTelaFacil.FACIL, jogo);

		jogo.preencherCampo();

	}

	public void gerarBotoes(int dificuldade, GeraTelaFacil jogo) {
		int nBotoes = 0;

		switch (dificuldade) {

		case GeraTelaFacil.FACIL:
			nBotoes = GeraTelaFacil.QTD_CAMPOS_FACIL;
			break;

		case GeraTelaFacil.MEDIO:
			nBotoes = GeraTelaFacil.QTD_CAMPOS_MEDIO;
			break;

		case GeraTelaFacil.DIFICIL:
			nBotoes = GeraTelaFacil.QTD_CAMPOS_DIFICIL;
			break;
		}

		JButton btn = null;

		for (int idx = 1; idx <= nBotoes; idx++) {

			btn = new JButton();
			btn.addActionListener(jogo);
			btn.setActionCommand(idx + "");

			buttons.add(btn);

			switch (dificuldade) {

			case GeraTelaFacil.FACIL:
				panel.add(btn);
				break;
			case GeraTelaFacil.MEDIO:
				panel.add(btn);
				break;
			case GeraTelaFacil.DIFICIL:
				panel.add(btn);
				break;
			}
		}
	}

}
