package MyThreads;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {

	public static JLabel[] lbs = new JLabel[5];
	private JComboBox<?> combox1;
	private JComboBox<?> combox2;
	private String[] minutes = { "select working time", "25 minutes", "30 minutes", "50 minutes", "60 minutes" };
	private String[] rest = { "select resting time", "5 minutes", "10 minutes", "15 minutes", "20 minutes" };
	private JButton b1;
	private JButton b2;
	private JButton b3;

	private boolean isWTselected = false;
	private boolean isRTselected = false;
	static MyThread1[] mt = new MyThread1[5];
	ImageIcon im1 = new ImageIcon("C:\\Users\\Roger\\git\\StudyPomodoroGUI\\StudyPomodoroGUI\\src\\PlayPauser.png");

	private static boolean y = true;
	static int secsAt = 0;
	private static JLabel secsLb;

	public MyFrame() {

		this.setSize(800, 800);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(50, 60, 80));
		this.setLocationRelativeTo(null);

		int[] bounds0 = { 0, 0, 400, 100 };
		createTextLabel("   Organize your Studying Session:", bounds0, 0);
		int[] bounds1 = { 0, 200, 360, 50, };
		createTextLabel("Working time: " + WorkingTime.getWTime() + ".\n Resting Time: " + RestingTime.getRT() + ". ",
				bounds1, 1);
		int[] bounds2 = { 375, 120, 420, 150, };
		createTextLabel(String.valueOf(SaveMinutes.getMins()) + "min", bounds2, 2);

		lbs[2].setFont(new Font("MV BOLI", Font.BOLD, 100));

		combox1 = new JComboBox(minutes);
		combox1.setBounds(400, 0, 140, 100);
		combox1.addActionListener(this);
		combox2 = new JComboBox(rest);
		combox2.setBounds(560, 0, 135, 100);
		combox2.addActionListener(this);

		b1 = new JButton();
		b1.setBounds(0, 260, 160, 160);
		b1.setFocusable(false);
		b1.setText("START!");
		b1.setFont(new Font("ARIAL", Font.BOLD, 20));
		b1.addActionListener(this);

		b2 = new JButton();
		b2.setBounds(200, 260, 160, 160);
		b2.setText("STOP!");
		b2.setFont(new Font("ARIAL", Font.BOLD, 20));
		b2.setFocusable(false);
		b2.addActionListener(this);

		b3 = new JButton();
		b3.setBounds(0, 440, 360, 50);
		b3.setText("STOP ALARM SOUND!");
		b3.setFont(new Font("ARIAL", Font.BOLD, 20));
		b3.setForeground(Color.RED);
		b3.setFocusable(false);
		b3.addActionListener(this);

		this.add(b2);
		this.add(b1);
		this.add(combox2);
		this.add(combox1);
		this.add(lbs[0]);
		this.add(lbs[1]);
		this.add(lbs[2]);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Studying Pomodoro Helper ");
		this.setVisible(true);
	}

	public void createTextLabel(String text, int[] bounds, int qi) {
		lbs[qi] = new JLabel();
		lbs[qi].setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		lbs[qi].setBackground(new Color(230, 230, 220));
		lbs[qi].setOpaque(true);
		lbs[qi].setText(text);
		lbs[qi].setFont(new Font("Arial", Font.BOLD, 20));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == combox1) {
			if (combox1.getSelectedItem().equals("25 minutes")) {

				WorkingTime.setWT(25);
				WorkingTime.setFinalWT(25);
				isWTselected = true;

			} else if (combox1.getSelectedItem().equals("30 minutes")) {

				WorkingTime.setWT(30);
				WorkingTime.setFinalWT(30);
				isWTselected = true;

			} else if (combox1.getSelectedItem().equals("50 minutes")) {

				WorkingTime.setWT(50);
				WorkingTime.setFinalWT(50);
				isWTselected = true;

			} else if (combox1.getSelectedItem().equals("60 minutes")) {

				WorkingTime.setWT(60);
				WorkingTime.setFinalWT(60);
				isWTselected = true;

			} else {

				System.out.println("You need to select an item!");
			}

			;
			lbs[2].setText(String.valueOf(WorkingTime.getWTime()) + "min");
			lbs[1].setText(
					"Working time: " + WorkingTime.getWTime() + ".\n Resting Time: " + RestingTime.getRT() + ". ");
			lbs[1].repaint();

		}

		if (e.getSource() == combox2) {
			if (combox2.getSelectedItem().equals("5 minutes")) {

				RestingTime.setRT(5);
				RestingTime.setFinalRT(5);
				isRTselected = true;

			} else if (combox2.getSelectedItem().equals("10 minutes")) {

				RestingTime.setRT(10);
				RestingTime.setFinalRT(10);
				isRTselected = true;

			} else if (combox2.getSelectedItem().equals("15 minutes")) {

				RestingTime.setRT(15);
				RestingTime.setFinalRT(15);
				isRTselected = true;

			} else if (combox2.getSelectedItem().equals("20 minutes")) {

				RestingTime.setRT(20);
				RestingTime.setFinalRT(20);
				isRTselected = true;

			} else {
				System.out.println("You need to select an item!");
				isRTselected = false;

			}
			lbs[1].setText(
					"Working time: " + WorkingTime.getWTime() + ".\n Resting Time: " + RestingTime.getRT() + ". ");
			lbs[1].repaint();

		}

		if (e.getSource() == b1 && isWTselected == true && isRTselected == true) {
			mt[0] = new MyThread1();
			MyThread1.running = true;

			CreateSecsLabel();
			this.add(secsLb);

			while (MyThread1.running == true) {
				if (changeSecs() == true) {

					for (int i = secsAt; i < 62; i++) {
						changeSecs();
						mt[0].start();

						if (i == 61) {

							i = 0;
						}
					}
				}
			}
			secsAt = SaveSeconds.getSecs();
		}

		if (MyThread1.running == false) {

			mt[0].interrupt();
			mt[0].start();

		} else if (e.getSource() == b2 && isWTselected == true && isRTselected == true) {
			MyThread1.running = false;
		}

		if (e.getSource() == b3) {

		}

	}

	public void CreateSecsLabel() {
		secsLb = new JLabel();
		secsLb.setLayout(null);
		secsLb.setText(String.valueOf(SaveSeconds.getSecs()) + "secs");
		secsLb.setFont(new Font("ARIAL", Font.BOLD, 100));
		secsLb.setBounds(380, 275, 400, 90);
		secsLb.setBackground(new Color(230, 230, 220));
		secsLb.setOpaque(true);
		secsLb.setVisible(true);
	}

	private static boolean changeSecs() {
		secsLb.setText(String.valueOf(SaveSeconds.getSecs()) + "secs");
		secsLb.repaint();
		return true;
	}

	private static void changeMins() {

		if (WorkingTime.isWTRunning == true) {
			lbs[2].setText(String.valueOf(WorkingTime.getWTime()) + "mins");
			lbs[2].repaint();
		} else if (WorkingTime.isWTRunning == false) {
			lbs[2].setText(String.valueOf(RestingTime.getRT()) + "mins");
			lbs[2].repaint();
		}

	}

	public static void startChanging() {
		changeSecs();
	}

	public static void startChangingMins() {
		changeMins();
	}
}
