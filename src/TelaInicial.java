import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaInicial implements ActionListener {
	JFrame frame;
	JPanel panelFacil, panelMedio, panelDificil;
	ArrayList<JButton> buttons;
	JMenuItem jogoFacil;
	JMenuItem jogoMedio;
	JMenuItem sair;

	private GeraTelaFacil jogo = null;

	public TelaInicial() {
		frame = new JFrame("Campo Minado :p");
		frame.setVisible(true);
		frame.setSize(783, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Inic\u00EDo");
		menuBar.add(mnNewMenu);

		JMenu novoJogo = new JMenu("Novo jogo");
		mnNewMenu.add(novoJogo);

		jogoFacil = new JMenuItem("F\u00E1cil");
		jogoFacil.addActionListener(this);
		novoJogo.add(jogoFacil);

		jogoMedio = new JMenuItem("M\u00E9dio");
		jogoMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMedia telaMedia = new TelaMedia();
				telaMedia.setVisible(true);
			}
		});
		novoJogo.add(jogoMedio);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Dific\u00EDl");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDificil telaDificil = new TelaDificil();
				telaDificil.setVisible(true);
			}
		});
		novoJogo.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Hist\u00F3rico");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaHistorico historico = new TelaHistorico();
				historico.setVisible(true);
			}
		});

		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Sobre");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);
			}
		});

		panelFacil = new JPanel(new GridLayout(8, 10));
		panelMedio = new JPanel(new GridLayout(12, 14));
		panelDificil = new JPanel(new GridLayout(16, 18));

		buttons = new ArrayList<JButton>();

		mnNewMenu.add(mntmNewMenuItem_4);

		sair = new JMenuItem("Sair");
		sair.addActionListener(this);

		mnNewMenu.add(sair);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 767, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		frame.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.repaint();
		panelFacil.removeAll();
		panelMedio.removeAll();
		panelDificil.removeAll();
		buttons.clear();

		if (e.getSource() == jogoFacil) {
			TelaFacil telaFacil = new TelaFacil();
			telaFacil.setVisible(true);

		} else if (e.getSource() == sair) {
			System.exit(0);
		}

	}
}