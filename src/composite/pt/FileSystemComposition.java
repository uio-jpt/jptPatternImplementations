import java.io.PrintStream;  
import java.util.Enumeration; 

template FileSystemComposition {
	
	inst CompositeProtocolPT;
	inst FileSystem;
	
	interface Component adds {
		void printStructure(PrintStream stream);
		int subSum();
	}
	
	class Directory adds implements Composite {
		
		public Directory(String name) {
			tsuper[FileSystem.Directory](name);
		}
		
		/**
	     * Implements <code>printStructure</code> for Composites: The indent 
	     * is appropriately updated and the method call is forwarded to all 
	     * children.
	     *
	     * @param s the PrintStream to print to
	     */
	    public void printStructure(PrintStream stream) {
	        CompositeHandler.indent();
	        stream.println("<Composite>"+this);
	        CompositeHandler.indent +=4;
			CompositeHandler.instance.recurseOperation(this, new PrintStructureVisitor(stream));
/*	        FileSystemComposition.aspectOf().recurseOperation(this, new Visitor() { 
	            public void doOperation(Component c) { c.printStructure(s); } 
	        } ); */
	
	        CompositeHandler.indent -=4;
	    }
	
	    /**
	     * Implements <code>subSum()</code> for Composites: The method call 
	     * is forwarded to all children, then the results are summed up.
	     *
	     * @returns the sum of leaf sizes of all elements in this structure
	     */

	    public int subSum() {     
	        Enumeration enum2 = CompositeHandler.instance.recurseFunction(this, new MyFunctionVisitor());
			/*FileSystemComposition.aspectOf().recurseFunction(
	          this, new FunctionVisitor() { 
	            public Object doFunction(Component c) { 
	                return new Integer(c.subSum()); 
	            
	        }); */

	        int sum = 0;
	        while (enum2.hasMoreElements()) {
	            sum += ((Integer) enum2.nextElement()).intValue();
	        }
	        return sum;
	    }
	

	}
	
	class File adds implements Leaf {
		
		public File(String name, int size) {
			tsuper[FileSystem.File](name, size);
		}
		
	    /**
	     * Implements <code>printStructure</code> for <i>Leaf</i>s.
	     *
	     * @param s the PrintStream to print to
	     */
	    public void printStructure(PrintStream stream) {
	        CompositeHandler.indent();
	        stream.println("<Leaf>"+this);
	    }
	
	    /**
	     * Implements <code>subSum()</code> for <i>Leaf</i>s: Simply returns
	     * the <i>Leaf</i>'s size.
	     *
	     * @returns the leaf id
	     */
	    public int subSum() {
	        return size;
	    }
	}
	
	class CompositeHandler adds {
		
		
		/**
		 * helper variable to store recursion depth for pretty printing
		 */
	    static int indent = 0;

	    /**
	     * Print a number of spaces according to the current recursion depth
	     */
	    static void indent() {
			for (int i=0; i<indent; i++)
				System.out.print(" ");
		}
		
	}
	
	class MyFunctionVisitor implements FunctionVisitor {
            assumed MyFunctionVisitor();

			public Object doFunction(Component c) { 
                return new Integer(c.subSum()); 
            }
	}
	
	class PrintStructureVisitor implements Visitor {
		protected PrintStream s;
		assumed PrintStructureVisitor(PrintStream s);
		public PrintStructureVisitor(PrintStream s) { this.s = s; }
		
		
		public void doOperation(Component c) { c.printStructure(s); } 
	}
}