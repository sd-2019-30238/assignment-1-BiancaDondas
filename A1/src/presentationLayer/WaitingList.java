package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import bussinessLogic.UserLogic;
import dataAccess.BookAccess;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class WaitingList {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaitingList window = new WaitingList();
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
	public WaitingList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(78, 92, 273, 264);
		frame.getContentPane().add(textPane);
		
		JButton btnShowWaitingList = new JButton("Show Waiting list");
		btnShowWaitingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogic ul = new UserLogic();
				ArrayList<String> waitlist = ul.Waiting();
				if (waitlist.isEmpty()) {
					//JOptionPane.showMessageDialog(null, "There are no");
				} else {
					for (String j : waitlist)
						textPane.setText(textPane.getText() + "\n" + j);
				}
			}
		});
		btnShowWaitingList.setBounds(123, 32, 162, 29);
		frame.getContentPane().add(btnShowWaitingList);
		
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
