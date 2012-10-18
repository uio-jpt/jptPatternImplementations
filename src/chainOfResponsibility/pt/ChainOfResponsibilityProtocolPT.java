import java.util.WeakHashMap;

template ChainOfResponsibilityProtocolPT {
	
	
	/**
     * This interface is used by extending aspects to say what types
     * handle requests. It models the <i>Handler</i> role.
     */
	interface Handler {
		
		/**
	     * Method defined for Handlers: returns true if a Handler wants to hanlde 
	     * that request. By default, requests are rejected.
	     *
	     * @param request the request to be handled
	     */
		public boolean acceptRequest(Request request);
	
	    /**
	     * Method defined for Handlers: handles a request. Default implementation,
	     * does nothing. It is possible to extend this library implementation to
	     * shows an error message if this method is not overwritten.
	     *
	     * @param request the request to be handled
	     */
		public void handleRequest(Request request);
		
	}    
	
	/**
	 * This interface is used by extending aspects to say what types
	 * represent requests. It models the <i>Request</i> role.
	 */
	interface Request { }    
	    
	
	
	public class RequestInitiator implements Handler {
		
		tabstract public boolean acceptRequest(Request request);
	
		tabstract public void handleRequest(Request request);
		
		/**
	     * The join points after which a request is raised.
	     * It replaces the normally scattered calls to <i>notify()</i>. To be
	     * concretized by sub-aspects.
	     */ 
		//	    protected abstract pointcut eventTrigger(Handler handler, Request request); 

		/**
	     * Calls receiveRequest() after a request was started.
	     *
	     * @param s the subject on which the change occured
	     */
		//		after eventTrigger(Handler handler, Request request) { 
		//			ChainLogistics.receiveRequest(handler, request);
		//		}
		
		public void handleEvent(Request request) { 
			ChainLogistics.receiveRequest(this, request);
		}
	}
	
	
	class ChainLogistics {
		/**
	     * Stores the mapping between <code>Handler</code>s and its<i>
	     * Successor</i>. For each handler, its <i>Successor</i>
	     * is stored.
	     */
		private static WeakHashMap successors = new WeakHashMap();
		
	    /**
	     * Implements the abstracted CoR behavior. Assumption: If the request is
	     * not handled, the last receiver handles it by default ( that is true
	     * for this implementnation of the protocol). 
	     *
	     * The current handler gets asked if it wants to handle the request. If
	     * not, the request is forwarded to its successor
	     */
		static void receiveRequest(Handler handler, Request request) {          
			if (handler.acceptRequest(request)) {
			    handler.handleRequest(request);
			} else {    
	  		    Handler successor = getSuccessor(handler);         
			    if (successor == null) {
					throw new ChainOfResponsibilityException("request unhandled (end of chain reached)\n");
					// This is one way to deal with unhandled requests.
			    } else {
	   	    	    receiveRequest(successor, request);
	   	    	}
			}
		}  	
	
	    /**
	     * Adds a successor to a <i>Handler</i>.  
	     *
	     * @param handler the handler to add a new successor to
	     * @param successor the new successor to attach
	     */ 
		public static void setSuccessor(Handler handler, Handler successor) {
			successors.put(handler, successor);
		}  
	
	
	    /**
	     * Returns the successor of a handler.  
	     *
	     * @param handler the handler in question
	     * @return the successor of the handler
	     */ 
		public static Handler getSuccessor(Handler handler) { 
		    return ((Handler) successors.get(handler));
		}		
	}
	
	
	/**
	 * Implements an exception that occurs if an a request reaches the 
	 * end of a <i>Chain of Responsibility</i> but remains unhandled. 
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/28/04  
	 *
	 * @see ChainOfResponsibilityProtocol
	 */
	public class ChainOfResponsibilityException extends external RuntimeException {  
	
	    /**
	     * Creates a ChainOfResponsibilityException
	     *
	     * @param s the error message 
	     */
		assumed ChainOfResponsibilityException(String s);
/*		public ChainOfResponsibilityException(String s) {
			super(s);
		}*/
	}
}