package Prototipus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Palya.Palya;

/**
 * Fõprogram
 * @author Hanicz
 *
 */
public class Main {

	private static BufferedReader in;

	/**
	 * Main metódus, a menüt írja ki.
	 * @param args parancssori argumentumok
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("1. Új teszt játék");
			System.out.println("2. Új játék");
			System.out.println("3. Betöltés");
			System.out.println("4. Ranglista");
			System.out.println("5. Kilépés");
			int be;
			try{
				be = Integer.parseInt(in.readLine());
				Bemenet b = new Bemenet();

				switch (be) {
				case 1:
					Palya p = new Palya();
					System.out.println("Teszt név:");
					String teszt = in.readLine();
					b.Kezelo(p,teszt);
					break;
				case 2:
					Palya pj = new Palya();
					pj.motor();
					break;
				case 3:
					b.betolt();
					break;
				case 4:
					b.ranglista();
					break;
				case 5:
					System.exit(0);
					break;
				default: 
					System.out.println("Hibás bemenet!");
					break;
					
				}
			}
			catch(NumberFormatException ex){
				System.out.println("Hibás bemenet!");
			}
		}

	}

}
