package BasicBankingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankTransferGUI extends JFrame {

	private JPanel contentPane;
	private JTextField amount;
	private JTextField toAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankTransferGUI frame = new BankTransferGUI();
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
	public BankTransferGUI() {
		setTitle("Basic Banking System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BankTransferGUI.class.getResource("/Images/Basic Banking System Logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 40, 351, 482);
		panel.setBackground(Color.white);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Transfer");
		lblNewLabel_1.setBounds(136, 11, 113, 51);
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Amount");
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(85, 102, 113, 21);
		panel.add(lblNewLabel_2);
		
		amount = new JTextField();
		amount.setForeground(new Color(0, 0, 0));
		amount.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 18));
		amount.setBounds(104, 130, 171, 30);
		amount.setBorder(null);
		panel.add(amount);
		amount.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(85, 165, 197, 2);
		panel.add(separator);
		
		toAccount = new JTextField();
		toAccount.setForeground(Color.BLACK);
		toAccount.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 18));
		toAccount.setColumns(10);
		toAccount.setBorder(null);
		toAccount.setBounds(104, 248, 171, 30);
		panel.add(toAccount);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(85, 282, 197, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("To (Account Number)");
		lblNewLabel_2_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(85, 216, 153, 21);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(BankTransferGUI.class.getResource("/Images/Amount Icon.png")));
		lblNewLabel_3_1_1.setBounds(25, 113, 85, 64);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1.setIcon(new ImageIcon(BankTransferGUI.class.getResource("/Images/Send Icon.png")));
		lblNewLabel_3_1_1_1.setBounds(25, 231, 85, 64);
		panel.add(lblNewLabel_3_1_1_1);
		
		/**
		 * set cursor to hand cursor if the cursor enters the label.
		 * set cursor to default cursor if the cursor exits the label.
		 * if clicked, transfer the amount to the user's account number
		 * disposes of window and opens BankHomeGUI.
		 */
		JButton btnNewButton = new JButton("TRANSFER");
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
				dispose();
				BankHomeGUI home = new BankHomeGUI();
				home.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.decode("#3a89e6"));
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 13));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(102, 363, 153, 36);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BankTransferGUI.class.getResource("/Images/BasicBankingSystem Transfer-View Background.png")));
		lblNewLabel.setBounds(-739, -145, 1324, 818);
		contentPane.add(lblNewLabel);
	}
}
