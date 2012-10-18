template VisitorProtocolPT {
	
	/**
	 * Implements the abstracted Visitor design pattern.<p> 
	 *
	 * Intent: <i>Represents an operation to be performed on the elements of an 
	 * object structure. Visitor lets you define a new operation without changing
	 * the classes of the elements on which it operates</i><p>
	 *
	 * Note that this implementation only deals with two different kind of nodes:
	 * terminal and non-terminal nodes. In cases where the aggregate structure  
	 * contains more types of nodes, this aspect cannot be used without 
	 * modifications. <p> 
	 *
	 * Note further that whenever the aggregate structure is unimportant, the
	 * additional functionality can be added in a much sipmler using 
	 * AspectJ's open classes mechanism (i.e., by using inter-type declarations
	 * to implement the desired functionality).
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */

    /**
     * Defines the <i>Element</i> role. The inerface is public so that
     * <i>ConcreteVisitor</i>s can use the type.
     */
    public interface VisitableNode {
	
	    /**
	     * Declares <code>accept(..)</code> for visitable nodes 
	     *
	     * @param visitor the visitor that is to be accepted
	     */
		public void accept(Visitor visitor);
	}

    /**
     * Defines a <i>ConcreteElement</i> role for non-terminal nodes in 
     * a binary tree structure. The interface is protected as it is only used
     * by concrete subaspects.
     */
	public class Node implements VisitableNode {
		/**
	     * Declares <code>accept(..)</code> for regular nodes 
	     *
	     * @param visitor the visitor that is to be accepted
	     */
		public void accept(Visitor visitor) { 
		    visitor.visitNode(this); 
		}
	}

    /**
     * Defines a <i>ConcreteElement</i> role for terminal nodes in 
     * a tree structure. The inerface is protected as it is only used
     * by concrete subaspects.
     */
	public class Leaf implements VisitableNode {
		
	    /**
	     * Declares <code>accept(..)</code> for leaf nodes 
	     *
	     * @param visitor the visitor that is to be accepted
	     */
		public void accept(Visitor visitor) { 
		    visitor.visitLeaf(this); 
		}
	} 

    /**
     * This interface is implemented by <i>ConcreteVisitor</i>s. 
     */
	public interface Visitor {

	    /**
	     * Defines a method signature for visiting regular nodes.
	     *
	     * @param node the regular node to visit
	     */

		public void visitNode(VisitableNode node);

	    /**
	     * Defines a method signature for visiting leaf nodes.
	     *
	     * @param node the leaf node to visit
	     */

		public void visitLeaf(VisitableNode node);

	    /**
	     * Defines a method signature for returning the visitor's results
	     *
	     * @param node a string containig the visitor's results
	     */

		public String report();
	}
}