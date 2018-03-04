package tazklevellerapp;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.TextArea;
import java.util.Calendar;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class tazklevellerapp {

	private JFrame frame;
	
	private Preferences prefs;
	private Calendar calendar = Calendar.getInstance();
	private int timeHr = calendar.get(Calendar.HOUR_OF_DAY);

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
		
		JLabel lblGood = new JLabel("Hello,");
		lblGood.setHorizontalAlignment(SwingConstants.CENTER);
		lblGood.setBounds(15, 16, 590, 43);
		panel.setLayout(null);
		
		lblGood.setFont(new Font("Segoe UI", Font.BOLD, 40));
		
		panel.add(lblGood);
		
		if(timeHr >= 6&& timeHr < 12) {
			lblGood.setText("Good Morning,");
		} else if(timeHr >= 12 && timeHr < 18) {
			lblGood.setText("Good Afternoon,");
		} else{
			lblGood.setText("Good Evening,");
		}
		
		SimpleAttributeSet attribs = new SimpleAttributeSet();  
		StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_CENTER); 
		
		JTextPane txtpnWhatWouldYou = new JTextPane();
		txtpnWhatWouldYou.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		txtpnWhatWouldYou.setEditable(false);
		txtpnWhatWouldYou.setText("What would you like to accomplish today?");
		txtpnWhatWouldYou.setBounds(0, 86, 620, 77);
		txtpnWhatWouldYou.setParagraphAttributes(attribs,true);
		
		panel.add(txtpnWhatWouldYou);
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
