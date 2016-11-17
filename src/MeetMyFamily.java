import java.util.ArrayList;

public class MeetMyFamily {
	ArrayList<MyFamily> famList = new ArrayList<MyFamily>();

	public MeetMyFamily() {
	}
	
	public void addFamilyMember (String newMember) {
		famList.add(new MyFamily(newMember));
	}
	
	public void showFamilyMembers () {
		System.out.println("My family members are: ");
		for (MyFamily f : famList) {
			System.out.println("   " + f.getName());
		}
	}
}
