import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleCalculator extends JFrame implements ActionListener {
	private JFrame frame;
	private JPanel numberPanel, operationPanel, resultPanel;
	private JTextField operand1Field, operand2Field;
	private JButton addButton, subButton, mulButton, divButton;
	private JLabel resultLabel;

	public SimpleCalculator() {
		frame = new JFrame("Simple Calculator");

		numberPanel = new JPanel();
		operationPanel = new JPanel();
		resultPanel = new JPanel();

		// Add 2 operand fields
		operand1Field = createOperandField("", numberPanel);
		operand2Field = createOperandField("", numberPanel);

		// Add operation buttons
		addButton = createOperationButton("Add", operationPanel);
		subButton = createOperationButton("Sub", operationPanel);
		mulButton = createOperationButton("Mul", operationPanel);
		divButton = createOperationButton("Div", operationPanel);

		// Create result field
		resultLabel = createResultLabel("", resultPanel);

		// Configure frame
		frame.setPreferredSize(new Dimension(400, 150));
		frame.add(numberPanel, BorderLayout.NORTH);
		frame.add(operationPanel, BorderLayout.CENTER);
		frame.add(resultPanel, BorderLayout.SOUTH);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	// Create operand field 
	private JTextField createOperandField (String initialValue, JPanel panel) {
		JTextField newField = new JTextField(initialValue, 10);
		newField.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(newField);
		return newField;
	}
	
	// Create operation buttons
	private JButton createOperationButton(String nameField, JPanel panel) {
		JButton newButton = new JButton(nameField);
		panel.add(newButton);
		newButton.addActionListener(this);
		return newButton;
	}
	
	// Create result field
	private JLabel createResultLabel(String initialValue, JPanel panel) {
		JLabel newLabel = new JLabel(initialValue);
		newLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5, true));
		newLabel.setPreferredSize(new Dimension(150, 30));
		newLabel.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(newLabel);
		return newLabel;
	}
	
	// Action listener for operation buttons
	@Override
	public void actionPerformed(ActionEvent event) {
		double num1Value = Double.parseDouble(operand1Field.getText());
		double num2Value = Double.parseDouble(operand2Field.getText());

		if (event.getSource() == addButton) {
			resultLabel.setText(String.format("%.3f", num1Value + num2Value));
		} else if (event.getSource() == subButton) {
			resultLabel.setText(String.format("%.3f", num1Value - num2Value));
		} else if (event.getSource() == mulButton) {
			resultLabel.setText(String.format("%.3f", num1Value * num2Value));
		} else if (event.getSource() == divButton) {
			resultLabel.setText(String.format("%.3f", num1Value / num2Value));
		}
	}
}
