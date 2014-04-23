package Grafikus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import Palya.Palya;
import Ranglista.Ranglista;

public class Main {
	private static JMenuItem newGameAction;
	private static JMenuItem ranglistaAction;
	private static JFrame frame;
	private static PalyaComponent palyaComponent;
	private static final ActionListener MENU_ACTION = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			final Object source = e.getSource();
			if (source == newGameAction) {
				palyaComponent.setPalya(new Palya());
			} else if (source == ranglistaAction) {
				Ranglista r = Ranglista.get();
				r.showRanglistaDialog(frame);
			}
		}
	};

	public static void main(String[] args) {
		
		frame = new JFrame("Szoftlab4 Torony védés");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		palyaComponent = new PalyaComponent(new Palya());
		frame.getContentPane().add(palyaComponent);

		JMenuBar menubar = new JMenuBar();

		JMenu menu = new JMenu("Játék");
		newGameAction = new JMenuItem("Új játék");
		newGameAction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		newGameAction.addActionListener(MENU_ACTION);
		menu.add(newGameAction);

		ranglistaAction = new JMenuItem("Ranglista");
		ranglistaAction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		ranglistaAction.addActionListener(MENU_ACTION);
		menu.add(ranglistaAction);

		menubar.add(menu);

		frame.setJMenuBar(menubar);
		frame.pack();
		frame.setVisible(true);
	}

}
