package Ellenseg;

import Cella.Cella;
import Szkeleton.Main;
import Torony.ITorony;

public class Ember extends Kaszt {

	@Override
	public void sebzodik(ITorony t) {
		Main.log();
	}

	@Override
	public void megall(int kor) {
		Main.log();
	}

	@Override
	public void halad(Cella c) {
		Main.log();
	}

	@Override
	public void meghal() {
		Main.log();
	}

}
