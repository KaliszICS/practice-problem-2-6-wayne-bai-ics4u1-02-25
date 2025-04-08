public class PracticeProblem {
	public static void main(String args[]) {}
	
	public static double[] cloneArray(double[] nums) {
		double[] val = new double[nums.length];
		for (int i = 0; i < nums.length; i++) {
			val[i] = nums[i];
		}
		return val;
	}

	public static int[] bubbleSort(double[] nums) {
		int swaps = 0;
		int comparisons = 0;

		for (int i = 0; i < nums.length; i++) {
			int oldSwapCount = swaps;
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j + 1] < nums[j]) {
					double mid = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = mid;
					swaps += 3;
				}
				comparisons += 1;
			}
			if (oldSwapCount == swaps) { // no swaps were made
				break;
			}
		}
		return new int[]{swaps,comparisons};
	}

	public static int[] selectionSort(double[] nums) {
		int swaps = 0;
		int comparisons = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			int minInd = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[minInd]) {
					minInd = j;
					swaps += 1;
				}
				comparisons += 1;
			}
			double middleMan = nums[i];
			nums[i] = nums[minInd];
			nums[minInd] = middleMan;

			swaps += 3;
		}
		
		return new int[]{swaps,comparisons};
	}

	public static int[] insertionSort(double[] nums) {
		int swaps = 0;
		int comparisons = 0;

		for (int i = 1; i < nums.length; i++) {
			double val = nums[i];
			int toIndex = i - 1;

			while (toIndex >= 0 && val < nums[toIndex]) {
				nums[toIndex + 1] = nums[toIndex];
				swaps += 1;
				toIndex -= 1;
				comparisons += 1;
			}
			nums[toIndex + 1] = val;
			swaps += 2;
		}

		
		return new int[]{swaps,comparisons};
	}

	public static String least(double[] nums, int ind) {
		int[] bubbleResult = bubbleSort(cloneArray(nums));
		int[] selectionResult = selectionSort(cloneArray(nums));
		int[] insertionResult = insertionSort(cloneArray(nums));
		// Compare in reverse alphabetical order to comply with "If two sorts tie for least, return the first one alphabetically"
		int min = selectionResult[ind];
		String minName = "Selection";

		if (min >= insertionResult[ind]) {
			min = insertionResult[ind];
			minName = "Insertion";
		}

		if (min >= bubbleResult[ind]) {
			return "Bubble";
		}

		return minName;
	}

	public static String leastSwaps(double[] nums) {
		return least(nums, 0);
	}
	public static String leastIterations(double[] nums) {
		return least(nums, 1);
	}
}
