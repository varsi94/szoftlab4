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
import Ellenseg.IEllenseg;
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
	private static final long serialVersionUID = -7175182164179721999L;
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

	/**
	 * Timer, ami id�ziti a l�p�seket a p�ly�n
	 */
	private Timer t = new Timer(KOR_TIME_DELAY, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// mozgat�s
			palya.motor();
			// �jrarajzol�s
			repaint();
		}
	});

	/**
	 * Konstruktor, a param�terk�nt �tadott p�ly�t jeleniti meg
	 * 
	 * @param palya
	 *            a p�lya
	 */
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
				//mindegyik cell�t kirajzoljuk
				final Cella c = palya.getTerkepCella(x, y);
				final ITorony torony = c.getTorony();
				if (torony != null) {
					//hozz�adjuk a torony list�hoz, a a l�v�sek kirajzol�s�hoz
					toronybuf.add(c);
				}
				final int pixelX = x * CELLA_PX_SIZE;
				final int pixelY = y * CELLA_PX_SIZE;
				// a cella rajzol�sa
				rajzoljCellat(g, c, x * CELLA_PX_SIZE, y * CELLA_PX_SIZE, CELLA_PX_SIZE, CELLA_PX_SIZE);

				if (palya.isHegyCella(c)) {
					//ha hegy, akkor egy fekete h�romsz�g rajzol�sa
					g.setColor(Color.BLACK);
					final int[] hegyX = new int[] { pixelX + CELLA_PX_SIZE / 2, pixelX + CELLA_PX_SIZE, pixelX };
					final int[] hegyY = new int[] { pixelY, pixelY + CELLA_PX_SIZE, pixelY + CELLA_PX_SIZE };
					g.fillPolygon(hegyX, hegyY, 3);
				}
				// n�gyzeth�l� kirajzol�sa
				g.setColor(Color.BLACK);
				g.drawLine(pixelX, pixelY, (x + 1) * CELLA_PX_SIZE, y * CELLA_PX_SIZE);
				g.drawLine(pixelX, pixelY, x * CELLA_PX_SIZE, (y + 1) * CELLA_PX_SIZE);
			}
		}

		// l�v�sek rajzol�sa, pirossal, vastag vonallal
		g.setColor(Color.RED);
		g2.setStroke(new BasicStroke(2.5f));
		for (Cella c : toronybuf) {
			final ITorony t = c.getTorony();
			for (Cella lov : t.getUtolsoLovesek()) {
				g.drawLine(c.getX() * CELLA_PX_SIZE + CELLA_PX_SIZE / 2, c.getY() * CELLA_PX_SIZE + CELLA_PX_SIZE / 4, lov.getX() * CELLA_PX_SIZE
						+ CELLA_PX_SIZE / 2, lov.getY() * CELLA_PX_SIZE + CELLA_PX_SIZE / 2);
			}
		}

		// hat�t�v indik�tor rajzol�sa, feh�r �tl�tsz� szinnel
		if (hatotavTorony != null) {
			g.setColor(new Color(255, 255, 255, 64));
			final int hatotav = hatotavTorony.getHatotav();
			g.fillRect((hatotavX - hatotav) * CELLA_PX_SIZE, (hatotavY - hatotav) * CELLA_PX_SIZE, (hatotav * 2 + 1) * CELLA_PX_SIZE, (hatotav * 2 + 1)
					* CELLA_PX_SIZE);
		}
		// var�zser�, jelenlegi k�r rajzol�sa a p�lya bal als� sark�ba
		g.setFont(g.getFont().deriveFont(Font.BOLD, 20f));
		g.setColor(Color.WHITE);
		g.drawString("Var�zser�: " + palya.getVarazsero(), 0, getHeight());

		g.setColor(Color.WHITE);
		g.drawString("K�r: " + palya.getKor(), 0, getHeight() - 25);
	}

	/**
	 * Kirajzol egy cell�t a kapott param�terek alapj�n
	 * 
	 * @param g
	 *            hova rajzoljon
	 * @param c
	 *            a cella amit ki kell rajzolni
	 * @param pixelX
	 *            g-n az x koordin�ta
	 * @param pixelY
	 *            g-n az y koordin�ta
	 * @param pixelW
	 *            milyen sz�less�gben akarjuk kirajzolni
	 * @param pixelH
	 *            milyen magass�gban akarjuk kirajzolni
	 */
	private static void rajzoljCellat(Graphics g, Cella c, int pixelX, int pixelY, int pixelW, int pixelH) {
		if (c.isUteleme()) {
			// ha �telem
			g.setColor(new Color(238, 213, 183));
			g.fillRect(pixelX, pixelY, pixelW, pixelH);
			final IAkadaly akadaly = c.getAkadaly();
			if (akadaly != null) {
				// ha van rajta akad�ly, akkor kirajzoljuk
				rajzoljAkadalyt(g, akadaly, pixelX, pixelY, pixelW, pixelH);
			}

			final List<IEllenseg> ellensegek = c.getEllensegek();
			final int count = ellensegek.size();
			for (IEllenseg ell : ellensegek) {
				// kirajzoljuk az ellens�geket
				rajzoljEllenseget(g, ell, pixelX, pixelY, pixelW, pixelH);
			}
			if (count > 1) {
				// ha t�bb mint 1 ellens�g van a cell�n kiirjuk hogy darab
				g.setColor(Color.WHITE);
				g.setFont(g.getFont().deriveFont(Font.BOLD, 16f));
				g.drawString(count + "", pixelX, pixelY + pixelH);
			}
		} else {
			// ha nem �telem
			g.setColor(new Color(160, 160, 160));
			g.fillRect(pixelX, pixelY, pixelW, pixelH);
			final ITorony torony = c.getTorony();
			if (torony != null) {
				// ha van torony kirajzoljuk
				rajzoljTornyot(g, torony, pixelX, pixelY, pixelW, pixelH);
			}
		}
	}

	/**
	 * Kirajzol egy akad�lyt a kapott param�terek alapj�n
	 * 
	 * @param g
	 *            hova rajzoljon
	 * @param a
	 *            az akad�ly amit ki kell rajzolni
	 * @param pixelX
	 *            g-n az x koordin�ta
	 * @param pixelY
	 *            g-n az y koordin�ta
	 * @param pixelW
	 *            milyen sz�less�gben akarjuk kirajzolni
	 * @param pixelH
	 *            milyen magass�gban akarjuk kirajzolni
	 */
	private static void rajzoljAkadalyt(Graphics g, IAkadaly a, int pixelX, int pixelY, int pixelW, int pixelH) {
		// az akad�ly soksz�g�nek koordin�t�i:
		final int[] akadalyX = new int[] { pixelX, pixelX + pixelW / 4, pixelX + pixelW / 4 * 3, pixelX + pixelW };
		final int[] akadalyY = new int[] { pixelY + pixelH, pixelY + pixelH / 2, pixelY + pixelH / 2, pixelY + pixelH };
		// megfelel� szinnel kirajzoljuk a soksz�get (trap�zt)
		g.setColor(a.getSzin());
		g.fillPolygon(akadalyX, akadalyY, 4);
		g.setColor(Color.WHITE);
		g.drawString(a.getHatas() + "", pixelX + pixelW / 3, pixelY + pixelH);
	}

	/**
	 * Kirajzol egy ellens�get a kapott param�terek alapj�n
	 * 
	 * @param g
	 *            hova rajzoljon
	 * @param ell
	 *            az ellens�g amit ki kell rajzolni
	 * @param pixelX
	 *            g-n az x koordin�ta
	 * @param pixelY
	 *            g-n az y koordin�ta
	 * @param pixelW
	 *            milyen sz�less�gben akarjuk kirajzolni
	 * @param pixelH
	 *            milyen magass�gban akarjuk kirajzolni
	 */
	private static void rajzoljEllenseget(Graphics g, IEllenseg ell, int pixelX, int pixelY, int pixelW, int pixelH) {
		// az ellens�g soksz�g�nek koordin�t�i:
		final int[] kasztX = new int[] { pixelX + pixelW / 2, pixelX + pixelW / 4 * 3, pixelX + pixelW * 3 / 5, pixelX + pixelW * 2 / 5, pixelX + pixelW / 4 };
		final int[] kasztY = new int[] { pixelY + pixelH / 4, pixelY + pixelH / 2, pixelY + pixelH, pixelY + pixelH, pixelY + pixelH / 2 };
		// a megfelel� szinnel kirajozljuk a soksz�get (�tsz�g)
		g.setColor(ell.getSzin());
		g.fillPolygon(kasztX, kasztY, kasztX.length);

		// a HP csikot fel�lre kirajzoljuk
		g.setColor(Color.RED);
		g.fillRect(pixelX, pixelY, pixelW, pixelH / 10);
		g.setColor(Color.GREEN);
		float hp = ell.getHp() / (float) ell.getStartHp();
		if (hp <= 0f) {
			hp = 0f;
		}
		g.fillRect(pixelX, pixelY, Math.round(pixelW * hp), pixelH / 10);
	}

	/**
	 * Kirajzol egy tornyot a kapott param�terek alapj�n
	 * 
	 * @param g
	 *            hova rajzoljon
	 * @param t
	 *            a torony amit ki kell rajzolni
	 * @param pixelX
	 *            g-n az x koordin�ta
	 * @param pixelY
	 *            g-n az y koordin�ta
	 * @param pixelW
	 *            milyen sz�less�gben akarjuk kirajzolni
	 * @param pixelH
	 *            milyen magass�gban akarjuk kirajzolni
	 */
	private static void rajzoljTornyot(Graphics g, ITorony t, int pixelX, int pixelY, int pixelW, int pixelH) {
		// torony kirajzol�sa
		if (t.isKod()) {
			// ha van k�d feh�rrel
			g.setColor(Color.WHITE);
		} else {
			// ha nincs k�d feket�vel
			g.setColor(Color.BLACK);
		}
		g.fillRect(pixelX + pixelW / 3, pixelY, pixelW / 3, pixelH);
	}

	@Override
	@Transient
	public Dimension getPreferredSize() {
		return new Dimension(CELLA_PX_SIZE * (Palya.PALYA_MAX_X_INDEX + 1), CELLA_PX_SIZE * (Palya.PALYA_MAX_Y_INDEX + 1));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// ha a user katting egy cell�ra, kisz�molyjuk melyik az a cella, majd meghivjuk a clickCella f�ggv�nyt
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
						// ha van el�g var�zser�, lerakjuk az akad�lyt
						palya.decVarazsero(Pok.KOLTSEG);
						palya.akadalytLerak(new Pok(c), c);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 1: {
					if (varazsero >= Ork.KOLTSEG) {
						// ha van el�g var�zser�, lerakjuk az akad�lyt
						palya.decVarazsero(Ork.KOLTSEG);
						palya.akadalytLerak(new Ork(c), c);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 2: {
					if (varazsero >= Ent.KOLTSEG) {
						// ha van el�g var�zser�, lerakjuk az akad�lyt
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
						// ha van el�g var�zser�, fejlesztj�k az akad�lyt
						palya.decVarazsero(LilaVarazsko.KOLTSEG);
						new LilaVarazsko().hat(akadaly);
					} else {
						kevesVarazsero();
					}
				}
			}
		} else {
			// ha nem �telem, tornyot rakhatunk le, vagy azt fejleszthet�nk
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
						// ha van el�g var�zser�, lerakjuk a tornyot
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
						// ha van el�g var�zser�, fejlesztj�k a tornyot
						palya.decVarazsero(FeherVarazsko.KOLTSEG);
						new FeherVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 1: {
					if (varazsero >= FeketeVarazsko.KOLTSEG) {
						// ha van el�g var�zser�, fejlesztj�k a tornyot
						palya.decVarazsero(FeketeVarazsko.KOLTSEG);
						new FeketeVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 2: {
					if (varazsero >= KekVarazsko.KOLTSEG) {
						// ha van el�g var�zser�, fejlesztj�k a tornyot
						palya.decVarazsero(KekVarazsko.KOLTSEG);
						new KekVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 3: {
					if (varazsero >= PirosVarazsko.KOLTSEG) {
						// ha van el�g var�zser�, fejlesztj�k a tornyot
						palya.decVarazsero(PirosVarazsko.KOLTSEG);
						new PirosVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 4: {
					if (varazsero >= SargaVarazsko.KOLTSEG) {
						// ha van el�g var�zser�, fejlesztj�k a tornyot
						palya.decVarazsero(SargaVarazsko.KOLTSEG);
						new SargaVarazsko().hat(t);
					} else {
						kevesVarazsero();
					}
					break;
				}
				case 5: {
					if (varazsero >= ZoldVarazsko.KOLTSEG) {
						// ha van el�g var�zser�, fejlesztj�k a tornyot
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
	 * Meghiv�dik ha kev�s a var�zser� v�s�rl�shoz, dial�gusablakot dob fel
	 */
	private void kevesVarazsero() {
		JOptionPane.showMessageDialog(this, "Kev�s var�szer�");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// torony hat�t�vols�g�nak a kijelz�s�nek a t�rl�se
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
		// a draggol�st deleg�ljuk a mozgat�sra
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// eg�r mozg�s detekt�l�sa
		final int x = e.getX();
		final int y = e.getY();
		if (x > 0 && y > 0 && x < getWidth() && y < getWidth()) {
			// ha valid a koordin�ta
			// akkor a torony hat�t�vols�g�t be�llitjuk, hogy melyiket jelenitse meg
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

	/**
	 * Meg�ll�tjuk a timert.
	 */
	public void timerStop() {
		t.stop();
	}
}
