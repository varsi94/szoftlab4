package Grafikus;

import java.awt.Graphics;

/**
 * Interf�sz, aminek implement�l�s�val az objektum kirajzolhat� lesz adott ter�letre
 */
public interface IRajzolhato {
	/**
	 * Adott rajzolhat� objektum kirajzol�sa
	 * 
	 * @param g
	 *            hova rajzoljuk ki
	 * @param pixelX
	 *            hova rajzolhat x koordin�ta
	 * @param pixelY
	 *            hova rajzolhat y koordin�ta
	 * @param pixelW
	 *            milyen sz�less�gben rajzolhat
	 * @param pixelH
	 *            milyen magass�gban rajzolhat
	 */
	public void rajzol(Graphics g, int pixelX, int pixelY, int pixelW, int pixelH);
}
