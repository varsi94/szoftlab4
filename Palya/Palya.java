package Palya;

import Szkeleton.Main;
import Cella.Cella;

public class Palya {
	private Cella hegy;
	private Cella[][] terkep;
	private int varazsero;
	private Cella[][] ut;
	private int kor;

	public void motor() {
		Main.log();
	}

	/**
	 * @return the varazsero
	 */
	public int getVarazsero() {
		Main.log();
		return varazsero;
	}

	/**
	 * @param varazsero
	 *            the varazsero to set
	 */
	public void setVarazsero(int varazsero) {
		Main.log();
		this.varazsero = varazsero;
	}

}
