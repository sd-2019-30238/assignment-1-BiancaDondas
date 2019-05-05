package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import bussinessLogic.StaffLogic;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyPayment {

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
					ModifyPayment window = new ModifyPayment();
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
	public ModifyPayment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 439, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(165, 73, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(165, 115, 146, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		JButton btnAddPayment = new JButton("Add payment");
		btnAddPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffLogic staff = new StaffLogic();
				String email = textField.getText();
				String payed = textField_1.getText();
				staff.verifyPayed(email, payed);
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		btnAddPayment.setBounds(110, 185, 153, 29);
		frame.getContentPane().add(btnAddPayment);

		JLabel lblUser = new JLabel("User email:");
		lblUser.setBounds(26, 76, 104, 20);
		frame.getContentPane().add(lblUser);

		JLabel lblPayed = new JLabel("Payed?");
		lblPayed.setBounds(36, 118, 69, 20);
		frame.getContentPane().add(lblPayed);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
