template ConcreteOutput {

	/**
	 * Implements a simple class that provides a <code>print(String)</code> 
	 * method. In this AspectJ implementation, there is no need for a 
	 * <i>Component</i> interface; this class is autonomous and does not need 
	 * to have pattern-related code.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */                        
	public class ConcreteOutput {
	    /**
	     * Prints the argument string to <code>System.out</code>.
	     *
	     * @param s the string to be printed.
	     */

		public void print(String s) {
			System.out.print(s);
		}
	}
}