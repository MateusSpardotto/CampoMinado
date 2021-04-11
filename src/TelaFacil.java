import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class TelaFacil extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFacil frame = new TelaFacil();
					frame.setVisible(true);
				} catch (Exception e)
				{
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
		
		mnNewMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TelaFacil frame = new TelaFacil();
				frame.dispose();
			}
		});
		
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		CampoMinado campoMinado = new CampoMinado();
		campoMinado.iniciaPartida(1);
		
		char[][] tela = campoMinado.getTela();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{tela[0][0], tela[0][1], tela[0][2], tela[0][3], tela[0][4], tela[0][5], tela[0][6], tela[0][7], tela[0][8], tela[0][9]},
				{tela[1][0], tela[1][1], tela[1][2], tela[1][3], tela[1][4], tela[1][5], tela[1][6], tela[1][7], tela[1][8], tela[1][9]},
				{tela[2][0], tela[2][1], tela[2][2], tela[2][3], tela[2][4], tela[2][5], tela[2][6], tela[2][7], tela[2][8], tela[2][9]},
				{tela[3][0], tela[3][1], tela[3][2], tela[3][3], tela[3][4], tela[3][5], tela[3][6], tela[3][7], tela[3][8], tela[3][9]},
				{tela[4][0], tela[4][1], tela[4][2], tela[4][3], tela[4][4], tela[4][5], tela[4][6], tela[4][7], tela[4][8], tela[4][9]},
				{tela[5][0], tela[5][1], tela[5][2], tela[5][3], tela[5][4], tela[5][5], tela[5][6], tela[5][7], tela[5][8], tela[5][9]},
				{tela[6][0], tela[6][1], tela[6][2], tela[6][3], tela[6][4], tela[6][5], tela[6][6], tela[6][7], tela[6][8], tela[6][9]},
				{tela[7][0], tela[7][1], tela[7][2], tela[7][3], tela[7][4], tela[7][5], tela[7][6], tela[7][7], tela[7][8], tela[7][9]},
			},
			new String[] {
				"sd", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setMinWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setMinWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setMinWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setMinWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setMinWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setMinWidth(40);
		table.getColumnModel().getColumn(7).setPreferredWidth(40);
		table.getColumnModel().getColumn(7).setMinWidth(40);
		table.getColumnModel().getColumn(8).setPreferredWidth(40);
		table.getColumnModel().getColumn(8).setMinWidth(40);
		table.getColumnModel().getColumn(9).setPreferredWidth(40);
		table.getColumnModel().getColumn(9).setMinWidth(40);
		table.setForeground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
