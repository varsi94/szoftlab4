package Grafikus;

import java.awt.Graphics;

/**
 * Interfész, aminek implementálásával az objektum kirajzolható lesz adott területre
 */
public interface IRajzolhato {
	/**
	 * Adott rajzolható objektum kirajzolása
	 * 
	 * @param g
	 *            hova rajzoljuk ki
	 * @param pixelX
	 *            hova rajzolhat x koordináta
	 * @param pixelY
	 *            hova rajzolhat y koordináta
	 * @param pixelW
	 *            milyen szélességben rajzolhat
	 * @param pixelH
	 *            milyen magasságban rajzolhat
	 */
	public void rajzol(Graphics g, int pixelX, int pixelY, int pixelW, int pixelH);
}
