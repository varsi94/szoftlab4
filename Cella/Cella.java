package Cella;

import java.util.ArrayList;
import java.util.List;

import Akadaly.IAkadaly;
import Ellenseg.IEllenseg;
import Prototipus.Veletlen;
import Torony.ITorony;

public class Cella implements Iterable<IEllenseg> {
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

	public final boolean isUteleme() {
		return uteleme;
	}

	@Override
	public java.util.Iterator<IEllenseg> iterator() {
		return ellensegek.iterator();
	}

	public IEllenseg getRandomEllenseg() {
		final int size = ellensegek.size();
		return size == 0 ? null : ellensegek.get(Veletlen.nextInt(size));
	}

	@Override
	public String toString() {
		return "[Cella " + x + " " + y + "]";
	}

	public final int getX() {
		return x;
	}

	public final int getY() {
		return y;
	}
}
