/**
 * 
 */
package Szkeleton.Szekvencia;

import Ellenseg.Ember;
import Ellenseg.IEllenseg;
import Torony.ITorony;
import Torony.Torony;


/**
 * Oszt�ly a "torony ellens�gre l�" szekvenci�ra.
 * @author Hanicz
 *
 */
public class ToronyEllensegreLo implements ISzekvencia {

	/**
	 * Ez a met�dus ind�tja el a szekvenci�t.
	 */
	@Override
	public void indit() {
		IEllenseg ember = new Ember();
		ITorony torony = new Torony();
		
		ember.sebzodik(torony);
	}

	/**
	 * Ez a met�dus adja vissza a szekvencia nev�t.
	 * @return Torony ellens�gre l�
	 */
	@Override
	public String getName() {
		return "Torony ellens�gre l�";
	}

}