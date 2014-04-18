package Prototipus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

import Akadaly.AAkadaly;
import Akadaly.Ent;
import Akadaly.IAkadaly;
import Akadaly.Ork;
import Akadaly.Pok;
import Cella.Cella;
import Ellenseg.Ember;
import Ellenseg.Hobbit;
import Ellenseg.IEllenseg;
import Ellenseg.Kaszt;
import Ellenseg.Torp;
import Ellenseg.Tunde;
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
				int[] koords = new int[2];
				koords = p.getUtCellaByKord(Integer.parseInt(splitted[2]),
						Integer.parseInt(splitted[3]));

				if (koords != null) {

					if (splitted[1].equals("tunde")) {
						IEllenseg tunde = new Tunde(p, koords[0], koords[1]);
						p.addEllenseg(tunde, p.getUtbyC(koords[0], koords[1]));
					} else if (splitted[1].equals("ember")) {
						IEllenseg ember = new Ember(p, koords[0], koords[1]);
						p.addEllenseg(ember, p.getUtbyC(koords[0], koords[1]));
					} else if (splitted[1].equals("torp")) {
						IEllenseg torp = new Torp(p, koords[0], koords[1]);
						p.addEllenseg(torp, p.getUtbyC(koords[0], koords[1]));
					} else if (splitted[1].equals("hobbit")) {
						IEllenseg hobbit = new Hobbit(p, koords[0], koords[1]);
						p.addEllenseg(hobbit, p.getUtbyC(koords[0], koords[1]));
					}
				} else
					System.out.println("Sikertelen!");

			}

			else if (splitted[0].equals("akaday")) {
				int[] koords = new int[2];
				koords = p.getUtCellaByKord(Integer.parseInt(splitted[2]),
						Integer.parseInt(splitted[3]));

				if (koords != null) {

					if (splitted[1].equals("ork")) {
						IAkadaly ork = new Ork(p.getUtbyC(koords[0], koords[1]));
						p.akadalytLerak(ork, p.getUtbyC(koords[0], koords[1]));
					} else if (splitted[1].equals("ent")) {
						IAkadaly ent = new Ent(p.getUtbyC(koords[0], koords[1]));
						p.akadalytLerak(ent, p.getUtbyC(koords[0], koords[1]));
					} else if (splitted[1].equals("pok")) {
						IAkadaly pok = new Pok(p.getUtbyC(koords[0], koords[1]));
						p.akadalytLerak(pok, p.getUtbyC(koords[0], koords[1]));
					}
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
		p = new Palya();
		String line;
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("mentes.txt"));
			line = reader.readLine();
			String[] splittedline = line.split("\\s+");
			p.setKor(Integer.parseInt(splittedline[0]));
			p.setPontszam(Integer.parseInt(splittedline[1]));
			reader.close();
		} catch (IOException e) {
			System.out.println("Nincs betöltendõ játék!");
		}

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
