template ScreenImpls {
	
	/** 
	 * Declares methods to print lines, decorators and text. Represents an 
	 * <i>Implementor</i> in the context of the Bridge design pattern.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/26/04
	 *
	 */
	public interface ScreenImplementation {

        /**
         * Prints a line feed.
         */
        void printLine();

        /** 
         * Prints a decorator symbol (a string of length 1).
         */
        void printDecor();

        /**
         * Prints the argument text.
         *
         * @param text the text to print
         */
        void printText(String text); 
	}
	
	/** 
	 * Prints capitalized text and uses double crosses ("#") to decorate. 
	 * Represents a <i>ConcreteImplementation</i> in the context of the Bridge 
	 * design pattern.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/26/04
	 *
	 */

	public class CrossCapitalImplementation implements ScreenImplementation {
       	/**
         * Does a line feed (to <code>System.out</code>).
         */
        public void printLine() {
            System.out.println();
        }

        /** 
         * Prints a double cross ("#") to <code>System.out</code>.
         */
        public void printDecor() {
            System.out.print("X");
        }

        /**
         * Prints the argument text in capitals to <code>System.out</code>.
         *
         * @param text the text to print
         */
        public void printText(String text) {
            System.out.print(text.toUpperCase());
        }
	}
	
	/** 
	 * Prints regular text and uses stars ("*") to decorate. Represents a 
	 * <i>ConcreteImplementation</i> in the context of the Bridge design pattern.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/26/04
	 *
	 */

	public class StarImplementation implements ScreenImplementation {

        /**
         * Does a line feed (to <code>System.out</code>).
         */
        public void printLine() {
            System.out.println();
        }

        /** 
         * Prints a star ("*") to <code>System.out</code>.
         */
        public void printDecor() {
            System.out.print("*");
        }

        /**
         * Prints the argument text to <code>System.out</code>.
         *
         * @param text the text to print
         */
        public void printText(String text) {
            System.out.print(text);
        }
	}
}