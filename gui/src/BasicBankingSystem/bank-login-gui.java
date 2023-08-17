package BasicBankingSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.text.AttributedString;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class BankLoginGUI extends JFrame {

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
					BankLoginGUI frame = new BankLoginGUI();
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
	public BankLoginGUI() {
		setTitle("Basic Banking System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BankLoginGUI.class.getResource("/Images/Basic Banking System Logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		lblNewLabel_1.setIcon(new ImageIcon(BankLoginGUI.class.getResource("/Images/Bank of Computer Science Logo.png")));
		lblNewLabel_1.setBounds(153, 11, 452, 150);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(87, 51, 709, 388);
		panel.setBackground(Color.white);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Bank of Computer Science");
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 30));
		lblNewLabel_2.setBounds(171, 11, 465, 118);
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
		lblNewLabel_4.setIcon(new ImageIcon(BankLoginGUI.class.getResource("/Images/Password Icon.png")));
		lblNewLabel_4.setBounds(134, 228, 98, 33);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(BankLoginGUI.class.getResource("/Images/Username Icon.png")));
		lblNewLabel_4_1.setBounds(136, 156, 84, 33);
		panel.add(lblNewLabel_4_1);
		
		/**
		 * set cursor to hand cursor if the cursor enters the button.
		 * set cursor to default cursor if the cursor exits the button.
		 * if the button is clicked, validate the user's input with the stored account data.
		 * if user's input matches account data, dispose window and open BankHomeGUI.
		 */
		JButton btnNewButton = new JButton("LOGIN");
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
				boolean loggedIn = false;
				
				try {
					customer = new Customer(username, password);
			        boolean facts = customer.findCustomer(username, password);
			        if(facts) {
						loggedIn = true;
					}
				} catch(Exception error) {}
				
				if(loggedIn) {
					dispose();
					BankHomeGUI homeView = new BankHomeGUI();
					homeView.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Sorry, we can't find an account with this username or password.");
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.decode("#3a89e6"));
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 13));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(191, 291, 333, 42);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Don't have an account?");
		lblNewLabel_5.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(265, 344, 123, 21);
		panel.add(lblNewLabel_5);
		
		/**
		 * set cursor to hand cursor if the cursor enters the label.
		 * set cursor to default cursor if the cursor exits the label.
		 * underline the label's text if cursor enters the range of it's borders.
		 * remove the underline if cursor exits the range of it's borders.
		 * if user clicks on label, dispose window and open BankRegisterGUI.
		 */
		JLabel lblNewLabel_5_1 = new JLabel("Register");
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
				BankRegisterGUI register = new BankRegisterGUI();
				register.setVisible(true);
			}
		});
		lblNewLabel_5_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 11));
		lblNewLabel_5_1.setBounds(387, 345, 47, 21);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BankLoginGUI.class.getResource("/Images/BasicBankingSystem Login Background.png")));
		lblNewLabel.setBounds(-477, 0, 1361, 561);
		contentPane.add(lblNewLabel);
	}
}
