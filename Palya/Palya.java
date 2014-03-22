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
	 * V�ge a j�t�knak.
	 */
	public void lost() {
		Main.log();
	}
	
	/**
	 * K�r n�vel�se
	 */
	private void korNovel() {
		Main.log();
		this.ment();
	}
	
	/*
	 * J�t�k ment�se. Csak a k�r�k v�g�n.
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
