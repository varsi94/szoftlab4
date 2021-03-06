package Palya;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Akadaly.IAkadaly;
import Cella.Cella;
import Ellenseg.IEllenseg;
import Grafikus.Veletlen;
import Ranglista.Ranglista;
import Torony.ITorony;

/**
 * P�ly�t reprezent�l� oszt�ly
 * 
 * @author Varsi
 */
public class Palya implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Kezdeti var�zser�
	 */
	private static final int KEZDO_VARAZSERO = 300;

	/**
	 * Utak sz�ma
	 */
	private static final int UTAK_SZAMA = 3;

	/**
	 * Maxim�lis index sz�less�gben
	 */
	public static final int PALYA_MAX_X_INDEX = 15;

	/**
	 * Maxim�lis index magass�gban
	 */
	public static final int PALYA_MAX_Y_INDEX = 15;

	/**
	 * A j�t�kos pontsz�ma
	 */
	private int pontszam = 0;

	/**
	 * A hegyhez tartoz� cella
	 */
	private Cella hegy;

	/**
	 * T�rk�p
	 */
	private Cella[][] terkep;

	/**
	 * Aktu�lis var�zser�
	 */
	private int varazsero = KEZDO_VARAZSERO;

	/**
	 * Utak t�mbje.
	 */
	private Cella[][] ut;

	/**
	 * Aktu�lis k�rsz�m
	 */
	private int kor;

	/**
	 * Ellens�gek list�ja
	 */
	private List<IEllenseg> ellensegek;

	/**
	 * Tornyok list�ja
	 */
	private List<ITorony> tornyok;

	/**
	 * V�ge van-e a j�t�knak
	 */
	private boolean jatekvege = false;

	/**
	 * Ellens�gek sz�ma az adott k�rben
	 */
	private int maxellen = 3;

	private int korSzamlalo = 0;

	/**
	 * Konstruktor
	 */
	public Palya() {
		kor = 1;
		terkep = csinaljTerkepet();
		ut = csinaljUtat(terkep);
		hegy = adjHegyet(terkep);
		ellensegek = new ArrayList<IEllenseg>();
		tornyok = new ArrayList<ITorony>();

	}

	/**
	 * Tesztekhez az �tem l�ptet�se. Az�rt van k�l�n, hogy ne gener�l�djanak �j ellens�gek
	 * 
	 * @return V�ge van-e a j�t�knak
	 */
	public boolean utemLep() {
		boolean vege = leptet();
		if (!vege) {
			loves();
		}
		return vege;
	}

	/**
	 * �temet lej�tsz� met�dus. P�ld�nyos�t egy Bemenet objektumot, �gy miel�tt l�ptetne, megk�rdezi a felhaszn�l�t, hogy akar-e valamilyen
	 * interakci�t v�grehajtani.
	 */
	public void motor() {
		if (jatekvege) {
			return;
		}
		korSzamlalo++;

		pontszam += 20 * kor;

		utemLep();
		if (korSzamlalo % 3 == 0 && maxellen > 0) {
			final int utindex = Veletlen.nextInt(UTAK_SZAMA);
			final IEllenseg ell = Veletlen.csinaljEllenseget(this, utindex);
			final Cella c = ut[utindex][0];
			addEllenseg(ell, c);
			c.akadalyoz(ell);
			maxellen--;
		}

		if (maxellen == 0 && ellensegek.size() == 0) {
			korNovel();
			if (kor >= 16) {
				win();
			}
		}
	}

	/**
	 * L�ptetj�k az �sszes ellens�get. Ha el�rte valamelyik a hegyet, akkor megh�vjuk a lost() met�dust
	 * 
	 * @return v�ge-e a j�t�knak
	 */
	private boolean leptet() {
		// nem foreach, halad removeolhat ellensegek kollekci�b�l
		for (int i = 0; i < ellensegek.size(); i++) {
			IEllenseg e = ellensegek.get(i);
			e.halad();

			if (e.getHp() <= 0) {
				i--;
				continue;
			}

			// ha m�g �l, �s eljutott a hegyig
			Cella c = ut[e.getUtIndex()][e.getCellaIndex()];
			if (isHegyCella(c)) {
				lost();
				return true;
			}
		}
		return false;
	}

	/**
	 * L�v�nk az �sszes toronnyal.
	 */
	private void loves() {
		for (ITorony t : tornyok) {
			t.loves();
		}
	}

	/**
	 * Torony lerak�s�t v�gz� met�dus. Ha van m�r ott torony, akkor nem rakjuk le.
	 * 
	 * @param t
	 *            Toronyra mutat� referencia
	 * @param hova
	 *            Cella, ahova le szeretn�nk rakni
	 * @return Siker�lt-e a torony lerak�s
	 */
	public boolean tornyotLerak(ITorony t, Cella hova) {
		if (hova.getTorony() != null) {
			return false;
		}
		final boolean result = hova.setTorony(t);
		if (result) {
			tornyok.add(t);
			pontszam -= 15;
		}
		return result;
	}

	/**
	 * K�d�t ereszt�nk n�h�ny toronyra.
	 */
	private void kodKiosztas() {
		for (ITorony t : tornyok) {
			final boolean kod = Veletlen.kod();
			t.setKod(kod);
			if (kod) {
				pontszam += 25;
			}
		}
	}

	/**
	 * Ellens�get hozz�ad� met�dus
	 * 
	 * @param ell
	 *            Ellens�gre mutat� referencia
	 * @param hova
	 *            Az ellens�g cell�ja
	 */
	public void addEllenseg(IEllenseg ell, Cella hova) {
		hova.hozzaad(ell);
		ellensegek.add(ell);
	}

	/**
	 * Akad�lyt hozz�ad� met�dus, ellen�rizz�k azt is, hogy van-e akad�ly a cell�n.
	 * 
	 * @param akadaly
	 *            Akad�lyra mutat� referencia
	 * @param hova
	 *            Az akad�ly cell�ja
	 * @return False, ha nem siker�lt az akad�ly lerak�sa
	 */
	public boolean akadalytLerak(IAkadaly akadaly, Cella hova) {
		if (hova.getAkadaly() != null) {
			return false;
		}
		final boolean result = hova.setAkadaly(akadaly);
		if (result) {
			pontszam += 15;
		}

		// nem foreach, akad�ly removeolhat ellensegek kollekci�b�l
		List<IEllenseg> hovaEllensegek = hova.getEllensegek();
		for (int i = 0; i < hovaEllensegek.size(); i++) {
			final IEllenseg e = hovaEllensegek.get(i);
			hova.akadalyoz(e);

			if (e.getHp() <= 0) {
				i--;
			}
		}

		return result;
	}

	/**
	 * Ellens�gek h�vj�k meg, hogyha meghaltak. Pontsz�mot n�vel�nk, �s kivessz�k az ellens�gek list�j�b�l
	 * 
	 * @param ell
	 *            A meghalt ellens�g
	 */
	public void meghaltam(IEllenseg ell) {
		ellensegek.remove(ell);
		pontszam += ell.getJutalom() - 10;
		varazsero += ell.getJutalom();
	}

	/**
	 * @return the varazsero
	 */
	public int getVarazsero() {
		return varazsero;
	}

	public void decVarazsero(int koltseg) {
		this.varazsero -= koltseg;
	}

	/**
	 * V�ge a j�t�knak.
	 */
	private void lost() {
		jatekvege = true;
		Ranglista r = Ranglista.get();
		String name = Ranglista.kerdBeAJatekosNevet();

		r.frissit(name, pontszam);
		r.mentes();
	}

	/**
	 * A j�t�kos megnyerte a j�t�kot.
	 */
	private void win() {
		jatekvege = true;
		Ranglista r = Ranglista.get();
		String name = Ranglista.kerdBeAJatekosNevet();

		pontszam += 1.25 * varazsero;

		r.frissit(name, pontszam);
		r.mentes();

	}

	/**
	 * K�r n�vel�se
	 */
	private void korNovel() {
		kodKiosztas();
		this.kor++;
		korSzamlalo = 0;
		maxellen = kor * 3;
		this.ment();
	}

	/**
	 * J�t�k ment�se. Csak a k�r�k v�g�n.
	 */
	private void ment() {
		try {
			String path = System.getProperty("user.dir") + "\\";
			File f1 = new File(path + "mentes.ser");
			if (f1.exists())
				f1.delete();
			FileOutputStream fileOut = new FileOutputStream("mentes.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			System.out.println("Nem siker�lt a ment�s!");
		}

	}

	/**
	 * Egy �tnak az egyik cell�j�t lek�rdez� met�dus
	 * 
	 * @param utindex
	 *            �t indexe
	 * @param cellaindex
	 *            az �ton bel�l a cella indexe
	 * @return a Cella
	 */
	public Cella getUtCella(int utindex, int cellaindex) {
		return ut[utindex][cellaindex];
	}

	/**
	 * A t�rk�p egy cell�j�t adja vissza az x �s y koordin�t�k alapj�n.
	 * 
	 * @param x
	 *            x koordin�ta
	 * @param y
	 *            y koordin�ta
	 * @return a cella
	 */
	public Cella getTerkepCella(int x, int y) {
		return terkep[x][y];
	}

	/**
	 * Megadja, hogy egy cella a hegy-e.
	 * 
	 * @param c
	 *            Cella
	 * @return True, ha a hegy, False, ha nem
	 */
	public boolean isHegyCella(Cella c) {
		return hegy == c;
	}

	/**
	 * Pontsz�m m�dos�t�sa
	 * 
	 * @param x
	 *            az �j pontsz�m
	 */
	public void setPontszam(int x) {
		pontszam += x;
	}

	/**
	 * T�rk�pet l�trehoz� met�dus.
	 * 
	 * @return A t�rk�p k�tdimenzi�s t�mbje.
	 */
	private static Cella[][] csinaljTerkepet() {
		Cella[][] terkep = new Cella[16][16];
		terkep[0][0] = new Cella(0, 0, false);
		terkep[0][1] = new Cella(0, 1, false);
		terkep[0][2] = new Cella(0, 2, false);
		terkep[0][3] = new Cella(0, 3, false);
		terkep[0][4] = new Cella(0, 4, false);
		terkep[0][5] = new Cella(0, 5, false);
		terkep[0][6] = new Cella(0, 6, false);
		terkep[0][7] = new Cella(0, 7, true);
		terkep[0][8] = new Cella(0, 8, false);
		terkep[0][9] = new Cella(0, 9, false);
		terkep[0][10] = new Cella(0, 10, false);
		terkep[0][11] = new Cella(0, 11, false);
		terkep[0][12] = new Cella(0, 12, false);
		terkep[0][13] = new Cella(0, 13, false);
		terkep[0][14] = new Cella(0, 14, false);
		terkep[0][15] = new Cella(0, 15, false);
		terkep[1][0] = new Cella(1, 0, false);
		terkep[1][1] = new Cella(1, 1, false);
		terkep[1][2] = new Cella(1, 2, false);
		terkep[1][3] = new Cella(1, 3, false);
		terkep[1][4] = new Cella(1, 4, false);
		terkep[1][5] = new Cella(1, 5, false);
		terkep[1][6] = new Cella(1, 6, false);
		terkep[1][7] = new Cella(1, 7, true);
		terkep[1][8] = new Cella(1, 8, false);
		terkep[1][9] = new Cella(1, 9, false);
		terkep[1][10] = new Cella(1, 10, false);
		terkep[1][11] = new Cella(1, 11, false);
		terkep[1][12] = new Cella(1, 12, false);
		terkep[1][13] = new Cella(1, 13, false);
		terkep[1][14] = new Cella(1, 14, false);
		terkep[1][15] = new Cella(1, 15, false);
		terkep[2][0] = new Cella(2, 0, false);
		terkep[2][1] = new Cella(2, 1, false);
		terkep[2][2] = new Cella(2, 2, false);
		terkep[2][3] = new Cella(2, 3, false);
		terkep[2][4] = new Cella(2, 4, false);
		terkep[2][5] = new Cella(2, 5, false);
		terkep[2][6] = new Cella(2, 6, false);
		terkep[2][7] = new Cella(2, 7, true);
		terkep[2][8] = new Cella(2, 8, true);
		terkep[2][9] = new Cella(2, 9, true);
		terkep[2][10] = new Cella(2, 10, false);
		terkep[2][11] = new Cella(2, 11, true);
		terkep[2][12] = new Cella(2, 12, true);
		terkep[2][13] = new Cella(2, 13, true);
		terkep[2][14] = new Cella(2, 14, true);
		terkep[2][15] = new Cella(2, 15, false);
		terkep[3][0] = new Cella(3, 0, false);
		terkep[3][1] = new Cella(3, 1, false);
		terkep[3][2] = new Cella(3, 2, false);
		terkep[3][3] = new Cella(3, 3, false);
		terkep[3][4] = new Cella(3, 4, true);
		terkep[3][5] = new Cella(3, 5, true);
		terkep[3][6] = new Cella(3, 6, true);
		terkep[3][7] = new Cella(3, 7, true);
		terkep[3][8] = new Cella(3, 8, false);
		terkep[3][9] = new Cella(3, 9, true);
		terkep[3][10] = new Cella(3, 10, false);
		terkep[3][11] = new Cella(3, 11, true);
		terkep[3][12] = new Cella(3, 12, false);
		terkep[3][13] = new Cella(3, 13, false);
		terkep[3][14] = new Cella(3, 14, true);
		terkep[3][15] = new Cella(3, 15, false);
		terkep[4][0] = new Cella(4, 0, false);
		terkep[4][1] = new Cella(4, 1, false);
		terkep[4][2] = new Cella(4, 2, false);
		terkep[4][3] = new Cella(4, 3, false);
		terkep[4][4] = new Cella(4, 4, true);
		terkep[4][5] = new Cella(4, 5, false);
		terkep[4][6] = new Cella(4, 6, false);
		terkep[4][7] = new Cella(4, 7, false);
		terkep[4][8] = new Cella(4, 8, false);
		terkep[4][9] = new Cella(4, 9, true);
		terkep[4][10] = new Cella(4, 10, true);
		terkep[4][11] = new Cella(4, 11, true);
		terkep[4][12] = new Cella(4, 12, false);
		terkep[4][13] = new Cella(4, 13, false);
		terkep[4][14] = new Cella(4, 14, true);
		terkep[4][15] = new Cella(4, 15, false);
		terkep[5][0] = new Cella(5, 0, false);
		terkep[5][1] = new Cella(5, 1, false);
		terkep[5][2] = new Cella(5, 2, false);
		terkep[5][3] = new Cella(5, 3, false);
		terkep[5][4] = new Cella(5, 4, true);
		terkep[5][5] = new Cella(5, 5, true);
		terkep[5][6] = new Cella(5, 6, false);
		terkep[5][7] = new Cella(5, 7, false);
		terkep[5][8] = new Cella(5, 8, false);
		terkep[5][9] = new Cella(5, 9, false);
		terkep[5][10] = new Cella(5, 10, false);
		terkep[5][11] = new Cella(5, 11, false);
		terkep[5][12] = new Cella(5, 12, false);
		terkep[5][13] = new Cella(5, 13, false);
		terkep[5][14] = new Cella(5, 14, true);
		terkep[5][15] = new Cella(5, 15, false);
		terkep[6][0] = new Cella(6, 0, false);
		terkep[6][1] = new Cella(6, 1, false);
		terkep[6][2] = new Cella(6, 2, false);
		terkep[6][3] = new Cella(6, 3, false);
		terkep[6][4] = new Cella(6, 4, false);
		terkep[6][5] = new Cella(6, 5, true);
		terkep[6][6] = new Cella(6, 6, false);
		terkep[6][7] = new Cella(6, 7, false);
		terkep[6][8] = new Cella(6, 8, false);
		terkep[6][9] = new Cella(6, 9, false);
		terkep[6][10] = new Cella(6, 10, false);
		terkep[6][11] = new Cella(6, 11, false);
		terkep[6][12] = new Cella(6, 12, false);
		terkep[6][13] = new Cella(6, 13, false);
		terkep[6][14] = new Cella(6, 14, true);
		terkep[6][15] = new Cella(6, 15, false);
		terkep[7][0] = new Cella(7, 0, true);
		terkep[7][1] = new Cella(7, 1, true);
		terkep[7][2] = new Cella(7, 2, true);
		terkep[7][3] = new Cella(7, 3, false);
		terkep[7][4] = new Cella(7, 4, false);
		terkep[7][5] = new Cella(7, 5, true);
		terkep[7][6] = new Cella(7, 6, false);
		terkep[7][7] = new Cella(7, 7, false);
		terkep[7][8] = new Cella(7, 8, false);
		terkep[7][9] = new Cella(7, 9, false);
		terkep[7][10] = new Cella(7, 10, false);
		terkep[7][11] = new Cella(7, 11, false);
		terkep[7][12] = new Cella(7, 12, true);
		terkep[7][13] = new Cella(7, 13, true);
		terkep[7][14] = new Cella(7, 14, true);
		terkep[7][15] = new Cella(7, 15, false);
		terkep[8][0] = new Cella(8, 0, false);
		terkep[8][1] = new Cella(8, 1, false);
		terkep[8][2] = new Cella(8, 2, true);
		terkep[8][3] = new Cella(8, 3, false);
		terkep[8][4] = new Cella(8, 4, false);
		terkep[8][5] = new Cella(8, 5, true);
		terkep[8][6] = new Cella(8, 6, false);
		terkep[8][7] = new Cella(8, 7, false);
		terkep[8][8] = new Cella(8, 8, false);
		terkep[8][9] = new Cella(8, 9, false);
		terkep[8][10] = new Cella(8, 10, false);
		terkep[8][11] = new Cella(8, 11, false);
		terkep[8][12] = new Cella(8, 12, true);
		terkep[8][13] = new Cella(8, 13, false);
		terkep[8][14] = new Cella(8, 14, false);
		terkep[8][15] = new Cella(8, 15, false);
		terkep[9][0] = new Cella(9, 0, false);
		terkep[9][1] = new Cella(9, 1, false);
		terkep[9][2] = new Cella(9, 2, true);
		terkep[9][3] = new Cella(9, 3, true);
		terkep[9][4] = new Cella(9, 4, true);
		terkep[9][5] = new Cella(9, 5, true);
		terkep[9][6] = new Cella(9, 6, true);
		terkep[9][7] = new Cella(9, 7, false);
		terkep[9][8] = new Cella(9, 8, false);
		terkep[9][9] = new Cella(9, 9, false);
		terkep[9][10] = new Cella(9, 10, false);
		terkep[9][11] = new Cella(9, 11, true);
		terkep[9][12] = new Cella(9, 12, true);
		terkep[9][13] = new Cella(9, 13, false);
		terkep[9][14] = new Cella(9, 14, false);
		terkep[9][15] = new Cella(9, 15, false);
		terkep[10][0] = new Cella(10, 0, false);
		terkep[10][1] = new Cella(10, 1, false);
		terkep[10][2] = new Cella(10, 2, false);
		terkep[10][3] = new Cella(10, 3, false);
		terkep[10][4] = new Cella(10, 4, false);
		terkep[10][5] = new Cella(10, 5, false);
		terkep[10][6] = new Cella(10, 6, true);
		terkep[10][7] = new Cella(10, 7, false);
		terkep[10][8] = new Cella(10, 8, false);
		terkep[10][9] = new Cella(10, 9, false);
		terkep[10][10] = new Cella(10, 10, false);
		terkep[10][11] = new Cella(10, 11, true);
		terkep[10][12] = new Cella(10, 12, false);
		terkep[10][13] = new Cella(10, 13, false);
		terkep[10][14] = new Cella(10, 14, false);
		terkep[10][15] = new Cella(10, 15, false);
		terkep[11][0] = new Cella(11, 0, false);
		terkep[11][1] = new Cella(11, 1, false);
		terkep[11][2] = new Cella(11, 2, false);
		terkep[11][3] = new Cella(11, 3, false);
		terkep[11][4] = new Cella(11, 4, true);
		terkep[11][5] = new Cella(11, 5, true);
		terkep[11][6] = new Cella(11, 6, true);
		terkep[11][7] = new Cella(11, 7, false);
		terkep[11][8] = new Cella(11, 8, false);
		terkep[11][9] = new Cella(11, 9, false);
		terkep[11][10] = new Cella(11, 10, false);
		terkep[11][11] = new Cella(11, 11, true);
		terkep[11][12] = new Cella(11, 12, true);
		terkep[11][13] = new Cella(11, 13, true);
		terkep[11][14] = new Cella(11, 14, true);
		terkep[11][15] = new Cella(11, 15, false);
		terkep[12][0] = new Cella(12, 0, false);
		terkep[12][1] = new Cella(12, 1, false);
		terkep[12][2] = new Cella(12, 2, false);
		terkep[12][3] = new Cella(12, 3, false);
		terkep[12][4] = new Cella(12, 4, true);
		terkep[12][5] = new Cella(12, 5, false);
		terkep[12][6] = new Cella(12, 6, false);
		terkep[12][7] = new Cella(12, 7, false);
		terkep[12][8] = new Cella(12, 8, false);
		terkep[12][9] = new Cella(12, 9, false);
		terkep[12][10] = new Cella(12, 10, false);
		terkep[12][11] = new Cella(12, 11, false);
		terkep[12][12] = new Cella(12, 12, false);
		terkep[12][13] = new Cella(12, 13, false);
		terkep[12][14] = new Cella(12, 14, true);
		terkep[12][15] = new Cella(12, 15, false);
		terkep[13][0] = new Cella(13, 0, false);
		terkep[13][1] = new Cella(13, 1, false);
		terkep[13][2] = new Cella(13, 2, false);
		terkep[13][3] = new Cella(13, 3, false);
		terkep[13][4] = new Cella(13, 4, true);
		terkep[13][5] = new Cella(13, 5, true);
		terkep[13][6] = new Cella(13, 6, true);
		terkep[13][7] = new Cella(13, 7, true);
		terkep[13][8] = new Cella(13, 8, true);
		terkep[13][9] = new Cella(13, 9, false);
		terkep[13][10] = new Cella(13, 10, false);
		terkep[13][11] = new Cella(13, 11, false);
		terkep[13][12] = new Cella(13, 12, false);
		terkep[13][13] = new Cella(13, 13, false);
		terkep[13][14] = new Cella(13, 14, true);
		terkep[13][15] = new Cella(13, 15, false);
		terkep[14][0] = new Cella(14, 0, false);
		terkep[14][1] = new Cella(14, 1, false);
		terkep[14][2] = new Cella(14, 2, false);
		terkep[14][3] = new Cella(14, 3, false);
		terkep[14][4] = new Cella(14, 4, false);
		terkep[14][5] = new Cella(14, 5, false);
		terkep[14][6] = new Cella(14, 6, false);
		terkep[14][7] = new Cella(14, 7, false);
		terkep[14][8] = new Cella(14, 8, true);
		terkep[14][9] = new Cella(14, 9, true);
		terkep[14][10] = new Cella(14, 10, true);
		terkep[14][11] = new Cella(14, 11, true);
		terkep[14][12] = new Cella(14, 12, true);
		terkep[14][13] = new Cella(14, 13, true);
		terkep[14][14] = new Cella(14, 14, true);
		terkep[14][15] = new Cella(14, 15, false);
		terkep[15][0] = new Cella(15, 0, false);
		terkep[15][1] = new Cella(15, 1, false);
		terkep[15][2] = new Cella(15, 2, false);
		terkep[15][3] = new Cella(15, 3, false);
		terkep[15][4] = new Cella(15, 4, false);
		terkep[15][5] = new Cella(15, 5, false);
		terkep[15][6] = new Cella(15, 6, false);
		terkep[15][7] = new Cella(15, 7, false);
		terkep[15][8] = new Cella(15, 8, false);
		terkep[15][9] = new Cella(15, 9, false);
		terkep[15][10] = new Cella(15, 10, false);
		terkep[15][11] = new Cella(15, 11, false);
		terkep[15][12] = new Cella(15, 12, false);
		terkep[15][13] = new Cella(15, 13, false);
		terkep[15][14] = new Cella(15, 14, false);
		terkep[15][15] = new Cella(15, 15, false);

		return terkep;
	}

	/**
	 * Hegyet visszaad� met�dus
	 * 
	 * @param terkep
	 *            T�rk�p
	 * @return Cella, ami a hegy lesz
	 */
	private static Cella adjHegyet(Cella[][] terkep) {
		return terkep[14][14];
	}

	/**
	 * Utak l�trehoz�sa
	 * 
	 * @param terkep
	 *            T�rk�p
	 * @return Az utak k�tdimenzi�s t�mbje
	 */
	private static Cella[][] csinaljUtat(Cella[][] terkep) {
		Cella[][] ut = new Cella[3][];
		ut[0] = new Cella[32];
		ut[0][0] = terkep[0][7];
		ut[0][1] = terkep[1][7];
		ut[0][2] = terkep[2][7];
		ut[0][3] = terkep[2][8];
		ut[0][4] = terkep[2][9];
		ut[0][5] = terkep[3][9];
		ut[0][6] = terkep[4][9];
		ut[0][7] = terkep[4][10];
		ut[0][8] = terkep[4][11];
		ut[0][9] = terkep[3][11];
		ut[0][10] = terkep[2][11];
		ut[0][11] = terkep[2][12];
		ut[0][12] = terkep[2][13];
		ut[0][13] = terkep[2][14];
		ut[0][14] = terkep[3][14];
		ut[0][15] = terkep[4][14];
		ut[0][16] = terkep[5][14];
		ut[0][17] = terkep[6][14];
		ut[0][18] = terkep[7][14];
		ut[0][19] = terkep[7][13];
		ut[0][20] = terkep[7][12];
		ut[0][21] = terkep[8][12];
		ut[0][22] = terkep[9][12];
		ut[0][23] = terkep[9][11];
		ut[0][24] = terkep[10][11];
		ut[0][25] = terkep[11][11];
		ut[0][26] = terkep[11][12];
		ut[0][27] = terkep[11][13];
		ut[0][28] = terkep[11][14];
		ut[0][29] = terkep[12][14];
		ut[0][30] = terkep[13][14];
		ut[0][31] = terkep[14][14];

		ut[1] = new Cella[32];
		ut[1][0] = terkep[0][7];
		ut[1][1] = terkep[1][7];
		ut[1][2] = terkep[2][7];
		ut[1][3] = terkep[3][7];
		ut[1][4] = terkep[3][6];
		ut[1][5] = terkep[3][5];
		ut[1][6] = terkep[3][4];
		ut[1][7] = terkep[4][4];
		ut[1][8] = terkep[5][4];
		ut[1][9] = terkep[5][5];
		ut[1][10] = terkep[6][5];
		ut[1][11] = terkep[7][5];
		ut[1][12] = terkep[8][5];
		ut[1][13] = terkep[9][5];
		ut[1][14] = terkep[9][6];
		ut[1][15] = terkep[10][6];
		ut[1][16] = terkep[11][6];
		ut[1][17] = terkep[11][5];
		ut[1][18] = terkep[11][4];
		ut[1][19] = terkep[12][4];
		ut[1][20] = terkep[13][4];
		ut[1][21] = terkep[13][5];
		ut[1][22] = terkep[13][6];
		ut[1][23] = terkep[13][7];
		ut[1][24] = terkep[13][8];
		ut[1][25] = terkep[14][8];
		ut[1][26] = terkep[14][9];
		ut[1][27] = terkep[14][10];
		ut[1][28] = terkep[14][11];
		ut[1][29] = terkep[14][12];
		ut[1][30] = terkep[14][13];
		ut[1][31] = terkep[14][14];

		ut[2] = new Cella[26];
		ut[2][0] = terkep[7][0];
		ut[2][1] = terkep[7][1];
		ut[2][2] = terkep[7][2];
		ut[2][3] = terkep[8][2];
		ut[2][4] = terkep[9][2];
		ut[2][5] = terkep[9][3];
		ut[2][6] = terkep[9][4];
		ut[2][7] = terkep[9][5];
		ut[2][8] = terkep[9][6];
		ut[2][9] = terkep[10][6];
		ut[2][10] = terkep[11][6];
		ut[2][11] = terkep[11][5];
		ut[2][12] = terkep[11][4];
		ut[2][13] = terkep[12][4];
		ut[2][14] = terkep[13][4];
		ut[2][15] = terkep[13][5];
		ut[2][16] = terkep[13][6];
		ut[2][17] = terkep[13][7];
		ut[2][18] = terkep[13][8];
		ut[2][19] = terkep[14][8];
		ut[2][20] = terkep[14][9];
		ut[2][21] = terkep[14][10];
		ut[2][22] = terkep[14][11];
		ut[2][23] = terkep[14][12];
		ut[2][24] = terkep[14][13];
		ut[2][25] = terkep[14][14];
		return ut;
	}

	/**
	 * @return the kor
	 */
	public int getKor() {
		return kor;
	}

	// lehetne igy is, de a torony hat�t�v miatt, jobb ha a PalyaComponent kezeli
	// @Override
	// public void rajzol(Graphics g, int pixelX, int pixelY, int pixelW, int pixelH) {
	// // TODO Auto-generated method stub
	// final int w = (pixelW) / (PALYA_MAX_X_INDEX + 1);
	// final int h = (pixelH) / (PALYA_MAX_Y_INDEX + 1);
	// for (int x = 0; x <= PALYA_MAX_X_INDEX; x++) {
	// for (int y = 0; y <= PALYA_MAX_Y_INDEX; y++) {
	// terkep[x][y].rajzol(g, x * w, y * h, w, h);
	// g.setColor(Color.BLACK);
	// g.drawLine(x * w, y * h, (x + 1) * w, y * h);
	// g.drawLine(x * w, y * h, x * w, (y + 1) * h);
	// }
	// }
	// }
}
