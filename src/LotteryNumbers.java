import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LotteryNumbers implements ActionListener {

	Random randomNum = new Random();
	//JLabel label;
	JButton resultButton = new JButton();
	
	public static void main(String[] args) {
		new LotteryNumbers();
	}
	
	public LotteryNumbers() {
		JFrame frame = new JFrame();
		frame.setTitle("Lottery Numbers");
		frame.setSize(300, 200);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton requestButton = new JButton("Get next lottery number!");
		requestButton.setBackground(new Color(0xDD66FF));
		panel.add(requestButton);
		
		//label = new JLabel();
		//label.setHorizontalAlignment(JLabel.CENTER);
		//label.setBackground(Color.blue);
		//label.setOpaque(true);
		//panel.add(label);
		
		resultButton.setBackground(new Color(0x11FF22));
		resultButton.setOpaque(true);
		panel.add(resultButton);
		
		panel.setLayout(new GridLayout(2, 1));

		frame.setVisible(true);
		//frame.pack();
		
		requestButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		resultButton.setText("   " + String.valueOf(randomNum.nextInt(1000000000)));	
	}

}
