public class NetflixRunner {
	public static void main(String[] args) {
		// 1. Create some Movie objects (at least 5).
		Movie clashOfTheTitans = new Movie("Clash of the Titans", 5);
		Movie noCountryForOldMen = new Movie("No Country For Old Men", 9);

		// 2. Use the Movie class to get the ticket price of one of your movies.
		System.out.println("Cost for movie: " + noCountryForOldMen.getTicketPrice());

		// 3. Create a NetflixQueue.
		NetflixQueue netflixQueue = new NetflixQueue();

		// 4. Add your movies to the Netflix queue.
		netflixQueue.addMovie(clashOfTheTitans);
		netflixQueue.addMovie(noCountryForOldMen);

		// 5. Print all the movies in your queue.
		netflixQueue.printMovies();

		// 6. Use your NetflixQueue object to finish the sentence "the best
		// movie is...."
		System.out.println("The best movie is: " + netflixQueue.getBestMovie());

		// 7. Use your NetflixQueue to finish the sentence "the second best
		// movie is...."
		netflixQueue.sortMoviesByRating();
		if (netflixQueue.movies.size() > 1)
			System.out.println("The second best movie is: " + netflixQueue.getMovie(1));
	}
}