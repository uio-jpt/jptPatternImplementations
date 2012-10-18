template SortingStrategyImplementation {
	
	inst StrategyProtocolPT with Protocol => Sorter;
	inst SortingImplementation;
	
	class BubbleSort adds implements Strategy {}	
	class LinearSort adds implements Strategy {}
	// interface Strategy adds {
	// 	void sort(int[] numbers);
	// }
	
	class Sorter adds implements Context {
		
		int[] sort(int[] numbers) {

			Strategy strategy = getConcreteStrategy(this);

			if (strategy instanceof BubbleSort) {
				((BubbleSort)strategy).sort(numbers);
			} else if (strategy instanceof LinearSort) {
				((LinearSort) strategy).sort(numbers);
			} else {
				// Invalid strategy: could throw an exception here
			}
			
			return numbers;
		}
	}
}


// declare parents: Sorter     implements Context;
// 
// /**
//  * Assignes the <i>Strategy</i> role to <code>LinearSort</code>
//  */
// 
// declare parents: LinearSort implements Strategy;
// 
// /**
//  * Assignes the <i>Strategy</i> role to <code>BubbleSort</code>
//  */
// 
// declare parents: BubbleSort implements Strategy;