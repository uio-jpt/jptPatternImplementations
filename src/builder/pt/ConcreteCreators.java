template ConcreteCreators {
	
	inst CreatorImpl with CreatorImpl => TextCreator;
	inst CreatorImpl with CreatorImpl => XMLCreator;
	
	/**
	 * Implements a <i>ConcreteBuilder</i> that builds textual descriptions
	 * of complex objects consisting of type, attributes and values. This version
	 * makes use of the default implementation of <code>getResult()</code>.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/26/04
	 */
	class TextCreator adds {

	    /** 
	     * Defines a <i>buildPart()</i> operation for type parts.
	     *
	     * @param newType the type to process
	     */ 

	    public void processType(String newType) {
	        representation = "This is a new "+newType+":\n";
	    }

	    /** 
	     * Defines a <i>buildPart()</i> operation for attribute parts.
	     *
	     * @param newAttribute the attribute to process
	     */ 

	    public void processAttribute(String newAttribute) {
	        representation += ("Its " + newAttribute + " is ");
	    }

	    /** 
	     * Defines a <i>buildPart()</i> operation for value parts.
	     *
	     * @param newValue the value to process
	     */ 

	    public void processValue(String newValue) {
	        representation += (newValue + ".\n");
	    }
	}
	
	/**
	 * Implements a <i>ConcreteBuilder</i> that builds XML descriptions
	 * of complex objects consisting of type, attributes and values.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/26/04
	 */
	class XMLCreator adds {

	    protected String tp = null;
	    protected String attribute = null;

	    /** 
	     * Defines a <i>buildPart()</i> operation for type parts.
	     *
	     * @param newType the type to process
	     */ 

	    public void processType(String newType) {
			representation = "<"+newType+">\n";
	        tp = newType;
	    }

	    /** 
	     * Defines a <i>buildPart()</i> operation for attribute parts.
	     *
	     * @param newAttribute the attribute to process
	     */ 

	    public void processAttribute(String newAttribute) {
	        checkAttribute();
			representation += ("\t<" + newAttribute + ">");
	        this.attribute = newAttribute;
	    }

	    /** 
	     * Defines a <i>buildPart()</i> operation for value parts.
	     *
	     * @param newValue the type to process
	     */ 

	    public void processValue(String newValue) {
			representation += newValue;
	    } 

	    /**
	     * Checks wether the opening type tag is closed and closes it if not.
	     */

	    protected void checkType() {
	        if (tp != null) {
				representation += ("</" + tp + ">\n");
	            tp = null;
	        }
	    }

	    /**
	     * Checks wether the opening attribute tag is closed and closes it if not.
	     */

	    protected void checkAttribute() {        
	        if (attribute != null) {
				representation += ("</" + attribute + ">\n");
	            attribute = null;
	        }
	    }

	    /** 
	     * Defines the <i>getResult()</i> operation for <i>Builder</i>s. 
	     */ 

	    public String getRepresentation() { 
	        checkAttribute();
	        checkType();
	        return representation;
	    }
	}
}