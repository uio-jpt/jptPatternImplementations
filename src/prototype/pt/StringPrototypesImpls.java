template StringPrototypeImpls {
	
	inst PrototypeProtocolPT with Prototype => StringPrototypeA;
	inst PrototypeProtocolPT with Prototype => StringPrototypeB;

	inst StringPrototypes;

	class StringPrototypeA adds {
	    public StringPrototypeA(String init) {
	        tsuper[StringPrototypes.StringPrototypeA](init);
	    }

	}
	
	
	
	class StringPrototypeB adds {

	    public StringPrototypeB(String init) {
	        tsuper[StringPrototypes.StringPrototypeB](init);
	    }

	    /**
	     * Provides an alternative method for cases when the default
	     * <code>clone()</code> method fails: Clones objects "by hand".
	     * 
	     * @param object the prototype object to clone
	     * @return a copy of the object
	     */
	    protected Object createClone() {
	    	return new StringPrototypeB(this.toString());
	    }
	}
}