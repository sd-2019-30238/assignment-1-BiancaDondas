package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BusinessLogic.UserLogic;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientReturnBook {

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
					ClientReturnBook window = new ClientReturnBook();
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
	public ClientReturnBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(195, 78, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(195, 120, 146, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblYourEmail = new JLabel("Your email");
		lblYourEmail.setBounds(38, 81, 100, 20);
		frame.getContentPane().add(lblYourEmail);
		
		JLabel lblBookTitle = new JLabel("Book title");
		lblBookTitle.setBounds(48, 123, 69, 20);
		frame.getContentPane().add(lblBookTitle);
		
		JButton btnReturn = new JButton("Return!");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email = textField.getText();
				String title = textField_1.getText();
				UserLogic u  = new UserLogic();
				u.returnBook(email, title);
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnReturn.setBounds(135, 180, 115, 29);
		frame.getContentPane().add(btnReturn);
	}
}
