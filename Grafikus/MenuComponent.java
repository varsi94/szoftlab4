package Grafikus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Palya.Palya;
import Ranglista.Ranglista;

/**
 * Komponens a menü kirajzolására.
 * 
 * @author Varsi
 * 
 */
public class MenuComponent extends JComponent implements MouseListener,
		MouseMotionListener {
	/**
	 * A kompnens szépessége és magassága
	 */
	private static final int HEIGHT = 200;
	private static final int WIDTH = 200;
	private static final long serialVersionUID = 5237335232850181080L;
	/**
	 * Melyik menüpont felett haladt el utoljára az egér.
	 */
	private int currMenuItem = -1;
	/**
	 * A menüpontok címkéi.
	 */
	private String[] menus;
	/**
	 * Szülõ frame
	 */
	private JFrame parent;

	/**
	 * Konstruktor
	 * @param _parent szülõ frame
	 */
	public MenuComponent(JFrame _parent) {
		addMouseListener(this);
		addMouseMotionListener(this);
		menus = new String[] { "Új játék", "Betöltés", "Ranglista", "Kilépés" };
		parent = _parent;
	}

	/**
	 * A komponens preferált méretét adja vissza.
	 * @return a méret
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

	/**
	 * Egy stringet kirajzoló metódus. Egy téglalapot adunk meg, aminek a közepére kell rajzolni
	 * a stringet (mind horizontálisan, mind vertikálisan.
	 * @param g Graphics objektum, amire rajzolunk
	 * @param s a string
	 * @param x a befoglaló téglalap bal felsõ pontjának x koordinátája
	 * @param y a befoglaló téglalap bal felsõ pontjának y koordinátája
	 * @param width a befoglaló téglalap szélessége
	 * @param height a befoglaló téglalap magassága
	 */
	private void drawString(Graphics g, String s, int x, int y, int width,
			int height) {
		FontMetrics metrics = g.getFontMetrics();
		int strHeight = metrics.getHeight();
		int strWidth = metrics.stringWidth(s);
		g.drawString(s, x + (width - strWidth) / 2, y + (height + strHeight)
				/ 2);
	}

	/**
	 * Paint metódus a menük kirajzolásához.
	 * @param g Graphics objektum, amire rajzolhatunk
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (currMenuItem >= 0) {
			g.setColor(new Color(255, 255, 255));
			g.fillRect(0, currMenuItem * 50, 200, 50);
		}

		g.setColor(Color.BLACK);
		for (int i = 0; i < menus.length; i++) {
			if (currMenuItem == i)
				g.setFont(new Font("Arial", Font.BOLD, 20));
			else
				g.setFont(new Font("Arial", Font.PLAIN, 20));
			drawString(g, menus[i], 0, i * 50, WIDTH, 50);
		}

		g.drawRect(0, 0, 200, 50);
		g.drawRect(0, 50, 200, 50);
		g.drawRect(0, 100, 200, 50);
		g.drawRect(0, 150, 200, 50);
	}

	/**
	 * mouseDragged esemény, ugyanazt kell csinálni, mint a mouseMoved-nál
	 * @param e MouseEvent
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	/**
	 * Lekérjük, hogy melyik menüpont felett haladt el az egér, és újrarajzoltunk
	 * @param e MouseEvent
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getY() >= 0 && e.getY() <= 200)
			currMenuItem = e.getY() / 50;
		else
			currMenuItem = -1;
		repaint();
	}

	/**
	 * Klikk esemény. 
	 * @param e MouseEvent
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		click(e.getY() / 50);
	}

	/**
	 * Új játék indítása egy új frame-ben.
	 */
	private void ujJatek() {
		JFrame frame = new JFrame("Szoftlab 4 torony védés");
		final PalyaComponent comp = new PalyaComponent(new Palya());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(comp);
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				comp.timerStop();
			}
		});
	}

	/**
	 * Ranglista megjelenítése.
	 */
	private void ranglista() {
		Ranglista r = Ranglista.get();
		r.showRanglistaDialog(this.parent);
	}

	/**
	 * Játék betöltése, és egy új frame megnyitása.
	 */
	private void betoltes() {
		ObjectInputStream ois = null;
		try {
			JFrame frame = new JFrame("Szoftlab 4 torony védés");
			ois = new ObjectInputStream(new FileInputStream("mentes.ser"));
			Palya p = (Palya) ois.readObject();

			final PalyaComponent comp = new PalyaComponent(p);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().add(comp);
			frame.pack();
			frame.setVisible(true);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					comp.timerStop();
				}
			});
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Nincs betölthetõ játékállás!", "Hiba", JOptionPane.PLAIN_MESSAGE);
		} catch (ClassNotFoundException e) {
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
				}
		}
	}

	/**
	 * A menün a kattintás lekezelése. A megfelelõ metódus fog elindulni, attól függõen,
	 * hogy melyikre kattintottunk.
	 * @param menuItem A menüelem indexe.
	 */
	private void click(int menuItem) {
		switch (menuItem) {
		case 0: // új játék
			ujJatek();
			break;
		case 1: // betöltés
			betoltes();
			break;
		case 2: // ranglista
			ranglista();
			break;
		case 3:
			parent.setVisible(false);
			parent.dispose();
			break;
		default:
			break;
		}
	}

	/**
	 * MouseEntered esemény - üres
	 * @param e MouseEvent
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * MouseExited esemény - ilyenkor nem szabad, hogy valamelyik menüpont
	 * fehér legyen
	 * @param e MouseEvent
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		currMenuItem = -1;
		repaint();
	}

	/**
	 * Üres metódus - mousePressed
	 * @param e MouseEvent
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * Üres metódus - mouseRelease
	 * @param e MouseEvent
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
