import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole {
	private static int count = 0;
	private JFrame frame;
	private static Date startTime = new Date();

	public WhackAMole() {
		frame = new JFrame("Whack a Button for Fame And Glory");
		frame.setSize(400, 500);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0xCC00FF));
		frame.add(panel);
		drawButtons(panel);
	}

	public static void main(String[] args) {
		new WhackAMole();
	}

	private void drawButtons(JPanel panel) {
		int ran = new Random().nextInt(24);
		for (int i = 0; i < 24; i++) {
			JButton b = new JButton();
			if (ran == i)
				b.setText("mole!");
			b.setPreferredSize(new Dimension(100, 50));
			b.setSelected(false);
			b.setBackground(new Color(0xCCBBFF));
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton hit = (JButton) e.getSource();
					if (hit.getText().equals("mole!")) {
						System.out.println("HIT!!");
						frame.dispose();
						count++;
						if (count >= 10)
							endGame(startTime, count);
						else
							new WhackAMole();
					}
				}
			});
			panel.add(b);
		}
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		System.out.println(timeAtStart.getTime() + " " + timeAtEnd.getTime());
		double whackRate = ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00) / molesWhacked;
		JOptionPane.showMessageDialog(null, "Your average whack rate is "
				+ String.format("%.2f", whackRate) + " seconds per mole.");
	}

}
