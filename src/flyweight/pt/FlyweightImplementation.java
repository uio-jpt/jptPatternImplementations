template FlyweightImplementation {
	
	inst Flyweights;
	inst FlyweightProtocolPT;
	
	class CharacterFlyweight adds implements Flyweight {
	 	public CharacterFlyweight(char c) {
			tsuper[Flyweights.CharacterFlyweight](c);
		}	
 	}
	
	class WhitespaceFlyweight adds implements Flyweight { 
		public WhitespaceFlyweight(char c) {
			tsuper[Flyweights.WhitespaceFlyweight](c);
		}
	}
	
	class FlyweightFactory adds {
	    /**
	     * Actually creates the <i>Flyweight</i> for a given <i>Key</i>. This 
	     * method is called by <code>getFlyweight(Object)</code> if the 
	     * flyweight does not already exist.
	     *
	     * @param key the key identifying the particular <i>Flyweight</i>
	     * @return the <i>Flyweight</i> representing the key
	     */

		protected Flyweight createFlyweight(Object key) {
			char c = ((Character) key).charValue(); 
			Flyweight flyweight = null;
			if (Character.isWhitespace(c)) {
				flyweight = new WhitespaceFlyweight(c);
			} else { 
				flyweight = new CharacterFlyweight(c);
			}
			return flyweight; 
		}  

	    /**
	     * Provides a custom interface to access the <i>Flyweights</i>. 
	     * Refers to the general <code>getFlyweight(Object)</code> method 
	     * defined on the abstract aspect.
	     *
	     * @param c the character identifying the particular flyweight
	     * @return the flyweight representing the character
	     */

		public PrintableFlyweight getPrintableFlyweight(char c) {
			return (PrintableFlyweight) createFlyweight(new Character(c));
		}
	}
}