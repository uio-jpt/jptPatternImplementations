package Exceptions {
    
    /**
     * Implements an exception that occurs if an a request reaches the 
     * end of a <i>Chain of Responsibility</i> but remains unhandled. 
     */
    public class ChainOfResponsibilityException extends RuntimeException {  
    
        /**
         * Creates a ChainOfResponsibilityException
         *
         * @param s the error message 
         */
      public ChainOfResponsibilityException(String s) {
            super(s);
        }
    }
}