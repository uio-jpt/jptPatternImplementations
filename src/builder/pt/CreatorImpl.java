template CreatorImpl {
	
	public class CreatorImpl implements CreatorInterface.Creator {

	    /** 
	     * An inheritable variable that carries the result of the build.
	     */
	    String representation;
	    
	    /** 
	     * Defines a <i>buildPart()</i> operation for type parts.
	     *
	     * @param type the type to process
	     */ 
	     public tabstract void processType(String tp);
	    
	    /** 
	     * Defines a <i>buildPart()</i> operation for attribute parts.
	     *
	     * @param newAttribute the attribute to process
	     */ 
	    
	    public tabstract void processAttribute(String newAttribute);
	    
	    /** 
	     * Defines a <i>buildPart()</i> operation for value parts.
	     *
	     * @param newValue the value to process
	     */ 
	    
	    public tabstract void processValue(String newValue);
	    
	    /** 
	     * Defines a <i>getResult()</i> operation for <i>Builder</i>s.
	     * This is the default implementation.
	     * 
	     * @return a representation of the build result
	     */ 
	    public String getRepresentation() {
	        return representation;
	    }  
	}
}