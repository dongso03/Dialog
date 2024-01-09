import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class NameFrame extends JFrame {
	public NameFrame() {
		JButton btn = new JButton("입력 대화창");

		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel("");
		pnl.add(lbl);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(NameFrame.this, "한글 이름을 입력해주세여");
				
				String name = JOptionPane.showInputDialog(NameFrame.this, "이름을 입력하세요");
				System.out.println(name);
				if (name != null) {
					lbl.setText(name);
				} else {
					lbl.setText("취소 하셨습니다.");
				}
			}
		});

		add(btn, "North");
		add(pnl, "Center");

		showGUI();
	}

	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class TestInputOptionPane {
	public static void main(String[] args) {
		new NameFrame();
	}
}
