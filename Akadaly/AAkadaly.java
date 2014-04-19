package Akadaly;

import Cella.Cella;
import Ellenseg.IEllenseg;

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

	/**
	 * Ez az attribútum tárolja az aktuális cellát;
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
