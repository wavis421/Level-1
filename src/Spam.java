import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Spam implements ActionListener {
	static final String FAKE_USERNAME = "wavis421@gmail.com";
	static final String FAKE_PASSWORD = "notforreal";
	// static final String FAKE_USERNAME = "your-best-friend-bob@gmail.com";
	// static final String FAKE_PASSWORD = "soupysoup";

	JTextField emailAddr;

	public static void main(String[] args) {
		new Spam();
	}

	public Spam() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);

		emailAddr = new JTextField(30);
		panel.add(emailAddr);

		JButton badButton = new JButton("BAD");
		JButton goodButton = new JButton("GOOD");

		panel.add(badButton);
		panel.add(goodButton);

		goodButton.addActionListener(this);
		badButton.addActionListener(this);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private boolean sendSpam(String recipient, String subject, String content) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(FAKE_USERNAME, FAKE_PASSWORD);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FAKE_USERNAME));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject(subject);
			message.setText(content);
			Transport.send(message);
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	String sendTextMessage(String phoneNumber, String message) {
		if (sendSpam(phoneNumber + "@cingularme.com", "", message))
			return "Cingular";
		if (sendSpam(phoneNumber + "@tmomail.net", "", message))
			return "T-Mobile";
		if (sendSpam(phoneNumber + "@vmobl.com", "", message))
			return "Virgin Mobile";
		if (sendSpam(phoneNumber + "@messaging.sprintpcs.com", "", message))
			return "Sprint";
		if (sendSpam(phoneNumber + "@vtext.com", "", message))
			return "Verizon";
		if (sendSpam(phoneNumber + "@messaging.nextel.com", "", message))
			return "Nextel";
		return "FAIL!";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// sendSpam(emailAddr.getText(), "Spam", "This is just Wendy's bad Java
		// program!!");
		System.out.println("Trying to send text message!");
		JOptionPane.showMessageDialog(null,
				sendTextMessage(emailAddr.getText(), "Message from Wendy's Java Program!!!"));

	}

}
