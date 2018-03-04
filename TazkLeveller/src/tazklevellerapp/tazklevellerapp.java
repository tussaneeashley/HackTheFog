package tazklevellerapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.TextArea;

public class tazklevellerapp {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-26,291
	 */
	private final TextArea textArea = new TextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tazklevellerapp window = new tazklevellerapp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tazklevellerapp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
