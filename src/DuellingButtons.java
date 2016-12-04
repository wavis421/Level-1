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

public class DuellingButtons implements ActionListener {
	private int clickCount = 0;

	public static void main(String[] args) {
		new DuellingButtons().createUI();
	}

	JButton leftButton = new JButton();
	JButton rightButton = new JButton();
	JTextField textField;

	Dimension BIG = new Dimension(400, 400);
	Dimension SMALL = new Dimension(200, 200);

	JFrame frame = new JFrame("Demanding Buttons");
	JPanel panel = new JPanel();

	private void createUI() {
		// 1. Add the panel to the frame
		frame.add(panel);

		// 2. Make the frame visible
		frame.setVisible(true);

		// 3. Set the text of the leftButton to "Click me!"
		leftButton.setText("Click me!");
		leftButton.setBackground(Color.red);
		leftButton.setOpaque(false);
		leftButton.setBorder(BorderFactory.createLineBorder(Color.red, 10, true));

		// 4. Set the text of the rightButton to "Click me!"
		rightButton.setText("Click me!");
		rightButton.setBackground(Color.blue);
		rightButton.setOpaque(false);
		rightButton.setBorder(BorderFactory.createLineBorder(Color.blue, 10, true));

		// 5. Add an action listener to the leftButton
		leftButton.addActionListener(this);

		// 6. Add an action listener to the rightButton
		rightButton.addActionListener(this);

		// 7. Add the leftButton to the panel
		panel.add(leftButton);

		// 8. Add the rightButton to the panel
		panel.add(rightButton);

		// Just extra stuff
		textField = new JTextField("You clicked " + clickCount + " times!");
		textField.setMargin(new Insets(10, 10, 10, 10));
		textField.setBorder(BorderFactory.createLineBorder(Color.pink, 10, true));
		panel.add(textField);

		// 9. Pack the frame
		frame.pack();

		// 10. Set the title of the frame to "Demanding Buttons"

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();

		clickCount++;
		textField.setText("You clicked " + clickCount + " times!");

		// If the buttonPressed was the leftButton.... 
		if (buttonPressed == leftButton) {
			// Set the text of the rightButton to "No, click Me!"
			// Set the PREFERRED size of the rightButton to BIG
			rightButton.setText("No, click Me!");
			rightButton.setPreferredSize(BIG);

			// Set the text of the leftButton to "Click Me!"
			// Set the PREFERRED size of the leftButton to SMALL
			leftButton.setText("Click Me!");
			leftButton.setPreferredSize(SMALL);
		}

		// If the buttonPressed was the rightButton, do the opposite.
		if (buttonPressed == rightButton) {
			// Set the text of the rightButton to "No, click Me!"
			// Set the PREFERRED size of the rightButton to BIG
			leftButton.setText("No, click Me!");
			leftButton.setPreferredSize(BIG);

			// Set the text of the leftButton to "Click Me!"
			// Set the PREFERRED size of the leftButton to SMALL
			rightButton.setText("Click Me!");
			rightButton.setPreferredSize(SMALL);
		}

		frame.pack();
	}
}
