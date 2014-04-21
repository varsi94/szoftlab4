package Prototipus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

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

/**
 * 
 * @author Hanicz Bemenet kezel�s�re.
 */
public class Bemenet {

	private static BufferedReader in;
	// private Palya p;
	private String tipus;

	/**
	 * ctor
	 */
	public Bemenet() {
	}

	/**
	 * 
	 * @param p
	 *            referencia a ap�ly�r�l
	 * @param teszt
	 *            null ha nem teszt, txt n�v ha teszt.
	 * @throws IOException
	 */
	public void Kezelo(Palya p, String teszt) throws IOException {

		while (true) {
			String unsplitted;
			String[] splitted;
			int index;
			// txtb�lbeolvasott parancsok t�rol�s�ra
			ArrayList<String> beolv = new ArrayList<String>();

			// Ha a teszt null akkor nem tesztet futtatunk ilyenkor mindig
			// beolvasunk a bemenetr�l
			// ha teszt akkor a txtb�l olvassuk a parancsokat.
			if (teszt == null) {
				in = new BufferedReader(new InputStreamReader(System.in));
				unsplitted = in.readLine();
				index = 1;
			} else {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(
							teszt + ".txt"));
					while ((unsplitted = reader.readLine()) != null) {
						beolv.add(unsplitted);
					}
					index = beolv.size();
					reader.close();
				} catch (IOException e) {
					System.out.println("Nincs ilyen teszt!");
					return;
				}
			}

			/**
			 * A parancsok mennyis�ge alapj�n futtatja le a bemenet kezelo
			 * else-ifet
			 */
			for (int i = 0; i < index; i++) {

				/**
				 * Vagy a bemenetet vagy a txt tartalmat spliteli.
				 */
				if (teszt == null)
					splitted = unsplitted.split("\\s+");
				else
					splitted = beolv.get(i).split("\\s+");

				/**
				 * Amennyiben kilepes a bemenet.
				 */
				if (splitted[0].equals("kilepes")) {
					return;
				}

				/**
				 * torony bemenet eset�n
				 */
				else if (splitted[0].equals("torony")) {

					if (splitted.length < 4)
						tipus = null;
					else
						tipus = splitted[3];

					int x, y;
					x = Integer.parseInt(splitted[2]);
					y = Integer.parseInt(splitted[1]);
					try {
						if (p.getTerkepCella(x, y).getTorony() == null) {
							ITorony t = new Torony(p, p.getTerkepCella(x, y),
									tipus);
							if (t.getKoltseg() > p.getVarazsero())
								System.out.println("Nincs el�g var�zser�!");
							else
								p.tornyotLerak(t, p.getTerkepCella(x, y));
						} else
							System.out.println("Foglalt cella!");
					} catch (NumberFormatException ex) {
						System.out.println("Hib�s bemenet!");

					} catch (ArrayIndexOutOfBoundsException ex) {
						System.out.println("Hib�s bemenet!");
					}
				}

				/**
				 * ellens�g bemenet eset�n
				 */
				else if (splitted[0].equals("ellenseg")) {
					try {
						int[] koords = new int[2];
						koords = p.getUtCellaByKord(
								Integer.parseInt(splitted[3]),
								Integer.parseInt(splitted[2]));

						if (koords != null) {

							if (splitted[1].equals("tunde")) {
								IEllenseg tunde = new Tunde(p, koords[0],
										koords[1]);
								p.addEllenseg(tunde,
										p.getUtCella(koords[0], koords[1]));
							} else if (splitted[1].equals("ember")) {
								IEllenseg ember = new Ember(p, koords[0],
										koords[1]);
								p.addEllenseg(ember,
										p.getUtCella(koords[0], koords[1]));
							} else if (splitted[1].equals("torp")) {
								IEllenseg torp = new Torp(p, koords[0],
										koords[1]);
								p.addEllenseg(torp,
										p.getUtCella(koords[0], koords[1]));
							} else if (splitted[1].equals("hobbit")) {
								IEllenseg hobbit = new Hobbit(p, koords[0],
										koords[1]);
								p.addEllenseg(hobbit,
										p.getUtCella(koords[0], koords[1]));
							} else
								System.out.println("Hib�s bemenet!");
						} else
							System.out.println("Sikertelen, helytelen cella.");
					} catch (NumberFormatException ex) {
						System.out.println("Hib�s bemenet!");
					} catch (ArrayIndexOutOfBoundsException ex) {
						System.out.println("Hib�s bemenet!");
					}

				}

				/**
				 * akad�ly bemenet eset�n
				 */
				else if (splitted[0].equals("akadaly")) {
					try {
						int[] koords = new int[2];
						koords = p.getUtCellaByKord(
								Integer.parseInt(splitted[3]),
								Integer.parseInt(splitted[2]));

						if (koords != null
								&& p.getTerkepCella(
										Integer.parseInt(splitted[3]),
										Integer.parseInt(splitted[2]))
										.getAkadaly() == null) {

							if (splitted[1].equals("ork")) {
								IAkadaly ork = new Ork(p.getUtCella(koords[0],
										koords[1]));
								if (p.getVarazsero() >= ork.getKoltseg()) {
									p.akadalytLerak(ork,
											p.getUtCella(koords[0], koords[1]));
								} else
									System.out.println("Nincs el�g var�zser�!");
							} else if (splitted[1].equals("ent")) {
								IAkadaly ent = new Ent(p.getUtCella(koords[0],
										koords[1]));
								if (p.getVarazsero() >= ent.getKoltseg()) {
									p.akadalytLerak(ent,
											p.getUtCella(koords[0], koords[1]));
								} else
									System.out.println("Nincs el�g var�zser�!");
							} else if (splitted[1].equals("pok")) {
								IAkadaly pok = new Pok(p.getUtCella(koords[0],
										koords[1]));
								if (p.getVarazsero() >= pok.getKoltseg()) {
									p.akadalytLerak(pok,
											p.getUtCella(koords[0], koords[1]));
								} else
									System.out.println("Nincs el�g var�zser�!");
							}
						} else
							System.out.println("Sikertelen, helytelen cella.");
					} catch (NumberFormatException ex) {
						System.out.println("Hib�s bemenet!");
					} catch (ArrayIndexOutOfBoundsException ex) {
						System.out.println("Hib�s bemenet!");
					}

				}

				/**
				 * varazsko bemenet eset�n
				 */
				else if (splitted[0].equals("varazsko")) {
					try {
						if (splitted[1].equals("fekete")) {
							ITVarazsko fekete = new FeketeVarazsko();
							int kolt = fekete.getKoltseg();
							if (p.getVarazsero() < kolt) {
								System.out.println("Nincs el�g var�zser�!");
							} else if (p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony() == null) {
								System.out
										.println("Sikertelen fejleszt�s: rossz c�lpont.");
							} else {
								p.setVarazsero(p.getVarazsero() - kolt);
								fekete.hat(p.getTerkepCella(
										Integer.parseInt(splitted[3]),
										Integer.parseInt(splitted[2]))
										.getTorony());
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
								System.out.println("Nincs el�g var�zser�!");
							} else if (p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony() == null) {
								System.out
										.println("Sikertelen fejleszt�s: rossz c�lpont.");
							} else {
								p.setVarazsero(p.getVarazsero() - kolt);
								feher.hat(p.getTerkepCella(
										Integer.parseInt(splitted[3]),
										Integer.parseInt(splitted[2]))
										.getTorony());
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
								System.out.println("Nincs el�g var�zser�!");
							} else if (p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony() == null) {
								System.out
										.println("Sikertelen fejleszt�s: rossz c�lpont.");
							} else {
								p.setVarazsero(p.getVarazsero() - kolt);
								piros.hat(p.getTerkepCella(
										Integer.parseInt(splitted[3]),
										Integer.parseInt(splitted[2]))
										.getTorony());
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
								System.out.println("Nincs el�g var�zser�!");
							} else if (p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony() == null) {
								System.out
										.println("Sikertelen fejleszt�s: rossz c�lpont.");
							} else {
								p.setVarazsero(p.getVarazsero() - kolt);
								kek.hat(p.getTerkepCella(
										Integer.parseInt(splitted[3]),
										Integer.parseInt(splitted[2]))
										.getTorony());
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
								System.out.println("Nincs el�g var�zser�!");
							} else if (p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony() == null) {
								System.out
										.println("Sikertelen fejleszt�s: rossz c�lpont.");
							} else {
								p.setVarazsero(p.getVarazsero() - kolt);
								zold.hat(p.getTerkepCella(
										Integer.parseInt(splitted[3]),
										Integer.parseInt(splitted[2]))
										.getTorony());
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
								System.out.println("Nincs el�g var�zser�!");
							} else if (p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getTorony() == null) {
								System.out
										.println("Sikertelen fejleszt�s: rossz c�lpont.");
							} else {
								p.setVarazsero(p.getVarazsero() - kolt);
								sarga.hat(p.getTerkepCella(
										Integer.parseInt(splitted[3]),
										Integer.parseInt(splitted[2]))
										.getTorony());
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
								System.out.println("Nincs el�g var�zser�!");

							} else if (p.getTerkepCella(
									Integer.parseInt(splitted[3]),
									Integer.parseInt(splitted[2])).getAkadaly() == null) {
								System.out
										.println("Sikertelen fejleszt�s: rossz c�lpont.");
							} else {
								p.setVarazsero(p.getVarazsero() - kolt);
								lila.hat(p.getTerkepCella(
										Integer.parseInt(splitted[3]),
										Integer.parseInt(splitted[2]))
										.getAkadaly());
								p.setPontszam(35);
								Kimenet.fejlesztes(p
										.getTerkepCella(
												Integer.parseInt(splitted[3]),
												Integer.parseInt(splitted[2]))
										.getAkadaly().getHatas());
							}
						}
					} catch (NumberFormatException ex) {
						System.out.println("Hib�s bemenet!");
					} catch (ArrayIndexOutOfBoundsException ex) {
						System.out.println("Hib�s bemenet!");
					}
				}

				/**
				 * k�d bemenet eset�n
				 */
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
						System.out.println("Hib�s bemenet!");
					}
				}

				/**
				 * �teml�ptet�s bemenet eset�n
				 */
				else if (splitted[0].equals("utemleptetes")) {
					try {
						for (int j = 0; j < Integer.parseInt(splitted[1]); j++)
							if (p.utemLep())
								break;
					} catch (NumberFormatException ex) {
						System.out.println("Hib�s bemenet!");
					} catch (ArrayIndexOutOfBoundsException ex) {
						System.out.println("Hib�s bemenet!");
					}
				/**
				 * log bemenet eset�n
				*/
				} else if (splitted[0].equals("log")) {
					p.logPalya();
				/**
				 * kezeletlen bemenet eset�n
				 */
				} else
					System.out.println("Ismeretlen bemenet!");
			}
			
			/**
			 * Ha tesz �s kil�p�nk a for ciklusb�l akkor visszat�r�nk a f�men�be.
			 */
			if (teszt != null)
				return;
		}
	}

	/**
	 * J�t�k�ll�s bet�lt�se
	 */
	public void betolt() {
		try {
			FileInputStream fileIn = new FileInputStream("mentes.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Palya p = new Palya();
			p = (Palya) in.readObject();
			in.close();
			fileIn.close();
			p.motor();
		} catch (IOException i) {
			System.out.println("Nem siker�lt a beolvas�s!");
		} catch (ClassNotFoundException c) {
			System.out.println("Nem tal�lhat� ment�s!");
		}

	}

	/**
	 * Ranglista bet�lt�se �s kiirat�sa
	 */
	public void ranglista() {
		Ranglista r = new Ranglista();

		try {
			FileInputStream fileIn = new FileInputStream("ranglista.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			r = (Ranglista) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			System.out.println("Nem siker�lt a beolvas�s!");
		} catch (ClassNotFoundException c) {
			System.out.println("Nem tal�lhat� ment�s!");
		}

		r.kiir();

	}

}
