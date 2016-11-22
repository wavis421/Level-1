
public class MeetMyFamilyRunner {
	public static void main(String[] args) {
		MeetMyFamily fam = new MeetMyFamily();
		
		fam.addFamilyMember("Wendy", 58);
		fam.addFamilyMember("Natasha", 28);
		fam.addFamilyMember("Jacqueline", 24);
		fam.addFamilyMember("Kristy", 25);
		fam.addFamilyMember("Graham", 58);
		
		fam.showFamilyMembers();
	}
}
