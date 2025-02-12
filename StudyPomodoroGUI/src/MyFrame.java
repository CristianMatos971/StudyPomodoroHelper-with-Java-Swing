import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {

	JLabel lb1;
	JComboBox<?> combox1;
	JComboBox<?> combox2;
	String[] minutes = { "select working time", "25 minutes", "30 minutes", "50 minutes ", "60 minutes" };
	String[] rest = { "select resting time", "5 minutes", "10 minutes", "15 minutes ", "20 minutes" };
	JButton b1;

	MyFrame() {

		this.setSize(800, 800);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(50, 60, 80));
		this.setLocationRelativeTo(null);

		int[] bounds1 = { 0, 0, 400, 100 };
		createTextLabel("   Organize your Studying Session:", bounds1);

		combox1 = new JComboBox(minutes);
		combox1.setBounds(400, 0, 150, 100);
		combox2 = new JComboBox(rest);
		combox2.setBounds(570, 0, 150, 100);

		b1 = new JButton();
		b1.setBounds(570, ABORT, WIDTH, HEIGHT);

		this.add(combox2);
		this.add(combox1);
		this.add(lb1);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Studying Pomodoro Helper ");
		this.setVisible(true);
	}

	public void createTextLabel(String text, int[] bounds) {
		lb1 = new JLabel();
		lb1.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		lb1.setBackground(new Color(230, 230, 220));
		lb1.setOpaque(true);
		lb1.setText(text);
		lb1.setFont(new Font("Arial", Font.BOLD, 20));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
