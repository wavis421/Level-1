import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	String[] jokes = { "Joke #1", "Joke #2", "Joke #3" };
	String[] punch = { "Punch #1", "Punch #2", "Punch #3" };
	int idx = 0;

	public static void main(String[] args) {
		new ChuckleClicker();
	}

	public ChuckleClicker() {
		makeButtons();
	}

	JButton jokeButton;
	JButton punchLineButton;

	void makeButtons() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);

		jokeButton = new JButton("Joke");
		punchLineButton = new JButton("PunchLine");
		panel.add(jokeButton);
		panel.add(punchLineButton);
		punchLineButton.setEnabled(false);

		jokeButton.addActionListener(this);
		punchLineButton.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jokeButton) {
			System.out.println(jokes[idx]);
			punchLineButton.setEnabled(true);
		} else {
			System.out.println(punch[idx]);
			idx++;
			idx = idx % jokes.length;
		}
	}
}
