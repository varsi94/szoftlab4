package Prototipus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Palya.Palya;

/**
 * F�program
 * @author Hanicz
 *
 */
public class Main {

	private static BufferedReader in;

	/**
	 * Main met�dus, a men�t �rja ki.
	 * @param args parancssori argumentumok
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("1. �j teszt j�t�k");
			System.out.println("2. �j j�t�k");
			System.out.println("3. Bet�lt�s");
			System.out.println("4. Ranglista");
			System.out.println("5. Kil�p�s");
			int be;
			try{
				be = Integer.parseInt(in.readLine());
				Bemenet b = new Bemenet();

				switch (be) {
				case 1:
					Palya p = new Palya();
					System.out.println("Teszt n�v:");
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
					System.out.println("Hib�s bemenet!");
					break;
					
				}
			}
			catch(NumberFormatException ex){
				System.out.println("Hib�s bemenet!");
			}
		}

	}

}
