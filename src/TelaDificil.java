import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaDificil extends JFrame {

	TelaDificil frame;
	private GeraTelaDificil jogo = null;
	private JPanel panel;
	ArrayList<JButton> buttons;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDificil frame = new TelaDificil();
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
	public TelaDificil() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1021, 925);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(new GridLayout(20, 24, 0, 0));

		buttons = new ArrayList<JButton>();

		jogo = new GeraTelaDificil(this, 3);

		gerarBotoes(3, jogo);

		jogo.preencherCampo();
	}

	public void gerarBotoes(int dificuldade, GeraTelaDificil jogo) {
		int nBotoes = 0;

		nBotoes = 480;

		JButton btn;

		for (int idx = 1; idx <= nBotoes; idx++) {

			btn = new JButton();
			btn.addActionListener(jogo);
			btn.setActionCommand(idx + "");

			buttons.add(btn);

			panel.add(btn);
		}
	}

}
