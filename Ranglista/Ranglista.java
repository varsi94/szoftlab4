package Ranglista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Osztály a ranglista tárolására
 * 
 * @author Sipka
 * 
 */
public class Ranglista implements Serializable {
	public static final String FILE_RANGLISTA_SER = "ranglista.ser";
	private static final long serialVersionUID = 1242587070802683790L;
	/**
	 * Ebben vannak az adatok.
	 */
	private Map<String, Integer> lista = new HashMap<String, Integer>();

	/**
	 * Ezzel a metódussal tudjuk frissíteni
	 * 
	 * @param name
	 *            játékos neve
	 * @param ido
	 *            játék ideje
	 */
	public void frissit(String name, int pontszam) {
		lista.put(name, pontszam);
	}

	/**
	 * Kiírjuk a ranglistát
	 */
	public void kiir() {
		for (Entry<String, Integer> e : lista.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}

	/**
	 * Konstruktor
	 */
	private Ranglista() {
	}

	/**
	 * Ranglista mentése
	 */
	public void mentes() {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(FILE_RANGLISTA_SER));
			out.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * Lekéri a ranglistát
	 * 
	 * @return a ranglista
	 */
	public static Ranglista get() {
		Ranglista result = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(FILE_RANGLISTA_SER));
			result = (Ranglista) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
		if (result == null) {
			return new Ranglista();
		}
		return result;
	}

	/**
	 * Be lehet kérni a játékos nevét
	 * 
	 * @return A név
	 */
	public static String kerdBeAJatekosNevet() {
		return JOptionPane.showInputDialog(null, "A pontszám mentéséhez add meg a neved");
	}

	/**
	 * Megjeleniti a ranglista megjelenitõ dialógust
	 * 
	 * @param f
	 *            a szülõ ablaka a dialógusnak
	 */
	public void showRanglistaDialog(JFrame f) {
		class RanglistaEntry implements Comparable<RanglistaEntry> {
			private final String name;
			private final int pontszam;

			public RanglistaEntry(String name, int pontszam) {
				this.name = name;
				this.pontszam = pontszam;
			}

			@Override
			public int compareTo(RanglistaEntry other) {
				return Integer.compare(pontszam, other.pontszam);
			}
		}

		final JDialog dialog = new JDialog(f, true);
		dialog.setTitle("Ranglista");
		dialog.setLocationRelativeTo(f);
		dialog.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		dialog.getContentPane().add(panel, BorderLayout.CENTER);

		List<RanglistaEntry> ranglista = new ArrayList<RanglistaEntry>();
		for (Entry<String, Integer> e : lista.entrySet()) {
			ranglista.add(new RanglistaEntry(e.getKey(), e.getValue()));
		}
		Collections.sort(ranglista);

		JLabel title = new JLabel("Ranglista");
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(title);
		if (ranglista.size() == 0) {
			JLabel noentry = new JLabel("Nincs bejegyzés");
			noentry.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(noentry);
		} else {
			int i = 1;
			for (RanglistaEntry re : ranglista) {
				JLabel label = new JLabel(i++ + ". " + re.name + ": " + re.pontszam);
				label.setAlignmentX(Component.LEFT_ALIGNMENT);
				panel.add(label);
			}
		}
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
			}
		});
		dialog.getContentPane().add(ok, BorderLayout.SOUTH);
		dialog.pack();
		dialog.setVisible(true);
	}

}
