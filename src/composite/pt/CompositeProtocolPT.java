import java.util.*;

template CompositeProtocolPT {
	
	/**
     * Defines the Component role. The role is public to allow clients to 
     * handle objects of that type.
     */
    interface Component {}                                       

    /**
     * Defines the Composite role. Composites are Components that can have
     * children. This role is only used within the pattern context, thus it
     * is protected.
     */
    interface Composite extends Component {}

    /**
     * Defines the Leaf role. Leafs are Components that can not have
     * children. This role is only used within the pattern context, thus it
     * is protected.
     */
    interface Leaf extends Component {}


	 /** 
	 * Defines an interface for visitors that operate on the composite 
	 * structure. These visitors are implemented by concrete sub-aspects
	 * and used in the <code>recurseOperation(Component, Visitor)</code>
	 * method. This construct is needed to allow for method forwarding:
	 * A composite that receives a method forwards the request to all its
	 * children.
	 */
	interface Visitor { 

	    /**
	     * Generic method that performs an unspecified operation on compoennts
	     *
	     * @param c the component to perform the operation on
	     */

	    public void doOperation(Component c);
	}


	/** 
	 * Defines an interface for visitors that operate on the composite 
	 * structure. These visitors are implemented by comcrete sub-aspects
	 * and used in the <code>recurseOperation(Component, Visitor)<>/code>
	 * method. This construct is needed to allow for method forwarding:
	 * A composite that receives a method forwards the request to all its
	 * children.  <p>
	 *
	 * This version allows for a return value of Object type. For some odd
	 * reason AJDT complains if this type is declared protected (as it should
	 * be). Note that Visitor above works fine as protected. 
	 */

	interface FunctionVisitor {

	    /**
	     * Generic method that performs an unspecified operation on components
	     *
	     * @param c the component to perform the operation on
	     */
	    public Object doFunction(Component c);
	}


	 class CompositeHandler 
	{
		assumed CompositeHandler();
	
		public static final CompositeHandler instance = new CompositeHandler();
	
		/**
	     * stores the mapping between components and their children
	     */    
	    private WeakHashMap perComponentChildren = new WeakHashMap();
	
	    /** 
	     * Returns a vector of the children of the argument component
	     */
	    private Vector getChildren(Component comp) {
	        Vector children = (Vector)perComponentChildren.get(comp);
	        if ( children == null ) {
	            children = new Vector();
	            perComponentChildren.put(comp, children);
	        }
	        return children;
	    }
	
	    /**
	     * Client-accessible method to add a new child to a composite
	     *
	     * @param composite the composite to add a new child to
	     * @param component the new child to add
	     */
	    public void addChild(Composite composite, Component component) { 
	        getChildren(composite).add(component);    
	    }
	
	    /**
	     * Client-accessible method to remove a child from a composite
	     *
	     * @param composite the composite to remove a child from
	     * @param component the child to remove
	     */
	
	    public void removeChild(Composite composite, Component component) { 
	        getChildren(composite).remove(component); 
	    }
	
	  	  /**
	     * Client-accessible method to get an Enumeration of all children of 
	     * a composite
	     *
	     * @param composite the composite to add a new child to
	     * @param component the new child to add
	     */
	
	    public Enumeration getAllChildren(Component c)  { 
	        return getChildren(c).elements(); 
	    }
	
	
	    /** 
	     * Implements the method-forwarding logic: If a method is to be applied 
	     * to the aggregate structure, each composite forwards it to its children
	     *
	     * @param c the current component
	     * @param v the visitor representing the operation to be performed
	     */
	    public void recurseOperation(Component c, Visitor v) {                    // This implements the logic that Composites forward 
	        for (Enumeration enum2 = getAllChildren(c); enum2.hasMoreElements(); ) {  // method calls to their children
	            Component child = (Component) enum2.nextElement();
	            v.doOperation(child);
	        }
	    }
	
	   	/** 
	     * Implements the method-forwarding logic: If a method is to be applied 
	     * to the aggregate structure, each composite forwards it to its children.
	     * This version allows for a return value of Object type, effectively
	     * enableing collecting aggregate results on the composite structure.
	     *
	     * @param c the current component
	     * @param fv the visitor representing the operation to be performed
	    */
	    public Enumeration recurseFunction(Component c, FunctionVisitor fv) {
	        Vector results = new Vector();
	        for (Enumeration enum2 = getAllChildren(c); enum2.hasMoreElements(); ) {  // method calls to their children
	            Component child = (Component) enum2.nextElement();
	            results.add(fv.doFunction(child));
	        }
	        return results.elements();
	    }
	}
}