import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaInicial
{
	JFrame frame;
	
	public TelaInicial()
	{
		frame = new JFrame("Campo Minado");
		frame.setVisible(true);
		frame.setSize(783, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inic\u00EDo");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Novo jogo");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("F\u00E1cil");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("M\u00E9dio");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Dific\u00EDl");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Hist\u00F3rico");
		mntmNewMenuItem_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TelaHistorico historico = new TelaHistorico();
				historico.setVisible(true);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Sobre");
		mntmNewMenuItem_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Sair");
		mnNewMenu.add(mntmNewMenuItem_5);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 767, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}