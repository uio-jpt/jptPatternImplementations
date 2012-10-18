template StringPrototypes {
	
	public class StringPrototypeA {

	    /**
	     * the string that this object encapsulates
	     */
	    protected String text;

	    /**
	     * Creates a new StringPrototypeA object with the given string
	     *
	     * @param init the initial String for this object
	     */
	    public StringPrototypeA(String init) {
	        text = init;
	    }

	    /**
	     * Changes the string this object encapsulates
	     *
	     * @param newText the new text for this object.
	     */  
	    public void setText(String newText) {
	        text = newText;
	    }

	    /**
	     * Returns a string representation of this object.
	     *
	     * @return a string representation of this object.
	     */
    	public String toString() {
	        return "MyString: "+ text;
	    } 
	}
	
	public class StringPrototypeB {

	    /**
	     * the string that this object encapsulates
	     */
	    protected String text;

	    /**
	     * Creates a new StringPrototypeA object with the given string
	     *
	     * @param init the initial String for this object
	     */
		assumed StringPrototypeB(String init);
	    public StringPrototypeB(String init) {
	        text = init;
	    }

	    /**
	     * Changes the string this object encapsulates
	     *
	     * @param newText the new text for this object.
	     */  
	    public void setText(String newText) {
	        text = newText;
	    }

	    /**
	     * Returns a string representation of this object.
	     *
	     * @return a string representation of this object.
	     */
	    public String toString() {
	        return "AnotherString: " + text;
	    } 
	}
	
	
}