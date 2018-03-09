package LAB1;

import java.util.Scanner;

public class Rainfall {
	private Scanner read = new Scanner(System.in);

	private String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" };
	private double[] rainfall = new double[12];
	private double totalRainfall = 0;
	private double avgRainMonthly = 0;

	// Overloaded constructors
	// maybe they are doing to much?
	public Rainfall(double[] rainfall) {
		this.rainfall = new double[rainfall.length];

		for (int i = 0; i <= rainfall.length - 1; i++) {
			this.rainfall[i] = rainfall[i];
		}

		System.out.printf("Avg Monthly Rainfall: %,.2f\n", getAvg());
		System.out.printf("Total Rainfall: %,.2f\n", getTotal());
		System.out.printf("Least Rainfall: %s\n", getLeast());
		System.out.printf("Most Rainfall: %s\n", getMost());
		read.close();
	}

	public Rainfall() {
		setRain();
		System.out.printf("Avg Monthly Rainfall: %,.2f\n", getAvg());
		System.out.printf("Total Rainfall: %,.2f\n", getTotal());
		System.out.printf("Least Rainfall: %s\n", getLeast());
		System.out.printf("Most Rainfall: %s\n", getMost());
		read.close();
	}

	// Private methods
	private void setRain() {
		// Stores Rain for each month
		for (int i = 0; i <= rainfall.length - 1; i++) {
			System.out.println("Amount Of Rain In  " + (months[i]) + " ");
			this.rainfall[i] = read.nextDouble();
			while (this.rainfall[i] < 0) {
				System.out.println("cannot rain negative ");
				this.rainfall[i] = read.nextDouble();

			}
			this.totalRainfall += this.rainfall[i];
			read.nextLine();
		}
	}

	private void setAvg() {
		for (int i = 0; i <= rainfall.length - 1; i++) {
			this.avgRainMonthly += this.rainfall[i];
		}
		this.avgRainMonthly /= (rainfall.length - 1);
	}

	private double getAvg() {
		if (this.avgRainMonthly == 0)
			setAvg();
		return this.avgRainMonthly;

	}

	private double getTotal() {
		if (this.totalRainfall < 1) {
			for (int i = 0; i <= rainfall.length - 1; i++) {
				this.totalRainfall += rainfall[i];
			}
		}
		return this.totalRainfall;
	}

	private String getMost() {
		double most = rainfall[0];
		String str = "";
		for (int i = 0; i <= rainfall.length - 1; i++) {
			if (rainfall[i] > most) {
				most = rainfall[i];
				str = months[i];
			} else if (rainfall[i] == most) {
				str += " and " + months[i];
			}
		}
		return str;
	}

	private String getLeast() {
		double most = rainfall[rainfall.length / 2];
		String str = "";
		for (int i = 0; i <= rainfall.length - 1; i++) {
			if (rainfall[i] < most) {
				most = rainfall[i];
				str = months[i];
			} else if (rainfall[i] == most) {
				str += " and " + months[i];
			}
		}
		return str;
	}

	public boolean equals(Rainfall o) {
		// If the object is compared with itself then return true
		if (o.getTotal() == this.getTotal()) {
			return true;
		} else {
			return false;
		}
	}
}
