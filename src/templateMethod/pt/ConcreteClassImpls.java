template ConcreteClassImpls {
	
	inst AbstractClassImpl with DecoratedStringGeneratorImpl => FancyGenerator;
	inst AbstractClassImpl with DecoratedStringGeneratorImpl => SimpleGenerator;
	
	/**
	 * Implements a <i>ConcreteClass</i> that decorates strings by turnung all
	 * characters into lowercase and then capitalizing the consonants. It also
	 * adds an explanation at the end.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */

	class FancyGenerator adds {

	    /**
	     * Prepares a string for decoration. Turns the string into lowercase.
	     *
	     * @param s the string to filter
	     * @return the prepared string
	     */

		public String prepare  (String s) {
			return s.toLowerCase();
		}

	    /**
	     * Filters a string. Capitalizes all consonants.
	     *
	     * @param s the string to filter
	     * @return the filtered string
	     */

		public String filter   (String s) {
			s = s.replace('a', 'A'); 
			s = s.replace('e', 'E');
			s = s.replace('i', 'I'); 
			s = s.replace('o', 'O');
			s = s.replace('u', 'U');
			return s; 
		}

	    /**
	     * Finalizes a string by adding an explanation to it.
	     *
	     * @param s the string to finalize
	     * @return the finalized string
	     */

		public String finalize (String s) {
			return (s+".\n(all consonants capitalized)");
		}
	}
	
	/**
	 * Implements a <i>ConcreteClass</i> that decorates strings by adding a 
	 * period at the end of them.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */

	class SimpleGenerator adds {
	
	    /**
	     * Prepares a string for decoration. Does nothing.
	     *
	     * @param s the string to filter
	     * @return the passed string
	     */
	
		public String prepare  (String s) {
			return s;
		}
	
	    /**
	     * Filters a string. Does nothing.
	     *
	     * @param s the string to filter
	     * @return the passed string
	     */
	
		public String filter   (String s) {
			return s;
		}
	
	    /**
	     * Finalizes a string by adding a period to it.
	     *
	     * @param s the string to finalize
	     * @return the finalized string
	     */
	
		public String finalize (String s) {
			return s+".";
		}
	}
	
	
}