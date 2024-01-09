import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MouseFrame extends JFrame {
	public MouseFrame() {
		JPanel pnl = new JPanel();
		
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
	
		btn1.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("마우스 버튼 뗌");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("마우스가 버튼 을눌려버렷!");
				System.out.println(e.getButton());
				if (SwingUtilities.isLeftMouseButton(e)) {
					System.out.println("왼버튼 누름");
				}
				System.out.println(e.getClickCount());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("마우스가 버튼 밖으로 들어옴");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("마우스가 버튼 안으로 들어와버렷!");
				System.out.println("x좌표"+e.getX());
				System.out.println("y좌표"+e.getY());
				System.out.println(e.getLocationOnScreen());
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("마우스가 클릭함 아앙");
			}
		});
		
		pnl.add(btn1);
		pnl.add(btn2);
		pnl.add(btn3);
		
		add(pnl);
		
	showGUI();	
	}
	private void showGUI() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MouseFrame();
	}
}
