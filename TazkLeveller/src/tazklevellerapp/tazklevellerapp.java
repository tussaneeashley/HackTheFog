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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class tazklevellerapp {
	private static final String filepathPrefs=".\\Data\\Preferences.ser";
	private static final String filepathList=".\\Data\\List.ser";
	
	private JFrame frame;
	
	private Preferences prefs;
	private Calendar calendar = Calendar.getInstance();
	private int timeHr = calendar.get(Calendar.HOUR_OF_DAY);
	private JTable table;
	private TaskList taskList;
	
	private int percent;

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
		taskList = new TaskList();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 647, 882);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBackground(prefs.getColor());
		tabbedPane.setBounds(0, 0, 625, 826);
		frame.getContentPane().add(tabbedPane);
		
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Home", null, panel, null);
		
		JLabel lblGood = new JLabel("Hello,");
		lblGood.setHorizontalAlignment(SwingConstants.CENTER);
		lblGood.setBounds(15, 16, 590, 65);
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
		StyleConstants.setFontFamily(attribs,"Segoe UI Light");
		StyleConstants.setFontSize(attribs, 30);
		
		JTextPane txtpnWhatWouldYou = new JTextPane();
		txtpnWhatWouldYou.setParagraphAttributes(attribs,true);
		txtpnWhatWouldYou.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		txtpnWhatWouldYou.setEditable(false);
		txtpnWhatWouldYou.setText("What would you like to accomplish today?");
		txtpnWhatWouldYou.setBounds(0, 86, 620, 77);
		
		
		panel.add(txtpnWhatWouldYou);
		JLabel label = new JLabel("");
		panel.add(label);
		
		table = new JTable();
		table.setBounds(15, 733, 590, -367);
		panel.add(table);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(-211, 175, 492, 71);
		panel.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Urgent", "Normal", "Low"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(522, 200, 83, 71);
		panel.add(comboBox);
		
		JButton btnAddTask = new JButton("Add Task");
		btnAddTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textArea.getText().trim().length() > 0) {
					taskList.addTask(new Task(textArea.getText(),comboBox.getSelectedIndex()));
					System.out.println(taskList.getNameIncomplete(0)+", "+taskList.getSeverityIncomplete(0));
				}
				
			}
		});
		btnAddTask.setBounds(243, 287, 115, 29);
		panel.add(btnAddTask);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Health", null, panel_1, null);
		panel_1.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(100);
		progressBar.setForeground(Color.RED);
		progressBar.setBounds(87, 5, 440, 124);
		panel_1.add(progressBar);
		
		
		
		
		
		ImageIcon happy = new ImageIcon("./Img/Happy.png");
		JLabel happyLabel = new JLabel(happy);
		
		ImageIcon Crying = new ImageIcon("./Img/Crying.png");
		JLabel cryingLabel = new JLabel(Crying);
		
		ImageIcon Okay = new ImageIcon("./Img/Not feeling Good.png");
		JLabel okayLabel = new JLabel(Okay);
		
		
		
		
		happyLabel.setBounds(130, 198, 334, 323);
		
		cryingLabel.setBounds(130, 198, 334, 323);
		
		okayLabel.setBounds(130, 198, 334, 323);
		
		if( taskList.getTotalCount() != 0) {
			
		 
		percent = taskList.getCompletedCount()/taskList.getTotalCount();
		
		}
		else {
			percent = 100;
		}
		
		progressBar.setValue(percent);
		
		if (percent <= 100 && percent >= 66) {
			
			happyLabel.setBounds(130, 198, 334, 323);
			panel_1.add(happyLabel);
			
		}
		
		
		if(percent < 66 && percent >= 33) {
			
			
			panel_1.add(okayLabel);
			
		}
		
		if(percent < 33) {
			
			
			panel_1.add(cryingLabel);
			
		}
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}
	public void WriteObjectToFile(Object serObj,String filepath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            fileOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
