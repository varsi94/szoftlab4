package Cella;

import java.util.List;

import Akadaly.IAkadaly;
import Ellenseg.IEllenseg;
import Szkeleton.Main;
import Torony.ITorony;

public class Cellac {
	/**
	 * Az x koordin�t�ja a pontnak.
	 */
	private int x;
	/**
	 * Az y koodin�t�ja a pontnak.
	 */
	private int y;
	/**
	 * Egy lista a rajta tart�zkod� ellens�gekr�l.
	 */
	private List<IEllenseg> ellensegek;
	/**
	 * Logikai �rt�k hogy a pont egy �ton tal�lhat�-e.
	 */
	private boolean uteleme;
	/**
	 * A raja tal�lhat� akad�lyra mutat.
	 */
	private IAkadaly akadaly;
	/**
	 * A rajta tal�lhat� toronyra mutat.
	 */
	private ITorony torony;

	public Cella(int x, int y, boolean uteleme) {
		Main.log();
		this.x = x;
		this.y = y;
		this.uteleme = uteleme;
	}

	/**
	 * Ha �j ellens�g l�p erre a cell�ra akkor azt belef�zi a list�ba.
	 * 
	 * @param e
	 */
	public void hozzaad(IEllenseg e) {
		Main.log();
		ellensegek.add(e);
	}

	/**
	 * Az adott ellens�g kiv�tele a list�b�l. Akkor h�v�dik meg a f�ggv�ny ha egy ellens�g elhagyja a cell�t.
	 * 
	 * @param e
	 */
	public void kivesz(IEllenseg e) {
		Main.log();
		ellensegek.remove(e);
	}

	/**
	 * Az akad�ly lek�r�se.
	 * 
	 * @return the akadaly
	 */
	public IAkadaly getAkadaly() {
		Main.log();
		return akadaly;
	}

	/**
	 * Az akad�ly elhelyez�se.
	 * 
	 * @param akadaly
	 *            the akadaly to set
	 */
	public void setAkadaly(IAkadaly akadaly) {
		Main.log();
		this.akadaly = akadaly;
	}

	/**
	 * A torony lek�r�se.
	 * 
	 * @return the torony
	 */
	public ITorony getTorony() {
		Main.log();
		return torony;
	}

	/**
	 * A torony lerak�sa.
	 * 
	 * @param torony
	 *            the torony to set
	 */
	public void setTorony(ITorony torony) {
		Main.log();
		this.torony = torony;
	}

	/**
	 * A lista lek�r�se ami a ellens�geket tartalmazza.
	 * 
	 * @return the ellensegek
	 */
	public List<IEllenseg> getEllensegek() {
		Main.log();
		return ellensegek;
	}

}
