import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CodingTestLevel1 extends JFrame implements ActionListener {
	JButton yellowButton, redButton, blueButton;

	public static void main(String[] args) {
		new CodingTestLevel1();
	}

	public CodingTestLevel1() {
		// Create frame
		JFrame frame = new JFrame("Color Teacher");
		JPanel panel = new JPanel();
		frame.add(panel);

		// Create yellow,red,blue buttons
		yellowButton = new JButton();
		configureButton (yellowButton, Color.yellow);
		
		redButton = new JButton();
		configureButton (redButton, Color.red);
		
		blueButton = new JButton();
		configureButton (blueButton, Color.blue);

		yellowButton.addActionListener(this);
		redButton.addActionListener(this);
		blueButton.addActionListener(this);

		// Add a text panel
		JTextField textField = new JTextField("Hi there!");
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setPreferredSize(new Dimension(120,70));
		textField.setForeground(Color.red);
		textField.setMargin(new Insets(10,10,10,10));
		
		// Add everything to the panel
		panel.add(yellowButton);
		panel.add(redButton);
		panel.add(blueButton);
		panel.add(textField);

		frame.pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	private void configureButton (JButton button, Color color) {
		button.setPreferredSize(new Dimension(150,75));
		button.setBackground(color);
		button.setOpaque(true);
		button.setSelected(false);
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
