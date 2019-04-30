/**
 * @author: Thromax
 * @version: 1.0
 * */

package com.thromax.perceptron;

public class Perceptron {
	private double l_rate;
	private float weights[];

	public Perceptron(double l_rate, int n_inputs) {
		this.l_rate = l_rate;
		System.out.println("Learning rate set to: " + l_rate);

		// Initialization of weight list
		float temp_weights[] = new float[n_inputs];
		for (int i = 1; i < n_inputs; i++) {
			temp_weights[i] = 0f;
		}
		weights = temp_weights;
		System.out.println("Input number set to: " + n_inputs);
	}

	public void predict(float[][] data) {
		// Provides estimation after training of given inputs

		for (int i = 0; i < data.length; i++) {
			System.out.println("Testing data: " + data[i][0] + " " + data[i][1]);
			System.out.println("Result: " + activation(data[i]));
		}

	}

	private int activation(float[] data) {
		/*
		 * Being 'w' = 'weight' and 'x' = 'input'
		 * 
		 * z = w1x1 + w2x2 + ... + wnxn
		 */
		int z = 0;

		for (int i = 0; i < weights.length; i++) {
			z += weights[i] * data[i];
		}

		// Result normalization (Binary Step - Activation function)
		if (z > 0)
			return 1;
		else
			return 0;
	}

	public void training(float[][] data) {
		/*
		 * Being 'w' = 'weight', 'l_rate' = 'learning rate', 'label' = 'real result' and
		 * 'predicted' = 'perceptron's result'
		 * 
		 * w += l_rate * (label-predicted) * input
		 */
		int prediction = 0;
		for (int x = 0; x < data.length; x++) {
			prediction = activation(data[x]);
			for (int i = 0; i < weights.length; i++) {
				weights[i] += l_rate * (data[x][data[x].length - 1] - prediction) * data[x][i];

			}

			// Printing weight updating
			System.out.println("Input: " + data[x][0] + " " + data[x][1]);
			System.out.println("Predicted: " + prediction + "\t Expected: " + data[x][data[x].length - 1]);
			System.out.print("\nWeights set to: ");
			for (int j = 0; j < weights.length; j++) {
				System.out.print(weights[j] + " ");

			}
			System.out.println("");
		}

	}

}
