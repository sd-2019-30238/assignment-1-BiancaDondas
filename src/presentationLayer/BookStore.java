package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import BusinessLogic.BookLogic;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BookStore {

	private JFrame frame;
	private JTextField txtFilterBy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookStore window = new BookStore();
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
	public BookStore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(127, 54, 26, 48);
		frame.getContentPane().add(scrollBar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.window);
		textPane.setBounds(37, 54, 116, 155);
		frame.getContentPane().add(textPane);
		
		txtFilterBy = new JTextField();
		txtFilterBy.setText("Filter by");
		txtFilterBy.setBounds(235, 65, 146, 26);
		frame.getContentPane().add(txtFilterBy);
		txtFilterBy.setColumns(10);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookLogic b = new BookLogic();
				String author = txtFilterBy.getText();
				ArrayList<String> result=b.filterAuthor(author);
				if(result.isEmpty())
				{
					//System.out.println("e gol!");
				}else {
					for (String j: result)
						//System.out.println(j);
					textPane.setText(textPane.getText()+"\n"+j);
				}
					
			}
		});
		btnFilter.setBounds(432, 73, 115, 29);
		frame.getContentPane().add(btnFilter);
		
		JButton btnNewButton = new JButton("Go to reading list");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookLogic b = new BookLogic();
				//if(b.available(title))
				ReadingList readingList = new ReadingList();
				readingList.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(295, 291, 240, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddToReading = new JButton("Add to reading list");
		btnAddToReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddToReading.setBounds(295, 246, 240, 29);
		frame.getContentPane().add(btnAddToReading);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtFilterBy() {
		return txtFilterBy;
	}

	public void setTxtFilterBy(JTextField txtFilterBy) {
		this.txtFilterBy = txtFilterBy;
	}
}
