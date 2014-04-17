package Palya;

import java.util.ArrayList;
import java.util.List;

import Akadaly.Ent;
import Akadaly.IAkadaly;
import Cella.Cella;
import Ellenseg.IEllenseg;
import Prototipus.Veletlen;
import Torony.ITorony;
import Torony.Torony;

public class Palya {
	public static final int MAX_ELLENSEGEK_SZAMA = 10;
	private static final int UTAK_SZAMA = 3;
	public static final int PALYA_MAX_X_INDEX = 15;
	public static final int PALYA_MAX_Y_INDEX = 15;

	private Cella hegy;
	private Cella[][] terkep;
	private int varazsero;
	private Cella[][] ut;
	private int kor;
	private List<IEllenseg> ellensegek;
	private List<ITorony> tornyok;
	private List<IAkadaly> akadalyok;

	private int ellensegSzamlalo;

	public void motor() {
		// System.out.println("Palya.motor() " + ellensegSzamlalo);
		loves();
		leptet();

		if (ellensegSzamlalo / 3 < MAX_ELLENSEGEK_SZAMA && ellensegSzamlalo % 3 == 0) {
			// hozzáadunk ellenséget
			final int utindex = Veletlen.nextInt(UTAK_SZAMA);
			final IEllenseg ell = Veletlen.csinaljEllenseget(this, utindex);
			addEllenseg(ell, ut[utindex][0]);
		}
		ellensegSzamlalo++;
		logPalya();
	}

	private void leptet() {
		for (int i = 0; i < ellensegek.size(); i++) {
			final IEllenseg e = ellensegek.get(i);
			final int size = ellensegek.size();
			e.halad();
			if (size < ellensegek.size()) {
				// ha az ellenség meghalt akadály miatt, ne maradjon ki senki a listából
				i--;
			}
		}
	}

	private void loves() {
		for (ITorony t : tornyok) {
			t.loves();
		}
	}

	public boolean tornyotLerak(ITorony t, Cella hova) {
		final boolean result = hova.setTorony(t);
		if (result) {
			tornyok.add(t);
		}
		return result;
	}

	public void addEllenseg(IEllenseg ell, Cella hova) {
		hova.hozzaad(ell);
		ellensegek.add(ell);
		System.out.println("New: " + ell + " at " + hova);
	}

	public boolean akadalytLerak(IAkadaly akadaly, Cella hova) {
		final boolean result = hova.setAkadaly(akadaly);
		if (result) {
			akadalyok.add(akadaly);
		}
		return result;
	}

	public void meghaltam(IEllenseg ell) {
		ellensegek.remove(ell);
	}

	public void meghaltam(IAkadaly a) {
		akadalyok.remove(a);
	}

	/**
	 * @return the varazsero
	 */
	public int getVarazsero() {
		return varazsero;
	}

	/**
	 * @param varazsero
	 *            the varazsero to set
	 */
	public void setVarazsero(int varazsero) {
		this.varazsero = varazsero;
	}

	/**
	 * Vége a játéknak.
	 */
	public void lost() {
	}

	/**
	 * A játékos megnyerte a játékot.
	 */
	public void win() {
	}

	/**
	 * Kör növelése
	 */
	private void korNovel() {
		this.ment();
	}

	/*
	 * Játék mentése. Csak a körök végén.
	 */

	private void ment() {
		System.out.println("ObjectOutputStream.writeObject();");
	}

	/**
	 * Konstruktor
	 */
	public Palya() {
		varazsero = 0;
		kor = 1;
		terkep = csinaljTerkepet();
		ut = csinaljUtat(terkep);
		hegy = adjHegyet(terkep);
		ellensegek = new ArrayList<IEllenseg>();
		tornyok = new ArrayList<ITorony>();
		akadalyok = new ArrayList<IAkadaly>();
		tornyotLerak(new Torony(this, terkep[8][3]), terkep[8][3]);
		tornyotLerak(new Torony(this, terkep[8][4]), terkep[8][4]);
		tornyotLerak(new Torony(this, terkep[7][3]), terkep[7][3]);
		tornyotLerak(new Torony(this, terkep[7][4]), terkep[7][4]);

		akadalytLerak(new Ent(ut[0][8]), ut[0][8]);
	}

	public Cella getUtCella(int utindex, int cellaindex) {
		return ut[utindex][cellaindex];
	}

	public Cella getTerkepCella(int x, int y) {
		return terkep[x][y];
	}

	public boolean isHegyCella(Cella c) {
		return hegy == c;
	}

	public void logPalya() {
		for (int i = 0; i < terkep.length; i++) {
			for (int j = 0; j < terkep[i].length; j++) {
				final Cella c = terkep[i][j];
				if (c.getEllensegek().size() > 0) {
					System.out.print(c.getEllensegek().get(0).getMarkChar());
				} else if (c.getAkadaly() != null) {
					System.out.print("A");
				} else if (c.getTorony() != null) {
					System.out.print("T");
				} else if (c.isUteleme()) {
					System.out.print("+");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static Cella[][] csinaljTerkepet() {
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

	public static Cella adjHegyet(Cella[][] terkep) {
		return terkep[14][14];
	}

	public static Cella[][] csinaljUtat(Cella[][] terkep) {
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
		ut[0][22] = terkep[8][11];
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

}
