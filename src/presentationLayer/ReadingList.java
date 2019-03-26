package presentationLayer;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextPane;

import BusinessLogic.BookLogic;
import DataAccess.Conn;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReadingList {
	private static Connection con=Conn.getConnection();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadingList window = new ReadingList();
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
	public ReadingList() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 616, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(96, 89, 278, 269);
		
		
		
		JButton btnBtn = new JButton("btn");
		btnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookStore bookStore=new BookStore();
				ArrayList<String> list=bookStore.getList();
				for(String t: list) {
					textPane.setText(t);
					System.out.println(list);
					
				}
				textPane.setText("ajshja");
				
			}
		});
		frame.getContentPane().add(textPane);
		btnBtn.setBounds(403, 89, 115, 29);
		frame.getContentPane().add(btnBtn);

		/*String query="Select * from readingList";
		Statement statement=con.createStatement();
		ResultSet result=statement.executeQuery(query);
		while(result.next()) {
			//System.out.println(result.getString(2)+"\n"+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
			textPane.setText(result.getString(1));
		}*/
		
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
