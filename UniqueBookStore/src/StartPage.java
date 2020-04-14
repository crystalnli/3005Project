import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;


public class StartPage extends JFrame{

	public StartPage() {
		JFrame start = new JFrame("login");
		JPanel jp = new JPanel(); 
		//jp.setLayout(new GridLayout(4,4,5,5));
		
		JLabel j1 = new JLabel("Username");
		JTextField user = new JTextField(20);
		/*user.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					user.setText("");
				}
			}
		});*/
		JLabel j2 = new JLabel("Password");
		JTextField password = new JTextField(20);
		
		JLabel j3 = new JLabel("Address");
		JTextField address = new JTextField(30);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String u = user.getText().trim();
				String p = password.getText().trim();
				int result = checkUserName(u,p);
				if(result == 1) {
					JOptionPane.showMessageDialog(start, "Invalid username or passward");
				}
				user.setText("");
				password.setText("");
			}
		});
		JButton register = new JButton("register");
		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String u = user.getText().trim();
				String p = password.getText().trim();
				int result = checkUserName(u,p);
				if(result == 1) {
					JOptionPane.showMessageDialog(start, "Username already in use");
				}
			}
		});
		
		jp.add(j1);
		jp.add(user);
		jp.add(j2);
		jp.add(password);
		jp.add(login);
		jp.add(register);
		
		start.add(jp);

		
		start.setBounds(500,500,500,500);
		start.setVisible(true);
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//public RegisterPage() {
		
	//}
	

	public int checkUserName(String name,String password) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BookStore", "postgres", "Crystal2013");
	            Statement statement = connection.createStatement();
				)
				{
				try {
					String state = "(select password from customer where username = " + name + ")";
					ResultSet resultSet = statement.executeQuery(state);
					String pw = resultSet.getString("password");
					System.out.println(pw);
					return 0;
					
				} catch (Exception sqle) {
		            System.out.println("Exception: " + sqle);
		            return 1;
		        }
	            

	    
	        } catch (Exception sqle) {
	            System.out.println("Exception: " + sqle);
	            return 1;
	        }
		}
	
	 public static void main(String[] args){
		   new StartPage();
	 }

}
