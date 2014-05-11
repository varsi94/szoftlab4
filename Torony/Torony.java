/**
 * 
 */
package Torony;

import java.util.ArrayList;
import java.util.List;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Grafikus.Veletlen;
import Palya.Palya;

/**
 * Tornyot reprezentáló osztály
 * 
 * @author Varsi
 * 
 */
public class Torony implements ITorony {
	private static final long serialVersionUID = 2733022368247174757L;
	/**
	 * Ködhöz tartozó kicsinyítõ paraméterek
	 */
	public static final int KOD_OSZTO_SZAMLALO = 3;
	public static final int KOD_OSZTO_NEVEZO = 5;

	/**
	 * Alap hatótávolság: így 5x5-ös négyzet
	 */
	private static final int START_HATOTAV = 2;

	/**
	 * Alap tüzelési gyakoriság: így minden körben egyszer lõ
	 */
	private static final int START_TUZGYAK = 1;

	/**
	 * Pályára mutató referencia
	 */
	private Palya palya;

	/**
	 * A cellára mutató referencia.
	 */
	private Cella cella;
	/**
	 * Az egyes ellenfelek elleni sebzés.
	 */
	private int[] sebzes;
	/**
	 * Hatótávolság.
	 */
	private int hatotav;
	/**
	 * Tüzelési gyakoriság
	 */
	private int tuzgyak;

	/**
	 * Van-e köd.
	 */
	private boolean kod;

	private List<Cella> utolsoLovesek = new ArrayList<Cella>();

	/**
	 * Amikor ez meghívódik akkor a torony megnézi hogy a hatósugarán belül lévõ cellákon van-e valaki és ha van akkor a legközelebbi ellenséget
	 * meglövi.
	 */
	@Override
	public void loves() {
		utolsoLovesek.clear();
		final int hatotav = getHatotav();
		final int x = cella.getX();
		final int y = cella.getY();
		final int minx = x - hatotav < 0 ? 0 : x - hatotav;
		final int maxx = x + hatotav > Palya.PALYA_MAX_X_INDEX ? Palya.PALYA_MAX_X_INDEX : x + hatotav;
		final int miny = y - hatotav < 0 ? 0 : y - hatotav;
		final int maxy = y + hatotav > Palya.PALYA_MAX_Y_INDEX ? Palya.PALYA_MAX_Y_INDEX : y + hatotav;

		int db = tuzgyak;
		kulso: for (int i = minx; i <= maxx; i++) {
			for (int j = miny; j <= maxy; j++) {
				final Cella c = palya.getTerkepCella(i, j);
				final List<IEllenseg> ellensegek = c.getEllensegek();

				int lastindex = ellensegek.size() - 1;
				if (lastindex >= 0) {
					utolsoLovesek.add(c);
				}
				// lastindex azért kell, hogy a duplázott ellenségek-et ne lõjük meg
				for (int k = 0; k <= lastindex; k++) {
					final IEllenseg ell = ellensegek.get(k);
					if (Veletlen.duplaLovedek()) {
						// dupplázzuk az ellenséget
						final int hp = ell.getHp() / 2;
						ell.setHp(hp);
						if (hp > 0) {
							final IEllenseg ujellenseg = ell.clone();
							ujellenseg.setHp(hp);
							palya.addEllenseg(ujellenseg, c);
							palya.setPontszam(50);
						}
					} else {
						ell.sebzodik(this);
					}
					if (ell.getHp() <= 0) {
						// meghalt ellenség
						k--;
						lastindex--;
						// k-t csökkentjük hogy ne maradjon ki ellenség következõ iterációkor
						// lastindex is csökken
					}
					if (--db <= 0) {
						// ha lõttünk elégszer
						break kulso;
					}
				}
			}
		}
	}

	/**
	 * Sebzés visszaadása
	 * 
	 * @param idx
	 *            ellenség indexe
	 * @return sebzés mértéke
	 */
	@Override
	public int getSebzes(int idx) {
		return sebzes[idx];
	}

	/**
	 * Sebzés növelése, fejlesztés esetén
	 * 
	 * @param idx
	 *            az ellenség indexe
	 */
	@Override
	public void setSebzes(int idx) {
		palya.setPontszam(35);
		sebzes[idx] += 10;
	}

	/**
	 * Konstruktor
	 * 
	 * @param palya
	 *            Pályára mutató referencia
	 * @param cella
	 *            Cellára mutató referencia
	 * @param tipus
	 *            Milyen tüzelési típussal rendelkezzen a torony
	 */
	public Torony(Palya palya, Cella cella) {
		this.palya = palya;
		this.cella = cella;
		sebzes = new int[] { 30, 30, 30, 30 };
		hatotav = START_HATOTAV;
		tuzgyak = START_TUZGYAK;
	}

	/**
	 * köd lekérdezése
	 * 
	 * @return True, ha van köd, False, ha nincs
	 */
	@Override
	public final boolean isKod() {
		return kod;
	}

	/**
	 * Köd módosítása
	 * 
	 * @param kod
	 *            legyen vagy ne
	 */
	@Override
	public final void setKod(boolean kod) {
		this.kod = kod;
	}

	/**
	 * Torony toString metódusa - igazából nincs használva, debughoz kellett
	 * 
	 * @return [Torony x y]
	 */
	@Override
	public String toString() {
		return "[Torony " + cella.getX() + " " + cella.getY() + "]";
	}

	@Override
	public boolean setTuzgyak() {
		palya.setPontszam(35);
		tuzgyak++;
		return true;
	}

	/**
	 * Hatótáv fejlesztése
	 */
	@Override
	public void setHatotav() {
		palya.setPontszam(35);
		hatotav++;
	}

	/**
	 * Tüzelési gyakoriság lekérdezése
	 * 
	 * @return tüzelési gyakoriság
	 */
	@Override
	public int getTuzgyak() {
		return tuzgyak;
	}

	/**
	 * Hatótáv lekérdezése
	 * 
	 * @return hatótáv
	 */
	@Override
	public int getHatotav() {
		return kod ? this.hatotav * KOD_OSZTO_SZAMLALO / KOD_OSZTO_NEVEZO : this.hatotav;
	}


	/**
	 * @return the utolsoLovesek
	 */
	@Override
	public List<Cella> getUtolsoLovesek() {
		return utolsoLovesek;
	}
}
