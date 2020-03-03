package online.test.staircase;

public class StaircaseProblem {
	
	public static void main(String[] args) {
		
		// if =1
		// [1]
		
		// if =2
		// [1,1]
		// [2]
		
		// if =3
		// [3]
		// [2.1] [1.2]
		// [1.1.1]
		
		//if =4
		// [3.1] [1.3]
		// [2.2]
		// [2.1.1] [1.2.1] [1.1.2]
		// [1.1.1.1]
		
		// If Stairs is 5 return 
		// [3, 2] [2, 3]
		// [3, 1, 1] [1,3,1] [1.1.3]
		// [2, 2, 1] [2.1.2] [1.2.2]
		// [2, 1 ,1 ,1] [1.2.1.1] [1.1.2.1] [1.1.1.2]
		// [1, 1, 1, 1, 1]
		
		System.out.println(numberOfWays(5)); // must be 13
		
	}

	private static Integer numberOfWays(int stairs) {

		if (stairs == 0) {
			return 1;
		}
		
		Integer[] sums = new Integer[stairs+1];
		sums[0] = 1;
 		
		for (int i = 1; i <= stairs; i++) {
			
			Integer total = 0;
			for (int j = 1; j <= 3; j++) {
				if ((i-j) >= 0) {
					total += sums[i - j];
				}
			}
			sums[i] = total;
		}
		
		return sums[stairs];
	}

}
