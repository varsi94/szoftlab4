package Prototipus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

import Akadaly.Ent;
import Akadaly.IAkadaly;
import Akadaly.Ork;
import Akadaly.Pok;
import Ellenseg.Ember;
import Ellenseg.Hobbit;
import Ellenseg.IEllenseg;
import Ellenseg.Torp;
import Ellenseg.Tunde;
import Palya.Palya;
import Ranglista.Ranglista;
import Torony.ITorony;
import Torony.Torony;
import Varazsko.FeherVarazsko;
import Varazsko.FeketeVarazsko;
import Varazsko.IAVarazsko;
import Varazsko.ITVarazsko;
import Varazsko.KekVarazsko;
import Varazsko.LilaVarazsko;
import Varazsko.PirosVarazsko;
import Varazsko.SargaVarazsko;
import Varazsko.ZoldVarazsko;

public class Bemenet {

	private static BufferedReader in;
	private Palya p;
	private String tipus;

	public Bemenet() {
	}

	public void Kezelo(Palya p) throws IOException {

		// hogy mindent sikerüljön lerakni
		p.setVarazsero(Integer.MAX_VALUE);

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
				try {
					ITorony t = new Torony(p, p.getTerkepCella(
							Integer.parseInt(splitted[2]),
							Integer.parseInt(splitted[1])), tipus);
					p.tornyotLerak(t, p.getTerkepCella(
							Integer.parseInt(splitted[2]),
							Integer.parseInt(splitted[1])));
				} catch (NumberFormatException ex) {
					System.out.println("Hibás bemenet!");

				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Hibás bemenet!");
				}
			}

			else if (splitted[0].equals("ellenseg")) {
				try {
					int[] koords = new int[2];
					koords = p.getUtCellaByKord(Integer.parseInt(splitted[3]),
							Integer.parseInt(splitted[2]));

					if (koords != null) {

						if (splitted[1].equals("tunde")) {
							IEllenseg tunde = new Tunde(p, koords[0], koords[1]);
							p.addEllenseg(tunde,
									p.getUtCella(koords[0], koords[1]));
						} else if (splitted[1].equals("ember")) {
							IEllenseg ember = new Ember(p, koords[0], koords[1]);
							p.addEllenseg(ember,
									p.getUtCella(koords[0], koords[1]));
						} else if (splitted[1].equals("torp")) {
							IEllenseg torp = new Torp(p, koords[0], koords[1]);
							p.addEllenseg(torp,
									p.getUtCella(koords[0], koords[1]));
						} else if (splitted[1].equals("hobbit")) {
							IEllenseg hobbit = new Hobbit(p, koords[0],
									koords[1]);
							p.addEllenseg(hobbit,
									p.getUtCella(koords[0], koords[1]));
						}
					} else
						System.out.println("Sikertelen, helytelen cella.");
				} catch (NumberFormatException ex) {
					System.out.println("Hibás bemenet!");
				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Hibás bemenet!");
				}

			}

			else if (splitted[0].equals("akadaly")) {
				try {
					int[] koords = new int[2];
					koords = p.getUtCellaByKord(Integer.parseInt(splitted[3]),
							Integer.parseInt(splitted[2]));

					if (koords != null) {

						if (splitted[1].equals("ork")) {
							IAkadaly ork = new Ork(p.getUtCella(koords[0],
									koords[1]));
							if (p.getVarazsero() >= ork.getKoltseg()) {
								p.akadalytLerak(ork,
										p.getUtCella(koords[0], koords[1]));
								p.setVarazsero(p.getVarazsero()
										- ork.getKoltseg());
							} else
								System.out.println("Nincs elég varázserõ!");
						} else if (splitted[1].equals("ent")) {
							IAkadaly ent = new Ent(p.getUtCella(koords[0],
									koords[1]));
							if (p.getVarazsero() >= ent.getKoltseg()) {
								p.akadalytLerak(ent,
										p.getUtCella(koords[0], koords[1]));
								p.setVarazsero(p.getVarazsero()
										- ent.getKoltseg());
							} else
								System.out.println("Nincs elég varázserõ!");
						} else if (splitted[1].equals("pok")) {
							IAkadaly pok = new Pok(p.getUtCella(koords[0],
									koords[1]));
							if (p.getVarazsero() >= pok.getKoltseg()) {
								p.akadalytLerak(pok,
										p.getUtCella(koords[0], koords[1]));
								p.setVarazsero(p.getVarazsero()
										- pok.getKoltseg());
							} else
								System.out.println("Nincs elég varázserõ!");
						}
					} else
						System.out.println("Sikertelen, helytelen cella.");
				} catch (NumberFormatException ex) {
					System.out.println("Hibás bemenet!");
				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Hibás bemenet!");
				}

			}

			else if (splitted[0].equals("varazsko")) {
				try {
					if (splitted[1].equals("fekete")) {
						ITVarazsko fekete = new FeketeVarazsko();
						int kolt = fekete.getKoltseg();
						if (p.getVarazsero() < kolt) {
							System.out.println("Nincs elég varázserõ!");
						} else if (p.getTerkepCella(
								Integer.parseInt(splitted[3]),
								Integer.parseInt(splitted[2])).getTorony() == null) {
							System.out
									.println("Sikertelen fejlesztés: rossz célpont.");
						} else {
							p.setVarazsero(p.getVarazsero() - kolt);
							fekete.hat(p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony());
							Kimenet.fejlesztes(p
									.getTerkepCella(
											Integer.parseInt(splitted[3]),
											Integer.parseInt(splitted[2]))
									.getTorony().getSebzes(2));
						}

					} else if (splitted[1].equals("feher")) {
						ITVarazsko feher = new FeherVarazsko();
						int kolt = feher.getKoltseg();
						if (p.getVarazsero() < kolt) {
							System.out.println("Nincs elég varázserõ!");
						} else if (p.getTerkepCella(
								Integer.parseInt(splitted[3]),
								Integer.parseInt(splitted[2])).getTorony() == null) {
							System.out
									.println("Sikertelen fejlesztés: rossz célpont.");
						} else {
							p.setVarazsero(p.getVarazsero() - kolt);
							feher.hat(p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony());
							Kimenet.fejlesztes(p
									.getTerkepCella(
											Integer.parseInt(splitted[3]),
											Integer.parseInt(splitted[2]))
									.getTorony().getSebzes(3));
						}

					} else if (splitted[1].equals("piros")) {
						ITVarazsko piros = new PirosVarazsko();
						int kolt = piros.getKoltseg();
						if (p.getVarazsero() < kolt) {
							System.out.println("Nincs elég varázserõ!");
						} else if (p.getTerkepCella(
								Integer.parseInt(splitted[3]),
								Integer.parseInt(splitted[2])).getTorony() == null) {
							System.out
									.println("Sikertelen fejlesztés: rossz célpont.");
						} else {
							p.setVarazsero(p.getVarazsero() - kolt);
							piros.hat(p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony());
							Kimenet.fejlesztes(p
									.getTerkepCella(
											Integer.parseInt(splitted[3]),
											Integer.parseInt(splitted[2]))
									.getTorony().getHatotav());
						}

					} else if (splitted[1].equals("kek")) {
						ITVarazsko kek = new KekVarazsko();
						int kolt = kek.getKoltseg();
						if (p.getVarazsero() < kolt) {
							System.out.println("Nincs elég varázserõ!");
						} else if (p.getTerkepCella(
								Integer.parseInt(splitted[3]),
								Integer.parseInt(splitted[2])).getTorony() == null) {
							System.out
									.println("Sikertelen fejlesztés: rossz célpont.");
						} else {
							p.setVarazsero(p.getVarazsero() - kolt);
							kek.hat(p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony());
							Kimenet.fejlesztes(p
									.getTerkepCella(
											Integer.parseInt(splitted[3]),
											Integer.parseInt(splitted[2]))
									.getTorony().getTuzgyak());
						}

					} else if (splitted[1].equals("zold")) {
						ITVarazsko zold = new ZoldVarazsko();
						int kolt = zold.getKoltseg();
						if (p.getVarazsero() < kolt) {
							System.out.println("Nincs elég varázserõ!");
						} else if (p.getTerkepCella(
								Integer.parseInt(splitted[3]),
								Integer.parseInt(splitted[2])).getTorony() == null) {
							System.out
									.println("Sikertelen fejlesztés: rossz célpont.");
						} else {
							p.setVarazsero(p.getVarazsero() - kolt);
							zold.hat(p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony());
							Kimenet.fejlesztes(p
									.getTerkepCella(
											Integer.parseInt(splitted[3]),
											Integer.parseInt(splitted[2]))
									.getTorony().getSebzes(1));
						}

					} else if (splitted[1].equals("sarga")) {
						ITVarazsko sarga = new SargaVarazsko();
						int kolt = sarga.getKoltseg();
						if (p.getVarazsero() < kolt) {
							System.out.println("Nincs elég varázserõ!");
						} else if (p.getTerkepCella(
								Integer.parseInt(splitted[3]),
								Integer.parseInt(splitted[2])).getTorony() == null) {
							System.out
									.println("Sikertelen fejlesztés: rossz célpont.");
						} else {
							p.setVarazsero(p.getVarazsero() - kolt);
							sarga.hat(p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony());
							Kimenet.fejlesztes(p
									.getTerkepCella(
											Integer.parseInt(splitted[3]),
											Integer.parseInt(splitted[2]))
									.getTorony().getSebzes(0));
						}

					} else if (splitted[1].equals("lila")) {
						IAVarazsko lila = new LilaVarazsko();
						int kolt = lila.getKoltseg();
						if (p.getVarazsero() < kolt) {
							System.out.println("Nincs elég varázserõ!");

						} else if (p.getTerkepCella(
								Integer.parseInt(splitted[3]),
								Integer.parseInt(splitted[2])).getAkadaly() == null) {
							System.out
									.println("Sikertelen fejlesztés: rossz célpont.");
						} else {
							p.setVarazsero(p.getVarazsero() - kolt);
							lila.hat(p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getAkadaly());
							Kimenet.fejlesztes(p
									.getTerkepCella(
											Integer.parseInt(splitted[3]),
											Integer.parseInt(splitted[2]))
									.getAkadaly().getHatas());
						}
					}
				} catch (NumberFormatException ex) {
					System.out.println("Hibás bemenet!");
				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Hibás bemenet!");
				}
			}

			else if (splitted[0].equals("kod")) {
				try {
					if (p.getTerkepCella(Integer.parseInt(splitted[2]),
							Integer.parseInt(splitted[1])).getTorony() != null)
						p.getTerkepCella(Integer.parseInt(splitted[2]),
								Integer.parseInt(splitted[1])).getTorony()
								.setKod(true);
					else
						System.out.println("Sikertelen, helytelen cella!");
				} catch (NumberFormatException ex) {
					System.out.println("Hibás bemenet!");
				}
			}

			else if (splitted[0].equals("utemleptetes")) {
				try {
					for (int i = 0; i < Integer.parseInt(splitted[1]); i++)
						if (p.utemLep())
							break;
				} catch (NumberFormatException ex) {
					System.out.println("Hibás bemenet!");
				} catch(ArrayIndexOutOfBoundsException ex){
					System.out.println("Hibás bemenet!");
				}
			} else
				System.out.println("Ismeretlen bemenet!");
		}
	}

	public void betolt() {
		String line;
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("mentes.txt"));
			line = reader.readLine();
			String[] splittedline = line.split("\\s+");
			p = new Palya();
			p.setKor(Integer.parseInt(splittedline[0]));
			p.setPontszam(Integer.parseInt(splittedline[1]));
			reader.close();
		} catch (IOException e) {
			System.out.println("Nincs betöltendõ játék!");
		} catch (NumberFormatException ex) {
			System.out.println("Hibás fájl!");
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
		} catch (ClassNotFoundException c) {
			System.out.println("Nem található mentés!");
		}

		r.kiir();

	}

}
