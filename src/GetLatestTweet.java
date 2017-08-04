import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.teachingextensions.logo.Colors;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GetLatestTweet implements ActionListener {

	JButton button = new JButton("Search the Twitterverse");
	JTextField searchBox = new JTextField(15);
	JTextPane output = new JTextPane();

	public static void main(String[] args) {
		new GetLatestTweet().createUI();
	}

	private void createUI() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("The Amazing Tweet Retriever");
		frame.setVisible(true);

		JPanel topPanel = new JPanel();
		topPanel.add(searchBox);
		topPanel.add(button);
		
		JPanel outputPanel = new JPanel();
		output.setBackground(new Color(0xadd8e6));
		output.setOpaque(true);
		output.setEditable(false);
		output.setPreferredSize(new Dimension(500,500));
		output.setBorder(BorderFactory.createEtchedBorder());
		JScrollPane scrollPane = new JScrollPane(output);
		outputPanel.add(scrollPane);
		
		frame.add(topPanel, BorderLayout.CENTER);
		frame.add(outputPanel, BorderLayout.SOUTH);
		frame.pack();

		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String searchTerm = searchBox.getText();
		output.setText(getLatestTweet(searchTerm));
	}

	private String getLatestTweet(String searchingFor) {
		Twitter twitter = new TwitterFactory().getInstance();
		AccessToken accessToken = new AccessToken(
				"2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
				"vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");
		twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
				"6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");
		twitter.setOAuthAccessToken(accessToken);
		Query query = new Query(searchingFor);
		try {
			String output = "";
			QueryResult result = twitter.search(query);
			int numTweets = result.getCount();
			if (numTweets > 15)
				numTweets = 15;
			for (int i = 0; i < numTweets; i++) {
				output += result.getTweets().get(i).getText() + "\n\n";
			}
			return output;
		} catch (Exception e) {
			System.err.print(e.getMessage());
			return "What the heck is that?";
		}
	}
}


