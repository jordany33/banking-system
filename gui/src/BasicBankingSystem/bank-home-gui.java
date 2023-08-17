package BasicBankingSystem;

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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class BankHomeGUI extends JFrame {

	private JPanel contentPane;
	protected JTable displayAccounts;
	private JTextField amountAction;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankHomeGUI frame = new BankHomeGUI();
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
	public BankHomeGUI() {
		setTitle("Basic Banking System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BankHomeGUI.class.getResource("/Images/Basic Banking System Logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 11));
		lblNewLabel_1.setIcon(new ImageIcon(BankHomeGUI.class.getResource("/Images/Bank of Computer Science Logo.png")));
		lblNewLabel_1.setBounds(101, 11, 452, 150);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(71, 51, 649, 482);
		panel.setBackground(Color.white);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Your accounts");
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		lblNewLabel_2.setBounds(251, 11, 465, 118);
		panel.add(lblNewLabel_2);
		
		displayAccounts = new JTable();
		displayAccounts.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		displayAccounts.setEnabled(false);
		displayAccounts.setShowGrid(false);
		displayAccounts.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
		displayAccounts.setBackground(new Color(240, 248, 255));
		displayAccounts.setModel(new DefaultTableModel(
			new Object[][] {
				{"Checking Account", "#12345678", "sadsadsadasdasd"},
			},
			new String[] {
				"Type", "ID", "Balance"
			}
		));
		displayAccounts.getColumnModel().getColumn(0).setPreferredWidth(30);
		displayAccounts.getColumnModel().getColumn(1).setPreferredWidth(15);
		displayAccounts.getColumnModel().getColumn(1).setMinWidth(12);
		displayAccounts.getColumnModel().getColumn(2).setPreferredWidth(50);
		displayAccounts.setRowHeight(20);
		displayAccounts.setBounds(97, 94, 446, 232);
		panel.add(displayAccounts);
		
		amountAction = new JTextField();
		amountAction.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		amountAction.setBounds(112, 366, 205, 22);
		amountAction.setBorder(null);
		panel.add(amountAction);
		amountAction.setColumns(10);
		
		/**
		 * set cursor to hand cursor if the cursor enters the label.
		 * set cursor to default cursor if the cursor exits the label.
		 * if clicked, deposit amount to the user's account balance.
		 */
		JButton btnNewButton = new JButton("DEPOSIT");
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
				double amount = Double.valueOf(amountAction.getText());
				Account deposit = new Account("adsaD");
				deposit.deposit(amount);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.decode("#3a89e6"));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 12));
		btnNewButton.setBounds(327, 361, 97, 34);
		panel.add(btnNewButton);
		
		/**
		 * set cursor to hand cursor if the cursor enters the label.
		 * set cursor to default cursor if the cursor exits the label.
		 * if clicked, withdraw amount from the user's account balance.
		 */
		JButton btnNewButton_1 = new JButton("WITHDRAW");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				double amount = Double.valueOf(amountAction.getText());
//				Account withdraw = new Account();
//				withdraw.withdraw(amount);
//			}
		});
		btnNewButton_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 12));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.decode("#3a89e6"));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBounds(434, 361, 109, 34);
		panel.add(btnNewButton_1);
		
		/**
		 * set cursor to hand cursor if the cursor enters the label.
		 * set cursor to default cursor if the cursor exits the label.
		 * if clicked, dispose window and open BankTransferGUI.
		 */
		JButton btnNewButton_2 = new JButton("TRANSFER");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
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
				BankTransferGUI transfer = new BankTransferGUI();
				transfer.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.decode("#3a89e6"));
		btnNewButton_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 12));
		btnNewButton_2.setBounds(97, 421, 144, 34);
		btnNewButton_2.setFocusPainted(false);
		panel.add(btnNewButton_2);
		
		/**
		 * set cursor to hand cursor if the cursor enters the label.
		 * set cursor to default cursor if the cursor exits the label.
		 * if clicked, dispose window and open BankNewAccountGUI.
		 */
		JButton btnNewButton_2_1 = new JButton("NEW ACCOUNT");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
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
				BankNewAccountGUI createAccount = new BankNewAccountGUI();
				createAccount.setVisible(true);
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBackground(Color.decode("#3a89e6"));
		btnNewButton_2_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 12));
		btnNewButton_2_1.setBounds(408, 421, 135, 34);
		btnNewButton_2_1.setFocusPainted(false);
		panel.add(btnNewButton_2_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(97, 392, 220, 2);
		separator.setBackground(Color.decode("#3a89e6"));
		panel.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("Amount");
		lblNewLabel_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(97, 337, 94, 27);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(BankHomeGUI.class.getResource("/Images/Amount Icon.png")));
		lblNewLabel_4.setBounds(38, 356, 77, 43);
		panel.add(lblNewLabel_4);
		
		/**
		 * remove the user's account if clicked.
		 */
		JButton btnNewButton_2_2 = new JButton("REMOVE ACCOUNT");
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		btnNewButton_2_2.setForeground(Color.WHITE);
		btnNewButton_2_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 12));
		btnNewButton_2_2.setFocusPainted(false);
		btnNewButton_2_2.setBackground(new Color(58, 137, 230));
		btnNewButton_2_2.setBounds(251, 421, 147, 34);
		panel.add(btnNewButton_2_2);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BankHomeGUI.class.getResource("/Images/BasicBankingSystem Home-View Background.png")));
		lblNewLabel.setBounds(-226, -115, 1069, 776);
		contentPane.add(lblNewLabel);
		JTextPane txtpnSdasdsada = new JTextPane();
		txtpnSdasdsada.setText("sdasdsada");
		txtpnSdasdsada.setBounds(0, 33, 189, 133);
	}
}
