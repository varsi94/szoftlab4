package Ellenseg;

import Cella.Cella;
import Szkeleton.Main;
import Torony.ITorony;

public abstract class Kaszt implements IEllenseg {
	/**
	 * Az objektum sebess�g�t tartja sz�mon. Ez egy eg�sz t�pus� �rt�k.
	 */
	private int speed;

	/**
	 * Azt tartja sz�mon hogy mennyi ideig nem l�phet az adott objektum. Eg�sz t�pus� �rt�k.
	 */
	private int kimarad;
	/**
	 * Az objektum �let�t tartja sz�mon. Ez egy eg�sz t�pus� �rt�k.
	 */
	private int hp;
	/**
	 * Az �tnak az index�t t�rolja amin tart�zkodik. Eg�sz t�pus.
	 */
	private int utIndex;
	/**
	 * A cella index�t t�rolja. Eg�sz t�pus.
	 */
	private int cellaIndex;

	@Override
	public abstract void sebzodik(ITorony t);

	@Override
	public abstract void megall(int kor);

	@Override
	public abstract void halad(Cella c);

	@Override
	public abstract void meghal();

	@Override
	public int getSpeed() {
		Main.log();
		return speed;
	}

	@Override
	public int getKimarad() {
		Main.log();
		return kimarad;
	}

	@Override
	public int getHp() {
		Main.log();
		return hp;
	}

	@Override
	public int getUtIndex() {
		Main.log();
		return utIndex;
	}

	@Override
	public int getCellaIndex() {
		Main.log();
		return cellaIndex;
	}

}
