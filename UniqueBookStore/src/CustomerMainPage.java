import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CustomerMainPage extends JFrame{

	public CustomerMainPage() {
		JFrame cMainPage = new JFrame("Book store for customer");
		JPanel main = new JPanel();
		JLabel j1 = new JLabel("Welcome to Unique Book Store!");
		
		JButton search = new JButton("search");
		JButton cart = new JButton("cart");
		JButton myOrder = new JButton ("my order");
		JButton check = new JButton ("check order");
		JButton logout = new JButton("log out");
		
		JButton ret = new JButton("return");
		ret.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				main.setVisible(true);
			}
		});
		
		
		main.add(search);
		main.add(cart);
		main.add(myOrder);
		main.add(check);
		main.add(logout);
		
		
		
		JPanel searchPage = new JPanel();
		JLabel j2 = new JLabel("search by");
		searchPage.add(ret);

		
		cMainPage.add(main);
		//cMainPage.add(searchPage);
		searchPage.setVisible(false);
		
		cMainPage.setBounds(500,500,500,500);
		cMainPage.setVisible(true);
		cMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	 public static void main(String[] args){
		   new CustomerMainPage();
	 }
}
