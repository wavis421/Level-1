import javax.swing.JOptionPane;

public class PracticeSubstring {
	public static void main(String[] args) {
		int startPos;
		String start;
		final String word = "supercalifragilisticexpialidocious";

		for (int i = 0; i < 20; i++) {
			start = JOptionPane.showInputDialog("Where to start?");
			startPos = Integer.parseInt(start);
			if (startPos + 3 > word.length())
				JOptionPane.showMessageDialog(null, "Your word isn't long enough");
			else
				JOptionPane.showMessageDialog(null, word.substring(startPos, startPos + 3));
		}
	}
}
