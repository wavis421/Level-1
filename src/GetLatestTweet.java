import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class GetLatestTweet implements ActionListener {

	JButton button = new JButton("Search the Twitterverse");
	JTextField searchBox = new JTextField(15);

	public static void main(String[] args) {
		new GetLatestTweet().createUI();
	}

	private void createUI() {
		JFrame frame = new JFrame();
		frame.setTitle("The Amazing Tweet Retriever");
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.add(searchBox);
		panel.add(button);
		frame.add(panel);
		frame.pack();

		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String searchTerm = searchBox.getText();
		JOptionPane.showMessageDialog(null, getLatestTweet(searchTerm));
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
			QueryResult result = twitter.search(query);
			return result.getTweets().get(0).getText();
		} catch (Exception e) {
			System.err.print(e.getMessage());
			return "What the heck is that?";
		}
	}
}


