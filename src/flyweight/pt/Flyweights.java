template Flyweights {
	
	
	/**
	 * Defines the <i>Flyweight</i> interface. Here, the flyweights are 
	 * characters that offer a single method: <code>print(boolean)</code>.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */

	public interface PrintableFlyweight {  

		/**
		 * Defines the method signature for <i>Flyweights</i>' 
		 * <code>print()</code> method
		 *
		 * @param uppercase whether the character is to be printed as uppercase
		 */

	  	public void print(boolean uppercase);
	}
	
		
	/**
	/**
	 * A <i>ConcreteFlyweight</i> storing a single regular character
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */
	public class CharacterFlyweight implements PrintableFlyweight {

	    /**
	     * The character this <i>ConcreteFlyweight</i> represents
	     */

		private char c;


	    /** 
	     * Creates a new <i>ConcreteFlyweight</i> and sets it to represent a 
	     * particular regular character
	     * 
	     * @param c the character to represent
	     */
		assumed CharacterFlyweight(char c);
		public CharacterFlyweight(char c) {
			this.c = c;
		}

	    /** 
	     * Prints the stored character
	     *
	     * @param uppercase whether the character should be printed in
	     * uppercase
	     */ 

		public void print(boolean uppercase) {
			System.out.print(uppercase ? Character.toUpperCase(c) : c);
		}
	}
	
	/**
	 * A <i>ConcreteFlyweight</i> storing a single whitespace 
	 * character
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 * 
	 * @see PrintableFlyweightFactory
	 */
	public class WhitespaceFlyweight implements PrintableFlyweight {


	    /**
	     * The character this flyweight represents
	     */

		private char c;

	    /** 
	     * Creates a new flyweight and sets it to represent a particular 
	     * whitespace character
	     * 
	     * @param c the character to represent
	     */

		assumed WhitespaceFlyweight(char c);
		public WhitespaceFlyweight(char c) {
			this.c = c;
		}

	    /** 
	     * Prints the stored character
	     *
	     * @param uppercase whether the character should be printed in
	     * uppercase
	     */ 

		public void print(boolean uppercase) {
			System.out.print(uppercase ? Character.toUpperCase(c) : c);
		}
	}
	
}