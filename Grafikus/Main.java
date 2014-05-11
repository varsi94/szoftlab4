package Grafikus;

import javax.swing.JFrame;

/**
 * Main class a program ind�t�s�hoz.
 * @author Varsi
 *
 */
public class Main {
	/**
	 * main met�dus: megnyit egy �j frame-t, rajta egy MenuComponent objektummal.
	 * @param args parancssori argumentumok
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Szoftlab4 Torony v�d�s");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuComponent comp = new MenuComponent(frame);
		frame.getContentPane().add(comp);
		frame.setResizable(false);
		
		frame.pack();
		frame.setVisible(true);
	}
}
