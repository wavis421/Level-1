public class Duck {
	String myColor;
	String myFavFood;
	
	public Duck (String color, String favoriteFood) {
		myColor = color;
		myFavFood = favoriteFood;
	}
	
	public void quack () {
		System.out.println("Quack-quack says the " + myColor + " duck.");
	}
	
	public void eat () {
		System.out.println("Munch-munch on " + myFavFood);
	}
}
