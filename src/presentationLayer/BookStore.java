package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import BusinessLogic.BookLogic;
import DataAccess.BookAccess;

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
		frame.setBounds(100, 100, 876, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.window);
		textPane.setBounds(15, 83, 205, 240);
		frame.getContentPane().add(textPane);
		textField = new JTextField();
		textField.setBounds(395, 183, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(602, 86, 223, 227);
		frame.getContentPane().add(textPane_1);

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
				ArrayList<String> result = b.filterAuthor(author);
				if (result.isEmpty()) {
					// System.out.println("e gol!");
				} else {
					for (String j : result)
						// System.out.println(j);
						textPane.setText(textPane.getText() + "\n" + j);
				}

			}
		});
		btnFilter.setBounds(426, 64, 115, 29);
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
		btnAddToReading.setBounds(288, 134, 240, 29);
		frame.getContentPane().add(btnAddToReading);

		JLabel lblReadingList = new JLabel("Reading List");
		lblReadingList.setBounds(663, 41, 130, 29);
		frame.getContentPane().add(lblReadingList);

		textField_1 = new JTextField();
		textField_1.setBounds(395, 249, 146, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblTitleOfThe = new JLabel("title of the book");
		lblTitleOfThe.setBounds(246, 186, 122, 20);
		frame.getContentPane().add(lblTitleOfThe);

		JLabel lblYourUsername = new JLabel("your username");
		lblYourUsername.setBounds(246, 252, 122, 20);
		frame.getContentPane().add(lblYourUsername);

		JLabel lblBooks = new JLabel("Books");
		lblBooks.setBounds(81, 45, 69, 20);
		frame.getContentPane().add(lblBooks);

		JLabel lblIfABook = new JLabel("* If a book is not available, you will join waiting list automaticaly");
		lblIfABook.setBounds(202, 351, 522, 20);
		frame.getContentPane().add(lblIfABook);

		JButton btnSeeWaitingList = new JButton("See waiting list");
		btnSeeWaitingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSeeWaitingList.setBounds(693, 347, 146, 29);
		frame.getContentPane().add(btnSeeWaitingList);

		JButton btnReturnBook = new JButton("Return book");
		btnReturnBook.setBounds(35, 347, 136, 29);
		frame.getContentPane().add(btnReturnBook);
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
