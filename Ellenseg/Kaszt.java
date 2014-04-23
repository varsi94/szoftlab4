package Ellenseg;

import java.awt.Color;
import java.awt.Graphics;

import Cella.Cella;
import Palya.Palya;
import Torony.ITorony;

/**
 * Ellens�gekhez tartoz� absztrakt �soszt�ly
 * 
 * @author Sipka
 * 
 */
public abstract class Kaszt implements IEllenseg {
	private static final long serialVersionUID = -1245802203646608322L;

	/**
	 * P�ly�ra mutat� referencia
	 */
	private Palya palya;
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

	/**
	 * Megadja, hogy a kaszt meg�l�s��rt mennyi var�zser� j�r.
	 */
	protected int jutalom;

	private int startHp;

	/**
	 * Konstruktor
	 * 
	 * @param palya
	 *            p�lya referencia
	 * @param speed
	 *            sebess�g
	 * @param hp
	 *            �letpont
	 * @param utIndex
	 *            �t azonos�t�ja
	 * @param cellaIndex
	 *            cella azonos�t�ja
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
	 * HP be�ll�ta a sebz�d�s sor�n
	 * 
	 * @param t
	 *            A torony, amelyik l�
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
	 * Sebz�d�s lek�rdez�se
	 * 
	 * @param t
	 *            Torony, amelyik l�
	 * @return Sebz�d�s m�rt�ke
	 */
	protected abstract int getSebzodes(ITorony t);

	/**
	 * Meg�ll�t� met�dus
	 * 
	 * @param utem
	 *            h�ny �temre maradjunk ki.
	 */
	@Override
	public final void megall(int utem) {
		kimarad += utem;
	}

	/**
	 * Met�dus, ami az ellens�g l�p�s�t teszi lehet�v�.
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
	 * Akkor h�v�dik meg, hogyha meghal az ellens�g. Kiveszi a cell�r�l mag�t, �s �rtes�ti a p�ly�t, hogy meghalt.
	 */
	@Override
	public final void meghal() {
		hp = 0;
		final Cella cella = palya.getUtCella(utIndex, cellaIndex);
		cella.kivesz(this);
		palya.meghaltam(this);
	}

	/**
	 * Sebess�get visszaad� met�dus
	 * 
	 * @return sebess�g
	 */
	@Override
	public final int getSpeed() {
		return speed;
	}

	/**
	 * Visszaadja, hogy h�ny k�r m�lva j�v�nk megint
	 * 
	 * @return k�vetkez� l�p�s h�ny k�r m�lva lesz
	 */
	@Override
	public final int getKimarad() {
		return kimarad;
	}

	/**
	 * �letpont lek�rdez�se
	 * 
	 * @return �letpont
	 */
	@Override
	public final int getHp() {
		return hp;
	}

	/**
	 * �letpont be�ll�t�sa
	 * 
	 * @param hp
	 *            az �j �letpont
	 */
	@Override
	public final void setHp(int hp) {
		this.hp = hp;
		if (hp <= 0) {
			meghal();
		}
	}

	/**
	 * �tindex lek�rdez�se
	 * 
	 * @return �t indexe
	 */
	@Override
	public final int getUtIndex() {
		return utIndex;
	}

	/**
	 * Cella index lek�rdez�se az �ton bel�l
	 * 
	 * @return Cella indexe
	 */
	@Override
	public final int getCellaIndex() {
		return cellaIndex;
	}

	/**
	 * M�sol� met�dus
	 * 
	 * @return m�solat
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
	 * Visszaadja a jutalmat, amit kap a j�t�kos a meg�l�s�rt.
	 * 
	 * @return a jutalom var�zser�ben m�rve
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