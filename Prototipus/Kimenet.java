package Prototipus;

import Torony.ITorony;
import Akadaly.IAkadaly;
import Cella.Cella;
import Ellenseg.IEllenseg;

/**
 * A kimeneti nyelv által adott eredmények összeszedve.
 * 
 * @author Varsi
 * 
 */
public class Kimenet {
	public static void jatekVege() {
		System.out.println("Játék vége");
	}

	public static void ujEllenseg(IEllenseg e, Cella hova) {
		System.out.println("Új " + e + ": " + hova);
	}

	public static void ujTorony(Cella hova) {
		System.out.println("Sikeres torony lerakás: " + hova);
	}

	public static void ujAkadaly(IAkadaly a) {
		System.out.println("Sikeres " + a + " lerakás: " + a.getCella());
	}

	public static void akadalyAktivalodik(IAkadaly a) {
		System.out.println(a + " aktiválódott: " + a.getCella());
	}

	public static void akadalyElpusztul(IAkadaly a) {
		System.out.println(a + " elpuszult: " + a.getCella());
	}

	public static void ellensegElpusztul(IEllenseg ellenseg, Cella hol) {
		System.out.println(ellenseg + " elpusztult: " + hol);
	}

	public static void ellensegLep(IEllenseg ellenseg, Cella hova) {
		System.out.println(ellenseg + " lépett, új koordinátája: " + hova);
	}

	public static void ellensegLelassul(IEllenseg ellenseg, Cella hol) {
		System.out.println(ellenseg + " lelassult: " + hol);
	}

	public static void fejlesztes(int ujErtek) {
		System.out
				.println("Sikeres fejlesztés. Fejlesztett képesség új értéke: "
						+ ujErtek);
	}

	public static void toronySebez(ITorony t, int eletPont) {
		System.out.println("Torony sebzés. Megmaradt életpont: " + eletPont);
	}

	public static void sikertelenTorony() {
		System.out.println("Sikertelen: helytelen cella");
	}

	public static void kodTorony(Cella cella) {
		System.out.println("Köd ezen a tornyon: " + cella.getY() + ","
				+ cella.getX());
	}

	public static void toronyKetszerez() {
		System.out.println("Torony ellenség kétszerezés.");
	}
}
