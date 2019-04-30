/**
 * @author: Thromax
 * @version: 1.0
 * */

package com.thromax.perceptron.data;

public class MainGenerator {

	public final static int iterations = 300;
	public final static double x_limit = 10, y_limit = 4;

	public static void main(String[] args) {
		// y = 0.4x
		double x, y, real_y;

		System.out.print("{");
		for (int i = 0; i < iterations; i++) {
			x = Math.random() * x_limit;
			y = Math.random() * y_limit;
			real_y = 0.4 * x;

			System.out.print("{" + x + "f," + y + "f,");

			if (y < real_y)
				System.out.print("0");
			else
				System.out.print("1");
			System.out.println("},");
		}

	}

}
