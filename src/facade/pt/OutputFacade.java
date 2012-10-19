template OutputFacade {
	
	inst Decoration with Decoration => OutputFacade;
	inst StringTransformer with StringTransformer => OutputFacade;
	inst RegularScreen with RegularScreen => OutputFacade;
	
	
	/**
	 * Implements the <i>Facade</i> role in the pattern by providing a 
	 * higher-level interface to the operations provided by 
	 * <code>RegularScreen</code>, <code>Decoration</code>, 
	 * and <code>StringTransformer</code>.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */

	class OutputFacade adds {

	    /**
	     * Prints a string using <code>RegularScreen</code>.
	     *
	     * @param s the string to print 
	     */

	    public void printNormal(String s) {
	        print(s);
	        newline();
	    }

	    /**
	     * Prints a two versions of string with decorations 
	     * using <code>RegularScreen</code> and <code>Decoration</code>.
	     *
	     * @param s the string to print 
	     */

	    public void printFancy(String s) {
			printDecoration();

	        print(transformToUpper(s+" (uppercase)"));
	        newline();

			printDecoration();

	        print(transformToLower(s+" (lowercase)"));
	        newline();

			printDecoration();
	    }

		/**
		 * Prints a decorator string.
		 */

		public void printDecoration() {
			print(getDecoration());
			newline();
			newline();
		}
	}
	
}