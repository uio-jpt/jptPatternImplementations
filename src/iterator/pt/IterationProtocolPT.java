import java.util.NoSuchElementException;
import java.util.Iterator;

template IteratorProtocolPT {
	
	
	required type ListSpec {
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
	
	
	class ReverseIterator implements Iterator {
    
        /**
         * the positition of the current element
         */
      	protected int current; 
    	
    	/**
    	 * the list this iterator operates on
    	 */
     	protected ListSpec list; 
    	
    	/**
    	 * Returns true if the iteration has more elements.
    	 *
    	 * @return true if the iteration has more elements
    	 */
    	public boolean hasNext() {
    		return (current > 0);
    	}
    	
    	/**
    	 * This opional method is not implemented for this iterator.
    	 */ 
      	public void remove() {
    	    throw new UnsupportedOperationException("remove() not supported");
        }                     
    	
        /**
         * Returns the next element in the iteration.
        */
   		public Object next() {
    		if (!hasNext()) {
    			throw new ArrayIndexOutOfBoundsException("Iterator out of Bounds"); 
    		} else {
        		return list.get(--current);
    	    }
    	}
    	
    	/**
    	 * Creates a new ReverseIterator from the given list.
    	 *
    	 * @param list the list to generate an iterator from
    	 */
    	public ReverseIterator(ListSpec list) {
    		this.list = list;
    		current = list.count();
    	}
    }

}