class TestClass {
	private static int numCats = 0;

	TestClass() {
		// unlike documentation, does not appear to default to PRIVATE!!
		TestClass.numCats++;
		System.out.println("this is private MyClass");
	}

	int getNumCats() {
		return TestClass.numCats;
	}
}