import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GeraTelaFacil implements ActionListener {
	private int nRows = 8;
	private int nCols = 10;
	private int nRowsCols;
	private int nBombas;

	private List<Posicao> campo;

	private TelaFacil tela;

	public GeraTelaFacil(TelaFacil tela, int dificuldade) {
		this.tela = tela;

		nRowsCols = nRows * nCols;

		campo = new ArrayList<Posicao>(nRowsCols);
	}

	private void demarcarProximidas(Posicao pos) {

		Posicao verifica = null;

		{
			verifica = procurarPor(pos.row - 1, pos.col - 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		{
			verifica = procurarPor(pos.row - 1, pos.col);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		{
			verifica = procurarPor(pos.row - 1, pos.col + 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		{
			verifica = procurarPor(pos.row, pos.col - 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		{
			verifica = procurarPor(pos.row, pos.col + 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		{
			verifica = procurarPor(pos.row + 1, pos.col - 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		{
			verifica = procurarPor(pos.row + 1, pos.col);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}

		{
			verifica = procurarPor(pos.row + 1, pos.col + 1);
			if (verifica != null && !verifica.isBomb) {
				verifica.bombCount++;

				campo.set(verifica.id - 1, verifica);
			}
		}
	}

	private void gerarBombas() {
		List<Posicao> bombas = new ArrayList<Posicao>();

		Random rand = new Random();

		nBombas = 10;

		while (bombas.size() < nBombas) {
			int id = rand.nextInt(nRowsCols + 1);

			if (id == 0)
				continue;

			Posicao pos = new Posicao(id, false, true);

			if (!bombas.contains(pos))
				bombas.add(pos);
		}

		for (Posicao posicao : bombas) {
			posicao.getRow(nCols);
			posicao.getCol(nCols);

			campo.set(posicao.id - 1, posicao);
		}

		for (Posicao posicao : campo) {
			if (posicao.isBomb)
				demarcarProximidas(posicao);
		}
	}

	public void preencherCampo() {
		for (int id = 1; id <= nRowsCols; id++) {
			Posicao posicao = new Posicao(id, false, false);
			posicao.getRow(nCols);
			posicao.getCol(nCols);

			campo.add(posicao);
		}

		gerarBombas();
	}

	private Posicao procurarPor(int row, int col) {
		for (Posicao posicao : campo) {
			if (posicao.row == row && posicao.col == col)
				return posicao;
		}

		return null;
	}

	private void revelarLinha(Posicao pos, char operacao) {

		Posicao verifica = null;

		int limiteSup = -1;

		for (int idx = pos.col; (idx < nCols) && (limiteSup == -1); idx++) {
			verifica = procurarPor(pos.row, idx);
			if (verifica != null) {
				if (verifica.isBomb || verifica.bombCount > 1)
					limiteSup = verifica.col;
				else if (verifica.bombCount == 1) {
					verifica = procurarPor(pos.row, idx + 1);
					if (verifica != null && !verifica.isBomb)
						continue;
				}
			}
		}

		int limiteInf = -1;

		for (int idx = pos.col; (idx >= 0) && (limiteInf == -1); idx--) {
			verifica = procurarPor(pos.row, idx);
			if (verifica != null) {
				if (verifica.isBomb || verifica.bombCount > 1)
					limiteInf = verifica.col;
				else if (verifica.bombCount == 1) {
					verifica = procurarPor(pos.row, idx - 1);
					if (verifica != null && !verifica.isBomb)
						continue;
				}
			}
		}

		if (limiteSup == -1)
			limiteSup = nCols;

		if (limiteInf == -1)
			limiteInf = 0;

		for (int idx = limiteInf; idx < limiteSup; idx++) {
			verifica = procurarPor(pos.row, idx);
			if (verifica != null && !verifica.isBomb) {
				verifica.isRevealed = true;
			}
		}
	}

	private void revelar(Posicao pos) {

		Posicao verifica = null;

		int limiteSup = -1;

		for (int idx = pos.row; (idx < nRows) && (limiteSup == -1); idx++) {
			verifica = procurarPor(idx, pos.col);
			if (verifica != null) {
				if (verifica.isBomb)
					limiteSup = verifica.row;
			}
		}

		int limiteInf = -1;

		for (int idx = pos.row; (idx >= 0) && (limiteInf == -1); idx--) {
			verifica = procurarPor(idx, pos.col);
			if (verifica != null) {
				if (verifica.isBomb)
					limiteInf = verifica.row;
			}
		}

		if (limiteSup == -1)
			limiteSup = nRows;

		if (limiteInf == -1)
			limiteInf = 0;

		verifica = null;

		for (int idx = limiteInf; idx < limiteSup; idx++) {

			verifica = procurarPor(idx, pos.col);

			revelarLinha(verifica, '-');
		}

	}

	private boolean ehBomba(Posicao pos) {
		if (pos.isBomb) {
			pos.isRevealed = true;
			return true;
		}

		revelar(pos);

		pos.isRevealed = true;

		return false;
	}

	private boolean ganhou() {
		int nBombasNaoReveladas = 0;

		for (Posicao posicao : campo) {
			if (posicao.isBomb && !posicao.isRevealed)
				nBombasNaoReveladas++;

			if (!posicao.isBomb && !posicao.isRevealed)
				return false;
		}

		return nBombasNaoReveladas == nBombas;
	}

	private void mostrarTudo() {
		for (Posicao posicao : campo) {
			posicao.isRevealed = true;
		}
	}

	private void atualizarBotoes() {
		for (JButton btn : tela.buttons) {
			Integer id = Integer.parseInt(btn.getActionCommand());

			Posicao pos = campo.get(id - 1);

			if (pos.isRevealed) {
				if (pos.isBomb)
					btn.setIcon(new ImageIcon("img/mina.png"));
				else if (pos.bombCount != 0)
					btn.setText(pos.bombCount + "");
				else
					btn.setText("");

				btn.setEnabled(false);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer id = Integer.parseInt(e.getActionCommand());

		Posicao pos = campo.get(id - 1);

		if (ehBomba(pos)) {
			mostrarTudo();

			atualizarBotoes();

		} else if (ganhou()) {
			mostrarTudo();

			atualizarBotoes();

			JOptionPane.showMessageDialog(null, "Parabéns!");
		}

		atualizarBotoes();
	}

}