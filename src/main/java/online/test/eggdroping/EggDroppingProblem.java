package online.test.eggdroping;

import java.util.stream.IntStream;

public class EggDroppingProblem {

	public static final int NUM_OF_EGGS = 2;
	public static final int NUM_OF_FLOORS = 100;

	private int[][] auxTable = new int[NUM_OF_EGGS + 1][NUM_OF_FLOORS + 1];

	public int findTheFloor() {

		auxTable[0][0] = 1;
		auxTable[1][0] = 1;
		
		auxTable[1] = IntStream.range(0, NUM_OF_FLOORS).toArray();

		for (int n = 2; n <= NUM_OF_EGGS; n++) {
			for (int m = 1; m <= NUM_OF_FLOORS; m++) {

				auxTable[n][m] = Integer.MAX_VALUE;

				for (int x = 1; x <= m; x++) {
					int maxDrops = 1 + Math.max(auxTable[n - 1][x - 1], auxTable[n][m - x]);

					if (maxDrops < auxTable[n][m]) {
						auxTable[n][m] = maxDrops;
					}
				}
			}
		}

		return auxTable[NUM_OF_EGGS][NUM_OF_FLOORS];
	}
	
	public static void main(String args[]) {
		EggDroppingProblem eggDroppingProblem = new EggDroppingProblem();
		System.out.println("Minimum of drops to find the specific floor: "+eggDroppingProblem.findTheFloor());
	}
}
