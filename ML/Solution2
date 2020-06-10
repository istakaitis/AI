/**
 * This class performs a multivariate logistic regression on the data within the
 * class.
 * 
 * @author Ignas Stakaitis
 *
 */
public class Solution2 {
	// the data used is stored in arrays
	public static double[] x1Values = new double[] { 1, 2, 0.3, 0.6, 1.2, 1.3, 1.8, 1.5, 3, 4, 3.1, 3.6, 3.8, 3.5,
			3.25 };
	public static double[] x2Values = new double[] { 1, 2, 1.2, 0.8, 1, 1, 2, 1.4, 3, 4, 3.3, 3.8, 2.1, 2.2, 2.8 };
	public static double[] yValues = new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 };

	/**
	 * The main method which runs the multivariate logistic regression.
	 * 
	 */
	public static void main(String[] args) {

		// number of iterations set to 0, will be incremented
		int epochs = 0;

		// initial values of w for the quadratic hypothesis function
		double w0 = 0;
		double w1 = 0;
		double w2 = 0;

		// learning rate
		double alpha = 0.1;
		// initialising current and previous cost
		double currentCost = -1;
		double previousCost = 0;
		double cost = 0;
		// while not converged
		while (Math.abs(currentCost - previousCost) > 0.0000000001) {
			// counting epochs
			epochs++;
			// updating previous cost
			previousCost = currentCost;
			// looping through the data array
			for (int j = 0; j < x1Values.length; j++) {
				double x1Value = x1Values[j];
				double x2Value = x2Values[j];
				double yValue = yValues[j];
				// prediction of y for a given xValue
				double prediction = (1 / (1 + Math.pow(Math.E, -(w0 + w1 * x1Value + w2 * x2Value))));
				// updating cost
				cost += (yValue * Math.log(prediction)) + ((1 - yValue) * Math.log(1 - prediction));
				// updating w0, w1 and w2
				w0 += alpha * (yValue - prediction);
				w1 += alpha * (yValue - prediction) * x1Value;
				w2 += alpha * (yValue - prediction) * x2Value;

			}
			// updating current cost
			cost = -1.0 / x1Values.length * cost;
			currentCost = cost;
			// prevent potential infinite loops
			if (epochs >= 100000000) {
				break;
			}
		}
		// printout of the information
		System.out.println("Number of epochs: " + epochs);
		System.out.println("Final cost: " + cost);
		System.out.println("w0: " + w0);
		System.out.println("w1: " + w1);
		System.out.println("w2: " + w2);
	}
}
