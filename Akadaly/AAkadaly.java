package Akadaly;

import Ellenseg.IEllenseg;
import Szkeleton.Main;

/**
 * Az akadályt implementáló absztrakt osztály
 * 
 */
public abstract class AAkadaly implements IAkadaly {
	/**
	 * Azt tárolja hogy mennyi varázserõbe kerül a megépítése.
	 */
	protected int koltseg;
	/**
	 * Ez az attribútum tárolja hogy hány ellenségre tudja végrehajtani a képességét mielõtt eltûnik.
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
