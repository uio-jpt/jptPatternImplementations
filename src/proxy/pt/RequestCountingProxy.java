template RequestCountingProxy {
	
	inst RequestBlockingProxy with RequestBlocker => RequestCounter;
	
	class RequestCounter adds { 

		/**
		 * An internal counter for the number of calls to <code>
		 * print(String)</code>.
		 */
		private int regularRequests = 0;


	    /**
	     * Not needed in PT:
		 * Forwards the request to its subject. We are not interested in
		 * this kind of request, but must implement the method (and the 
		 * request forwarding) anyway since the method is part of the 
		 * <code>RequestBlocker</code> interface.
	     *
	     * @param s the string to print
	     */
		// public void safeRequest(String s) {
		// 	realSubject.safeRequest(s);                                                
		// 	System.out.println("[RequestCounter:] Not interested in safe " +
		// 		"requests, but must implement anyway");		
		// }

		/**
	     * Forwards the request to its subject and prints 
	     * out how many times the <i>request()</i> has been called so far. 
		 *
		 * @param s the string to print
		 */
		public void regularRequest(String s) {
			regularRequests++;
			tsuper[RequestBlockingProxy.RequestBlocker].regularRequest(s);                                                
			System.out.println("[RequestCounter:] That was regular request nr. " +
				regularRequests);		
		}

		/**
		 * Not needed in PT:
		 * Forwards the request to its subject. We are not interested in
		 * this kind of request, but must implement the method (and the 
		 * request forwarding) anyway since the method is part of the 
		 * <code>RequestBlocker</code> interface.
		 *
		 * @param s the string to print
		 */
		// public void unsafeRequest(String s) {
		// 	realSubject.unsafeRequest(s);                                                
		// 	System.out.println("[RequestCounter:] Not interested in unsafe requests," +
		// 		" but must implement anyway");		
		// }

	}
}