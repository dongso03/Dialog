import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LogingToPizza extends JFrame {

	private JPanel contentPane;
	private JPanel pizza;
	private JTextField tfID;
	private JPasswordField passwordField;
	private JPanel two;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;

	public LogingToPizza() {
		init();
		two = new JPanel();
		pizza = new JPanel();
//		contentPane = new JPanel();

		CardLayout layout = new CardLayout();
		two.setLayout(layout);

		two.add(contentPane, "로그아웃");
		two.add(pizza, "로그인");
		SpringLayout sl_pizza = new SpringLayout();
		pizza.setLayout(sl_pizza);
		
		btnNewButton_1 = new JButton("로그아웃");
		sl_pizza.putConstraint(SpringLayout.NORTH, btnNewButton_1, 39, SpringLayout.NORTH, pizza);
		sl_pizza.putConstraint(SpringLayout.WEST, btnNewButton_1, 163, SpringLayout.WEST, pizza);
		pizza.add(btnNewButton_1);
		
		ActionListener l2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(two, e.getActionCommand());
				tfID.setText(null);
				passwordField.setText(null);
			}
		};

		ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String id = tfID.getText();
				String password = passwordField.getText();

				if (id.equals("admin") && password.equals("1234")) {
				//	layout.show(two, e.getActionCommand());
					setVisible(false);
					new MenuPrice();
				} else {
					lblNewLabel.setText("로그인실패");
				}
			}
		};
		btnNewButton.addActionListener(l);
		btnNewButton_1.addActionListener(l2);

		getContentPane().add(two);

		showGUI();
	}

	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		lblNewLabel = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -70, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel);

		btnNewButton = new JButton("로그인");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 25, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 82, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 141, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -52, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);

		tfID = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, tfID, 88, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, tfID, -29, SpringLayout.WEST, btnNewButton);
		contentPane.add(tfID);
		tfID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 34, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("패스워드");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -23, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, btnNewButton);
		contentPane.add(lblNewLabel_2);

		passwordField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.WEST, tfID, 0, SpringLayout.WEST, passwordField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tfID, -23, SpringLayout.NORTH, passwordField);
		sl_contentPane.putConstraint(SpringLayout.EAST, passwordField, -29, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, passwordField, -310, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, passwordField, 126, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, passwordField, 44, SpringLayout.EAST, lblNewLabel_2);
		contentPane.add(passwordField);

	}

	public static void main(String[] args) {
		new LogingToPizza();

	}
}
