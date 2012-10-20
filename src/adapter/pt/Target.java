package Target {
	
	/**
	 * Declares the target interface with a general output method. Acts as the 
	 * <i>Target</i> in the pattern context.
	 *
	 * @author Jan Hannemann
	 * @author Gregor Kiczales
	 * @version 1.1, 01/26/04
	 */

	public interface Writer {

	    /**
	     * Prints the argument string. In the pattern context, this is the
	     * <i>request()</i> method on the <i>Target</i>. 
	     *
	     * @param s the string to print
	     * @see PrinterAdapter 
	     */

		public void write(String s);
	}
	
}