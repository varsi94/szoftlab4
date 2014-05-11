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
 * Tornyot reprezent�l� oszt�ly
 * 
 * @author Varsi
 * 
 */
public class Torony implements ITorony {
	private static final long serialVersionUID = 2733022368247174757L;
	/**
	 * K�dh�z tartoz� kicsiny�t� param�terek
	 */
	public static final int KOD_OSZTO_SZAMLALO = 3;
	public static final int KOD_OSZTO_NEVEZO = 5;

	/**
	 * Alap hat�t�vols�g: �gy 5x5-�s n�gyzet
	 */
	private static final int START_HATOTAV = 2;

	/**
	 * Alap t�zel�si gyakoris�g: �gy minden k�rben egyszer l�
	 */
	private static final int START_TUZGYAK = 1;

	/**
	 * P�ly�ra mutat� referencia
	 */
	private Palya palya;

	/**
	 * A cell�ra mutat� referencia.
	 */
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

	/**
	 * Van-e k�d.
	 */
	private boolean kod;

	private List<Cella> utolsoLovesek = new ArrayList<Cella>();

	/**
	 * Amikor ez megh�v�dik akkor a torony megn�zi hogy a hat�sugar�n bel�l l�v� cell�kon van-e valaki �s ha van akkor a legk�zelebbi ellens�get
	 * megl�vi.
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
				// lastindex az�rt kell, hogy a dupl�zott ellens�gek-et ne l�j�k meg
				for (int k = 0; k <= lastindex; k++) {
					final IEllenseg ell = ellensegek.get(k);
					if (Veletlen.duplaLovedek()) {
						// duppl�zzuk az ellens�get
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
						// meghalt ellens�g
						k--;
						lastindex--;
						// k-t cs�kkentj�k hogy ne maradjon ki ellens�g k�vetkez� iter�ci�kor
						// lastindex is cs�kken
					}
					if (--db <= 0) {
						// ha l�tt�nk el�gszer
						break kulso;
					}
				}
			}
		}
	}

	/**
	 * Sebz�s visszaad�sa
	 * 
	 * @param idx
	 *            ellens�g indexe
	 * @return sebz�s m�rt�ke
	 */
	@Override
	public int getSebzes(int idx) {
		return sebzes[idx];
	}

	/**
	 * Sebz�s n�vel�se, fejleszt�s eset�n
	 * 
	 * @param idx
	 *            az ellens�g indexe
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
	 *            P�ly�ra mutat� referencia
	 * @param cella
	 *            Cell�ra mutat� referencia
	 * @param tipus
	 *            Milyen t�zel�si t�pussal rendelkezzen a torony
	 */
	public Torony(Palya palya, Cella cella) {
		this.palya = palya;
		this.cella = cella;
		sebzes = new int[] { 30, 30, 30, 30 };
		hatotav = START_HATOTAV;
		tuzgyak = START_TUZGYAK;
	}

	/**
	 * k�d lek�rdez�se
	 * 
	 * @return True, ha van k�d, False, ha nincs
	 */
	@Override
	public final boolean isKod() {
		return kod;
	}

	/**
	 * K�d m�dos�t�sa
	 * 
	 * @param kod
	 *            legyen vagy ne
	 */
	@Override
	public final void setKod(boolean kod) {
		this.kod = kod;
	}

	/**
	 * Torony toString met�dusa - igaz�b�l nincs haszn�lva, debughoz kellett
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
	 * Hat�t�v fejleszt�se
	 */
	@Override
	public void setHatotav() {
		palya.setPontszam(35);
		hatotav++;
	}

	/**
	 * T�zel�si gyakoris�g lek�rdez�se
	 * 
	 * @return t�zel�si gyakoris�g
	 */
	@Override
	public int getTuzgyak() {
		return tuzgyak;
	}

	/**
	 * Hat�t�v lek�rdez�se
	 * 
	 * @return hat�t�v
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
