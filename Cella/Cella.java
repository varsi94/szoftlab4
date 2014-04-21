package Cella;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Akadaly.IAkadaly;
import Ellenseg.IEllenseg;
import Prototipus.Veletlen;
import Torony.ITorony;

/**
 * Cellát reprezentáló osztály.
 * @author Sipka
 *
 */
public class Cella implements Serializable {
	private static final long serialVersionUID = 7004825596826728002L;
	/**
	 * Az x koordinátája a pontnak.
	 */
	private int x;
	/**
	 * Az y koodinátája a pontnak.
	 */
	private int y;
	/**
	 * Egy lista a rajta tartózkodó ellenségekrõl.
	 */
	private List<IEllenseg> ellensegek;
	/**
	 * Logikai érték hogy a pont egy úton található-e.
	 */
	private boolean uteleme;
	/**
	 * A raja található akadályra mutat.
	 */
	private IAkadaly akadaly;
	/**
	 * A rajta található toronyra mutat.
	 */
	private ITorony torony;

	/**
	 * Konstruktor
	 * @param x A cella x koordinátája
	 * @param y A cella y koordinátája
	 * @param uteleme True, ha út, False, ha nem 
	 */
	public Cella(int x, int y, boolean uteleme) {
		this.x = x;
		this.y = y;
		this.uteleme = uteleme;
		ellensegek = new ArrayList<IEllenseg>();
	}

	/**
	 * Ha új ellenség lép erre a cellára akkor azt belefûzi a listába.
	 * 
	 * @param e
	 */
	public void hozzaad(IEllenseg e) {
		ellensegek.add(e);
	}

	/**
	 * Az adott ellenség kivétele a listából. Akkor hívódik meg a függvény ha egy ellenség elhagyja a cellát.
	 * 
	 * @param e
	 */
	public void kivesz(IEllenseg e) {
		ellensegek.remove(e);
	}

	/**
	 * Az akadály lekérése.
	 * 
	 * @return the akadaly
	 */
	public IAkadaly getAkadaly() {
		return akadaly;
	}

	/**
	 * Az akadály elhelyezése.
	 * 
	 * @param akadaly
	 *            the akadaly to set
	 * @return sikerült-e lerakni az akadályt
	 */
	public boolean setAkadaly(IAkadaly akadaly) {
		if (uteleme) {
			this.akadaly = akadaly;
			return true;
		}
		return false;
	}

	/**
	 * A torony lekérése.
	 * 
	 * @return the torony
	 */
	public ITorony getTorony() {
		return torony;
	}

	/**
	 * A torony lerakása.
	 * 
	 * @param torony
	 *            the torony to set
	 * @return sikerült-e lerakni a tornyot
	 */
	public boolean setTorony(ITorony torony) {
		if (!uteleme) {
			this.torony = torony;
			return true;
		}
		return false;
	}

	/**
	 * A lista lekérése ami a ellenségeket tartalmazza.
	 * 
	 * @return the ellensegek
	 */
	public List<IEllenseg> getEllensegek() {
		return ellensegek;
	}
	
	/**
	 * Út-e
	 * @return True, ha igen, False, ha nem.
	 */
	public final boolean isUteleme() {
		return uteleme;
	}

	/**
	 * A cellán tartózkodó ellenségek közül visszaad egyet.
	 * @return Az ellenség
	 */
	public IEllenseg getRandomEllenseg() {
		final int size = ellensegek.size();
		return size == 0 ? null : ellensegek.get(Veletlen.nextInt(size));
	}

	/**
	 * Kiíráshoz
	 * @return y koordináta, x koordináta
	 */
	@Override
	public String toString() {
		return y + "," + x;
	}

	/**
	 * X koordinátát adja vissza
	 * @return x koordináta
	 */
	public final int getX() {
		return x;
	}

	/**
	 * Y koordinátát adja vissza
	 * @return y koordináta
	 */
	public final int getY() {
		return y;
	}
}
