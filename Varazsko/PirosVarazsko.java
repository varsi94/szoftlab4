package Varazsko;

import Torony.ITorony;

/**
 * Var�zsk�, mely egy torony hat�t�vols�g�t n�veli.Csak toronyra lehet r�helyezni.
 * 
 * @author Varsi
 * 
 */
public class PirosVarazsko implements ITVarazsko {
	public static final int KOLTSEG = 220;

	/**
	 * /** Hat�s kifejt�se
	 * 
	 * @param t
	 *            a c�ltorony
	 * @return Siker�lt-e
	 */
	@Override
	public boolean hat(ITorony t) {
		t.setHatotav();
		return true;
	}

}
