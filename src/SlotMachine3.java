import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine3 implements ActionListener {
	public static void main(String[] args) {
		new SlotMachine3();
	}

	JFrame frame = new JFrame();
	JPanel buttonPanel = new JPanel();
	JPanel imagePanel = new JPanel();

	private String orangeImage = "orange.jpg";
	private String cherryImage = "cherry.jpg";
	private String bananaImage = "banana.jpg";

	private JLabel leftLabel;
	private JLabel centerLabel;
	private JLabel rightLabel;

	public SlotMachine3() {
		JButton spinButton = new JButton("Spin");
		buttonPanel.add(spinButton);
		spinButton.addActionListener(this);

		leftLabel = loadImage(orangeImage);
		centerLabel = loadImage(cherryImage);
		rightLabel = loadImage(bananaImage);

		imagePanel.setPreferredSize(new Dimension(800, 300));
		imagePanel.add(leftLabel);
		imagePanel.add(centerLabel);
		imagePanel.add(rightLabel);

		frame.add(buttonPanel, BorderLayout.NORTH);
		frame.add(imagePanel, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	private JLabel getRandomImage() {
		int r = new Random().nextInt(3);
		if (r == 0)
			return loadImage(bananaImage);
		else if (r == 1)
			return loadImage(orangeImage);
		else
			return loadImage(cherryImage);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		imagePanel.removeAll();

		leftLabel = getRandomImage();
		centerLabel = getRandomImage();
		rightLabel = getRandomImage();

		imagePanel.add(leftLabel);
		imagePanel.add(centerLabel);
		imagePanel.add(rightLabel);

		imagePanel.repaint();
		frame.pack();

		if (leftLabel.getIcon().toString().equals(centerLabel.getIcon().toString())
				&& centerLabel.getIcon().toString().equals(rightLabel.getIcon().toString()))
			JOptionPane.showMessageDialog(null, "You win!!");
	}
}
