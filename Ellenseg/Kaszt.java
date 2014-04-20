package Ellenseg;

import Cella.Cella;
import Palya.Palya;
import Prototipus.Kimenet;
import Torony.ITorony;

public abstract class Kaszt implements IEllenseg {
	private Palya palya;
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

	public Kaszt(Palya palya, int speed, int hp, int utIndex, int cellaIndex) {
		this.palya = palya;
		this.speed = speed;
		this.kimarad = speed;
		this.hp = hp;
		this.utIndex = utIndex;
		this.cellaIndex = cellaIndex;
	}

	@Override
	public final void sebzodik(ITorony t) {
		hp -= getSebzodes(t);

		Kimenet.toronySebez(t, hp);

		if (hp <= 0) {
			meghal();
		}
	}

	protected abstract int getSebzodes(ITorony t);

	@Override
	public final void megall(int utem) {
		kimarad += utem;
		Cella c = palya.getUtCella(utIndex, cellaIndex);
		Kimenet.ellensegLelassul(this, c);
	}

	@Override
	public final void halad() {
		if (--kimarad > 0) {
			// kimaradunk
			return;
		}

		kimarad = speed;
		final Cella regi = palya.getUtCella(utIndex, cellaIndex);
		final Cella uj = palya.getUtCella(utIndex, ++cellaIndex);
		regi.kivesz(this);
		uj.hozzaad(this);
		Kimenet.ellensegLep(this, uj);
	}

	@Override
	public final void meghal() {
		final Cella cella = palya.getUtCella(utIndex, cellaIndex);
		Kimenet.ellensegElpusztul(this, cella);
		cella.kivesz(this);
		palya.meghaltam(this);
	}

	@Override
	public final int getSpeed() {
		return speed;
	}

	@Override
	public final int getKimarad() {
		return kimarad;
	}

	@Override
	public final int getHp() {
		return hp;
	}

	@Override
	public final void setHp(int hp) {
		this.hp = hp;
		if (hp == 0) {
			meghal();
		}
	}

	@Override
	public final int getUtIndex() {
		return utIndex;
	}

	@Override
	public final int getCellaIndex() {
		return cellaIndex;
	}

	@Override
	public IEllenseg clone() {
		// shallow copy
		try {
			return (IEllenseg) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}