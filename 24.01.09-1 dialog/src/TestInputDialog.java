import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class InputMainFrame extends JFrame {
	private JLabel lbl;
	
	
	public JLabel getLbl() {
		return lbl;
	}
	public InputMainFrame() {
		JPanel pnl = new JPanel();
		lbl = new JLabel("");
		
		JButton popup = new JButton("입력 대화창 열기");
		popup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InputDialog dialog = new InputDialog(InputMainFrame.this);
				dialog.setVisible(true);
			}
		});
		pnl.add(lbl);
		
		add(popup, "North");
		add(pnl, "Center");
		
		showGUI();
	}
	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class InputDialog extends JDialog {
	public InputDialog(InputMainFrame main) {
		super(main);
		
		setModal(true);
		
		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel("이름");
		JTextField tf = new JTextField(10);
		JButton btnConfirm = new JButton("확인");
		JButton btnCancel = new JButton("취소");
		
		ActionListener l = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("확인")) {
					String value = tf.getText();
					main.getLbl().setText(value);
				}
				
				dispose();
				
			}
		};
		btnConfirm.addActionListener(l);
		btnCancel.addActionListener(l);
		
		pnl.add(lbl);
		pnl.add(tf);
		pnl.add(btnConfirm);
		pnl.add(btnCancel);
		
		add(pnl);
		
		setSize(400, 400);
		setLocationRelativeTo(main);
	}
}

public class TestInputDialog {
	public static void main(String[] args) {
		new InputMainFrame();
	}
}








