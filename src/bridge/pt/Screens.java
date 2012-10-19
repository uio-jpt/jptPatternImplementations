import java.util.Date;     

template Screens {
		
	inst ScreenImpls;
	
	/**
	 * Represents the <i>Abstraction</i> in the scenario. <code>Screen</code>
	 * provides two methods to draw/print: <code>drawText(String)</code> and
	 * <code>drawTextBox(String)</code>. Both methods call appropriate methods
	 * on the <code>ScreenImplementor</code> of this <code>Screen</code> object.
	 * 
	 * Note that cannot be an interface, since it has implementation 
	 * associated with it (otherwise it would require multiple inheritance). 
	 * This restricts the flexibility of the patter somewhat as all 
	 * <i>RefinedAbstractions</i> consequently can not have additional 
	 * superclasses.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/26/04
	 *
	 */
	public class Screen {

	    /**
	     * stores the actual <i>Implementor</i> to use 
	     */
	    private ScreenImplementation implementor;  

	    /**
	     * Creates a new <code>Screen</code> object given an <i>Implementor</i>
	     *
	     * @param implementor the implementor to use for calls to 
	     * <i>operationImpl()</i>
	     */
	    public Screen(ScreenImplementation implementor) {
	        this.implementor = implementor;
	    }

	    /**
	     * Draws or prints a text to an output device determined by the 
	     * current <i>Implementor</i>.
	     *
	     * @param text The text to be drawn/printed
	     */
	    public void drawText(String text) {
	        implementor.printText(text);
	        implementor.printLine();
	    }

	    /**
	     * Draws or prints a text in a box to an output device determined 
	     * by the current <i>Implementor</i>.
	     *
	     * @param text The text to be drawn/printed
	     */
	    public void drawTextBox(String text) {

	        int length = text.length();

	        for(int i=0; i<length+4; i++) {
	            implementor.printDecor();
	        }

	        implementor.printLine();
	        implementor.printDecor();
	        implementor.printText(" "+text+" ");
	        implementor.printDecor();
	        implementor.printLine();

	        for(int i=0; i<length+4; i++) {
	            implementor.printDecor();
	        }

	        implementor.printLine(); 
	    }
	}
	
	/** 
	 * Prints/draws a greeting in a text box. Represents a <i>RefinedAbstraction
	 * </i> in the context of the Bridge design pattern.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/26/04
	 *
	 */
	public class GreetingScreen extends Screen {
	    /** 
	     * Creates a new <code>GreetingScreen</code> object with the provided
	     * <i>Implementor</i>.
	     *
	     * @param si the implementor to use
	     */       
	    assumed GreetingScreen(ScreenImplementation si); //  { 	        super(si);   }

	    /**
	     * Draws/prints a greeting in a text box
	     */
	    public void drawGreeting() {
	        drawTextBox("Greetings!");
	    }
	}
	
	/** 
	 * Prints/draws the current system time in a text box. Represents a 
	 * <i>RefinedAbstraction</i> in the context of the Bridge design pattern.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/26/04
	 *
	 */



	public class InformationScreen extends Screen { 

	    /** 
	     * Creates a new <code>InformationScreen</code> object with the provided
	     * <i>Implementor</i>.
	     *
	     * @param si the implementor to use
	     */       
	    assumed InformationScreen(ScreenImplementation si); // {       super(si);	    }

	    /**
	     * Draws/prints the system time in a text box
	     */
	    public void drawInfo() {  
	        Date date = new Date();
	        drawTextBox("Current system time: "+date);
	    }
	}
}