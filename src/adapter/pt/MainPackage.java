package MainPackage {
	
	inst Adapter;
	
	/**
	 * Implements the driver for the Adapter design pattern example. <p> 
	 *
	 * Intent: <i> Convert the interface of a class into another interface clients
	 * expect. Adapter lets classes work together that couldn't otherwise because
	 * incompatible interfaces.</i><p>
	 *
	 * Experimental setup: anloguous to the pattern structure as described on page
	 * 141 of the "Design Patterns" book:
	 * 
	 * <code>Adaptee</code> can print strings to <code>System.out</code>. 
	 * <code>Adapter</code> allows to access <code>Adaptee</code>'s functionality
	 * via <code>Target</code>'s interface.<p>  
	 * 
	 * <i>This is the AspectJ implementation.</i><p>
	 *
	 * The implementation is that of an <i>object adapter</i> (NOT class adapter),
	 * as the latter requires multiple inheritance which Java does not provide. 
	 * 
	 * In this implementation, the <i>Adaptee</i> is effectively made to conform
	 * with the <i>Target</i> interface directly. <code>Adapter</code> is an 
	 * aspect that ensures that by using the <code>declare parents</code> 
	 * construct (to ensure <i>Adaptee</i> is of type <i>Target</i>) and an
	 * inter-type declaration of the missing interface method. 
	 *
	 * @author Jan Hannemann
	 * @author Gregor Kiczales
	 * @version 1.1, 01/26/04
	 * 
	 * @see Target
	 * @see Adaptee
	 * @see Adapter
	 */

	public class Main { 

	    /**
	     * the Adaptee in the scenario. Note that our adaptee can be used as a 
	     * Writer because of the <code>declare parents</code> statement in the 
	     * aspect.
	     */

		private static Target.Writer adaptee; 

		/**
		 * Implements the driver. 
		 * 
		 * In this implementation, the <i>Adaptee</i> becomes its own
		 * <i>Adapter</i>, so only one variable is needed.
		 * 
		 * @param args required for a main method, but ignored
		 */

		public static void main(String[] args) {

			System.out.println("Creating Adaptee (which is its own Adapter)...");
			adaptee = new SystemOutPrinter();

			System.out.print  ("Adapter and Adaptee are the same object: ");
			System.out.println(adaptee == adaptee);

			System.out.println("Issuing the request() to the Adapter...");
			adaptee.write("Test successful.");
		}
	}
	
}