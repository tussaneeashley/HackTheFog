package tazklevellerapp;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.TextArea;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class tazklevellerapp {

	private JFrame frame;
	
	private Preferences prefs;

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
		prefs = new Preferences();
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 647, 882);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(prefs.getColor());
		tabbedPane.setBounds(0, 0, 625, 826);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(87, 5, 440, 124);
		panel_1.add(progressBar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(351, 176, 10, 10);
		panel_1.add(panel_3);
		
		
		ImageIcon happy = new ImageIcon("./Img/Happy.png");
		JLabel happyLabel = new JLabel(happy);
		
		happyLabel.setBounds(130, 198, 334, 323);
		panel_1.add(happyLabel);
		
		
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}
}
