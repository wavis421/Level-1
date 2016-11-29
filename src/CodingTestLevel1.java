import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CodingTestLevel1 implements ActionListener {
	JButton yellowButton, redButton, blueButton;

	public static void main(String[] args) {
		new CodingTestLevel1();
	}

	public CodingTestLevel1() {
		JFrame frame = new JFrame("Color Teacher");
		JPanel panel = new JPanel();
		frame.add(panel);

		yellowButton = new JButton("        ");
		configureButton (yellowButton, Color.yellow);
		
		redButton = new JButton("        ");
		configureButton (redButton, Color.red);
		
		blueButton = new JButton("        ");
		configureButton (blueButton, Color.blue);

		yellowButton.addActionListener(this);
		redButton.addActionListener(this);
		blueButton.addActionListener(this);

		panel.add(yellowButton);
		panel.add(redButton);
		panel.add(blueButton);

		frame.pack();
		frame.setVisible(true);
	}

	private void configureButton (JButton button, Color color) {
		button.setPreferredSize(new Dimension(100,50));
		button.setBorder(BorderFactory.createEtchedBorder());
		button.setBackground(color);
		button.setOpaque(true);
	}
	
	void speak(String words) {
		System.out.println(words);
		
		/*
		try {
			Runtime.getRuntime().exec("say " + words);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == yellowButton)
			speak("yellow");
		else if (arg0.getSource() == redButton)
			speak("red");
		else if (arg0.getSource() == blueButton)
			speak("blue");
	}
}
