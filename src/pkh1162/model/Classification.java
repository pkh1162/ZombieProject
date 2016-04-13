package pkh1162.model;

public enum Classification {
	Newbie(0, 21, 21, 81, 81, 101),			//The six numbers represent the upper and lower damage limits dealt
	Runner(0, 21, 81, 101, 21, 81), 			//to each experience level. These are passed to the randomness class
	Veteran(81, 101, 21, 81, 0, 21);			//in order work out a calculated damage to each experience level.

	private int a1, a2, b1, b2, c1, c2;

	private Classification(int a1, int a2, int b1, int b2, int c1, int c2) {
		this.a1 = a1;
		this.a2 = a2;
		this.b1 = b1;
		this.b2 = b2;
		this.c1 = c1;
		this.c2 = c2;
	}

	public int getA1() {
		return a1;
	}

	public int getA2() {
		return a2;
	}

	public int getB1() {
		return b1;
	}

	public int getB2() {
		return b2;
	}

	public int getC1() {
		return c1;
	}

	public int getC2() {
		return c2;
	}
	

}