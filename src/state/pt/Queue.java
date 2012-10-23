template Queue {
	
	/**
	 * Defines the interface for <i>State</i>s within this queue example. The 
	 * operations provided are <code>insert(..)</code>, <code>getFirst(..)</code>,
	 * and <code>removeFirst(..)</code>. This verison
	 * does not require passing the context as an argument to these functions. 
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */

	public interface QueueState {

	    /**
	     * Tries to insert an object into the queue. Returns true if successful, 
	     * false otherwiese.
	     *
	     * @param arg the object to be inserted into the queue
	     * @return true if insertion was successful, false otherwise.
	     */ 

		public boolean insert(Object arg);

	    /**
	     * Returns the first item in the queue
	     *
	     * @return the first item in the queue
	     */ 

		public Object  getFirst();	

	    /**
	     * Tries to remove an object from the queue. Returns true if successful,
	     * false otherwiese.
	     *
	     * @return true if deletion was successful, false otherwise.
	     */ 

		public boolean removeFirst();	

	}
	
	/**
	 * Implements the <i>context</i> of the queue example. This is effectively
	 * a queue with limited capacity. Requests are forwarded to the current state
	 * object.  
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */

	public class Queue {

	    /**
	     * the current state of this context
	     */          

		protected QueueState state = null;

	    /**
	     * Tries to insert an object into the queue. Returns true if successful, 
	     * false otherwiese.
	     *
	     * @param arg the object to be inserted into the queue
	     * @return true if insertion was successful, false otherwise.
	     */ 

		public boolean insert(Object arg) {	
			return state.insert(arg);
		}

	    /**
	     * Returns the first item in the queue
	     *
	     * @return the first item in the queue
	     */ 

		public Object  getFirst() {		
			return state.getFirst();
		}

	    /**
	     * Tries to remove an object from the queue. Returns true if successful,
	     * false otherwiese.
	     *
	     * @return true if deletion was successful, false otherwise.
	     */ 

		public boolean removeFirst() {	
			return state.removeFirst();
		} 

	    /**
	     * Sets the state of the context to the arguments state.
	     *
	     * @param state the new state for the context object.
	     */

		public void setState(QueueState state) {
			this.state = state;
		} 
	}	
}