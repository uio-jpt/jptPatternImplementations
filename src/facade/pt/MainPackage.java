package MainPacakge {
	
	inst OutputFacade;
	
	
	/**
	 * Implements the driver for the Facade design pattern example.<p> 
	 *
	 * Intent: <i>Provide a unified interface to a set of interfaces in a 
	 * subsystem. Facade defines a higher-level interface that makes the 
	 * subsystem easier to use.</i><p>
	 *
	 * The <i>subsystem</i> consists of three classes that provide low-level
	 * string manipulation and output functionality: <code>RegularScreen</code>,
	 * <code>Decoration</code>, and <code>StringTransformer</code>. The <i>Facade
	 * </i> class <code>OutputFacade</code> procides a higher-level interface
	 * to output strings. This class calls methods on that higer-level interface.
	 *
	 * <p><i>This is the Java version.</i><p>    
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.11, 04/29/04
	 */

	public class Main {

	    /**
	     * Tests the higher-level interface of <code>OutputFacade</code>.
	     * 
	     * @param args Command-line parameters, ignored here
	     */  

	    public static void main(String[] args) {
	        OutputFacade facade = new OutputFacade();

	        System.out.println("Testing Facade...");
	        facade.printDecoration();

	        facade.printNormal("Facade: this is normal printing");
	        facade.printFancy ("Facade: this is fancy  printing");
	    }

	}
	
}