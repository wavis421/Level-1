import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JLabel jokeLabel;

	void makeButtons() {
		JFrame frame = new JFrame();
		JPanel buttonPanel = new JPanel();
		JPanel jokePanel = new JPanel();
		frame.add(buttonPanel);
		frame.add(jokePanel);
		frame.setLayout(new GridLayout(2, 1));

		jokeButton = new JButton("Joke");
		punchLineButton = new JButton("PunchLine");
		buttonPanel.add(jokeButton);
		buttonPanel.add(punchLineButton);
		punchLineButton.setEnabled(false);
		
		jokeLabel = new JLabel("     ");
		jokePanel.add(jokeLabel);

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
			jokeLabel.setText(jokes[idx]);
			punchLineButton.setEnabled(true);
		} else {
			System.out.println(punch[idx]);
			jokeLabel.setText(punch[idx]);
			idx++;
			idx = idx % jokes.length;
		}
	}
}
