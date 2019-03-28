package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BusinessLogic.StaffLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class ReturnBook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public ReturnBook() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 746, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(46, 134, 69, 20);
		frame.getContentPane().add(lblEmail);

		JLabel lblBookTitle = new JLabel("Book title:");
		lblBookTitle.setBounds(46, 182, 82, 20);
		frame.getContentPane().add(lblBookTitle);

		textField = new JTextField();
		textField.setBounds(160, 131, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(160, 179, 146, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffLogic staff = new StaffLogic();
				String email = textField.getText();
				String title = textField_1.getText();
				staff.bookReturn(email, title);
				try {
					staff.verifyReturn(email, title);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnReturn.setBounds(139, 269, 115, 29);
		frame.getContentPane().add(btnReturn);

		JLabel lblReturnBook = new JLabel("Return Book!");
		lblReturnBook.setBounds(132, 48, 140, 20);
		frame.getContentPane().add(lblReturnBook);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(384, 73, 253, 261);
		StaffLogic staff = new StaffLogic();
		ArrayList<String> result = staff.showReturnedBook();
		if (result.isEmpty()) {
			// System.out.println("e gol!");
		} else {
			for (String j : result)
				// System.out.println(j);
				textPane.setText(textPane.getText() + "\n" + j);
		}

		frame.getContentPane().add(textPane);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
