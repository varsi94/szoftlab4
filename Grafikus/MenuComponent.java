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
 * Komponens a men� kirajzol�s�ra.
 * 
 * @author Varsi
 * 
 */
public class MenuComponent extends JComponent implements MouseListener,
		MouseMotionListener {
	/**
	 * A kompnens sz�pess�ge �s magass�ga
	 */
	private static final int HEIGHT = 200;
	private static final int WIDTH = 200;
	private static final long serialVersionUID = 5237335232850181080L;
	/**
	 * Melyik men�pont felett haladt el utolj�ra az eg�r.
	 */
	private int currMenuItem = -1;
	/**
	 * A men�pontok c�mk�i.
	 */
	private String[] menus;
	/**
	 * Sz�l� frame
	 */
	private JFrame parent;

	/**
	 * Konstruktor
	 * @param _parent sz�l� frame
	 */
	public MenuComponent(JFrame _parent) {
		addMouseListener(this);
		addMouseMotionListener(this);
		menus = new String[] { "�j j�t�k", "Bet�lt�s", "Ranglista", "Kil�p�s" };
		parent = _parent;
	}

	/**
	 * A komponens prefer�lt m�ret�t adja vissza.
	 * @return a m�ret
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

	/**
	 * Egy stringet kirajzol� met�dus. Egy t�glalapot adunk meg, aminek a k�zep�re kell rajzolni
	 * a stringet (mind horizont�lisan, mind vertik�lisan.
	 * @param g Graphics objektum, amire rajzolunk
	 * @param s a string
	 * @param x a befoglal� t�glalap bal fels� pontj�nak x koordin�t�ja
	 * @param y a befoglal� t�glalap bal fels� pontj�nak y koordin�t�ja
	 * @param width a befoglal� t�glalap sz�less�ge
	 * @param height a befoglal� t�glalap magass�ga
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
	 * Paint met�dus a men�k kirajzol�s�hoz.
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
	 * mouseDragged esem�ny, ugyanazt kell csin�lni, mint a mouseMoved-n�l
	 * @param e MouseEvent
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	/**
	 * Lek�rj�k, hogy melyik men�pont felett haladt el az eg�r, �s �jrarajzoltunk
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
	 * Klikk esem�ny. 
	 * @param e MouseEvent
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		click(e.getY() / 50);
	}

	/**
	 * �j j�t�k ind�t�sa egy �j frame-ben.
	 */
	private void ujJatek() {
		JFrame frame = new JFrame("Szoftlab 4 torony v�d�s");
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
	 * Ranglista megjelen�t�se.
	 */
	private void ranglista() {
		Ranglista r = Ranglista.get();
		r.showRanglistaDialog(this.parent);
	}

	/**
	 * J�t�k bet�lt�se, �s egy �j frame megnyit�sa.
	 */
	private void betoltes() {
		ObjectInputStream ois = null;
		try {
			JFrame frame = new JFrame("Szoftlab 4 torony v�d�s");
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
			JOptionPane.showMessageDialog(null, "Nincs bet�lthet� j�t�k�ll�s!", "Hiba", JOptionPane.PLAIN_MESSAGE);
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
	 * A men�n a kattint�s lekezel�se. A megfelel� met�dus fog elindulni, att�l f�gg�en,
	 * hogy melyikre kattintottunk.
	 * @param menuItem A men�elem indexe.
	 */
	private void click(int menuItem) {
		switch (menuItem) {
		case 0: // �j j�t�k
			ujJatek();
			break;
		case 1: // bet�lt�s
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
	 * MouseEntered esem�ny - �res
	 * @param e MouseEvent
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * MouseExited esem�ny - ilyenkor nem szabad, hogy valamelyik men�pont
	 * feh�r legyen
	 * @param e MouseEvent
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		currMenuItem = -1;
		repaint();
	}

	/**
	 * �res met�dus - mousePressed
	 * @param e MouseEvent
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * �res met�dus - mouseRelease
	 * @param e MouseEvent
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
