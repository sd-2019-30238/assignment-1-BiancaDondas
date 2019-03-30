package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import bussinessLogic.BookLogic;
import bussinessLogic.Recomandations;
import bussinessLogic.Trends;
import bussinessLogic.recomandationFactory;
import dataAccess.BookAccess;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BookStore {

	private JFrame frame;
	private JTextField txtFilterBy;
	private JTextField textField;
	private ArrayList<String> list = new ArrayList<String>();
	private JTextField textField_1;

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
		frame.setBounds(100, 100, 876, 589);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.window);
		textPane.setBounds(15, 195, 205, 240);
		frame.getContentPane().add(textPane);
		textField = new JTextField();
		textField.setBounds(395, 295, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(419, 144, 146, 26);
		comboBox.addItem("By title");
		comboBox.addItem("By author");
		comboBox.addItem("By genre");
		comboBox.setSelectedItem(null);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("Trends");
		comboBox_1.addItem("Genre");

		//comboBox_1.setSelectedItem(null);
		comboBox_1.setBounds(245, 96, 146, 26);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("crime");
		comboBox_2.addItem("history");
		comboBox_2.addItem("software");
		comboBox_2.setBounds(245, 144, 143, 26);
		frame.getContentPane().add(comboBox_2);
		

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(602, 198, 223, 227);
		BookLogic b = new BookLogic();
			for (String j : b.books())
				textPane.setText(textPane.getText() + "\n" + j);
		frame.getContentPane().add(textPane_1);

		txtFilterBy = new JTextField();
		txtFilterBy.setText("Filter by");
		txtFilterBy.setBounds(419, 96, 146, 26);
		frame.getContentPane().add(txtFilterBy);
		txtFilterBy.setColumns(10);
		

		JButton btnFilter = new JButton("Filter");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookLogic b = new BookLogic();
				String filter = (String) comboBox.getSelectedItem();
				if (filter.equals("By author")) {
					textPane.setText(null);
					String author = txtFilterBy.getText();
					ArrayList<String> result = b.filterAuthor(author);
					if (result.isEmpty()) {
						JOptionPane.showMessageDialog(null, "There are no books by that author");
					} else {
						for (String j : result)
							textPane.setText(textPane.getText() + "\n" + j);
					}
				}
				else if(filter.equals("By genre"))
				{
					textPane.setText(null);
					String genre = txtFilterBy.getText();
					ArrayList<String> result = b.filterGenre(genre);
					if (result.isEmpty()) {
						JOptionPane.showMessageDialog(null, "There are no books in that genre");
					} else {
						for (String j : result)
							textPane.setText(textPane.getText() + "\n" + j);
					}
				}
				else if(filter.equals("By title"))
				{
					textPane.setText(null);
					String title = txtFilterBy.getText();
					ArrayList<String> result = b.filterTitle(title);
					if (result.isEmpty()) {
						JOptionPane.showMessageDialog(null, "There are no books with that title");
					} else {
						for (String j : result)
							textPane.setText(textPane.getText() + "\n" + j);
					}
				}

			}
		});
		btnFilter.setBounds(440, 195, 115, 29);
		frame.getContentPane().add(btnFilter);

		JButton btnAddToReading = new JButton("Add to reading list");
		btnAddToReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookLogic book = new BookLogic();
				String title = textField.getText();
				String username = textField_1.getText();
				try {
					book.available(username, title);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String result1 = book.show(username);
				// for (String j: result1)
				// System.out.println(j);
				textPane_1.setText(textPane_1.getText() + "\n" + title);
				textField.setText(null);
				textField_1.setText(null);
			}

		});
		btnAddToReading.setBounds(288, 246, 240, 29);
		frame.getContentPane().add(btnAddToReading);

		JLabel lblReadingList = new JLabel("Reading List");
		lblReadingList.setBounds(663, 153, 130, 29);
		frame.getContentPane().add(lblReadingList);

		textField_1 = new JTextField();
		textField_1.setBounds(395, 361, 146, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblTitleOfThe = new JLabel("title of the book");
		lblTitleOfThe.setBounds(246, 298, 122, 20);
		frame.getContentPane().add(lblTitleOfThe);

		JLabel lblYourUsername = new JLabel("your username");
		lblYourUsername.setBounds(246, 364, 122, 20);
		frame.getContentPane().add(lblYourUsername);

		JLabel lblBooks = new JLabel("Books");
		lblBooks.setBounds(81, 157, 69, 20);
		frame.getContentPane().add(lblBooks);

		JLabel lblIfABook = new JLabel("* If a book is not available, you will join waiting list automaticaly");
		lblIfABook.setBounds(202, 463, 522, 20);
		frame.getContentPane().add(lblIfABook);

		JButton btnSeeWaitingList = new JButton("Go to waiting list");
		btnSeeWaitingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WaitingList wl = new WaitingList();
				wl.getFrame().setVisible(true);
			}
		});
		btnSeeWaitingList.setBounds(678, 459, 161, 29);
		frame.getContentPane().add(btnSeeWaitingList);

		JButton btnReturnBook = new JButton("Return book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title= textField.getText();
				String email = textField_1.getText();
				BookLogic b = new BookLogic();
				
				b.requestReturn(email, title);
				textPane.setText(null);
				textPane_1.setText(null);
			}
		});
		btnReturnBook.setBounds(35, 459, 136, 29);
		frame.getContentPane().add(btnReturnBook);
		
		JButton btnGetRecomandation = new JButton("Get recomandation!");
		btnGetRecomandation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String combo = (String) comboBox_1.getSelectedItem();
				String combo1 = (String) comboBox_2.getSelectedItem();
				System.out.println(combo + combo1);
				recomandationFactory rec = new recomandationFactory();
				Recomandations r1 = rec.gettReco(combo);		
				textPane.setText(textPane.getText() + "\n" + 	r1.getRecomandation(combo1));
				textPane.updateUI();
			}
		});
		btnGetRecomandation.setBounds(235, 195, 171, 29);
		frame.getContentPane().add(btnGetRecomandation);
		
	
	

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

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}
}
