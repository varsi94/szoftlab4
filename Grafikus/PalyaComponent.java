package Grafikus;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Akadaly.Ent;
import Akadaly.IAkadaly;
import Akadaly.Ork;
import Akadaly.Pok;
import Cella.Cella;
import Palya.Palya;
import Torony.ITorony;
import Torony.Torony;
import Varazsko.FeherVarazsko;
import Varazsko.FeketeVarazsko;
import Varazsko.KekVarazsko;
import Varazsko.LilaVarazsko;
import Varazsko.PirosVarazsko;
import Varazsko.SargaVarazsko;
import Varazsko.ZoldVarazsko;

/**
 * A komponens ami k�pes megjeleniteni a P�ly�t
 */
public class PalyaComponent extends JComponent implements MouseListener, MouseMotionListener {
	/**
	 * Mennyi ms-enk�nt legyen �j k�r, motor hiv�s
	 */
	private static final int KOR_TIME_DELAY = 500;
	/**
	 * A cella sz�less�ge �s magass�ga
	 */
	private static final int CELLA_PX_SIZE = 40;
	/**
	 * Referencia a p�ly�ra
	 */
	private Palya palya;

	// fel�viszed az egeret, hat�t�v kijelz�shez

	/**
	 * Hat�t�vols�g jelz�s x koordin�ta
	 */
	private int hatotavX;
	/**
	 * Hat�t�vols�g jelz�s y koordin�ta
	 */
	private int hatotavY;

	/**
	 * A torony aminek a hat�t�vols�g�t jelezz�k
	 */
	private ITorony hatotavTorony;

	/**
	 * A tornyok ideiglenes list�ja, minden kirajzol�skor �jra felt�ltj�k, �s berajzoljuk a l�v�seket
	 */
	private List<Cella> toronybuf = new ArrayList<Cella>();

	private Timer t = new Timer(KOR_TIME_DELAY, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			palya.motor();
			repaint();
		}
	});

	public PalyaComponent(Palya palya) {
		this.palya = palya;
		t.start();
		t.setRepeats(true);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		toronybuf.clear();
		// p�lya kirajzol�sa
		for (int x = 0; x <= Palya.PALYA_MAX_X_INDEX; x++) {
			for (int y = 0; y <= Palya.PALYA_MAX_Y_INDEX; y++) {
				final Cella c = palya.getTerkepCella(x, y);
				final ITorony torony = c.getTorony();
				if (torony != null) {
					toronybuf.add(c);
				}
				final int pixelX = x * CELLA_PX_SIZE;
				final int pixelY = y * CELLA_PX_SIZE;
				// cell�k
				c.rajzol(g, x * CELLA_PX_SIZE, y * CELLA_PX_SIZE, CELLA_PX_SIZE, CELLA_PX_SIZE);

				if (palya.isHegyCella(c)) {
					g.setColor(Color.BLACK);
					final int[] hegyX = new int[] { pixelX + CELLA_PX_SIZE / 2, pixelX + CELLA_PX_SIZE, pixelX };
					final int[] hegyY = new int[] { pixelY, pixelY + CELLA_PX_SIZE, pixelY + CELLA_PX_SIZE };
					g.fillPolygon(hegyX, hegyY, 3);
				}
				// n�gyzeth�l�
				g.setColor(Color.BLACK);
				g.drawLine(pixelX, pixelY, (x + 1) * CELLA_PX_SIZE, y * CELLA_PX_SIZE);
				g.drawLine(pixelX, pixelY, x * CELLA_PX_SIZE, (y + 1) * CELLA_PX_SIZE);
			}
		}

		// l�v�sek rajzol�sa
		g.setColor(Color.RED);
		g2.setStroke(new BasicStroke(2.5f));
		for (Cella c : toronybuf) {
			final ITorony t = c.getTorony();
			for (Cella lov : t.getUtolsoLovesek()) {
				g.drawLine(c.getX() * CELLA_PX_SIZE + CELLA_PX_SIZE / 2, c.getY() * CELLA_PX_SIZE + CELLA_PX_SIZE / 2, lov.getX() * CELLA_PX_SIZE
						+ CELLA_PX_SIZE / 2, lov.getY() * CELLA_PX_SIZE + CELLA_PX_SIZE / 2);
			}
		}

		// hat�t�v indik�tor rajzol�sa
		if (hatotavTorony != null) {
			g.setColor(new Color(255, 255, 255, 64));
			final int hatotav = hatotavTorony.getHatotav();
			g.fillRect((hatotavX - hatotav) * CELLA_PX_SIZE, (hatotavY - hatotav) * CELLA_PX_SIZE, (hatotav * 2 + 1) * CELLA_PX_SIZE, (hatotav * 2 + 1)
					* CELLA_PX_SIZE);
		}
		// var�zser�, jelenlegi k�r rajzol�sa
		g.setFont(g.getFont().deriveFont(Font.BOLD, 20f));
		g.setColor(Color.WHITE);
		g.drawString("Var�zser�: " + palya.getVarazsero(), 0, getHeight());

		g.setColor(Color.WHITE);
		g.drawString("K�r: " + palya.getKor(), 0, getHeight() - 25);
	}

	@Override
	@Transient
	public Dimension getPreferredSize() {
		return new Dimension(CELLA_PX_SIZE * (Palya.PALYA_MAX_X_INDEX + 1), CELLA_PX_SIZE * (Palya.PALYA_MAX_Y_INDEX + 1));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		final int x = e.getX() / CELLA_PX_SIZE;
		final int y = e.getY() / CELLA_PX_SIZE;
		final Cella c = palya.getTerkepCella(x, y);
		clickCella(c);
	}

	/**
	 * Meghiv�dik, ha a user r�klikkelt valamelyik cell�ra, le akar rakni oda valamit, lerakhat tornyot, akad�lyt, vagy var�zsk�vet
	 * 
	 * @param c
	 *            melyik cella
	 */
	private void clickCella(Cella c) {
		t.stop();
		final Object[] options;
		final int varazsero = palya.getVarazsero();
		final String title;
		String msg;
		if (c.isUteleme()) {
			// ha �telem, akad�lyt rakunk le vagy fejlesztj�k
			title = "Akad�ly";
			final IAkadaly akadaly = c.getAkadaly();
			if (akadaly == null) {
				// ha nincs rajta akad�ly akkor az lerakhat
				msg = "Milyen akad�lyt rakjunk le?" + "\nP�k: lass�t" + "\nOrk: gyilkol" + "\nEnt: m�sz�rol";
				options = new Object[] { "P�kot (" + Pok.KOLTSEG + ")", "Orkot (" + Ork.KOLTSEG + ")", "Entet (" + Ent.KOLTSEG + ")", };
				final int n = JOptionPane.showOptionDialog(this, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						null);
				switch (n) {
				case 0: {
					if (varazsero >= Pok.KOLTSEG) {
						palya.decVarazsero(Pok.KOLTSEG);
						palya.akadalytLerak(new Pok(c), c);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 1: {
					if (varazsero >= Ork.KOLTSEG) {
						palya.decVarazsero(Ork.KOLTSEG);
						palya.akadalytLerak(new Ork(c), c);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 2: {
					if (varazsero >= Ent.KOLTSEG) {
						palya.decVarazsero(Ent.KOLTSEG);
						palya.akadalytLerak(new Ent(c), c);
					} else {
						kevesVarazsero();
					}
					break;
				}
				default: {
					break;
				}
				}
			} else {
				// fejlesztheti a megl�v� akad�lyt
				msg = "Haszn�ljunk var�zsk�vet az akad�lyon?";
				options = new Object[] { "Igen (" + LilaVarazsko.KOLTSEG + ")", "Nem" };
				final int n = JOptionPane.showOptionDialog(this, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						options[0]);
				if (n == 0) {
					if (varazsero >= LilaVarazsko.KOLTSEG) {
						palya.decVarazsero(LilaVarazsko.KOLTSEG);
						new LilaVarazsko().hat(akadaly);
					} else {
						kevesVarazsero();
					}
				}
			}
		} else {
			title = "Torony";
			final ITorony t = c.getTorony();
			if (t == null) {
				// tornyot rakhat le
				msg = "Rakjunk le tornyot?";
				options = new Object[] { "Igen (" + ITorony.KOLTSEG + ")", "Nem" };
				final int n = JOptionPane.showOptionDialog(this, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						options[0]);
				if (n == 0) {
					if (varazsero >= ITorony.KOLTSEG) {
						palya.decVarazsero(ITorony.KOLTSEG);
						palya.tornyotLerak(new Torony(palya, c), c);
					} else {
						kevesVarazsero();
					}
				}
			} else {
				// fejleszheti a tornyot
				msg = "Milyen var�zsk�vet haszn�ljunk a tornyon?" + //
						"\nFeh�r: t�nd�k ellen" + //
						"\nFekete: t�rp�k ellen" + //
						"\nK�k: nagyobb t�zel�si gyakoris�g" + //
						"\nPiros: nagyobb hat�t�vols�g" + //
						"\nS�rga: emberek ellen" + //
						"\nZ�ld: hobbitok ellen";//
				options = new Object[] { "Feh�ret (" + FeherVarazsko.KOLTSEG + ")", "Feket�t (" + FeketeVarazsko.KOLTSEG + ")",
						"K�ket (" + KekVarazsko.KOLTSEG + ")", "Pirosat (" + PirosVarazsko.KOLTSEG + ")", "S�rg�t (" + SargaVarazsko.KOLTSEG + ")",
						"Z�ldet (" + ZoldVarazsko.KOLTSEG + ")" };
				final int n = JOptionPane.showOptionDialog(this, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						options[0]);
				switch (n) {
				case 0: {
					if (varazsero >= FeherVarazsko.KOLTSEG) {
						palya.decVarazsero(FeherVarazsko.KOLTSEG);
						new FeherVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 1: {
					if (varazsero >= FeketeVarazsko.KOLTSEG) {
						palya.decVarazsero(FeketeVarazsko.KOLTSEG);
						new FeketeVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 2: {
					if (varazsero >= KekVarazsko.KOLTSEG) {
						palya.decVarazsero(KekVarazsko.KOLTSEG);
						new KekVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 3: {
					if (varazsero >= PirosVarazsko.KOLTSEG) {
						palya.decVarazsero(PirosVarazsko.KOLTSEG);
						new PirosVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 4: {
					if (varazsero >= SargaVarazsko.KOLTSEG) {
						palya.decVarazsero(SargaVarazsko.KOLTSEG);
						new SargaVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 5: {
					if (varazsero >= ZoldVarazsko.KOLTSEG) {
						palya.decVarazsero(ZoldVarazsko.KOLTSEG);
						new ZoldVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				default: {
					break;
				}
				}
			}
		}
		repaint();
		t.start();
	}

	/**
	 * Meghiv�dik ha kev�s a var�zser� v�s�rl�shoz
	 */
	private void kevesVarazsero() {
		JOptionPane.showMessageDialog(this, "Kev�s var�szer�");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		hatotavTorony = null;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// eg�r mozg�s detekt�l�sa
		final int x = e.getX();
		final int y = e.getY();
		if (x > 0 && y > 0 && x < getWidth() && y < getWidth()) {
			hatotavX = x / CELLA_PX_SIZE;
			hatotavY = y / CELLA_PX_SIZE;
			final Cella c = palya.getTerkepCella(hatotavX, hatotavY);
			hatotavTorony = c.getTorony();
			repaint();
		}
	}

	/**
	 * Be�llithat� a p�lya amit a Component megjelenitsen
	 * 
	 * @param palya
	 *            the palya to set
	 */
	public void setPalya(Palya palya) {
		this.palya = palya;
		hatotavTorony = null;
		repaint();
	}
}
