template AbstractClassImpl {
	
	/**
	 * Defines the interface for generating decorated strings. 
	 * In this example, it acts as the <i>AbstractClass</i>. 
	 * 
	 * The template method is <code>generate(String)</code>,
	 * which uses all other methods defined in this abstract class.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */
	public class DecoratedStringGeneratorImpl implements AbstractClassInterface.DecoratedStringGenerator { 

	    /**
	     * Decorates a string. This is the <i>TemplateMethod()</i>.
	     *
	     * @param s the string to decorate
	     * @return the decorated string
	     */

		public String generate(String s) {
			s = prepare(s);
			s = filter(s);
			s = finalize(s);
			return s;
		}

	    /**
	     * Prepares a string for decoration.
	     *
	     * @param s the string to filter
	     * @return the prepared string
	     */

		public tabstract String prepare  (String s);

	    /**
	     * Filters a string. 
	     *
	     * @param s the string to filter
	     * @return the filtered string
	     */

		public tabstract String filter   (String s);

	    /**
	     * Finalizes a string. This is the last step in the template method.
	     *
	     * @param s the string to finalize
	     * @return the finalized string
	     */

		public tabstract String finalize (String s);
	}
	
}