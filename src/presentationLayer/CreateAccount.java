package presentationLayer;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import BusinessLogic.UserLogic;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class CreateAccount extends JFrame{

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
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
	public CreateAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 622, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(98, 126, 98, 20);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(98, 174, 98, 20);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(98, 225, 69, 20);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(98, 277, 98, 20);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setBounds(98, 325, 146, 20);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(277, 322, 190, 26);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(277, 274, 190, 26);
		frame.getContentPane().add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(277, 171, 190, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(277, 123, 190, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(277, 232, 190, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Weekly");
		comboBox.addItem("Montly");
		comboBox.addItem("Once a year");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(277, 382, 190, 26);
		frame.getContentPane().add(comboBox);
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogic u = new UserLogic();
				String nume = textField.getText();
				String payment = (String) comboBox.getSelectedItem();
				String lastName = textField_1.getText();
				String email = textField_2.getText();
				char[] p1 = passwordField.getPassword();
				String pass = "";
			    for(char x : p1) {
			    pass += x;
			    }
			    char[] p2 = passwordField_1.getPassword();
				String pass1 = "";
			    for(char x : p2) {
			     pass1 += x;
			    }
				if(pass.equals(pass1) && !nume.equals(null) && !lastName.equals(null) && !email.equals(null))
					{
						u.adaugaClient(nume, lastName, email,pass,payment,"Yes");
						u.adaugaPay(email, payment);
						frame.setVisible(false);
						Login loginFrame =  new Login();
						loginFrame.getFrame().setVisible(true);
					}
					
				else 
				{
					JOptionPane.showMessageDialog(null, "Passwords doesn't match");
				}
				
			}
		});
		btnSignUp.setBounds(214, 504, 115, 29);
		frame.getContentPane().add(btnSignUp);
		
		JCheckBox chckbxAcceptTermsAnd = new JCheckBox("Accept terms and conditions");
		chckbxAcceptTermsAnd.setBounds(163, 452, 275, 29);
		frame.getContentPane().add(chckbxAcceptTermsAnd);
		
		JLabel lblChoosePayment = new JLabel("Choose payment");
		lblChoosePayment.setBounds(98, 385, 146, 20);
		frame.getContentPane().add(lblChoosePayment);
		
		
		
		JLabel lblCreateANew = new JLabel("Create a new account!");
		lblCreateANew.setForeground(Color.BLUE);
		lblCreateANew.setFont(new Font("Goudy Old Style", Font.BOLD, 27));
		lblCreateANew.setBounds(165, 30, 261, 64);
		frame.getContentPane().add(lblCreateANew);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JPasswordField getPasswordField_1() {
		return passwordField_1;
	}

	public void setPasswordField_1(JPasswordField passwordField_1) {
		this.passwordField_1 = passwordField_1;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}
}
