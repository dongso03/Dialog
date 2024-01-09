import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;

public class fakeLogin extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public fakeLogin() {
		JPanel pnl = new JPanel();
		JPanel pnl2 = new JPanel();
		JPanel pnlCard = new JPanel();
		textField = new JTextField(10);
		
		textField_1 = new JTextField(10);
		
		JLabel lblNewLabel = new JLabel("아이디");
		
		JLabel lblNewLabel_1 = new JLabel("비번");
		JLabel lbl3 = new JLabel("페이크다 이 병맛드랑");
		
		JButton btn = new JButton("로그인");
		pnl2.add(lbl3);
		
		CardLayout layout = new CardLayout();
		pnlCard.setLayout(layout);
		pnlCard.add(pnl,"기본");
		pnlCard.add(pnl2,"페이크");
		layout.show(pnlCard, "기본");
		
		pnl.add(lblNewLabel);
		pnl.add(textField);
		pnl.add(lblNewLabel_1);
		pnl.add(textField_1);
		pnl.add(btn);
		
		textField.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				layout.show(pnlCard, "기본");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				layout.show(pnlCard, "페이크");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("sd");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Random random = new Random();
			    
			    int maxX = getWidth() - btn.getWidth();   // 프레임 가로 크기에서 버튼 가로 크기를 뺀 값
			    int maxY = getHeight() - btn.getHeight(); // 프레임 세로 크기에서 버튼 세로 크기를 뺀 값
			    
			    int randomX = random.nextInt(maxX);
			    int randomY = random.nextInt(maxY);
			    
			    btn.setLocation(randomX, randomY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("sd");
			}
		});
		
		add(pnlCard);
		
		showGUI();
		
		
		
		
	}
	
	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new fakeLogin();
	}
}
