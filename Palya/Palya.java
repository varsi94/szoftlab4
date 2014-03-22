package Palya;

import Szkeleton.Main;
import Cella.Cella;

public class Palya {
	private Cella hegy;
	private Cella[][] terkep;
	private int varazsero;
	private Cella[][] ut;
	private int kor;

	public void motor() {
		Main.log();
		this.korNovel();
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
	
	private void ment(){
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
