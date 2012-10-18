template FlyweightProtocolPT {
	
	
	class FlyweightFactory 
	{
		/** 
	     * stores the existing <i>Flyweight</i> by key
	     */
		private java.util.Hashtable flyweights = new java.util.Hashtable();

		/**
		 * Creates a <i>Flyweight</i> for a given key. This method is called by
		 * <code>getFlyweight(Object)</code> if the flyweight does not already
		 * exist.
		 *
		 * @param key the key identifying the particular flyweight
		 * @return the <i>Flyweight</i> representing the key
		 */
		protected tabstract Flyweight createFlyweight(Object key);

		/**
		 * Returns the <i>Flyweight</i> for a particular key.
		 * If the appropriate <i>Flyweight</i> does not yet exist, it is created 
		 * on demand.
		 *
		 * @param key the key identifying the particular <i>Flyweight</i>
		 * @return the <i>Flyweight</i> representing the key
		 */
		public Flyweight getFlyweight(Object key) {
			if (flyweights.containsKey(key)) {
				return (Flyweight) flyweights.get(key);
			} else {
				Flyweight flyweight = createFlyweight(key);
				flyweights.put(key, flyweight);  
				return flyweight;
			}
		}
	}

    /** 
     * defines the <i>Flyweight</i> role.
     */
	interface Flyweight { }
}