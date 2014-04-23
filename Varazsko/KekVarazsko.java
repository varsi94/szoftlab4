package Varazsko;

import Torony.ITorony;

/**
 * Var�zsk�, amely a torony t�zel�si gyakoris�g�t n�veli.
 * 
 * @author Varsi
 * 
 */
public class KekVarazsko implements ITVarazsko {
	public static final int KOLTSEG = 150;

	/**
	 * Hat�s kifejt�se
	 * 
	 * @param t
	 *            A C�ltorony
	 * @return Siker�lt-e
	 */
	@Override
	public boolean hat(ITorony t) {
		return t.setTuzgyak();
	}

	/**
	 * Konstruktor
	 */
	public KekVarazsko() {
	}

}
