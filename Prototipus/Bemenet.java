package Prototipus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

import Palya.Palya;
import Ranglista.Ranglista;
import Torony.ITorony;
import Torony.Torony;

public class Bemenet {

	private static BufferedReader in;
	private Palya p;
	private String tipus;

	public Bemenet() {
	}

	public void Kezelo() throws IOException {

		p = new Palya();

		while (true) {

			in = new BufferedReader(new InputStreamReader(System.in));
			String unsplitted = in.readLine();
			String[] splitted = unsplitted.split("\\s+");

			if (splitted[0].equals("kilepes")) {
				System.exit(0);
			}

			else if (splitted[0].equals("torony")) {

				if (splitted.length < 4)
					tipus = null;
				else
					tipus = splitted[3];

				boolean res = p.tornyotLerak(
						new Torony(p, p.getTerkepCella(
								Integer.parseInt(splitted[1]),
								Integer.parseInt(splitted[2])), tipus),
						p.getTerkepCella(Integer.parseInt(splitted[1]),
								Integer.parseInt(splitted[2])));
				if (res)
					System.out.println("Sikeres torony lerakás: " + splitted[1]
							+ "," + splitted[2]);
				else
					System.out.println("Sikertelen.");
			}

			else if (splitted[0].equals("ellenseg")) {
				if (splitted[1].equals("tunde")) {

				} else if (splitted[1].equals("ember")) {

				} else if (splitted[1].equals("torp")) {

				} else if (splitted[1].equals("hobbit")) {

				}

			}

			else if (splitted[0].equals("akaday")) {
				if (splitted[1].equals("ork")) {

				} else if (splitted[1].equals("ent")) {

				} else if (splitted[1].equals("pok")) {

				}

			}

			else if (splitted[0].equals("varazsko")) {
				if (splitted[1].equals("fekete")) {

				} else if (splitted[1].equals("feher")) {

				} else if (splitted[1].equals("piros")) {

				} else if (splitted[1].equals("kek")) {

				} else if (splitted[1].equals("zold")) {

				} else if (splitted[1].equals("sarga")) {

				} else if (splitted[1].equals("lila")) {

				}
			}

			else if (splitted[0].equals("kod")) {

			}

			else if (splitted[0].equals("utemleptetes")) {
				p.leptet();
			}

		}
	}

	public void betolt() {

	}

	public void ranglista() {
		Ranglista r = new Ranglista();
		
		try {
			FileInputStream fileIn = new FileInputStream("mittomen.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			r = (Ranglista) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			System.out.println("Nem sikerült a beolvasás!");
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Nem található mentés!");
			c.printStackTrace();
		}
		
		r.kiir();

	}

}
