package Szkeleton;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

//ez az oszt�ly tartalmazza a program bel�p�si pontj�t
//a szkeletonban a kezel�fel�let megval�s�t�sa ker�l itt implement�l�sra
public class Main {
	private static BufferedReader in;

	// ez a statikus met�dus jelzi ki a szkeleton kezel�fel�let�nek men�j�ben a
	// v�laszt�si lehet�s�geket
	public static void MenuKiir() {
		// el�sz�r t�rli a kijelz�t
		Main.KonzolTorles();

		// majd ki�rja az egyes v�laszt�si lehet�s�geket
		System.out.println("0  - �j j�t�k");
		System.out.println("1  - J�t�k bet�lt�se");
		System.out.println("2  - Ranglista megtekint�se");
		System.out.println("3  - J�t�kb�l kil�p�s");
		System.out.println("4  - Torony lerak�sa");
		System.out.println("5  - Torony fejleszt�se var�zsk�vel");
		System.out.println("6  - Akad�ly lerak�sa");
		System.out.println("7  - Akad�ly fejleszt�se lila var�zsk�vel");
		System.out.println("8  - �j k�r");
		System.out.println("9  - J�t�k ment�se");
		System.out.println("10 - Torony ellens�gre l�");
		System.out.println("11 - Ellens�g sebz�dik");
		System.out.println("12 - Ellens�g elpusztul");
		System.out.println("13 - Akad�ly elpuszt�tja az ellens�get");
		System.out.println("14 - Akad�ly elt�nik");
		System.out.println("15 - Akad�ly lass�tja az ellens�get");
		System.out.println("16 - Ellens�g lelass�t�sa");
		System.out.println("17 - Ellens�g l�p");
		System.out.println("18 - Ellens�g el�ri a hegyet");
		System.out.println("19 - J�t�k v�ge");
		System.out.println("20 - Ranglist�ba �r�s");

		// ezut�n egy sorral elv�lasztva ki�rja a fel�letb�l, s �gy a
		// szkeletonb�l val� kil�p�s inform�ci�it
		System.out.println();
		System.out.println("o  - (Fel�let Kil�p�s)");
	}

	// ez a statikus met�dus 50 sort l�ptet, ilym�don "t�rli" a kijelz�t
	public static void KonzolTorles() {

		// 50 hossz� ciklusban ki�runk �res sorokat
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	// ez a statikus met�dus kezeli a men�r�l val� �tmeneteket, �tveszi a men�re
	// be�rt �rt�ket
	// a visszaadott �rt�kek:
	// 0 - ki�rtunk egy funkci�t: innen folytatjuk
	// 1 - nem defini�lt bemenet volt: innen folytatjuk
	// 2 - kil�p�s funkci�t k�rt: innen folytatjuk
	public static int MenuKezelo(String uzenetSor) {

		// ebben a v�ltoz�ban t�roljuk majd a men�ben �tvett karaktert
		int uzenet;

		// t�rli a kijelz�t, mivel ki�r�s lesz ezut�n
		Main.KonzolTorles();

		// �tkasztolja sz�mra (a switch-hez), ha tudja
		try {
			uzenet = Integer.parseInt(uzenetSor);
			// ha nem lehet sz�mm� kasztolni
		} catch (java.lang.NumberFormatException e) {
			try {
				// amennyiben 'o'-val kezd�dik, kil�p�nk (ez a return 2)
				if (uzenetSor.charAt(0) == 'o') {
					return 2;
					// m�sk�l�nben a bemenet nem defini�lt: vissza a men�be (ez
					// a return 1)
				} else {
					return 1;
				}
				// ha enter j�tt, arra is lekezeli, majd men�be vissza
			} catch (java.lang.StringIndexOutOfBoundsException ex) {
				return 1;
			}
		}

		// ha siker�lt a kaszt, akkor a megfelel� funkci� ker�l megh�v�sra
		switch (uzenet) {
		case 0:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 1:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 2:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 3:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 4:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 5:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 6:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 7:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 8:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 9:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 10:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 11:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 12:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 13:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 14:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 15:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 16:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 17:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 18:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 19:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		case 20:
			// **ide a megh�vand� f�ggv�ny neve**
			return 0;
		default:
			// m�sk�l�nben nem defini�lt a kapott sz�m: vissza a men�be
			return 1;
		}
	}

	public static String readString() throws IOException {
		ident();
		return in.readLine();
	}

	public static int readInt() throws IOException {
		while (true) {
			ident();
			try {
				String read = in.readLine();
				try {
					return Integer.parseInt(read);
				} catch (NumberFormatException e) {
				}
			} catch (IOException e) {
				e.printStackTrace();
				return -1;
			}
		}
	}

	public static void log() {
		StackTraceElement e = ident();
		System.out.println(e);
	}

	public static void println(String line) {
		ident();
		System.out.println(line);
	}

	private static StackTraceElement ident() {
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		StringBuilder build = new StringBuilder(stack.length + 64);
		for (int i = 0; i < stack.length - 4; i++) {
			build.append("\t");
		}
		System.out.print(build);
		return stack[3];
	}

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		// kezdetben 'm', hiszen a men�be l�p be
		char uzenet = 'm';

		// am�g nem akarunk kil�pni, addig ki�rjuk a men�t
		while (uzenet == 'm') {
			// ki�rja az opci�kat
			Main.MenuKiir();

			// beolvassa az �zenetet
			String uzenetSor = new String();

			try {
				uzenetSor = Main.readString();
				// ha nem siker�l, jelez
			} catch (IOException e) {
				System.out.println("Sikertelen a beolvas�s, �gy kil�pek");
				break;
			}

			// megh�vja a men� kezel�j�t a megadott bemenetre
			int opcio = Main.MenuKezelo(uzenetSor);

			// a visszaadott �rt�kek alapj�n folytatjuk
			switch (opcio) {
			// ez esetben funkci�t �rtunk ki: �j �zenetet beolvasol, majd
			// kil�phetsz, vagy a men�be vissza
			case 0:
				// els� karakter lek�rdez�se
				try {
					uzenetSor = Main.readString();
					uzenet = uzenetSor.charAt(0);
					// ha valami m�s j�tt: men�be vissza
				} catch (IOException e) {
					uzenet = 'm';
					// enterre lekezel�s: ekkor is men�be vissza
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					uzenet = 'm';
				}

				// ha ki akarunk l�pni
				if (uzenet == 'o') {
					// konzolt t�rli
					Main.KonzolTorles();
					// kil�p
					System.exit(0);

					// ha nem kil�pni akar: men�be vissza
				} else {
					uzenet = 'm';
				}
				break;
			// ekkor a men�be vissza
			case 1:
				uzenet = 'm';
				break;
			// ekkor ki akarunk l�pni
			case 2:
				// kil�p�s
				System.exit(0);
				break;
			// ilyen opci� nem �llhat el�, de ha m�gis, akkor men�be vissza
			default:
				uzenet = 'm';

			}
		}

		in.close();
	}
}