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

import Palya.Palya;
import Ranglista.Ranglista;

/**
 * Komponens a menü kirajzolására.
 * @author Varsi
 *
 */
public class MenuComponent extends JComponent implements MouseListener, MouseMotionListener {
	private static final int HEIGHT = 200;
	private static final int WIDTH = 200;
	private static final long serialVersionUID = 5237335232850181080L;
	private int currMenuItem = -1;
	private String[] menus;
	private JFrame parent;
	public MenuComponent(JFrame _parent) {
		this.addMouseListener(this);
		addMouseMotionListener(this);
		menus = new String[] {
			"Új játék", "Betöltés", "Ranglista", "Kilépés"
		};
		parent = _parent;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
	
	private void drawString(Graphics g, String s, int x, int y, int width, int height) {
		FontMetrics metrics = g.getFontMetrics();
		int strHeight = metrics.getHeight();
		int strWidth = metrics.stringWidth(s);
		g.drawString(s, x + (width-strWidth) / 2, y + (height + strHeight) / 2);
	}
	
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
			drawString(g, menus[i], 0, i*50, WIDTH, 50);
		}
		
		g.drawRect(0, 0, 200, 50);
		g.drawRect(0, 50, 200, 50);
		g.drawRect(0, 100, 200, 50);
		g.drawRect(0, 150, 200, 50);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getY() >= 0 && e.getY() <= 200)
			currMenuItem = e.getY() / 50;
		else
			currMenuItem = -1;
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		click(e.getY() / 50);
	}
	
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
	
	private void ranglista() {
		Ranglista r = Ranglista.get();
		r.showRanglistaDialog(this.parent);
	}

	private void betoltes() {
		ObjectInputStream ois = null;
		try {
			JFrame frame = new JFrame("Szoftlab 4 torony védés");
			ois = new ObjectInputStream(new FileInputStream("mentes.ser"));
			Palya p = (Palya)ois.readObject();
			
			final PalyaComponent comp = new PalyaComponent(p);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(comp);
			frame.pack();
			frame.setVisible(true);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					comp.timerStop();
				}
			});
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
				}
		}
	}
	
	private void click(int menuItem) {
		switch (menuItem) {
		case 0:										// új játék
			ujJatek();
			break;
		case 1:										// betöltés
			betoltes();
			break;
		case 2:										// ranglista
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


	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		currMenuItem = -1;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
