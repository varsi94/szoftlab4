/**
 * 
 */
package Torony;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Palya.Palya;
import Prototipus.Kimenet;
import Prototipus.Veletlen;

/**
 * Tornyot reprezentáló osztály
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
	 * Tüzelési típus beállítása
	 */
	private String TUZELESI_TIPUS;

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

	/**
	 * Amikor ez meghívódik akkor a torony megnézi hogy a hatósugarán belül lévõ
	 * cellákon van-e valaki és ha van akkor a legközelebbi ellenséget meglövi.
	 */
	@Override
	public void loves() {
		final int hatotav = kod ? this.hatotav * KOD_OSZTO_SZAMLALO
				/ KOD_OSZTO_NEVEZO : this.hatotav;
		final int x = cella.getX();
		final int y = cella.getY();
		final int minx = x - hatotav < 0 ? 0 : x - hatotav;
		final int maxx = x + hatotav > Palya.PALYA_MAX_X_INDEX ? Palya.PALYA_MAX_X_INDEX
				: x + hatotav;
		final int miny = y - hatotav < 0 ? 0 : y - hatotav;
		final int maxy = y + hatotav > Palya.PALYA_MAX_Y_INDEX ? Palya.PALYA_MAX_Y_INDEX
				: y + hatotav;

		boolean lott = false;
		for (int db = 0; db < tuzgyak; db++) {
			lott = false;
			kulso: for (int i = minx; i <= maxx; i++) {
				for (int j = miny; j <= maxy; j++) {
					final Cella c = palya.getTerkepCella(i, j);
					final IEllenseg ell = c.getRandomEllenseg();
					if (ell == null)
						continue;
					final int hp = ell.getHp();
					if (ell != null) {
						if (TUZELESI_TIPUS == null) {
							if (Veletlen.duplaLovedek()) {
								// dupplázzuk az ellenséget
								Kimenet.toronyKetszerez();
								final IEllenseg uj = ell.clone();
								final IEllenseg uj2 = ell.clone();
								uj.setHp(hp / 2);
								uj2.setHp(hp / 2);
								palya.addEllenseg(
										uj,
										palya.getUtCella(ell.getUtIndex(),
												ell.getCellaIndex()));
								palya.addEllenseg(
										uj2,
										palya.getUtCella(ell.getUtIndex(),
												ell.getCellaIndex()));
								ell.meghal();
								palya.incMaxellen();
								// a meghalás miatt kapunk plusz varázserõt, ezt levonjuk
								palya.setVarazsero(palya.getVarazsero() - ell.getJutalom());
								palya.setPontszam(50);
							} else {
								ell.sebzodik(this);
							}
						}
						else if (TUZELESI_TIPUS.equals("ketszerez")) {
							// dupplázzuk az ellenséget
							System.out.println("Torony ellenség kétszerezés.");
							final IEllenseg uj = ell.clone();
							final IEllenseg uj2 = ell.clone();
							palya.incMaxellen();
							ell.meghal();
							uj.setHp(hp / 2);
							uj2.setHp(hp / 2);
							palya.addEllenseg(
									uj,
									palya.getUtCella(ell.getUtIndex(),
											ell.getCellaIndex()));
							palya.addEllenseg(
									uj2,
									palya.getUtCella(ell.getUtIndex(),
											ell.getCellaIndex()));
							// a meghalás miatt kapunk plusz varázserõt, ezt levonjuk
							palya.setVarazsero(palya.getVarazsero() - ell.getJutalom());
							palya.setPontszam(50);
						} else if (TUZELESI_TIPUS.equals("sebez")) {
							ell.sebzodik(this);
						}
						lott = true;
						break kulso;// ellenség keresés befejezése, külsõ ciklus
									// break
					}
				}
			}
			if (!lott)
				break;
		}
	}

	/**
	 * Sebzés visszaadása
	 * @param idx ellenség indexe
	 * @return sebzés mértéke
	 */
	@Override
	public int getSebzes(int idx) {
		return sebzes[idx];
	}

	/**
	 * Sebzés növelése, fejlesztés esetén
	 * @param idx az ellenség indexe
	 */
	@Override
	public void setSebzes(int idx) {
		palya.setPontszam(35);
		sebzes[idx] += 10;
	}
	
	/**
	 * Konstruktor
	 * @param palya Pályára mutató referencia
	 * @param cella Cellára mutató referencia
	 * @param tipus Milyen tüzelési típussal rendelkezzen a torony
	 */
	public Torony(Palya palya, Cella cella, String tipus) {
		this.palya = palya;
		this.cella = cella;
		this.TUZELESI_TIPUS = tipus;
		sebzes = new int[] { 30, 30, 30, 30 };
		hatotav = START_HATOTAV;
		tuzgyak = START_TUZGYAK;
	}

	/**
	 * köd lekérdezése
	 * @return True, ha van köd, False, ha nincs 
	 */
	@Override
	public final boolean isKod() {
		return kod;
	}

	/**
	 * Köd módosítása
	 * @param kod legyen vagy ne
	 */
	@Override
	public final void setKod(boolean kod) {
		this.kod = kod;
		if(kod) Kimenet.kodTorony(cella);
	}

	/**
	 * Torony toString metódusa - igazából nincs használva, debughoz kellett
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
	 * @return tüzelési gyakoriság
	 */
	@Override
	public int getTuzgyak() {
		return tuzgyak;
	}

	/**
	 * Hatótáv lekérdezése
	 * @return hatótáv
	 */
	@Override
	public int getHatotav() {
		return hatotav;
	}

	/**
	 * Költség lekérdezése
	 * @return költség
	 */
	@Override
	public int getKoltseg() {
		return KOLTSEG;
	}

}
