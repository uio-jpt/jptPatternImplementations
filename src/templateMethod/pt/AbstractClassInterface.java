package AbstractClassInterface {
	
	/**
	 * Defines the interface for creators. In this example, it acts as the <i>
	 * AbstractClass</i>. T
	 * 
	 * Note that the template method <code>generate(String)</code>
	 * (which uses all other methods defined in this abstract class) is
	 * implemented by the aspect.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */
	public interface DecoratedStringGenerator { 

	 	/**
	     * Decorates a string. This is the <i>TemplateMethod()</i>.
	     *
	     * @param s the string to decorate
	     * @return the decorated string
	     */
		public String generate(String s);
		
	    /**
	     * Prepares a string for decoration.
	     *
	     * @param s the string to filter
	     * @return the prepared string
	     */
		public String prepare  (String s);

	    /**
	     * Filters a string. 
	     *
	     * @param s the string to filter
	     * @return the filtered string
	     */
		public String filter   (String s);

	    /**
	     * Finalizes a string. This is the last step in the template method.
	     *
	     * @param s the string to finalize
	     * @returns the finalized string
	     */
		public String finalize (String s);
	}
}
