import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CustomerMainPage extends JFrame{

	public CustomerMainPage() {
		JFrame cMainPage = new JFrame("Book store for customer");
		JPanel controlPanel = new JPanel();
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		JLabel j1 = new JLabel("Welcome to Unique Book Store!");
		j1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton search = new JButton("search");
		search.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton cart = new JButton("cart");
		cart.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton myOrder = new JButton ("my order");
		myOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton check = new JButton ("check order");
		check.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton logout = new JButton("log out");
		logout.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		main.add(j1);
		main.add(search);
		main.add(cart);
		main.add(myOrder);
		main.add(check);
		main.add(logout);
		

		
		
		JPanel searchPage = new JPanel();
		searchPage.setLayout(new BoxLayout(searchPage, BoxLayout.Y_AXIS));
		JTextField value = new JTextField();
		value.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel j2 = new JLabel("search book by");
		j2.setAlignmentX(Component.CENTER_ALIGNMENT);
		String[] option = {"name","author","ISBN","genre"};
		JList list = new JList(option);
		list.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton ok = new JButton("OK");
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JPanel show = new JPanel();
				String key = (String)list.getSelectedValue();
				String word = value.getText();
				ArrayList<String> books = sqlSearch(key,word);
				if (books.isEmpty()) {
					books.add("No result");
				}
				//JOptionPane.showMessageDialog(null,books,JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		
		JButton ret = new JButton("return");
		ret.setAlignmentX(Component.CENTER_ALIGNMENT);
		ret.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controlPanel.remove(searchPage);
				controlPanel.add(main);
				controlPanel.revalidate();
				controlPanel.repaint();
			}
		});
		
		searchPage.add(value);
		searchPage.add(j2);
		searchPage.add(list);
		searchPage.add(ok);
		searchPage.add(ret);
		
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controlPanel.remove(main);
				controlPanel.add(searchPage);
				controlPanel.revalidate();
				controlPanel.repaint();
				
			}
		});
		controlPanel.add(main);
		cMainPage.add(controlPanel);
		
		cMainPage.setBounds(500,500,500,500);
		cMainPage.setVisible(true);
		cMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public ArrayList<String> sqlSearch(String key,String value) {
		ArrayList<String> books = new ArrayList<String>();
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BookStore",  "postgres", "Crystal2013");
	            Statement statement = connection.createStatement();
				)
				{
				try {
					String state = "(select * from book where " + key +" = '" + value + "')";
					System.out.println(state);
					ResultSet rs = statement.executeQuery(state);
                    while (rs.next()) {
                           System.out.println(rs.getString(1));
                           books.add(rs.getString(1));
                        
                    }
					return books;
					
				} catch (Exception sqle) {
		            System.out.println("Exception: " + sqle);
		        }
	            

	    
	        } catch (Exception sqle) {
	            System.out.println("Exception: " + sqle);
	        }
		return books;
	}
	
	 public static void main(String[] args){
		   new CustomerMainPage();
	 }
}
