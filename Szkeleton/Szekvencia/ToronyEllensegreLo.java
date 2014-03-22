/**
 * 
 */
package Szkeleton.Szekvencia;

import Ellenseg.Ember;
import Ellenseg.IEllenseg;
import Torony.ITorony;
import Torony.Torony;


/**
 * Osztály a "torony ellenségre lõ" szekvenciára.
 * @author Hanicz
 *
 */
public class ToronyEllensegreLo implements ISzekvencia {

	/**
	 * Ez a metódus indítja el a szekvenciát.
	 */
	@Override
	public void indit() {
		IEllenseg ember = new Ember();
		ITorony torony = new Torony();
		
		ember.sebzodik(torony);
	}

	/**
	 * Ez a metódus adja vissza a szekvencia nevét.
	 * @return Torony ellenségre lõ
	 */
	@Override
	public String getName() {
		return "Torony ellenségre lõ";
	}

}