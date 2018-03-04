package tazklevellerapp;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.TextArea;
import java.util.Calendar;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class tazklevellerapp {
	private static final String filepathPrefs=".\\Data\\Preferences.ser";
	private static final String filepathList=".\\Data\\List.ser";
	
	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	
	private Preferences prefs;
	private Calendar calendar = Calendar.getInstance();
	private int timeHr = calendar.get(Calendar.HOUR_OF_DAY);
	private JTable table;
	private TaskList taskList;
	
	private int percent;
	private JTable table_1;
	private JTable table_2;
	
	private ImageIcon happy = new ImageIcon(new ImageIcon("./Img/Happy.png").getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT));
	private JLabel happyLabel = new JLabel(happy);
	private ImageIcon Crying = new ImageIcon(new ImageIcon("./Img/Crying.png").getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT));
	private JLabel cryingLabel = new JLabel(Crying);
	private ImageIcon Okay = new ImageIcon(new ImageIcon("./Img/Not Feeling Good.png").getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT));
	private JLabel okayLabel = new JLabel(Okay);
	private JProgressBar progressBar;
	private JLabel lblNewLabel;
	

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
	 * @throws IOException 
	 */
	public tazklevellerapp() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
//		if (!new File(filepathPrefs).exists())
//		{
//			prefs = new Preferences();
//		} else {
//			prefs = (Preferences) readObjectFromFile(filepathPrefs);
//		}
//		if (!new File(filepathList).exists())
//		{
//			taskList = new TaskList();
//		} else {
//			taskList = (TaskList) readObjectFromFile(filepathList);
//		}
				
		prefs = new Preferences();
		taskList = new TaskList();
		frame = new JFrame();
		frame.getContentPane().setBackground(prefs.getColor());
		frame.setBounds(100, 100, 647, 952);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBackground(prefs.getColor());
		tabbedPane.setBounds(0, 0, 625, 896);
		frame.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		panel.setBackground(Color.PINK);
		tabbedPane.addTab("Home",new ImageIcon("./Img/home.png") , panel, null);
		
		JLabel lblGood = new JLabel("Hello,");
		lblGood.setHorizontalAlignment(SwingConstants.CENTER);
		lblGood.setBounds(15, 16, 590, 65);
		panel.setLayout(null);
		
//		JButton btnSave = new JButton("Save");
//		btnSave.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				new File(filepathPrefs);
//				new File(filepathList);
//				writeObjectToFile(prefs,filepathPrefs);
//				writeObjectToFile(taskList,filepathList);
//			}
//		});
//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnSave.setBounds(15, 16, 80, 29);
//		panel.add(btnSave);
		
//		JButton btnLoad = new JButton("Load");
//		btnLoad.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				try {
//					initialize();
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//		btnLoad.setBounds(101, 16, 95, 29);
//		panel.add(btnLoad);
		
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
		txtpnWhatWouldYou.setBackground(prefs.getColor());
		txtpnWhatWouldYou.setParagraphAttributes(attribs,true);
		txtpnWhatWouldYou.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		txtpnWhatWouldYou.setEditable(false);
		txtpnWhatWouldYou.setText("What would you like to accomplish today?");
		txtpnWhatWouldYou.setBounds(25, 86, 580, 58);
		
		
		panel.add(txtpnWhatWouldYou);
		JLabel label = new JLabel("");
		panel.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(-211, 175, 492, 71);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(15, 200, 421, 71);
		panel.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Urgent", "Normal", "Low"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(451, 200, 154, 71);
		panel.add(comboBox);
		
		JLabel label_1 = new JLabel("Incomplete: " + taskList.getIncompleteCount());
		label_1.setBounds(15, 792, 121, 20);
		panel.add(label_1);
		
		JLabel lblCompletedTasks = new JLabel("Completed: " + taskList.getCompletedCount());
		lblCompletedTasks.setBounds(146, 792, 95, 20);
		panel.add(lblCompletedTasks);
		
		JLabel lblTotalTasks = new JLabel("Total: " + taskList.getTotalCount());
		lblTotalTasks.setBounds(256, 792, 102, 20);
		panel.add(lblTotalTasks);
		
		JButton btnAddTask = new JButton("Add Task");
		btnAddTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textArea.getText().trim().length() > 0) {
					taskList.addTask(textArea.getText(),comboBox.getSelectedIndex());
					updateHomeTable();
					updateIncompleteTable();
					updateCompleteTable();
					label_1.setText("Incomplete: "+taskList.getIncompleteCount());
					lblCompletedTasks.setText("Completed: "+taskList.getCompletedCount());
					lblTotalTasks.setText("Total: "+taskList.getTotalCount());
					updatePercent();
				} else {}
				
			}
		});
		btnAddTask.setBounds(243, 287, 115, 29);
		panel.add(btnAddTask);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateHomeTable();
		table.getColumnModel().getColumn(0).setPreferredWidth(236);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.setBounds(15, 391, 590, 385);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(Color.WHITE);
		table.setRowHeight(55);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(15, 391, 590, 385);
		panel.add(scroll);
		
		JButton btnCompleteTask = new JButton("Completed");
		btnCompleteTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taskList.setComplete(table.getSelectedRow());
				updateHomeTable();
				updateCompleteTable();
				updateIncompleteTable();
				label_1.setText("Incomplete: "+taskList.getIncompleteCount());
				lblCompletedTasks.setText("Completed: "+taskList.getCompletedCount());
				lblTotalTasks.setText("Total: "+taskList.getTotalCount());
				updatePercent();
				
			}
		});
		btnCompleteTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCompleteTask.setBounds(379, 788, 113, 29);
		panel.add(btnCompleteTask);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taskList.removeTask(table.getSelectedRow());
				updateHomeTable();
				updateCompleteTable();
				updateIncompleteTable();
				label_1.setText("Incomplete: "+taskList.getIncompleteCount());
				lblCompletedTasks.setText("Completed: "+taskList.getCompletedCount());
				lblTotalTasks.setText("Total: "+taskList.getTotalCount());
				updatePercent();
			}
		});
		btnDelete.setBounds(499, 788, 95, 29);
		panel.add(btnDelete);
		
		happyLabel.setBounds(130, 198, 334, 323);
		cryingLabel.setBounds(130, 198, 334, 323);
		okayLabel.setBounds(130, 198, 334, 323);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		tabbedPane.addTab("Mood", new ImageIcon("./Img/mood.png"), panel_1, null);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Your Puppy's emotion is Happy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 30));
		lblNewLabel.setBounds(15, 672, 590, 83);
		panel_1.add(lblNewLabel);
		
		
		
		if(taskList.getTotalCount() != 0) {
		percent = taskList.getCompletedCount()/taskList.getTotalCount()*100;
		}
		else {
			percent = 20;
		}
		
		progressBar = new JProgressBar();
		progressBar.setValue(percent);
		progressBar.setBounds(94, 46, 440, 33);
		panel_1.add(progressBar);
		
		
		
		
		updatePercent();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		tabbedPane.addTab("All Tasks", new ImageIcon("./Img/notepad.png"), panel_2, null);
		panel_2.setLayout(null);
		
		table_1 = new JTable();
		table_1.setRowHeight(35);
		table_1.setBounds(15, 16, 590, 317);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		updateIncompleteTable();
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(15, 16, 590, 317);
		panel_2.add(scrollPane);
		
		JButton btnComplete = new JButton("Complete");
		btnComplete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taskList.setComplete(table_1.getSelectedRow());
				updateHomeTable();
				updateCompleteTable();
				updateIncompleteTable();
				label_1.setText("Incomplete: "+taskList.getIncompleteCount());
				lblCompletedTasks.setText("Completed: "+taskList.getCompletedCount());
				lblTotalTasks.setText("Total: "+taskList.getTotalCount());
				updatePercent();
				
			}
		});
		btnComplete.setBounds(188, 349, 115, 29);
		panel_2.add(btnComplete);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taskList.removeTask(table_1.getSelectedRow());
				updateHomeTable();
				updateCompleteTable();
				updateIncompleteTable();
				label_1.setText("Incomplete: "+taskList.getIncompleteCount());
				lblCompletedTasks.setText("Completed: "+taskList.getCompletedCount());
				lblTotalTasks.setText("Total: "+taskList.getTotalCount());
				updatePercent();
			}
		});
		btnDelete_1.setBounds(318, 349, 115, 29);
		panel_2.add(btnDelete_1);
		
		table_2 = new JTable();
		updateCompleteTable();
		table_2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_2.setRowHeight(35);
		table_2.setBounds(15, 404, 590, 317);
		JScrollPane scrollPane2 = new JScrollPane(table_2);
		scrollPane2.setBounds(15, 404, 590, 317);
		panel_2.add(scrollPane2);
		
		
		
		JButton button_1 = new JButton("Delete");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taskList.removeCompleted(table_2.getSelectedRow());
				updateHomeTable();
				updateCompleteTable();
				updateIncompleteTable();
				label_1.setText("Incomplete: "+taskList.getIncompleteCount());
				lblCompletedTasks.setText("Completed: "+taskList.getCompletedCount());
				lblTotalTasks.setText("Total: "+taskList.getTotalCount());
				updatePercent();
				
			}
		});
		button_1.setBounds(249, 737, 115, 29);
		panel_2.add(button_1);
	}
	public void writeObjectToFile(Object serObj,String filepath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            fileOut.close();
            System.out.println("The Object  was successfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public Object readObjectFromFile(String filepath) throws IOException {
		Object readCase = null;
		ObjectInputStream objectinputstream = null;
		try {
		    FileInputStream streamIn = new FileInputStream(filepath);
		    objectinputstream = new ObjectInputStream(streamIn);
		    readCase = objectinputstream.readObject();
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if(objectinputstream != null){
		        objectinputstream.close();
		    } 
		}
		return readCase;
	}
	
	public void updateHomeTable(){
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
			{null, null},
			{null, null},
			{null, null},
			{null, null},
			{null, null},
			{null, null},
		},
		new String[] {
			"Incomplete Tasks", "Severity"
		});
		if (taskList.getIncompleteCount()>0) {
			int loopSize = Math.min(taskList.getIncompleteCount(), 6);
			for(int i =0;i<loopSize;i++) {
				tableModel.setValueAt(taskList.getNameIncomplete(i), i, 0);
				tableModel.setValueAt(taskList.getSeverityIncomplete(i), i, 1);
			}
		}
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(236);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
	}
	
	public void updateIncompleteTable(){
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"Incomplete Tasks", "Severity"
				}
			);
		if (taskList.getIncompleteCount()>0) {
			int loopSize = Math.min(taskList.getIncompleteCount(), 14);
			for(int i =0;i<loopSize;i++) {
				tableModel.setValueAt(taskList.getNameIncomplete(i), i, 0);
				tableModel.setValueAt(taskList.getSeverityIncomplete(i), i, 1);
			}
		}
		table_1.setModel(tableModel);
	}
	public void updateCompleteTable(){
		DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"Completed Tasks", "Severity"
				}
			);
		if (taskList.getCompletedCount()>0) {
			int loopSize = Math.min(taskList.getCompletedCount(), 14);
			for(int i =0;i<loopSize;i++) {
				tableModel.setValueAt(taskList.getNameComplete(i), i, 0);
				tableModel.setValueAt(taskList.getSeverityComplete(i), i, 1);
			}
		}
		table_2.setModel(tableModel);
	}
	
	public void updatePercent() {
		if(taskList.getTotalCount() != 0) {
			percent = (int)((taskList.getCompletedCount()/(double)taskList.getTotalCount())*100);
			}
		else {
				percent = 20;
			}
		if (percent <= 100 && percent >= 66) {
			
			lblNewLabel.setText("Your Puppy is Happy");
			panel_1.add(happyLabel);
			panel_1.remove(cryingLabel);
			panel_1.remove(okayLabel);
			progressBar.setForeground(Color.GREEN);
		}
		
		if(percent < 66 && percent >= 33) {	
			lblNewLabel.setText("Your Puppy is Worried ");
			panel_1.add(okayLabel);
			panel_1.remove(happyLabel);
			panel_1.remove(cryingLabel);
			progressBar.setForeground(Color.YELLOW);
		}
		
		if(percent < 33) {
			lblNewLabel.setText("Your Puppy is Sad");
			panel_1.add(cryingLabel);
			panel_1.remove(happyLabel);
			panel_1.remove(okayLabel);
			progressBar.setForeground(Color.RED);
		}
		progressBar.setValue(percent);
	}
}
