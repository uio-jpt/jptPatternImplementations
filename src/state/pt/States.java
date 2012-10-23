template States {
	
	inst Queue;
	
	/**
	 * Implements the <i>ConcreteState</i> "empty" for the queue example. 
	 * Removing items is impossible if the queue is empty. 
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 *        
	 * @see QueueNormal
	 * @see QueueFull
	 */

	public class QueueEmpty implements QueueState {
		
		assumed QueueEmpty();

	    /**
	     * Tries to insert an object into the queue. Returns true since it is
	     * always possible to insert items into an empty queue. The appropriate
	     * state transitions are implemented by the aspect.
	     *
	     * @param arg the object to be inserted into the queue
	     * @return true.
	     */ 

		public boolean insert(Object arg) {		
			return true; 
		}

	    /**
	     * Returns the first item in the queue. Returns null since the queue is 
	     * empty.
	     *
	     * @return null.
	     */ 

		public Object  getFirst() {
			return null;
		}

	    /**
	     * Tries to remove an object from the queue. Returns false (queue is 
	     * empty).
	     *
	     * @param context the <i>Context</i> for this design pattern (for update 
	     * on demand)
	     * @return false.
	     */ 

		public boolean removeFirst(){
			return false;
		} 

	}
	
	/**
	 * Implements the <i>ConcreteState</i> "full" for the queue example. 
	 * Inserting items is impossible if the queue is full. 
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 *
	 * @see QueueEmpty
	 * @see QueueNormal
	 */

	public class QueueFull implements QueueState {

		assumed QueueFull();

	    /**
	     * stores the items in the queue
	     */

		protected Object[] items;

		/**
		 * stores the index of the first item in the queue.
		 */  

		protected int first;

	    /**
	     * Tries to insert an object into the queue. Returns false since the
	     * queue is full.
	     *
	     * @param arg the object to be inserted into the queue
	     * @return false.
	     */ 

		public boolean insert(Object arg) {	
			return false;
		}

	    /**
	     * Returns the first item in the queue. 
	     *
	     * @return the first item in the queue.
	     */ 

		public Object  getFirst() {	
			return items[first];
		}

	    /**
	     * Tries to remove an object from the queue. Returns true if successful,
	     * false otherwiese. The state transition to "normal" is implemented by 
	     * the aspect.
	     *
	     * @return true since it is always possible to delete an item from a 
	     * full queue
	     */ 

		public boolean removeFirst(){	    
			return true;
		}
	}
	
	public class QueueNormal implements QueueState {

		assumed QueueNormal();
		
	    /**
	     * stores the items in the queue
	     */

		protected Object[] items = new Object[3];

	    /**
	     * stores the index of the first item in the queue
	     */

		protected int first = 0; 

	    /**
	     * stores the index of the last item in the queue
	     */

		protected int last  = 0;

	    /**
	     * Tries to insert an object into the queue. Returns true if successful, 
	     * false otherwiese. Potential state changes to "full" are facilitated 
	     * by the aspect.
	     *
	     * @param arg the object to be inserted into the queue
	     * @return true if insertion was successful, false otherwise.
	     */ 

		public boolean insert(Object arg) {		// Inserts a new Object into the queue
			items[(last)%items.length] = arg; 
			last = (last+1) % items.length;  
			return true;
		}

	    /**
	     * Returns the first item in the queue. 
	     *
	     * @returns null.
	     */ 

		public Object  getFirst() {				// Returns the first element in the queue 
			return items[first];
		}

	    /**
	     * Tries to remove an object from the queue. Returns true if successful,
	     * false otherwiese. Potential state changes to "empty" are facilitated 
	     * by the aspect.
	     *
	     * @return true if deletion was successful, false otherwise.
	     */ 

		public boolean removeFirst(){			// Removes the first element from the queue  
			first = (first + 1) % items.length; 
			return true;
		}
	}	
}