import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

public class SimpleCalculaterRobbie {
	
	public static void main(String[] args){
		
		SimpleCalculaterRobbie calculator = new SimpleCalculaterRobbie();
		
	}
	
	public SimpleCalculaterRobbie(){
		
		JFrame frame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		
		panel1.add(field1);
		panel1.add(field2);
		
		JButton addButton = new JButton("Add");
		JButton subtractButton = new JButton("Subtract");
		JButton multiplyButton = new JButton("Multiply");
		JButton divideButton = new JButton("Divide");
		
		panel2.add(addButton);
		panel2.add(subtractButton);
		panel2.add(multiplyButton);
		panel2.add(divideButton);
		
		JLabel label1 = new JLabel();
		
		panel3.add(label1);
		
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);

	}
	
}