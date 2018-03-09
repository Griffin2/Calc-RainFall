package LAB1;

public class Driver {

	public static void main(String[] args) {

		//// built in driver
		Rainfall rain = new Rainfall(new double[] { 8, 6, 10, 5, 2, 1, 2, 2, 5, 9, 11, 12 });

		//// built in class
		// Rainfall rain = new Rainfall();

		System.out.println("\n\nprogram location :" + rain);
	}
}
