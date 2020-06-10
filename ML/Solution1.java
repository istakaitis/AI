/**
 * This class performs a univariate non-linear regression on the data within the
 * class.
 * 
 * @author Ignas Stakaitis
 *
 */
public class Solution1 {
	// the data used is stored in arrays
	public static double[] xValues = new double[] { -100, -10, -3, 0, 1, 2, 3, 4, 10, 100 };
	public static double[] yValues = new double[] { 9901, 91, 7, 1, 3, 7, 13, 21, 111, 10101 };

	/**
	 * The main method which runs the univariate non-linear regression.
	 */
	public static void main(String[] args) {

		// number of iterations set to 0, will be incremented
		int epochs = 0;

		// initial values of w for the quadratic hypothesis function
		double w0 = 0;
		double w1 = 0;
		double w2 = 0;

		// learning rate
		double alpha = 0.00000001;
		// initialising current and previous cost
		double currentCost = -1;
		double previousCost = 0;
		// while not converged
		while (Math.abs(currentCost - previousCost) > 0.0000000001) {
			// counting epochs
			epochs++;
			// updating previous cost
			previousCost = currentCost;
			// setting cost to 0
			double cost = 0;
			// looping through the data array
			for (int j = 0; j < xValues.length; j++) {
				double xValue = xValues[j];
				double yValue = yValues[j];
				// prediction of y for a given xValue
				double prediction = w0 + (w1 * xValue) + (w2 * xValue * xValue);
				// updating cost
				cost += (yValue - prediction) * (yValue - prediction);
				// updating w0, w1 and w2
				w0 += alpha * (yValue - prediction);
				w1 += alpha * (yValue - prediction) * xValue;
				w2 += alpha * (yValue - prediction) * xValue * xValue;

			}
			// updating current cost
			currentCost = cost;
			// prevent potential infinite loops
			if (epochs >= 100000000) {
				break;
			}
		}
		// printout of the information
		System.out.println("Final cost: " + currentCost);
		System.out.println("Number of epochs: " + epochs);
		System.out.println("Final Equation: h(x) = " + w2 + " * x^2 + " + w1 + " * x + " + w0);
	}
}
