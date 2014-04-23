package Akadaly;

import java.awt.Color;
import java.awt.Graphics;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Az akad�lyt implement�l� absztrakt oszt�ly
 * 
 */
public abstract class AAkadaly implements IAkadaly {
	private static final long serialVersionUID = 1390074678693050108L;
	/**
	 * Ez az attrib�tum t�rolja hogy h�ny ellens�gre tudja v�grehajtani a k�pess�g�t miel�tt elt�nik.
	 */
	protected int hatas;

	/**
	 * Ez az attrib�tum t�rolja az aktu�lis cell�t;
	 */
	protected Cella cella;

	/**
	 * Konstruktor
	 */
	public AAkadaly(int hatas, Cella c) {
		this.hatas = hatas;
		this.cella = c;
	}

	/**
	 * Akad�lyoz� met�dus
	 * 
	 * @param e
	 *            az akad�lyozand� ellens�g
	 * @return True, ha m�g �l az akad�ly, false, ha nem
	 */
	@Override
	public abstract boolean akadalyoz(IEllenseg e);

	/**
	 * Fejleszt�si met�dus
	 */
	@Override
	public abstract void fejleszt();

	/**
	 * A cell�t lek�rdez� met�dus.
	 * 
	 * @return Azt a cell�t adja vissza, amelyiken az akad�ly �ll.
	 */
	@Override
	public final Cella getCella() {
		return cella;
	}

	/**
	 * Hat�st lek�rdez� met�dus.
	 * 
	 * @return M�g h�ny ellens�gre tud hatni az akad�ly.
	 */
	@Override
	public final int getHatas() {
		return hatas;
	}

	@Override
	public void rajzol(Graphics g, int pixelX, int pixelY, int pixelW, int pixelH) {
		final int[] akadalyX = new int[] { pixelX, pixelX + pixelW / 4, pixelX + pixelW / 4 * 3, pixelX + pixelW };
		final int[] akadalyY = new int[] { pixelY + pixelH, pixelY + pixelH / 2, pixelY + pixelH / 2, pixelY + pixelH };
		g.setColor(getAkadalyColor());
		g.fillPolygon(akadalyX, akadalyY, 4);
		g.setColor(Color.WHITE);
		g.drawString(hatas + "", pixelX + pixelW / 3, pixelY + pixelH);
	}

	protected abstract Color getAkadalyColor();
}
