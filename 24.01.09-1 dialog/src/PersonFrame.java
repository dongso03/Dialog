import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.PolicyErrorHolder;

// 메인창

// 입력 대화창
class FormDialog extends JDialog {
	private JTextField[] tf;
	private boolean isConfirm;

	public FormDialog() {
		tf = new JTextField[3];

		setModal(true);

		JPanel pnl = new JPanel();
		JPanel pnlEast = new JPanel();
		JButton btnConfirm = new JButton("입력 완료");

		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isConfirm = true;
				dispose();
			}
		});

		pnlEast.add(btnConfirm);
		add(pnlEast, "East");

		String[] lables = { "이름", "나이", "전화번호" };
		int index = 0;
		for (String str : lables) {
			JPanel pnlInput = new JPanel();
			JLabel lblText = new JLabel(str);
			JTextField tfInput = new JTextField(15);
			tf[index] = tfInput;
			index++;

			pnlInput.add(lblText);
			pnlInput.add(tfInput);

			pnl.add(pnlInput);
		}

		add(pnl);

		setSize(500, 500);
	}

	public Person showForm() {
		setVisible(true);
		if (isConfirm) {
			return new Person(tf[0].getText(), tf[1].getText(), tf[2].getText());
		} else {
			return null;
		}
	}
}

class Person {
	private String name;
	private String age;
	private String phone;

	public Person(String name, String age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}

}
// 인적정보
// 이름 => TextField
// 나이 => TextField, Spinner, ComboBox, Slider, ... 
// 전화번호 => TextField

public class PersonFrame {
	public static void main(String[] args) {
		FormDialog dialog = new FormDialog();
		Person result = dialog.showForm();
		System.out.println("rkqtghkrdls" + result);
	}
}
