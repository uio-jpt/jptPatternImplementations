package MainPackage {
	
	inst ConcreteOutput;
	inst StringDecorators with BracketDecorator => ConcreteOutput, StarDecorator => ConcreteOutput;
	
	class ConcreteOutput adds {
		public void print(String s) {
			tsuper[ConcreteOutput.ConcreteOutput].print(decorateBracket(decorateStar(s)));
		}
	}
	
	public class Main {

		/**
		 * Implements the driver for the Decorator design pattern example.<p> 
		 *
		 * Experimental setup: Concrete decorator (ConcreteOutput) prints a
		 * string, Decorators (StarDecorator and BracketDecorator) wrap other
		 * output around it. Output should be: "[ *** <String> *** ]" 
		 *
		 * @param args command line paramters, unused
		 */

		public static void main(String[] args) {

			ConcreteOutput original = new ConcreteOutput();

			original.print("<String>");    

			System.out.println();
		}
	}
	
}