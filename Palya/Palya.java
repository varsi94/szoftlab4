package Palya;

import java.io.IOException;

import Ranglista.Ranglista;
import Szkeleton.Main;
import Torony.ITorony;
import Torony.Torony;
import Akadaly.IAkadaly;
import Akadaly.Ork;
import Akadaly.Pok;
import Cella.Cella;
import Ellenseg.Ember;
import Ellenseg.IEllenseg;

public class Palya {
	private Cella hegy;
	private Cella[][] terkep;
	private int varazsero;
	private Cella[][] ut;
	private int kor;

	public void motor() {
		Main.log();
		if (Main.currSzekvencia == 8 || Main.currSzekvencia == 9)	 // Új kör és mentés
			this.korNovel();

		else if (Main.currSzekvencia == 10){	 // Torony lõ
			ITorony t = new Torony();
			t.loves();
		} else if (Main.currSzekvencia == 12) { 	// Ellenség elpusztul
			ITorony torony = new Torony();
			torony.loves();
		} else if (Main.currSzekvencia == 13 || Main.currSzekvencia == 14) {		//Akadály elpusztítja az ellenséget
			IAkadaly ork = new Ork(0,0, new Cella(0, 0, true));
			IEllenseg ember = new Ember();
			ork.akadalyoz(ember);
		} else if (Main.currSzekvencia == 15) {		//Akadály lelassítja az ellenséget
			IAkadaly pok = new Pok(0, 0, new Cella(0, 0, true));
			IEllenseg ember = new Ember();
			pok.akadalyoz(ember);
		} else if (Main.currSzekvencia == 17) {		//Ellenség léptetése
			IEllenseg ember = new Ember();
			ember.getCellaIndex();
			Cella ujCella = new Cella(0, 0, true);
			ember.halad(ujCella);
		} else if (Main.currSzekvencia == 18) {		//Ellenség eléri a hegyet
			IEllenseg ember = new Ember();
			Cella ujCella = new Cella(0,0,true);
			ember.getUtIndex();
			ember.halad(ujCella);
			lost();
		} else if (Main.currSzekvencia == 20) {		//Ranglistába írás
			Ranglista ranglista = new Ranglista();
			System.out.println("Adja meg a nevet!");
			String name = null;
			try {
				name = Main.readString();
				ranglista.frissit(name, 45);
			} catch (IOException e) {
			}
		}
	}

	/**
	 * @return the varazsero
	 */
	public int getVarazsero() {
		Main.log();
		return varazsero;
	}

	/**
	 * @param varazsero
	 *            the varazsero to set
	 */
	public void setVarazsero(int varazsero) {
		Main.log();
		this.varazsero = varazsero;
	}

	/**
	 * Vége a játéknak.
	 */
	public void lost() {
		Main.log();
	}

	/**
	 * Kör növelése
	 */
	private void korNovel() {
		Main.log();
		this.ment();
	}

	/*
	 * Játék mentése. Csak a körök végén.
	 */

	private void ment() {
		Main.log();
		System.out.println("ObjectOutputStream.writeObject();");
	}

	/**
	 * Konstruktor
	 */
	public Palya() {
		Main.log();
		varazsero = 0;
		kor = 1;

	}
}
