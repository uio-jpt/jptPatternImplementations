template RequestBlockingProxy {
	
	inst RealSubject with OutputImplementation => RequestBlocker;
	
	class RequestBlocker adds { 

	
	    /**
		 * Not necessary in PT:
		 * Forwards the request to its subject. We are not interested in
		 * this kind of request, but must implement the method (and the 
		 * request forwarding) anyway since the method is part of the 
		 * <code>RequestBlocker</code> interface.
	     *
	     * @param s the string to print
	     */
		// public void safeRequest(String s) {
		// 	realSubject.safeRequest(s);                                                
		// 	System.out.println("[RequestBlocker:] Not interested in safe requests," +
		// 		" but must implement anyway");		
		// }

		/**
		 * Not necessary in PT:
		 * Forwards the request to its subject. We are not interested in
		 * this kind of request, but must implement the method (and the 
		 * request forwarding) anyway since the method is part of the 
		 * <code>RequestBlocker</code> interface.
		 *
		 * @param s the string to print
		 */
		// public void regularRequest(String s) {
		// 	realSubject.regularRequest(s);                                                
		// 	System.out.println("[RequestBlocker:] Not interested in regular requests," +
		// 		" but must implement anyway");		
		// }

		/**
		 * Blocks unsafe requests.
		 *
		 * @param s the string to print
		 */
		public void unsafeRequest(String s) {
			System.out.println("[RequestBlocker:] " + s + " blocked.");		
		}
	}
}