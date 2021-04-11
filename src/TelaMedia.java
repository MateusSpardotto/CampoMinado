import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.ArrayList;

public class TelaMedia extends JFrame {

	TelaMedia frame;
	private GeraTelaMedia jogo = null;
	private JPanel panel;
	ArrayList<JButton> buttons;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMedia frame = new TelaMedia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaMedia() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 647, 451);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(new GridLayout(14, 18, 0, 0));

		buttons = new ArrayList<JButton>();

		jogo = new GeraTelaMedia(this, GeraTelaMedia.MEDIO);

		gerarBotoes(GeraTelaMedia.MEDIO, jogo);

		jogo.preencherCampo();
	}

	public void gerarBotoes(int dificuldade, GeraTelaMedia jogo) {
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
