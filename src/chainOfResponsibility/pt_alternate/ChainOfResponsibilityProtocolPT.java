import java.util.WeakHashMap;

template ChainOfResponsibilityProtocolPT {
    
	
	/**
     * This interface is used by extending aspects to say what types
     * handle requests. It models the <i>Handler</i> role.
     */
    required interface Handler {
        
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
        
		public void handleEvent(Request request);

    }

	/**
     * This interface is used by extending aspects to say what types
     * represent requests. It models the <i>Request</i> role.
     */
    required interface Request { }


	/**
	* Default implementation for handlers
	*/
    public class HandlerImpl implements Handler {
        
		Handler successor;

        tabstract public boolean acceptRequest(Request request);

		tabstract public void handleRequest(Request request);

		public void handleEvent(Request request) {          
            if (acceptRequest(request)) {
                handleRequest(request);
            } else {    
                if (successor == null) {
                    throw new Exceptions.ChainOfResponsibilityException("request unhandled (end of chain reached)\n");
                    // This is one way to deal with unhandled requests.
                } else {
                    successor.handleEvent(request);
                }
            }
        }   
    
        /**
         * Sets the successor of this Handler
          */ 
        public void setSuccessor(Handler successor) {
            this.successor = successor;
        }  
    }
    
    

}