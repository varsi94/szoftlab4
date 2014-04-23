package Ellenseg;

import java.awt.Color;
import java.awt.Graphics;

import Cella.Cella;
import Palya.Palya;
import Torony.ITorony;

/**
 * Ellenségekhez tartozó absztrakt õsosztály
 * 
 * @author Sipka
 * 
 */
public abstract class Kaszt implements IEllenseg {
	private static final long serialVersionUID = -1245802203646608322L;

	/**
	 * Pályára mutató referencia
	 */
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

	/**
	 * Megadja, hogy a kaszt megöléséért mennyi varázserõ jár.
	 */
	protected int jutalom;

	private int startHp;

	/**
	 * Konstruktor
	 * 
	 * @param palya
	 *            pálya referencia
	 * @param speed
	 *            sebesség
	 * @param hp
	 *            életpont
	 * @param utIndex
	 *            út azonosítója
	 * @param cellaIndex
	 *            cella azonosítója
	 */
	public Kaszt(Palya palya, int speed, int hp, int utIndex, int cellaIndex) {
		this.palya = palya;
		this.speed = speed;
		this.kimarad = speed;
		this.hp = hp;
		this.startHp = hp;
		this.utIndex = utIndex;
		this.cellaIndex = cellaIndex;
	}

	/**
	 * HP beállíta a sebzõdés során
	 * 
	 * @param t
	 *            A torony, amelyik lõ
	 */
	@Override
	public final void sebzodik(ITorony t) {
		hp -= getSebzodes(t);
		System.out.println("Kaszt.sebzodik() " + this + " " + hp);
		if (hp <= 0) {
			meghal();
		}
	}

	/**
	 * Sebzõdés lekérdezése
	 * 
	 * @param t
	 *            Torony, amelyik lõ
	 * @return Sebzõdés mértéke
	 */
	protected abstract int getSebzodes(ITorony t);

	/**
	 * Megállító metódus
	 * 
	 * @param utem
	 *            hány ütemre maradjunk ki.
	 */
	@Override
	public final void megall(int utem) {
		kimarad += utem;
	}

	/**
	 * Metódus, ami az ellenség lépését teszi lehetõvé.
	 */
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
		uj.akadalyoz(this);
	}

	/**
	 * Akkor hívódik meg, hogyha meghal az ellenség. Kiveszi a celláról magát, és értesíti a pályát, hogy meghalt.
	 */
	@Override
	public final void meghal() {
		hp = 0;
		final Cella cella = palya.getUtCella(utIndex, cellaIndex);
		cella.kivesz(this);
		palya.meghaltam(this);
	}

	/**
	 * Sebességet visszaadó metódus
	 * 
	 * @return sebesség
	 */
	@Override
	public final int getSpeed() {
		return speed;
	}

	/**
	 * Visszaadja, hogy hány kör múlva jövünk megint
	 * 
	 * @return következõ lépés hány kör múlva lesz
	 */
	@Override
	public final int getKimarad() {
		return kimarad;
	}

	/**
	 * Életpont lekérdezése
	 * 
	 * @return életpont
	 */
	@Override
	public final int getHp() {
		return hp;
	}

	/**
	 * Életpont beállítása
	 * 
	 * @param hp
	 *            az új életpont
	 */
	@Override
	public final void setHp(int hp) {
		this.hp = hp;
		if (hp <= 0) {
			meghal();
		}
	}

	/**
	 * Útindex lekérdezése
	 * 
	 * @return út indexe
	 */
	@Override
	public final int getUtIndex() {
		return utIndex;
	}

	/**
	 * Cella index lekérdezése az úton belül
	 * 
	 * @return Cella indexe
	 */
	@Override
	public final int getCellaIndex() {
		return cellaIndex;
	}

	/**
	 * Másoló metódus
	 * 
	 * @return másolat
	 */
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

	/**
	 * Visszaadja a jutalmat, amit kap a játékos a megölésért.
	 * 
	 * @return a jutalom varázserõben mérve
	 */
	@Override
	public int getJutalom() {
		return jutalom;
	}

	@Override
	public void rajzol(Graphics g, int pixelX, int pixelY, int pixelW, int pixelH) {
		final int[] kasztX = new int[] { pixelX + pixelW / 2, pixelX + pixelW / 4 * 3, pixelX + pixelW / 2, pixelX + pixelW / 4 };
		final int[] kasztY = new int[] { pixelY + pixelH / 4, pixelY + pixelH / 2, pixelY + pixelH / 3 * 4, pixelY + pixelH / 2 };
		g.setColor(getKasztSzin());
		g.fillPolygon(kasztX, kasztY, 4);
		g.setColor(Color.RED);
		g.fillRect(pixelX, pixelY, pixelW, pixelH / 10);
		g.setColor(Color.GREEN);
		float hp = this.hp / (float) startHp;
		if (hp <= 0f) {
			hp = 0f;
		}
		g.fillRect(pixelX, pixelY, Math.round(pixelW * hp), pixelH / 10);
	}

	protected abstract Color getKasztSzin();
}