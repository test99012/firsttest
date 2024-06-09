package datos;

import java.util.Random;

public class Functions {

	public static int[] randomArray(int n, int min, int max) {

		int[] arr = new int[n];
		Random random = new Random();

		for (int i = 0; i < n; i++) {

			arr[i] = random.nextInt(max - min + 1) + min;
		}

		return arr;
	}

}
