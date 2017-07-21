import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinConverter implements ActionListener {

	JTextField englishBox = new JTextField(20);
	JTextField pigLatinBox = new JTextField(20);

	public static void main(String[] args) {

		new PigLatinConverter().createUI();
	}

	private void createUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setTitle("Joon's Pig Latin Converter");
		panel.add(englishBox);

		JButton convertButton = new JButton("translate");
		convertButton.addActionListener(this);
		panel.add(convertButton);

		panel.add(pigLatinBox);

		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String pigLatin = new PigLatinTranslator().translate(englishBox.getText());
		pigLatinBox.setText(pigLatin);

	}
}
