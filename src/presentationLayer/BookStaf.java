package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BookStaf extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookStaf window = new BookStaf();
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
	public BookStaf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 403, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnModifyPayment = new JButton("Modify payment");
		btnModifyPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModifyPayment modify = new ModifyPayment();
				modify.getFrame().setVisible(true);
				
			}
		});
		btnModifyPayment.setBounds(96, 95, 174, 29);
		frame.getContentPane().add(btnModifyPayment);
		
		JButton btnNewButton = new JButton("Return & Assign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook rBook = null;
				try {
					rBook = new ReturnBook();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rBook.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(96, 173, 174, 29);
		frame.getContentPane().add(btnNewButton);
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
