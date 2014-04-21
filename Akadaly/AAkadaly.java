package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Az akad�lyt implement�l� absztrakt oszt�ly
 * 
 */
public abstract class AAkadaly implements IAkadaly {
	private static final long serialVersionUID = 1390074678693050108L;
	/**
	 * Azt t�rolja hogy mennyi var�zser�be ker�l a meg�p�t�se.
	 */
	protected int koltseg;
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
	public AAkadaly(int koltseg, int hatas, Cella c) {
		this.koltseg = koltseg;
		this.hatas = hatas;
		this.cella = c;
	}

	/**
	 * Akad�lyoz� met�dus
	 * @param e az akad�lyozand� ellens�g
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
	 * K�lts�get visszaad� met�dus.
	 * @return Az akad�ly k�lts�ge
	 */
	@Override
	public final int getKoltseg() {
		return koltseg;
	}
	
	/**
	 * A cell�t lek�rdez� met�dus.
	 * @return Azt a cell�t adja vissza, amelyiken az akad�ly �ll.
	 */
	@Override
	public final Cella getCella() {
		return cella;
	}
	
	/**
	 * Hat�st lek�rdez� met�dus.
	 * @return M�g h�ny ellens�gre tud hatni az akad�ly.
	 */
	public final int getHatas(){
		return hatas;
	}
}
