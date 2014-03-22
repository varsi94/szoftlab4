package Cella;

import java.util.List;

import Akadaly.IAkadaly;
import Ellenseg.IEllenseg;
import Szkeleton.Main;
import Torony.ITorony;

public class Cellac {
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
		Main.log();
		this.x = x;
		this.y = y;
		this.uteleme = uteleme;
	}

	/**
	 * Ha új ellenség lép erre a cellára akkor azt belefûzi a listába.
	 * 
	 * @param e
	 */
	public void hozzaad(IEllenseg e) {
		Main.log();
		ellensegek.add(e);
	}

	/**
	 * Az adott ellenség kivétele a listából. Akkor hívódik meg a függvény ha egy ellenség elhagyja a cellát.
	 * 
	 * @param e
	 */
	public void kivesz(IEllenseg e) {
		Main.log();
		ellensegek.remove(e);
	}

	/**
	 * Az akadály lekérése.
	 * 
	 * @return the akadaly
	 */
	public IAkadaly getAkadaly() {
		Main.log();
		return akadaly;
	}

	/**
	 * Az akadály elhelyezése.
	 * 
	 * @param akadaly
	 *            the akadaly to set
	 */
	public void setAkadaly(IAkadaly akadaly) {
		Main.log();
		this.akadaly = akadaly;
	}

	/**
	 * A torony lekérése.
	 * 
	 * @return the torony
	 */
	public ITorony getTorony() {
		Main.log();
		return torony;
	}

	/**
	 * A torony lerakása.
	 * 
	 * @param torony
	 *            the torony to set
	 */
	public void setTorony(ITorony torony) {
		Main.log();
		this.torony = torony;
	}

	/**
	 * A lista lekérése ami a ellenségeket tartalmazza.
	 * 
	 * @return the ellensegek
	 */
	public List<IEllenseg> getEllensegek() {
		Main.log();
		return ellensegek;
	}

}
