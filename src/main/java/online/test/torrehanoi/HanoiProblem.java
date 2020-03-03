package online.test.torrehanoi;

import java.math.BigInteger;

public class HanoiProblem {

	protected BigInteger steps = BigInteger.ZERO;

	public void solveHanoi(int n, String from, String aux, String to) {

		steps = steps.add(BigInteger.ONE);
		if (n == 1) {
			System.out.println("Move plate 1 from " + from + " to " + to);
			return;
		}

		solveHanoi(n - 1, from, to, aux);
		System.out.println("Move plate " + n + " from " + from + " to " + to);
		solveHanoi(n - 1, aux, from, to);
	}

	public static void main(String[] args) {
		HanoiProblem hanoi = new HanoiProblem();
		hanoi.solveHanoi(5, "A", "B", "C");
		System.out.println("Steps: " + hanoi.steps);
	}

}
