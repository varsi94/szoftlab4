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
 * 
 * @author Varsi
 * 
 */
public class Torony implements ITorony {
	private static final long serialVersionUID = 2733022368247174757L;
	public static final int KOD_OSZTO_SZAMLALO = 3;
	public static final int KOD_OSZTO_NEVEZO = 5;
	private static final int START_HATOTAV = 2;
	private static final int START_TUZGYAK = 1;
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

	private boolean kod;

	/**
	 * Amikor ez megh�v�dik akkor a torony megn�zi hogy a hat�sugar�n bel�l l�v�
	 * cell�kon van-e valaki �s ha van akkor a legk�zelebbi ellens�get megl�vi.
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
								// duppl�zzuk az ellens�get
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
							} else {
								ell.sebzodik(this);
							}
						}
						else if (TUZELESI_TIPUS.equals("ketszerez")) {
							// duppl�zzuk az ellens�get
							System.out.println("Torony ellens�g k�tszerez�s.");
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
						} else if (TUZELESI_TIPUS.equals("sebez")) {
							ell.sebzodik(this);
						}
						lott = true;
						break kulso;// ellens�g keres�s befejez�se, k�ls� ciklus
									// break
					}
				}
			}
			if (!lott)
				break;
		}
	}

	@Override
	public int getSebzes(int idx) {
		return sebzes[idx];
	}

	@Override
	public void setSebzes(int idx) {
		sebzes[idx] += 10;
	}

	/**
	 * Konstruktor
	 */
	public Torony(Palya palya, Cella cella, String tipus) {
		this.palya = palya;
		this.cella = cella;
		this.TUZELESI_TIPUS = tipus;
		sebzes = new int[] { 30, 30, 30, 30 };
		hatotav = START_HATOTAV;
		tuzgyak = START_TUZGYAK;
	}

	@Override
	public final boolean isKod() {
		return kod;
	}

	@Override
	public final void setKod(boolean kod) {
		this.kod = kod;
		Kimenet.kodTorony(cella);
	}

	@Override
	public String toString() {
		return "[Torony " + cella.getX() + " " + cella.getY() + "]";
	}

	@Override
	public boolean setTuzgyak() {
		tuzgyak++;
		return true;
	}

	@Override
	public void setHatotav() {
		hatotav++;
	}

	@Override
	public int getTuzgyak() {
		return tuzgyak;
	}

	@Override
	public int getHatotav() {
		return hatotav;
	}

	@Override
	public int getKoltseg() {
		return KOLTSEG;
	}

}
