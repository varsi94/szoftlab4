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
import Ellenseg.*;
import Palya.Palya;
import Ranglista.Ranglista;
import Torony.*;
import Varazsko.*;

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
				return;
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
					System.out.println("Sikeres torony lerak�s: " + splitted[1]
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
						p.addEllenseg(tunde, p.getUtCella(koords[0], koords[1]));
					} else if (splitted[1].equals("ember")) {
						IEllenseg ember = new Ember(p, koords[0], koords[1]);
						p.addEllenseg(ember, p.getUtCella(koords[0], koords[1]));
					} else if (splitted[1].equals("torp")) {
						IEllenseg torp = new Torp(p, koords[0], koords[1]);
						p.addEllenseg(torp, p.getUtCella(koords[0], koords[1]));
					} else if (splitted[1].equals("hobbit")) {
						IEllenseg hobbit = new Hobbit(p, koords[0], koords[1]);
						p.addEllenseg(hobbit,
								p.getUtCella(koords[0], koords[1]));
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
						IAkadaly ork = new Ork(p.getUtCella(koords[0],
								koords[1]));
						p.akadalytLerak(ork, p.getUtCella(koords[0], koords[1]));
					} else if (splitted[1].equals("ent")) {
						IAkadaly ent = new Ent(p.getUtCella(koords[0],
								koords[1]));
						p.akadalytLerak(ent, p.getUtCella(koords[0], koords[1]));
					} else if (splitted[1].equals("pok")) {
						IAkadaly pok = new Pok(p.getUtCella(koords[0],
								koords[1]));
						p.akadalytLerak(pok, p.getUtCella(koords[0], koords[1]));
					}
				}

			}

			else if (splitted[0].equals("varazsko")) {

				if (splitted[1].equals("fekete")) {
					ITVarazsko fekete = new FeketeVarazsko();
					int kolt = fekete.getKoltseg();
					if (p.getVarazsero() < kolt) {
						System.out.println("Nincs el�g var�zser�!");
					} else if (p.getTerkepCella(Integer.parseInt(splitted[2]),
							Integer.parseInt(splitted[3])).getTorony() == null) {
						System.out
								.println("Sikertelen fejleszt�s: rossz c�lpont.");
					} else {
						p.setVarazsero(p.getVarazsero() - kolt);
						fekete.hat(p.getTerkepCella(
								Integer.parseInt(splitted[2]),
								Integer.parseInt(splitted[3])).getTorony());
						System.out
								.println("Sikeres fejleszt�s. Fejlesztett k�pess�g �j �rt�ke: "
										+ p.getTerkepCella(
												Integer.parseInt(splitted[2]),
												Integer.parseInt(splitted[3]))
												.getTorony().getSebzes(2));
					}

				} else if (splitted[1].equals("feher")) {
					ITVarazsko feher = new FeherVarazsko();
					int kolt = feher.getKoltseg();
					if (p.getVarazsero() < kolt) {
						System.out.println("Nincs el�g var�zser�!");
					} else if (p.getTerkepCella(Integer.parseInt(splitted[2]),
							Integer.parseInt(splitted[3])).getTorony() == null) {
						System.out
								.println("Sikertelen fejleszt�s: rossz c�lpont.");
					} else {
						p.setVarazsero(p.getVarazsero() - kolt);
						feher.hat(p.getTerkepCella(
								Integer.parseInt(splitted[2]),
								Integer.parseInt(splitted[3])).getTorony());
						System.out
								.println("Sikeres fejleszt�s. Fejlesztett k�pess�g �j �rt�ke: "
										+ p.getTerkepCella(
												Integer.parseInt(splitted[2]),
												Integer.parseInt(splitted[3]))
												.getTorony().getSebzes(3));
					}

				} else if (splitted[1].equals("piros")) {
					ITVarazsko piros = new PirosVarazsko();
					int kolt = piros.getKoltseg();
					if (p.getVarazsero() < kolt) {
						System.out.println("Nincs el�g var�zser�!");
					} else if (p.getTerkepCella(Integer.parseInt(splitted[2]),
							Integer.parseInt(splitted[3])).getTorony() == null) {
						System.out
								.println("Sikertelen fejleszt�s: rossz c�lpont.");
					} else {
						p.setVarazsero(p.getVarazsero() - kolt);
						piros.hat(p.getTerkepCella(
								Integer.parseInt(splitted[2]),
								Integer.parseInt(splitted[3])).getTorony());
						System.out
								.println("Sikeres fejleszt�s. Fejlesztett k�pess�g �j �rt�ke: "
										+ p.getTerkepCella(
												Integer.parseInt(splitted[2]),
												Integer.parseInt(splitted[3]))
												.getTorony().getHatotav());
					}

				} else if (splitted[1].equals("kek")) {
					ITVarazsko kek = new KekVarazsko();
					int kolt = kek.getKoltseg();
					if (p.getVarazsero() < kolt) {
						System.out.println("Nincs el�g var�zser�!");
					} else if (p.getTerkepCella(Integer.parseInt(splitted[2]),
							Integer.parseInt(splitted[3])).getTorony() == null) {
						System.out
								.println("Sikertelen fejleszt�s: rossz c�lpont.");
					} else {
						p.setVarazsero(p.getVarazsero() - kolt);
						kek.hat(p.getTerkepCella(
								Integer.parseInt(splitted[2]),
								Integer.parseInt(splitted[3])).getTorony());
						System.out
								.println("Sikeres fejleszt�s. Fejlesztett k�pess�g �j �rt�ke: "
										+ p.getTerkepCella(
												Integer.parseInt(splitted[2]),
												Integer.parseInt(splitted[3]))
												.getTorony().getTuzgyak());
					}

				} else if (splitted[1].equals("zold")) {
					ITVarazsko zold = new ZoldVarazsko();
					int kolt = zold.getKoltseg();
					if (p.getVarazsero() < kolt) {
						System.out.println("Nincs el�g var�zser�!");
					} else if (p.getTerkepCella(Integer.parseInt(splitted[2]),
							Integer.parseInt(splitted[3])).getTorony() == null) {
						System.out
								.println("Sikertelen fejleszt�s: rossz c�lpont.");
					} else {
						p.setVarazsero(p.getVarazsero() - kolt);
						zold.hat(p.getTerkepCella(
								Integer.parseInt(splitted[2]),
								Integer.parseInt(splitted[3])).getTorony());
						System.out
								.println("Sikeres fejleszt�s. Fejlesztett k�pess�g �j �rt�ke: "
										+ p.getTerkepCella(
												Integer.parseInt(splitted[2]),
												Integer.parseInt(splitted[3]))
												.getTorony().getSebzes(1));
					}

				} else if (splitted[1].equals("sarga")) {
					ITVarazsko sarga = new SargaVarazsko();
					int kolt = sarga.getKoltseg();
					if (p.getVarazsero() < kolt) {
						System.out.println("Nincs el�g var�zser�!");
					} else if (p.getTerkepCella(Integer.parseInt(splitted[2]),
							Integer.parseInt(splitted[3])).getTorony() == null) {
						System.out
								.println("Sikertelen fejleszt�s: rossz c�lpont.");
					} else {
						p.setVarazsero(p.getVarazsero() - kolt);
						sarga.hat(p.getTerkepCella(
								Integer.parseInt(splitted[2]),
								Integer.parseInt(splitted[3])).getTorony());
						System.out
								.println("Sikeres fejleszt�s. Fejlesztett k�pess�g �j �rt�ke: "
										+ p.getTerkepCella(
												Integer.parseInt(splitted[2]),
												Integer.parseInt(splitted[3]))
												.getTorony().getSebzes(0));
					}

				} else if (splitted[1].equals("lila")) {
					IAVarazsko lila = new LilaVarazsko();
					int kolt = lila.getKoltseg();
					if (p.getVarazsero() < kolt) {
						System.out.println("Nincs el�g var�zser�!");

					} else if (p.getTerkepCella(Integer.parseInt(splitted[2]),
							Integer.parseInt(splitted[3])).getAkadaly() == null) {
						System.out
								.println("Sikertelen fejleszt�s: rossz c�lpont.");
					} else {
						p.setVarazsero(p.getVarazsero() - kolt);
						lila.hat(p.getTerkepCella(
								Integer.parseInt(splitted[2]),
								Integer.parseInt(splitted[3])).getAkadaly());
						System.out
								.println("Sikeres fejleszt�s. Fejlesztett k�pess�g �j �rt�ke: "
										+ p.getTerkepCella(
												Integer.parseInt(splitted[2]),
												Integer.parseInt(splitted[3]))
												.getAkadaly().getHatas());
					}
				}
			}

			else if (splitted[0].equals("kod")) {
				p.getTerkepCella(Integer.parseInt(splitted[1]),
						Integer.parseInt(splitted[2])).getTorony().setKod(true);
			}

			else if (splitted[0].equals("utemleptetes")) {
				for (int i = 0; i < Integer.parseInt(splitted[1]); i++)
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
			System.out.println("Nincs bet�ltend� j�t�k!");
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
			System.out.println("Nem siker�lt a beolvas�s!");
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Nem tal�lhat� ment�s!");
			c.printStackTrace();
		}

		r.kiir();

	}

}
