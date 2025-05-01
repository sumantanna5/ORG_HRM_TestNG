package Practice;

public class ArrayQuestions {

	/*
	 * Q1. Find a Element from Array .
	 */

	public void FindElemntFromArray(int Search) {
		int[] arr = { 10, 15, 20, 30, 60, 77, 88, 91, 101, 27, 18, 19 };

		for (int i = 0; i < arr.length; i++) {
			if (Search == arr[i]) {
				System.out.println("Search Value Matched List :" + arr[i]);
				break;
			}

			System.err.println("Not Matched to Searched Value :" + arr[i]);
		}
	}

	/*
	 * Q2. Find Repetitive Element from List
	 */

	public void RepetitiveElement() {

		int[] b = { 1, 2, 3, 5, 6, 7, 8, 9, 2, 3, 6, 11 };
		int add = 0;
		for (int i = 0; i < b.length; i++) {
			int count = 0;
			for (int j = 0; j < b.length; j++) {
				if (b[i] == b[j]) {
					count++;
				}

			}
			add = add + b[i];
			System.out.println(add);
			System.out.println("Count of " + b[i] + ":" + count);
		}
	}

	public static String ab() {
		String Father = "Ravi";
		System.out.println(Father);
		String Mother = "Swathi";
		System.out.println(Mother);
		String Name = "Sumant";
		return Name;
	}

	public void abname(String TestName) {
		System.out.println(TestName);
	}

	public static void main(String[] args) {

//		ArrayQuestions aq = new ArrayQuestions();
//		aq.FindElemntFromArray(15);
//		aq.FindElemntFromArray(18);
//		aq.RepetitiveElement();

//		ab();
		ArrayQuestions aq = new ArrayQuestions();
		String Lname = ab();
		aq.abname(Lname);
	}

}
