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
	JLabel label;
	
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
		
		JButton button = new JButton("Get next lottery number!");
		panel.add(button);
		
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label);
		
		panel.setLayout(new GridLayout(2, 1));

		frame.setVisible(true);
		//frame.pack();
		
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		label.setText("   " + String.valueOf(randomNum.nextInt(1000000000)));	
	}

}
