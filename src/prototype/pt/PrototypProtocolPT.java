template PrototypeProtocolPT {

	/**
	 * Implements the abstract Prototype design pattern. It attaches a default
	 * <code>clone()</code> method on all <i>Prototype</i> participants and
	 * provides a static <code>cloneObject(Prototype)</clone> method. The default
	 * implementation of that method is to try to use the <code>clone()</code> 
	 * method and, failing that, to call its protected <code>
	 * createCloneFor(Prototype)</code> method. Concrete subaspects can either 
	 * overwrite none or one (or both) of the methods to tailor their
	 * particular design pattern instance to its individual needs
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/13/04
	 */ 

   
    class Prototype implements Cloneable {
    
	    /**
	     * Attaches a default <code>clone()</code> method to all prototypes.
	     * This makes use of Java's clone() mechanism that creates a deep copy
	     * of the object in question.
	     * 
	     * @return a copy of the object
	     */
	    public Object clone() throws CloneNotSupportedException {   
	        return super.clone();
	    }
    
	    /**
	     * Provides a static default aspect method for cloning prototypes.
	     * It uses the attached clone() method if possible. If not, it calls the
	     * static <code>createCloneFor(Prototype)</code> method.
	     * 
	     * @param object the prototype object to clone
	     * @return a copy of the object
	     */
	    public Object cloneObject() {
	        try {
	            return clone();
	        } catch (CloneNotSupportedException ex) {
	            return createClone();
	        }
	    }
    
	    /**
	     * Provides an alternative method for cases when the default
	     * <code>clone()</code> method fails. This method can be 
	     * overwritten by concrete subaspects. In this default implementation
	     * it return null.
	     * 
	     * @param object the prototype object to clone
	     * @return a copy of the object, but null in this case
	     */
	    protected Object createClone() { 
	        return null;
	    }
	}
}