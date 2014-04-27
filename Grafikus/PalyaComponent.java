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
 * A komponens ami képes megjeleniteni a Pályát
 */
public class PalyaComponent extends JComponent implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = -7175182164179721999L;
	/**
	 * Mennyi ms-enként legyen új kör, motor hivás
	 */
	private static final int KOR_TIME_DELAY = 500;
	/**
	 * A cella szélessége és magassága
	 */
	private static final int CELLA_PX_SIZE = 40;
	/**
	 * Referencia a pályára
	 */
	private Palya palya;

	// feléviszed az egeret, hatótáv kijelzéshez

	/**
	 * Hatótávolság jelzés x koordináta
	 */
	private int hatotavX;
	/**
	 * Hatótávolság jelzés y koordináta
	 */
	private int hatotavY;

	/**
	 * A torony aminek a hatótávolságát jelezzük
	 */
	private ITorony hatotavTorony;

	/**
	 * A tornyok ideiglenes listája, minden kirajzoláskor újra feltöltjük, és berajzoljuk a lövéseket
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
		// pálya kirajzolása
		for (int x = 0; x <= Palya.PALYA_MAX_X_INDEX; x++) {
			for (int y = 0; y <= Palya.PALYA_MAX_Y_INDEX; y++) {
				final Cella c = palya.getTerkepCella(x, y);
				final ITorony torony = c.getTorony();
				if (torony != null) {
					toronybuf.add(c);
				}
				final int pixelX = x * CELLA_PX_SIZE;
				final int pixelY = y * CELLA_PX_SIZE;
				// cellák
				rajzoljCellat(g, c, x * CELLA_PX_SIZE, y * CELLA_PX_SIZE, CELLA_PX_SIZE, CELLA_PX_SIZE);

				if (palya.isHegyCella(c)) {
					g.setColor(Color.BLACK);
					final int[] hegyX = new int[] { pixelX + CELLA_PX_SIZE / 2, pixelX + CELLA_PX_SIZE, pixelX };
					final int[] hegyY = new int[] { pixelY, pixelY + CELLA_PX_SIZE, pixelY + CELLA_PX_SIZE };
					g.fillPolygon(hegyX, hegyY, 3);
				}
				// négyzetháló
				g.setColor(Color.BLACK);
				g.drawLine(pixelX, pixelY, (x + 1) * CELLA_PX_SIZE, y * CELLA_PX_SIZE);
				g.drawLine(pixelX, pixelY, x * CELLA_PX_SIZE, (y + 1) * CELLA_PX_SIZE);
			}
		}

		// lövések rajzolása
		g.setColor(Color.RED);
		g2.setStroke(new BasicStroke(2.5f));
		for (Cella c : toronybuf) {
			final ITorony t = c.getTorony();
			for (Cella lov : t.getUtolsoLovesek()) {
				g.drawLine(c.getX() * CELLA_PX_SIZE + CELLA_PX_SIZE / 2, c.getY() * CELLA_PX_SIZE + CELLA_PX_SIZE / 4, lov.getX() * CELLA_PX_SIZE
						+ CELLA_PX_SIZE / 2, lov.getY() * CELLA_PX_SIZE + CELLA_PX_SIZE / 2);
			}
		}

		// hatótáv indikátor rajzolása
		if (hatotavTorony != null) {
			g.setColor(new Color(255, 255, 255, 64));
			final int hatotav = hatotavTorony.getHatotav();
			g.fillRect((hatotavX - hatotav) * CELLA_PX_SIZE, (hatotavY - hatotav) * CELLA_PX_SIZE, (hatotav * 2 + 1) * CELLA_PX_SIZE, (hatotav * 2 + 1)
					* CELLA_PX_SIZE);
		}
		// varázserõ, jelenlegi kör rajzolása
		g.setFont(g.getFont().deriveFont(Font.BOLD, 20f));
		g.setColor(Color.WHITE);
		g.drawString("Varázserõ: " + palya.getVarazsero(), 0, getHeight());

		g.setColor(Color.WHITE);
		g.drawString("Kör: " + palya.getKor(), 0, getHeight() - 25);
	}

	private static void rajzoljCellat(Graphics g, Cella c, int pixelX, int pixelY, int pixelW, int pixelH) {
		if (c.isUteleme()) {
			g.setColor(new Color(238, 213, 183));
			g.fillRect(pixelX, pixelY, pixelW, pixelH);
			final IAkadaly akadaly = c.getAkadaly();
			if (akadaly != null) {
				rajzoljAkadalyt(g, akadaly, pixelX, pixelY, pixelW, pixelH);
			}

			final List<IEllenseg> ellensegek = c.getEllensegek();
			final int count = ellensegek.size();
			for (IEllenseg ell : ellensegek) {
				rajzoljEllenseget(g, ell, pixelX, pixelY, pixelW, pixelH);
			}
			if (count > 1) {
				g.setColor(Color.WHITE);
				g.setFont(g.getFont().deriveFont(Font.BOLD, 16f));
				g.drawString(count + "", pixelX, pixelY + pixelH);
			}
		} else {
			g.setColor(new Color(160, 160, 160));
			g.fillRect(pixelX, pixelY, pixelW, pixelH);
			final ITorony torony = c.getTorony();
			if (torony != null) {
				rajzoljTornyot(g, torony, pixelX, pixelY, pixelW, pixelH);
			}
		}
	}

	private static void rajzoljAkadalyt(Graphics g, IAkadaly a, int pixelX, int pixelY, int pixelW, int pixelH) {
		final int[] akadalyX = new int[] { pixelX, pixelX + pixelW / 4, pixelX + pixelW / 4 * 3, pixelX + pixelW };
		final int[] akadalyY = new int[] { pixelY + pixelH, pixelY + pixelH / 2, pixelY + pixelH / 2, pixelY + pixelH };
		g.setColor(a.getSzin());
		g.fillPolygon(akadalyX, akadalyY, 4);
		g.setColor(Color.WHITE);
		g.drawString(a.getHatas() + "", pixelX + pixelW / 3, pixelY + pixelH);
	}

	private static void rajzoljEllenseget(Graphics g, IEllenseg ell, int pixelX, int pixelY, int pixelW, int pixelH) {
		final int[] kasztX = new int[] { pixelX + pixelW / 2, pixelX + pixelW / 4 * 3, pixelX + pixelW * 3 / 5, pixelX + pixelW * 2 / 5, pixelX + pixelW / 4 };
		final int[] kasztY = new int[] { pixelY + pixelH / 4, pixelY + pixelH / 2, pixelY + pixelH, pixelY + pixelH, pixelY + pixelH / 2 };
		g.setColor(ell.getSzin());
		g.fillPolygon(kasztX, kasztY, kasztX.length);
		g.setColor(Color.RED);
		g.fillRect(pixelX, pixelY, pixelW, pixelH / 10);
		g.setColor(Color.GREEN);
		float hp = ell.getHp() / (float) ell.getStartHp();
		if (hp <= 0f) {
			hp = 0f;
		}
		g.fillRect(pixelX, pixelY, Math.round(pixelW * hp), pixelH / 10);
	}

	private static void rajzoljTornyot(Graphics g, ITorony t, int pixelX, int pixelY, int pixelW, int pixelH) {
		if (t.isKod()) {
			g.setColor(Color.WHITE);
		} else {
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
		final int x = e.getX() / CELLA_PX_SIZE;
		final int y = e.getY() / CELLA_PX_SIZE;
		final Cella c = palya.getTerkepCella(x, y);
		clickCella(c);
	}

	/**
	 * Meghivódik, ha a user ráklikkelt valamelyik cellára, le akar rakni oda valamit, lerakhat tornyot, akadályt, vagy varázskövet
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
			// ha útelem, akadályt rakunk le vagy fejlesztjük
			title = "Akadály";
			final IAkadaly akadaly = c.getAkadaly();
			if (akadaly == null) {
				// ha nincs rajta akadály akkor az lerakhat
				msg = "Milyen akadályt rakjunk le?" + "\nPók: lassít" + "\nOrk: gyilkol" + "\nEnt: mészárol";
				options = new Object[] { "Pókot (" + Pok.KOLTSEG + ")", "Orkot (" + Ork.KOLTSEG + ")", "Entet (" + Ent.KOLTSEG + ")", };
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
				// fejlesztheti a meglévõ akadályt
				msg = "Használjunk varázskövet az akadályon?";
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
				msg = "Milyen varázskövet használjunk a tornyon?" + //
						"\nFehér: tündék ellen" + //
						"\nFekete: törpök ellen" + //
						"\nKék: nagyobb tüzelési gyakoriság" + //
						"\nPiros: nagyobb hatótávolság" + //
						"\nSárga: emberek ellen" + //
						"\nZöld: hobbitok ellen";//
				options = new Object[] { "Fehéret (" + FeherVarazsko.KOLTSEG + ")", "Feketét (" + FeketeVarazsko.KOLTSEG + ")",
						"Kéket (" + KekVarazsko.KOLTSEG + ")", "Pirosat (" + PirosVarazsko.KOLTSEG + ")", "Sárgát (" + SargaVarazsko.KOLTSEG + ")",
						"Zöldet (" + ZoldVarazsko.KOLTSEG + ")" };
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
	 * Meghivódik ha kevés a varázserõ vásárláshoz
	 */
	private void kevesVarazsero() {
		JOptionPane.showMessageDialog(this, "Kevés varászerõ");
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
		// egér mozgás detektálása
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
	 * Beállitható a pálya amit a Component megjelenitsen
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
	 * Megállítjuk a timert.
	 */
	public void timerStop() {
		t.stop();
	}
}
