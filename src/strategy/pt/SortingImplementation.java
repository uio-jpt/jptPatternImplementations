template SortingImplementation {
	
	public class BubbleSort 
	{

	    /**
	     * Helper method that exchanges two values in an int array
	     * 
	     * @param numbers the int array
	     * @param pos1 the position of the first element
	     * @param pos2 the position of the second element
	     */

		private void exchange(int[] numbers, int pos1, int pos2) {
			int tmp = numbers[pos1];
			numbers[pos1] = numbers[pos2];
			numbers[pos2] = tmp;
		}

	    /**
	     * Sorts an int array using basic bubblesort
	     * 
	     * @param numbers the int array to sort
	     */

		public void sort(int[] numbers) {
			System.out.print("Sorting by BubbleSort...");		
			for (int end = numbers.length; end > 1; end --) {
				for (int current = 0; current < end - 1; current ++) {
					if (numbers[current] > numbers[current+1]) {
						exchange(numbers, current, current+1);
					}
				}
			}
			System.out.println("done.");
		}
	}
		
		
	public class LinearSort {

	    /**
	     * Helper method that exchanges two values in an int array
	     * 
	     * @param numbers the int array
	     * @param pos1 the position of the first element
	     * @param pos2 the position of the second element
	     */

		private void exchange(int[] numbers, int pos1, int pos2) {
			int tmp = numbers[pos1];
			numbers[pos1] = numbers[pos2];
			numbers[pos2] = tmp;
		}


	    /**
	     * Sorts an int array
	     * 
	     * @param numbers the int array to sort
	     */

		public void sort(int[] numbers) {
			System.out.print("Sorting by LinearSort...");
			int lowest  = 0;  

			for (int start = 0; start < numbers.length; start ++) {
				lowest = start;

				for (int current = start; current < numbers.length; current ++) {
					if (numbers[current] < numbers[lowest]) {
						lowest = current;
					}
				}
	    		exchange(numbers, start, lowest);
			}
			System.out.println("done.");
		}
	}
		
	class Sorter {
		tabstract int[] sort(int[] numbers);
	}	
}