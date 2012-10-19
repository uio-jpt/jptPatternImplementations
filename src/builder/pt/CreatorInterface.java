package CreatorInterface {
	/**
	 * Defines the interface for <i>Builder</i>s. 
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/26/04
	 * 
	 * @see TextCreator
	 * @see XMLCreator
	 */
	public interface Creator {

	    /** 
	     * Defines a <i>buildPart()</i> operation for type parts.
	     *
	     * @param type the type to process
	     */ 
	    public void processType(String tp);

	    /** 
	     * Defines a <i>buildPart()</i> operation for attribute parts.
	     *
	     * @param newAttribute the attribute to process
	     */ 
	    public void processAttribute(String newAttribute);

	    /** 
	     * Defines a <i>buildPart()</i> operation for value parts.
	     *
	     * @param newValue the value to process
	     */ 
	    public abstract void processValue(String newValue);

	    /** 
	     * Defines a <i>getResult()</i> operation for <i>Builder</i>s.
	     * This is the default implementation.
	     * 
	     * @return a representation of the build result
	     */ 
	    public String getRepresentation();
	}
}