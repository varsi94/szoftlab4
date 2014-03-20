package Akadaly;

import Ellenseg.IEllenseg;
import Szkeleton.Main;

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

	public AAkadaly(int koltseg, int hatas) {
		Main.log();
		this.koltseg = koltseg;
		this.hatas = hatas;
	}

	@Override
	public abstract boolean akadalyoz(IEllenseg e);

	@Override
	public abstract void fejleszt();

	@Override
	public final int getKoltseg() {
		Main.log();
		return koltseg;
	}

}
