package Ellenseg;

import java.io.IOException;

import Cella.Cella;
import Szkeleton.Main;
import Torony.ITorony;

public class Ember extends Kaszt {

	@Override
	public void sebzodik(ITorony t) {
		Main.log();
		t.getSebzes(0);
		String s = null;
		while (s == null) {
			System.out.println("Meghaljon az ellenség? I/N");
			try {
				String tmp = Main.readString();
				if (tmp.equals("I") || tmp.equals("N"))
					s = tmp;
			} catch (IOException e) {
			}
		}
		if (s.equals("I")) {
			meghal();
		}
	}

	@Override
	public void megall(int kor) {
		Main.log();
	}

	@Override
	public void halad(Cella c) {
		Main.log();
		Cella regiCella = new Cella(0, 0, true);
		regiCella.kivesz(this);
		c.hozzaad(this);
	}

	@Override
	public void meghal() {
		Main.log();
		Cella c = new Cella(0, 0, true);
		c.kivesz(this);
	}

}
