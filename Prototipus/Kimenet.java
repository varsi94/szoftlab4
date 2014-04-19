package Prototipus;

import Torony.ITorony;
import Akadaly.IAkadaly;
import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * A kimeneti nyelv �ltal adott eredm�nyek �sszeszedve.
 * 
 * @author Varsi
 * 
 */
public class Kimenet {
	public static void jatekVege() {
		System.out.println("J�t�k v�ge");
	}

	public static void ujEllenseg(IEllenseg e, Cella hova) {
		System.out.println("�j " + e + ": " + hova);
	}

	public static void ujTorony(Cella hova) {
		System.out.println("Sikeres torony lerak�s: " + hova);
	}

	public static void ujAkadaly(IAkadaly a) {
		System.out.println("Sikeres " + a + " lerak�s: " + a.getCella());
	}

	public static void akadalyAktivalodik(IAkadaly a) {
		System.out.println(a + " aktiv�l�dott: " + a.getCella());
	}

	public static void akadalyElpusztul(IAkadaly a) {
		System.out.println(a + " elpuszult: " + a.getCella());
	}

	public static void ellensegElpusztul(IEllenseg ellenseg, Cella hol) {
		System.out.println(ellenseg + " elpusztult: " + hol);
	}

	public static void ellensegLep(IEllenseg ellenseg, Cella hova) {
		System.out.println(ellenseg + " l�pett, �j koordin�t�ja: " + hova);
	}

	public static void ellensegLelassul(IEllenseg ellenseg, Cella hol) {
		System.out.println(ellenseg + " lelassult: " + hol);
	}

	public static void fejlesztes(int ujErtek) {
		System.out
				.println("Sikeres fejleszt�s. Fejlesztett k�pess�g �j �rt�ke: "
						+ ujErtek);
	}

	public static void toronySebez(ITorony t, int eletPont) {
		System.out.println("Torony sebz�s. Megmaradt �letpont: " + eletPont);
	}

	public static void sikertelenTorony() {
		System.out.println("Sikertelen: helytelen cella");
	}

	public static void kodTorony(Cella cella) {
		System.out.println("K�d ezen a tornyon: " + cella.getY() + ","
				+ cella.getX());
	}

	public static void toronyKetszerez() {
		System.out.println("Torony ellens�g k�tszerez�s.");
	}
}
