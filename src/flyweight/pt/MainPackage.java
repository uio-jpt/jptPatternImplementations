package MainPackage {
	
	inst FlyweightImplementation;
	
	class CharacterFlyweight adds {
	 	public CharacterFlyweight(char c) {
			tsuper(c);
		}
	}
	
	class WhitespaceFlyweight adds {
	 	public WhitespaceFlyweight(char c) {
			tsuper(c);
		}
	}
	
	public class Main {

		/**
		 * Implements the driver for the Flyweight design pattern example.<p> 
		 *
		 * This example creates a sentence out of <code>PrintableFlyweight</i>s
		 * (characters and whitespaces). 
		 */

		public static void main(String[] args) {

			System.out.println("This is a test for the AspectJ version of the "
			    + "Flyweight pattern implementation.");
			System.out.println("The client will use char flyweights to print "
			    + "the phrase");
			System.out.println("\"This Is A Test\".\n");
			System.out.println("Testing Pattern: Flyweight - STARTING\n");

			FlyweightFactory f = new FlyweightFactory();
			
			PrintableFlyweight T = f.getPrintableFlyweight('t');
			PrintableFlyweight H = f.getPrintableFlyweight('h');
			PrintableFlyweight I = f.getPrintableFlyweight('i');
			PrintableFlyweight S = f.getPrintableFlyweight('s');
			PrintableFlyweight A = f.getPrintableFlyweight('a');
			PrintableFlyweight E = f.getPrintableFlyweight('e');
			PrintableFlyweight Empty = f.getPrintableFlyweight(' '); 

			// Printing: "This Is A Test"

			T.print(true);
			H.print(false);
			I.print(false);
			S.print(false);

			Empty.print(true);

			I.print(true);
			S.print(false);

			Empty.print(true);

			A.print(true);

			Empty.print(true);

			T.print(true);
			E.print(false);
			S.print(false);
			T.print(false);	

			System.out.println();

			System.out.println("\nTesting Pattern: State - FINISHED");
		}
	}
}