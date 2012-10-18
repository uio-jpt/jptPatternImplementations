package MainPackage {

	inst BinaryTreeVisitors;
	
	/**
	 * Implements the driver for the Visitor design pattern example.<p> 
	 *
	 * Intent: <i>Represents an operation to be performed on the elements of an 
	 * object structure. Visitor lets you define a new operation without changing
	 * the classes of the elements on which it operates</i><p>
	 *
	 * Participating classes are <code>SummationVisitor</code> and 
	 * <code>TraversalVisitor</code> as <i>ConcreteVisitor</i>s, implementing the 
	 * <code>VisitorProtocol.Visitor</code> interface. <BR>
	 * 
	 * <code>BinaryTreeNode</code> and <code>BinaryTreeLeaf</code> are 
	 * <i>ConcreteElement</i>s, implementing the <code>Visitable</code> interface.
	 * <p>
	 *
	 * In this example, a binary tree that has int values as leafs is built. 
	 * SummationVisitor is a <i>Visitor</i> that collects the sum of 
	 * elements in the leafs (should be 6). 
	 * 
	 * TraversalVisitor is a <i>Visitor</i> that 
	 * collects a description of the tree like {{1,2},3}
	 *
	 * <p><i>This is the AspectJ version.</i><p>
	 *
	 * Note that <UL>
	 * <LI> Every visitor (even the inteface) has to know of each possible element 
	 *      type in the object structure. 
	 * <LI> Nodes need not to know of the visitor interface; 
	 * </UL>
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */

	public class Main { 

	    /**
	     * Implements the driver for the Visitor design pattern example.<p> 
	     *
	     * @param args the command-line parameters, unused
	     */


		public static void main(String[] args) { 

		    System.out.println("Building the tree (1): leaves");

			BinaryTreeLeaf one   = new BinaryTreeLeaf(1);
			BinaryTreeLeaf two   = new BinaryTreeLeaf(2);
			BinaryTreeLeaf three = new BinaryTreeLeaf(3);

		    System.out.println("Building the tree (1): regular nodes");

			BinaryTreeNode regN = new BinaryTreeNode(one, two);
			BinaryTreeNode root = new BinaryTreeNode(regN, three);

	        System.out.println("The tree now looks like this: ");
	        System.out.println("         regN                 ");
	        System.out.println("        /    \\               ");
	        System.out.println("    regN      3               ");
	        System.out.println("   /    \\                    ");
	        System.out.println("  1      2                    ");

	        System.out.println("Visitor 1: SumVisitor, collects the sum of leaf");
	        System.out.println("values. Result should be 6.");

			SummationVisitor sumVisitor = new SummationVisitor();  
			root.accept(sumVisitor);
			System.out.println(sumVisitor.report());  

	        System.out.println("Visitor 2: TraversalVisitor, collects a tree");
	        System.out.println("representation. Result should be {{1,2},3}.");

			TraversalVisitor traversalVisitor = new TraversalVisitor();  
			root.accept(traversalVisitor);
			System.out.println(traversalVisitor.report());  
		}
	}
}