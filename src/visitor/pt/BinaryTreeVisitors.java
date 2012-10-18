template BinaryTreeVisitors {
	
	inst VisitorProtocolPT with Node => BinaryTreeNode, Leaf => BinaryTreeLeaf;
	inst BinaryTree;
	
	interface Visitable adds extends VisitableNode {}
	
	class BinaryTreeNode adds {
		public BinaryTreeNode(Visitable left, Visitable right) {
			tsuper[BinaryTree.BinaryTreeNode](left, right);
		}
	}	
	
	class BinaryTreeLeaf adds {
		public BinaryTreeLeaf(int value) {
			tsuper[BinaryTree.BinaryTreeLeaf](value);
		}
	} 
	
	public class SummationVisitor implements Visitor {

	    /**
	     * the colleced sum of leaf values
	     */

		protected int sum = 0;

	    /**
	     * Visits a non-terminal binary tree node.
	     *
	     * @param node the regular node
	     */

		public void visitNode(VisitableNode node) {                      
		    if (node instanceof BinaryTreeNode) {
	    		BinaryTreeNode rnode = (BinaryTreeNode) node; 
	    		rnode.left.accept(this);
	    		rnode.right.accept(this);
	    	}
		}

	    /**
	     * Visits a terminal tree node.
	     *
	     * @param node the leaf
	     */

		public void visitLeaf(VisitableNode node) { 
		    if (node instanceof BinaryTreeLeaf) {
	    		BinaryTreeLeaf leaf = (BinaryTreeLeaf) node;
		    	sum += leaf.getValue();
		    }
		}

		/** 
		 * Returns the result of the visitor's operation
		 *
		 * @return a string representing the sum of elemnent in the tree's leaves
		 */

		public String report() {
			return ">>> SumVisitor collected a sum of "+sum;
		}
	}
	
	/**
	 * Implements a <i>ConcreteVisitor</i> that collects string representation 
	 * of the tree.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */

	public class TraversalVisitor implements Visitor {

	    /** 
	     * contains the accumulated result
	     */

		protected String result = "";

	    /**
	     * Visits a a non-terminal binary tree node.
	     *
	     * @param node the regular node
	     */

		public void visitNode(VisitableNode node) {
		    if (node instanceof BinaryTreeNode) {
	    		BinaryTreeNode rnode = (BinaryTreeNode) node;
	    		result += "{"; 
	    		rnode.left.accept(this);
	    		result += ",";
	    		rnode.right.accept(this);
	    		result += "}";
	    	}
		}

	    /**
	     * Visits a terminal tree node.
	     *
	     * @param node the leaf
	     */

		public void visitLeaf(VisitableNode node) {  
		    if (node instanceof BinaryTreeLeaf) {
	    		BinaryTreeLeaf leaf = (BinaryTreeLeaf) node;
		    	result += leaf.value;
		    }
		}

		/** 
		 * Returns the result of the visitor's operation
		 *
		 * @return a string representing a traversal of the tree
		 */

		public String report() {
			return ">>> TraversalVisitor traversed the tree to: "+result;
		}
	}
}