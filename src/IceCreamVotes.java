
public class IceCreamVotes {
	private static int votes = 0;
	private String flavor;
	private String personName;

	public IceCreamVotes(String personName, String flavor) {
		this.personName = personName;
		this.flavor = flavor;
		votes++;
	}
	
	public String getFlavor() {
		return flavor;
	}
	
	public void setFlavor(String newFlavor) {
		flavor = newFlavor;
	}
	
	public String getName() {
		return personName;
	}

	public static int getNumVotes() {
		return votes;
	}
}
