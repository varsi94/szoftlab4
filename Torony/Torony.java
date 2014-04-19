/**
 * 
 */
package Torony;

import Cella.Cella;
import Ellenseg.IEllenseg;
import Palya.Palya;
import Prototipus.Veletlen;

/**
 * 
 * @author Varsi
 * 
 */
public class Torony implements ITorony {
	public static final int KOD_OSZTO_SZAMLALO = 3;
	public static final int KOD_OSZTO_NEVEZO = 5;
	private static final int START_HATOTAV = 2;
	private static final int START_TUZGYAK = 4;
	private String TUZELESI_TIPUS;

	private Palya palya;
	private Cella cella;
	/**
	 * Az egyes ellenfelek elleni sebz�s.
	 */
	private int[] sebzes;
	/**
	 * Hat�t�vols�g.
	 */
	private int hatotav;
	/**
	 * T�zel�si gyakoris�g
	 */
	private int tuzgyak;

	private int korVar;

	private boolean kod;

	/**
	 * Amikor ez megh�v�dik akkor a torony megn�zi hogy a hat�sugar�n bel�l l�v�
	 * cell�kon van-e valaki �s ha van akkor a legk�zelebbi ellens�get megl�vi.
	 */
	@Override
	public void loves() {
		if (--korVar > 0) {
			// nem l�v�nk
			return;
		}
		korVar = tuzgyak;
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

		kulso: for (int i = minx; i <= maxx; i++) {
			for (int j = miny; j <= maxy; j++) {
				final Cella c = palya.getTerkepCella(i, j);
				final IEllenseg ell = c.getRandomEllenseg();
				if (ell == null)
					continue;
				final int hp = ell.getHp();
				if (ell != null) {
					if (TUZELESI_TIPUS.equals("ketszerez")) {
						// duppl�zzuk az ellens�get
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
					} else if (TUZELESI_TIPUS.equals("sima lovedek")) {
						ell.sebzodik(this);
					} else {
						if (Veletlen.duplaLovedek()) {
							// duppl�zzuk az ellens�get
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
						} else {
							ell.sebzodik(this);
						}
					}
					lott = true;
					break kulso;// ellens�g keres�s befejez�se, k�ls� ciklus
								// break
				}
			}
		}
		if (!lott) {
			korVar = 1;
		}
	}

	@Override
	public int getSebzes(int idx) {
		return sebzes[idx];
	}

	@Override
	public void setSebzes(int idx) {
		sebzes[idx]++;
	}

	/**
	 * Konstruktor
	 */
	public Torony(Palya palya, Cella cella, String tipus) {
		this.palya = palya;
		this.cella = cella;
		this.TUZELESI_TIPUS = tipus;
		sebzes = new int[] { 1, 1, 1, 1 };
		hatotav = START_HATOTAV;
		tuzgyak = START_TUZGYAK;
		korVar = tuzgyak;
		System.out.println("Sikeres torony lerak�s: "
				+ cella.getX() + "," + cella.getY());
	}

	@Override
	public final boolean isKod() {
		return kod;
	}

	@Override
	public final void setKod(boolean kod) {
		this.kod = kod;
		System.out.println("K�d ezen a tornyon:" + this.cella.getX() + "," + this.cella.getY());
	}

	@Override
	public String toString() {
		return "[Torony " + cella.getX() + " " + cella.getY() + "]";
	}

	@Override
	public boolean setTuzgyak() {
		if (--tuzgyak == 0) {
			tuzgyak = 0;
			return false;
		}
		return true;
	}

	@Override
	public void setHatotav() {
		hatotav++;
	}
	
	@Override
	public int getTuzgyak(){
		return tuzgyak;
	}
	
	@Override
	public int getHatotav(){
		return hatotav;
	}
	
	@Override
	public int getKoltseg(){
		return KOLTSEG;
	}


}
