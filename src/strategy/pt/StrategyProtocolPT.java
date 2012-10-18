template StrategyProtocolPT {
	
	 // New PT class:
	class Protocol {
		/**
	     * Stores the current strategy for each context
	     * 
	     * @param numbers the int array to sort
	     */
	  	java.util.Hashtable strategyPerContext = new java.util.Hashtable();

	    /**
	     * Sets the strategy for a given context
	     * 
	     * @param c the context to set the strategy for 
	     * @param s the new strategy
	     */
	 	public void setConcreteStrategy(Context c, Strategy s) {
	 		strategyPerContext.put(c, s); 
	 	}

	    /**
	     * Returns the strategy for a given context
	     * 
	     * @param c the context object
	     * @return the strategy object for that context
	     */
	 	public Strategy getConcreteStrategy(Context c) {
	 		return (Strategy) strategyPerContext.get(c);
	 	}
		
	}
	

    /**
     * Defines the <i>Strategy</i> role
     */
	// AJ decl: protected interface Strategy { }
	interface Strategy { }

    /**
     * Defines the <i>Context</i> role
     */
    // AJ decl: protected interface Context  { }   
	interface Context { }
}