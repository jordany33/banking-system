package BasicBankingSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

public class BankNewAccountGUI extends  JFrame{

	protected JPanel contentPane;
	protected DefaultTableModel model;
	protected JRadioButton checking;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankNewAccountGUI frame = new BankNewAccountGUI();
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
	public BankNewAccountGUI() {
		setTitle("Basic Banking System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BankTransferGUI.class.getResource("/Images/Basic Banking System Logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 40, 351, 361);
		panel.setBackground(Color.white);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Open an account");
		lblNewLabel_1.setBounds(91, 11, 164, 51);
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		/**
		 * set cursor to hand cursor if the cursor enters the label.
		 * set cursor to default cursor if the cursor exits the label.
		 * creates a new account of type checking or saving and stores it in user's account.
		 * disposes window and opens BankHomeGUI.
		 */
		JButton btnNewButton = new JButton("CREATE");
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
				String accType = checking.getText();

				try { 
					Customer customerAcc = new Customer();
					customerAcc.createAccount(accType);
					customerAcc.addAccountsToFile();
					
					dispose();
					BankHomeGUI home = new BankHomeGUI();
					home.setVisible(true);
				} catch(Exception error) {}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.decode("#3a89e6"));
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 13));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(96, 271, 153, 36);
		panel.add(btnNewButton);
		
		/**
		 * set cursor to hand cursor if the cursor enters the label.
		 * set cursor to default cursor if the cursor exits the label.
		 * selects checking for the type of account to be created.
		 */
		checking = new JRadioButton("Checking");
		checking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		checking.setForeground(Color.BLACK);
		checking.setBackground(Color.white);
		checking.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		checking.setBounds(71, 112, 77, 36);
		checking.setFocusPainted(false);
		panel.add(checking);
		
		/**
		 * set cursor to hand cursor if the cursor enters the label.
		 * set cursor to default cursor if the cursor exits the label.
		 * selects saving for the type of account to be created.
		 */
		JRadioButton rdbtnSaving = new JRadioButton("Saving");
		rdbtnSaving.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		rdbtnSaving.setForeground(Color.BLACK);
		rdbtnSaving.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		rdbtnSaving.setBackground(Color.WHITE);
		rdbtnSaving.setBounds(209, 112, 63, 36);
		rdbtnSaving.setFocusPainted(false);
		panel.add(rdbtnSaving);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BankTransferGUI.class.getResource("/Images/BasicBankingSystem Transfer-View Background.png")));
		lblNewLabel.setBounds(-739, -145, 1324, 818);
		contentPane.add(lblNewLabel);
	}
}
