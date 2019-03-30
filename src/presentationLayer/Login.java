package presentationLayer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bussinessLogic.BookLogic;
import bussinessLogic.UserLogic;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	CreateAccount frame1 = new CreateAccount();
	private JPasswordField passwordField;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.text);
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 739, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserLogic u = new UserLogic();
				BookLogic b = new BookLogic();
				String email = textField.getText();
				char[] p = passwordField.getPassword();
				String pass = "";
				for (char x : p) {
					pass += x;
				}
				try {
					if (u.logare(email, pass) == 1) {
						if (b.payment(email)) {
							BookStore bs = new BookStore();
							bs.getFrame().setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Sorry, it seems you didn't pay your subscription");
						}
					} else if (u.logare(email, pass) == 2) {
						BookStaf bs = new BookStaf();
						bs.getFrame().setVisible(true);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		btnLogIn.setBounds(320, 313, 115, 29);
		frame.getContentPane().add(btnLogIn);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(114, 180, 105, 20);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(114, 241, 69, 20);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(287, 238, 203, 26);
		frame.getContentPane().add(passwordField);

		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblWelcome.setBounds(289, 55, 217, 55);
		frame.getContentPane().add(lblWelcome);

		JButton btnNewButton = new JButton("Create account!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount ca = new CreateAccount();
				ca.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(47, 361, 203, 29);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(287, 177, 203, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
