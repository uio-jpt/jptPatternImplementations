template BinaryTree {
	
	/**
	 * Defines the interface for nodes. For this example, the interface is empty.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */

	public interface Visitable {}
	
	/**
	 * Implements a <i>ConcreteElement</i> of the aggregate strcuture. This is a 
	 * terminal binary tree element (leaf).
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */

	public class BinaryTreeLeaf implements Visitable {

	    /**
	     * the value stored in this leaf
	     */

		protected int value;

	    /**
	     * Creates a new Leaf with the given value.
	     *
	     * @param value the value of the leaf
	     */

		public BinaryTreeLeaf(int value) {
			this.value = value;
		} 

		/** 
		 * Accessor for the leaf's value
		 *
		 * @return the leaf's value
		 */

		public int getValue() {
		    return value;
		}
	}
	/**
	 * Implements a <i>ConcreteElement</i> of the aggregate strcuture. This is a
	 * non-terminal binary tree element.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */

	public class BinaryTreeNode implements Visitable {

	    /**
	     * the left subtree
	     */

		protected Visitable left;

	    /**
	     * the right subtree
	     */

		protected Visitable right;

		/**
		 * Accessor for the left subtree.
		 *
		 * @return the left subtree.
		 */

		public Visitable getLeft() {
		    return left;
		}

		/**
		 * Accessor for the right subtree.
		 *
		 * @return the right subtree.
		 */

		public Visitable getRight() {
		    return right;
		}

	    /**
	     * Creates a non-terminal node of a binary tree. 
	     *
	     * @param l the new left subtree.
	     * @param l the new left subtree.
	     */

		public BinaryTreeNode(Visitable left, Visitable right) {
			this.left  = left;
			this.right = right;
		}
	}
}