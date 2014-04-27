package Grafikus;

import javax.swing.JFrame;


public class Main {
/*	private static JMenuItem newGameAction;
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
		frame.setResizable(false);

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
*/
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Szoftlab4 Torony védés");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuComponent comp = new MenuComponent(frame);
		frame.getContentPane().add(comp);
		frame.setResizable(false);
		
		frame.pack();
		frame.setVisible(true);
	}
}
