template FileSystem {
	
	/**
	 * Implements a <i>Leaf</i>. Note that in this AspectJ version, the 
	 * participants are decoupled from the pattern. Thus, this leaf does
	 * not need to implement the <i>Component</i> interface.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/06/04
	 * 
	 * @see Component 
	 * @see Directory
	 */

	public class File { 

		/**
		 * stores the name for this File
		 */

		protected String name;

		/**
		 * stores the size for this File
		 */

		protected int size;
		/**
		 * Creates a new File with a given name and size
		 *
		 * @param name the name for the new File
		 * @param size the size for the new File
		 */

		assumed File(String name, int size);
		public File(String name, int size) {
			this.name = name;
			this.size = size;
		}

		/**
		 * Overwrites the <code>toString()</code> method from <code>Object</code>
		 * to print information about this object
		 */

		public String toString() {
			return ("File: "+name+" ("+size+" KB)");
		}

	 	/**
		 * Returns the size of this File
		 * 
		 * @return the size of this File (on disk)
		 */
		public int getSize() {
			return size;
		}
	}
	
	/**
	 * Implements a <i>Composite</i>. Note that in this AspectJ version, the 
	 * participants are decoupled from the pattern. Thus, this composite does
	 * not need to implement an interface or even keep track of its children.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/06/04
	 * 
	 * @see Component 
	 * @see File
	 */

	public class Directory { 

		/**
		 * stores the name of this Directory
		 */

		protected String name;

		/**
		 * Creates a new Directory with a given name
		 *
		 * @param name the name for the new Directory object
		 */

		assumed Directory(String name);
		public Directory(String name) {
			this.name = name;
		}

		/**
		 * Overwrites the <code>toString()</code> method from <code>Object</code>
		 * to print information about this Directory
		 */

		public String toString() {
			return ("Directory: "+name);
		}
	}
	
}