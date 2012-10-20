package MainPackage {
	
	inst ConcreteClassImpls;
	
	
	/* 
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */
	public class Main {

		/**
		 * Implements the driver for the Template Method design 
		 * pattern example.<p>
		 *
		 * @param args the command line parameters, unused
		 */
		public static void main(String[] args) {
			String original = "This Is The Original String To Be Processed";

			AbstractClassInterface.DecoratedStringGenerator c1 = new SimpleGenerator();
			AbstractClassInterface.DecoratedStringGenerator c2 = new FancyGenerator();

			System.out.println("<Original>");
			System.out.println(original);
			System.out.println("<SimpleGenerator>");
			System.out.println(c1.generate(original));
			System.out.println("<FancyGenerator>");
			System.out.println(c2.generate(original));
		}
	}
	
}