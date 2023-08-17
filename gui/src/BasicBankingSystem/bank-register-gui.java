package BasicBankingSystem;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class BankRegisterGUI extends JFrame, Customer {

	private JPanel contentPane;
	private JTextField uNameField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankRegisterGUI frame = new BankRegisterGUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankRegisterGUI() {
		setTitle("Basic Banking System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BankRegisterGUI.class.getResource("/Images/Basic Banking System Logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		lblNewLabel_1.setIcon(new ImageIcon(BankRegisterGUI.class.getResource("/Images/Bank of Computer Science Logo.png")));
		lblNewLabel_1.setBounds(153, 11, 452, 150);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(87, 51, 709, 388);
		panel.setBackground(Color.white);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Create Account");
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 30));
		lblNewLabel_2.setBounds(248, 12, 317, 118);
		panel.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(191, 259, 333, 14);
		panel.add(separator);
		
		uNameField = new JTextField();
		uNameField.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		uNameField.setBounds(223, 165, 333, 14);
		uNameField.setBorder(null);
		panel.add(uNameField);
		uNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(223, 240, 333, 14);
		passwordField.setBorder(null);
		panel.add(passwordField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(191, 190, 333, 14);
		panel.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(191, 141, 84, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(191, 215, 84, 13);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(BankRegisterGUI.class.getResource("/Images/Password Icon.png")));
		lblNewLabel_4.setBounds(134, 228, 98, 33);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(BankRegisterGUI.class.getResource("/Images/Username Icon.png")));
		lblNewLabel_4_1.setBounds(136, 156, 84, 33);
		panel.add(lblNewLabel_4_1);
		
		/**
		 * set cursor to hand cursor if the cursor enters the button.
		 * set cursor to default cursor if the cursor exits the button.
		 * if user clicks button, store the username and password input.
		 */
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = uNameField.getText();
				String password = passwordField.getText();
				
				try {
					if((username.isEmpty()) || (password.isEmpty())) {
						JOptionPane.showMessageDialog(contentPane, "Your username and password must contain more than 1 character.");
					} else {
						Customer customer = new Customer(username, password);
					    customer.storeCustomer(username, password);  
					    
					    dispose();
					    BankLoginGUI loginView = new BankLoginGUI();
					    loginView.setVisible(true);
					}
				} catch(Exception error) {}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.decode("#3a89e6"));
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 13));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(191, 291, 333, 42);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Already have an account?");
		lblNewLabel_5.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(267, 344, 129, 21);
		panel.add(lblNewLabel_5);
		
		/**
		 * set cursor to hand cursor if the cursor enters the button.
		 * set cursor to default cursor if the cursor exits the button.
		 * underline the label's text if cursor enters the range of it's borders.
		 * remove the underline if cursor exits the range of it's borders.
		 * if user clicks on label, dispose window and open BankLoginGUI.
		 */
		JLabel lblNewLabel_5_1 = new JLabel("Log in");
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				Font font = lblNewLabel_5_1.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblNewLabel_5_1.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
				Font font = lblNewLabel_5_1.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, -1);
				lblNewLabel_5_1.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				BankLoginGUI login = new BankLoginGUI();
				login.setVisible(true);
			}
		});
		lblNewLabel_5_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 11));
		lblNewLabel_5_1.setBounds(397, 345, 47, 21);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BankRegisterGUI.class.getResource("/Images/BasicBankingSystem Login Background.png")));
		lblNewLabel.setBounds(-477, 0, 1361, 561);
		contentPane.add(lblNewLabel);
	}
}
