template StringTransformer {
	/**
	 * Implements basic string manipulation facilities.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */

	public class StringTransformer {

	    /**
	     * Transforms a string to upper case
	     *
	     * @param s the string to transform
	     * @returns the transformed string
	     */

	    public String transformToUpper(String s) {
	        return s.toUpperCase();
	    }

	    /**
	     * Transforms a string to lower case
	     *
	     * @param s the string to transform
	     * @returns the transformed string
	     */

	    public String transformToLower(String s) {
	        return s.toLowerCase();
	    }
	}
	
}