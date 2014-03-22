package Ranglista;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Szkeleton.Main;

public class Ranglista {
	private Map<String, Integer> lista = new HashMap<String, Integer>();

	public void frissit(String name, int ido) {
		Main.log();
		lista.put(name, ido);
	}

	public void kiir() {
		Main.log();
		for (Entry<String, Integer> e : lista.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
	
	public Ranglista(){
		Main.log();
	}

}
