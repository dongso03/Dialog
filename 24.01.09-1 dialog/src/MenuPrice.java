
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.acl.Group;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;

public class MenuPrice extends JFrame {
	public MenuPrice() {
		JRadioButton rdoSuji = new JRadioButton("페페로니 피자");
		JRadioButton rdoDaechang = new JRadioButton("치즈 피자");
		JRadioButton rdoMushroom = new JRadioButton("불고기 피자");

		

		ButtonGroup grp = new ButtonGroup();
		grp.add(rdoSuji);
		grp.add(rdoDaechang);
		grp.add(rdoMushroom);

		rdoSuji.setSelected(true);

		JPanel pnl = new JPanel();
		SpringLayout sl_pnl = new SpringLayout();
		sl_pnl.putConstraint(SpringLayout.NORTH, rdoMushroom, 94, SpringLayout.SOUTH, rdoDaechang);
		sl_pnl.putConstraint(SpringLayout.WEST, rdoMushroom, 0, SpringLayout.WEST, rdoSuji);
		sl_pnl.putConstraint(SpringLayout.NORTH, rdoDaechang, 88, SpringLayout.SOUTH, rdoSuji);
		sl_pnl.putConstraint(SpringLayout.WEST, rdoDaechang, 0, SpringLayout.WEST, rdoSuji);
		sl_pnl.putConstraint(SpringLayout.NORTH, rdoSuji, 106, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, rdoSuji, 76, SpringLayout.WEST, pnl);
		
		pnl.setLayout(sl_pnl);
		pnl.add(rdoSuji);
		pnl.add(rdoDaechang);
		pnl.add(rdoMushroom);

		

		getContentPane().add(pnl);

		JCheckBox chckbxNewCheckBox = new JCheckBox("피클 추가");
		sl_pnl.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox, 0, SpringLayout.NORTH, rdoSuji);
		sl_pnl.putConstraint(SpringLayout.WEST, chckbxNewCheckBox, 172, SpringLayout.EAST, rdoSuji);
		pnl.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("치즈 추가");
		sl_pnl.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_1, 0, SpringLayout.NORTH, rdoDaechang);
		sl_pnl.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_1, 0, SpringLayout.WEST, chckbxNewCheckBox);
		pnl.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("핫소스 추가");
		sl_pnl.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_2, 0, SpringLayout.NORTH, rdoMushroom);
		sl_pnl.putConstraint(SpringLayout.WEST, chckbxNewCheckBox_2, 0, SpringLayout.WEST, chckbxNewCheckBox);
		pnl.add(chckbxNewCheckBox_2);

		JLabel lblNewLabel = new JLabel("가격");
		sl_pnl.putConstraint(SpringLayout.WEST, lblNewLabel, 244, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lblNewLabel, -80, SpringLayout.SOUTH, pnl);
		pnl.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("선택 초기화");
		sl_pnl.putConstraint(SpringLayout.NORTH, btnNewButton, 31, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnNewButton, 238, SpringLayout.WEST, pnl);
		pnl.add(btnNewButton);
		
		ActionListener act = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				  rdoSuji.setSelected(true);  // 라디오 버튼 초기화
			        chckbxNewCheckBox.setSelected(false);  // 체크박스 초기화
			        chckbxNewCheckBox_1.setSelected(false);
			        chckbxNewCheckBox_2.setSelected(false);
			        lblNewLabel.setText("가격");  // 라벨 초기화
			    }
		};

		ItemListener lis = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int basePrice = 0;

				if (rdoSuji.isSelected()) {
					basePrice = 20000;
				} else if (rdoDaechang.isSelected()) {
					basePrice = 15000;
				} else if (rdoMushroom.isSelected()) {
					basePrice = 23000;
				}

				int additionalPrice = 0;

				if (chckbxNewCheckBox.isSelected()) {
					additionalPrice += 500;
				}

				if (chckbxNewCheckBox_1.isSelected()) {
					additionalPrice += 300;
				}

				if (chckbxNewCheckBox_2.isSelected()) {
					additionalPrice += 700;
				}

				int totalPrice = basePrice + additionalPrice;
				lblNewLabel.setText("가격: " + totalPrice + "원");
			}
		};

		rdoSuji.addItemListener(lis);
		rdoDaechang.addItemListener(lis);
		rdoMushroom.addItemListener(lis);
		chckbxNewCheckBox.addItemListener(lis);
		chckbxNewCheckBox_1.addItemListener(lis);
		chckbxNewCheckBox_2.addItemListener(lis);
		btnNewButton.addActionListener(act);

		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {

		new MenuPrice();
	}
}
