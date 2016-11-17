import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole {
	private static int count = 0;
	private JFrame frame;

	public WhackAMole () {
		frame = new JFrame("Whack a Button for Fame And Glory");
		frame.setSize(400, 600);
		frame.setVisible(true);

		JPanel panel = new JPanel();
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
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton hit = (JButton) e.getSource();
					if (hit.getText().equals("mole!")) {
						System.out.println("HIT!!");
						frame.dispose();
						count++;
						if (count < 10)
							new WhackAMole();
					}
				}
			});
			panel.add(b);
		}
	}
}
