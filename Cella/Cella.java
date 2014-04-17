package Cella;

import java.util.ArrayList;
import java.util.List;

import Akadaly.IAkadaly;
import Ellenseg.IEllenseg;
import Prototipus.Veletlen;
import Torony.ITorony;

public class Cella implements Iterable<IEllenseg> {
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
		this.x = x;
		this.y = y;
		this.uteleme = uteleme;
		ellensegek = new ArrayList<IEllenseg>();
	}

	/**
	 * Ha �j ellens�g l�p erre a cell�ra akkor azt belef�zi a list�ba.
	 * 
	 * @param e
	 */
	public void hozzaad(IEllenseg e) {
		ellensegek.add(e);
	}

	/**
	 * Az adott ellens�g kiv�tele a list�b�l. Akkor h�v�dik meg a f�ggv�ny ha egy ellens�g elhagyja a cell�t.
	 * 
	 * @param e
	 */
	public void kivesz(IEllenseg e) {
		ellensegek.remove(e);
	}

	/**
	 * Az akad�ly lek�r�se.
	 * 
	 * @return the akadaly
	 */
	public IAkadaly getAkadaly() {
		return akadaly;
	}

	/**
	 * Az akad�ly elhelyez�se.
	 * 
	 * @param akadaly
	 *            the akadaly to set
	 * @return siker�lt-e lerakni az akad�lyt
	 */
	public boolean setAkadaly(IAkadaly akadaly) {
		if (uteleme) {
			this.akadaly = akadaly;
			return true;
		}
		return false;
	}

	/**
	 * A torony lek�r�se.
	 * 
	 * @return the torony
	 */
	public ITorony getTorony() {
		return torony;
	}

	/**
	 * A torony lerak�sa.
	 * 
	 * @param torony
	 *            the torony to set
	 * @return siker�lt-e lerakni a tornyot
	 */
	public boolean setTorony(ITorony torony) {
		if (!uteleme) {
			this.torony = torony;
			return true;
		}
		return false;
	}

	/**
	 * A lista lek�r�se ami a ellens�geket tartalmazza.
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
