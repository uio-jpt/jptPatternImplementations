template StateTransitions {
	
	inst States;
	
	class Queue adds {

	    /** 
	     * the queue's "empty" state
	     */  

		protected QueueEmpty  empty  = new QueueEmpty();

	    /** 
	     * the queue's "normal" state
	     */  

		protected QueueNormal normal = new QueueNormal();

	    /** 
	     * the queue's "full" state
	     */  

		protected QueueFull   full   = new QueueFull(); 


	    /** 
	     * Sets the initial state of the queue to empty. 
	     *
	     * @param queue the queue context that is initialized.
	     */


		// after(Queue queue): initialization(new()) && target(queue) {
		// 	queue.setState(empty);
		// }
		
		public Queue() {
			setState(empty);
		}
		

	    /** 
	     * Updates the queue context's state after each call from it to the 
	     * <code>insert(Object)</code> method if its current state.
	     *
	     * @param queue the queue context that makes the call.
	     * @param qs the current QueueState that receives the call
	     * @param arg the object to be inserted.
	     */

//		after(Queue queue, QueueState qs, Object arg): call(boolean QueueState+.insert(Object)) && target(qs) && args(arg) && this(queue) {
		public boolean insert(Object arg) {
			
			boolean retval = tsuper[States.Queue].insert(arg);
			
			if (state == empty) { 
				normal.insert(arg);
				setState(normal);
			} else if (state == normal) { 
				if (normal.first == normal.last) {
					full.items = normal.items;
					full.first = normal.first;
					setState(full);
				}
			}
			return retval;
		} 

	    /** 
	     * Updates the queue context's state after each call from it to the 
	     * <code>removeFirst()</code> method if its current state.
	     *
	     * @param queue the queue context that makes the call.
	     * @param qs the current QueueState that receives the call
	     */

	//	after(Queue queue, QueueState qs): call(boolean QueueState+.removeFirst()) && target(qs) && this(queue) {
		public boolean removeFirst() {
			
			boolean retval = tsuper[States.Queue].removeFirst();
					
			if (state == full) {
				normal.items = full.items;
				normal.last  = full.first;
				normal.first = (full.first +1) % normal.items.length;
				setState(normal);
			} else if (state == normal) {
				if (normal.first == normal.last) {
					setState(empty);
				}
			}
			
			return retval;
		}   
	}
	
}