/**
 * IceCreamVotes:
 * 
 * This recipe introduces Arrays and reviews the concept of static class
 * variables and getters/setters.
 * 
 * @author Wendy Avis
 *
 */

public class IceCreamVotesRunner {
	public static void main(String[] args) {
		IceCreamVotes[] votesList = { 
				new IceCreamVotes("Wendy", "Vanilla"),
				new IceCreamVotes("Graham", "Strawberry") };

		System.out.println("Total # of votes = " + IceCreamVotes.getNumVotes());

		for (int i = 0; i < votesList.length; i++) {
			System.out.println(votesList[i].getName() + " likes " + votesList[i].getFlavor() + " ice cream.");
		}

		votesList[0].setFlavor("Chocolate");

		for (int i = 0; i < votesList.length; i++) {
			System.out.println(votesList[i].getName() + " likes " + votesList[i].getFlavor() + " ice cream.");
		}
	}
}

