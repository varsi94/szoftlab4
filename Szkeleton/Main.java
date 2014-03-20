package Szkeleton;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

//ez az osztály tartalmazza a program belépési pontját
//a szkeletonban a kezelõfelület megvalósítása kerül itt implementálásra
public class Main {
	private static BufferedReader in;

	// ez a statikus metódus jelzi ki a szkeleton kezelõfelületének menüjében a
	// választási lehetõségeket
	public static void MenuKiir() {
		// elõször törli a kijelzõt
		Main.KonzolTorles();

		// majd kiírja az egyes választási lehetõségeket
		System.out.println("0  - Új játék");
		System.out.println("1  - Játék betöltése");
		System.out.println("2  - Ranglista megtekintése");
		System.out.println("3  - Játékból kilépés");
		System.out.println("4  - Torony lerakása");
		System.out.println("5  - Torony fejlesztése varázskõvel");
		System.out.println("6  - Akadály lerakása");
		System.out.println("7  - Akadály fejlesztése lila varázskõvel");
		System.out.println("8  - Új kör");
		System.out.println("9  - Játék mentése");
		System.out.println("10 - Torony ellenségre lõ");
		System.out.println("11 - Ellenség sebzõdik");
		System.out.println("12 - Ellenség elpusztul");
		System.out.println("13 - Akadály elpusztítja az ellenséget");
		System.out.println("14 - Akadály eltûnik");
		System.out.println("15 - Akadály lassítja az ellenséget");
		System.out.println("16 - Ellenség lelassítása");
		System.out.println("17 - Ellenség lép");
		System.out.println("18 - Ellenség eléri a hegyet");
		System.out.println("19 - Játék vége");
		System.out.println("20 - Ranglistába írás");

		// ezután egy sorral elválasztva kiírja a felületbõl, s így a
		// szkeletonból való kilépés információit
		System.out.println();
		System.out.println("o  - (Felület Kilépés)");
	}

	// ez a statikus metódus 50 sort léptet, ilymódon "törli" a kijelzõt
	public static void KonzolTorles() {

		// 50 hosszú ciklusban kiírunk üres sorokat
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	// ez a statikus metódus kezeli a menürõl való átmeneteket, átveszi a menüre
	// beírt értéket
	// a visszaadott értékek:
	// 0 - kiírtunk egy funkciót: innen folytatjuk
	// 1 - nem definiált bemenet volt: innen folytatjuk
	// 2 - kilépés funkciót kért: innen folytatjuk
	public static int MenuKezelo(String uzenetSor) {

		// ebben a változóban tároljuk majd a menüben átvett karaktert
		int uzenet;

		// törli a kijelzõt, mivel kiírás lesz ezután
		Main.KonzolTorles();

		// átkasztolja számra (a switch-hez), ha tudja
		try {
			uzenet = Integer.parseInt(uzenetSor);
			// ha nem lehet számmá kasztolni
		} catch (java.lang.NumberFormatException e) {
			try {
				// amennyiben 'o'-val kezdõdik, kilépünk (ez a return 2)
				if (uzenetSor.charAt(0) == 'o') {
					return 2;
					// máskülönben a bemenet nem definiált: vissza a menübe (ez
					// a return 1)
				} else {
					return 1;
				}
				// ha enter jött, arra is lekezeli, majd menübe vissza
			} catch (java.lang.StringIndexOutOfBoundsException ex) {
				return 1;
			}
		}

		// ha sikerült a kaszt, akkor a megfelelõ funkció kerül meghívásra
		switch (uzenet) {
		case 0:
			// **ide a meghívandó függvény neve**
			return 0;
		case 1:
			// **ide a meghívandó függvény neve**
			return 0;
		case 2:
			// **ide a meghívandó függvény neve**
			return 0;
		case 3:
			// **ide a meghívandó függvény neve**
			return 0;
		case 4:
			// **ide a meghívandó függvény neve**
			return 0;
		case 5:
			// **ide a meghívandó függvény neve**
			return 0;
		case 6:
			// **ide a meghívandó függvény neve**
			return 0;
		case 7:
			// **ide a meghívandó függvény neve**
			return 0;
		case 8:
			// **ide a meghívandó függvény neve**
			return 0;
		case 9:
			// **ide a meghívandó függvény neve**
			return 0;
		case 10:
			// **ide a meghívandó függvény neve**
			return 0;
		case 11:
			// **ide a meghívandó függvény neve**
			return 0;
		case 12:
			// **ide a meghívandó függvény neve**
			return 0;
		case 13:
			// **ide a meghívandó függvény neve**
			return 0;
		case 14:
			// **ide a meghívandó függvény neve**
			return 0;
		case 15:
			// **ide a meghívandó függvény neve**
			return 0;
		case 16:
			// **ide a meghívandó függvény neve**
			return 0;
		case 17:
			// **ide a meghívandó függvény neve**
			return 0;
		case 18:
			// **ide a meghívandó függvény neve**
			return 0;
		case 19:
			// **ide a meghívandó függvény neve**
			return 0;
		case 20:
			// **ide a meghívandó függvény neve**
			return 0;
		default:
			// máskülönben nem definiált a kapott szám: vissza a menübe
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
		// kezdetben 'm', hiszen a menübe lép be
		char uzenet = 'm';

		// amíg nem akarunk kilépni, addig kiírjuk a menüt
		while (uzenet == 'm') {
			// kiírja az opciókat
			Main.MenuKiir();

			// beolvassa az üzenetet
			String uzenetSor = new String();

			try {
				uzenetSor = Main.readString();
				// ha nem sikerül, jelez
			} catch (IOException e) {
				System.out.println("Sikertelen a beolvasás, így kilépek");
				break;
			}

			// meghívja a menü kezelõjét a megadott bemenetre
			int opcio = Main.MenuKezelo(uzenetSor);

			// a visszaadott értékek alapján folytatjuk
			switch (opcio) {
			// ez esetben funkciót írtunk ki: új üzenetet beolvasol, majd
			// kiléphetsz, vagy a menübe vissza
			case 0:
				// elsõ karakter lekérdezése
				try {
					uzenetSor = Main.readString();
					uzenet = uzenetSor.charAt(0);
					// ha valami más jött: menübe vissza
				} catch (IOException e) {
					uzenet = 'm';
					// enterre lekezelés: ekkor is menübe vissza
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					uzenet = 'm';
				}

				// ha ki akarunk lépni
				if (uzenet == 'o') {
					// konzolt törli
					Main.KonzolTorles();
					// kilép
					System.exit(0);

					// ha nem kilépni akar: menübe vissza
				} else {
					uzenet = 'm';
				}
				break;
			// ekkor a menübe vissza
			case 1:
				uzenet = 'm';
				break;
			// ekkor ki akarunk lépni
			case 2:
				// kilépés
				System.exit(0);
				break;
			// ilyen opció nem állhat elõ, de ha mégis, akkor menübe vissza
			default:
				uzenet = 'm';

			}
		}

		in.close();
	}
}