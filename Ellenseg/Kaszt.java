package Ellenseg;

import Cella.Cella;
import Szkeleton.Main;
import Torony.ITorony;

public abstract class Kaszt implements IEllenseg {
	/**
	 * Az objektum sebességét tartja számon. Ez egy egész típusú érték.
	 */
	private int speed;

	/**
	 * Azt tartja számon hogy mennyi ideig nem léphet az adott objektum. Egész típusú érték.
	 */
	private int kimarad;
	/**
	 * Az objektum életét tartja számon. Ez egy egész típusú érték.
	 */
	private int hp;
	/**
	 * Az útnak az indexét tárolja amin tartózkodik. Egész típus.
	 */
	private int utIndex;
	/**
	 * A cella indexét tárolja. Egész típus.
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
