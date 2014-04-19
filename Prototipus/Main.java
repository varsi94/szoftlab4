package Prototipus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Palya.Palya;

public class Main {

	private static BufferedReader in;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1. Új játék");
		System.out.println("2. Betöltés");
		System.out.println("3. Ranglista");
		System.out.println("4. Kilépés");
		
		while (true) {
			int be;
			try{
				be = Integer.parseInt(in.readLine());
				Bemenet b = new Bemenet();

				switch (be) {
				case 1:
					b.Kezelo();
					break;
				case 2:
					b.betolt();
					break;
				case 3:
					b.ranglista();
					break;
				case 4:
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
