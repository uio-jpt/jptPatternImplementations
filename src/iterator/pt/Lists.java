template Lists {
	
	/**
	 * Defines an interface for a basic list. 
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/12/04
	 * 
	 * @see OpenList
	 */

	public interface SimpleList { 

	    /** 
	     * Returns the number of elements in the list
	     *
	     * @return the number of elements in the list
	     */

		public int count(); 

		/**
		 * Appends an object to the list
		 *
		 * @param o the object to append
		 * @return true if successful, false otherwise
		 */

		public boolean append(Object o);

		/**
		 * Removes an object from the list
		 *
		 * @param o the object to remove
		 * @return true if successful, false otherwise
		 */

		public boolean remove(Object o); 

		/**
		 * Returns an object from the list
		 *
		 * @param index the position of the object
		 * @return the object at position index
		 */

		public Object get(int index);
	}
	
	
	/**
	 * Implements a basic open list. This implementation is based on 
	 * <code>java.util.LinkedList</code>. In essence, this class acts as an 
	 * adapter for the Java class. <p>
	 *
	 * In this version, it is no longer necessary to implement the factory
	 * method here to create the iterator.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/12/04
	 */

	public class OpenList implements SimpleList {

		java.util.LinkedList list = new java.util.LinkedList();

	    /** 
	     * Returns the number of elements in the list
	     *
	     * @return the number of elements in the list
	     */

		public int count() {
			return list.size();
		}

		/**
		 * Appends an object to the list. Since this is an open list, inserting 
		 * elements is assumed to succeed.
		 *
		 * @param o the object to append
		 * @return true if successful, false otherwise
		 */

		public boolean append(Object o) {
			list.addLast(o);
			return true;
		}

		/**
		 * Removes an object from the list
		 *
		 * @param o the object to remove
		 * @return true if successful, false otherwise
		 */

		public boolean remove(Object o) {
			return list.remove(o);   
		} 

		/**
		 * Returns an object from the list
		 *
		 * @param index the position of the object
		 * @return the object at position index
		 */

		public Object get(int index) {
			return list.get(index);
		}
	}
	
	
}