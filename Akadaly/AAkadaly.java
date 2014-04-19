package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * Az akad�lyt implement�l� absztrakt oszt�ly
 * 
 */
public abstract class AAkadaly implements IAkadaly {
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

	public AAkadaly(int koltseg, int hatas, Cella c) {
		this.koltseg = koltseg;
		this.hatas = hatas;
		this.cella = c;
	}

	@Override
	public abstract boolean akadalyoz(IEllenseg e);

	@Override
	public abstract void fejleszt();

	@Override
	public final int getKoltseg() {
		return koltseg;
	}

	@Override
	public final Cella getCella() {
		return cella;
	}
	
	public final int getHatas(){
		return hatas;
	}
}
