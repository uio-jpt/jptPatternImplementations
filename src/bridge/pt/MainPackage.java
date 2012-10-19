package MainPackage {
	
	inst Screens;
	
	/**
	 * Implements the driver for the Bridge design pattern example. <p> 
	 *
	 * Intent: <i> Decouple an abstraction from its implementation so that the 
	 * two can vary independently.</i><p>
	 *
	 * Scenario: Have seperate hierarchies for Abstractions (here: Screens)
	 *           and Implementors (here: ScreenImplementation), so that both 
	 *           can change independently of each other 
	 *
	 * Participants: <UL>
	 *
	 * <LI> <code>Screen</code> - <i>Abstraction</i> that defines 
	 *      an interface for printing text and boxedText to System.out. 
	 * <LI> <code>GreetingScreen</code> - <i>RefinedAbstraction</i> that prints
	 *      a boxed greeting message
	 * <LI> <code>InformationScreen</code> - <i>RefinedAbstraction</i> that prints
	 *      the system time (boxed)
	 * <LI> <code>ScreenImplementation</code> - <i>Implementor</i> interface, 
	 *      defines basic operations to output formatted strings
	 * <LI> <code>StarImplementation</code> - <i>ConcreteImplementation</i> that 
	 *      creates textBoxes of stars
	 * <LI> <code>CrossCapitalImplementation</code> - <i>ConcreteImplementation
	 *      </i> that creates textBoxes of double crosses (hashes) and prints all
	 *      text capitalized
	 * </UL><p>
	 *
	 * <i>This is the Java implementation.</i><p>
	 *
	 * Note that <i>Abstraction</i> cannot be an interface in Java, as we need to
	 * specify how <i>operation()</i> is performed using the interface of 
	 * <i>Implementor</i>. As <i>Abstraction</i> is not necessarily a defining 
	 * role, this is a limitation. With multiple inheritance, this would not be
	 * the case.
	 *
	 * @author Jan Hannemann
	 * @author Gregor Kiczales
	 * @version 1.1, 01/26/04
	 */

	public class Main {

	    /**
	     * Implements the driver for this example. The two different screens
	     * and screen implementations are tested in all possible combinations.
	     *
	     * @param args required by Java, but ignored
	     */
	    public static void main(String[] args) { 

	        System.out.println("Creating implementations...");

	        ScreenImplementation i1 = new StarImplementation();
	        ScreenImplementation i2 = new CrossCapitalImplementation();

	        System.out.println("Creating abstraction (screens) / implementation combinations...");

	        GreetingScreen gs1 = new GreetingScreen(i1);
	        GreetingScreen gs2 = new GreetingScreen(i2);
	        InformationScreen is1 = new InformationScreen(i1);
	        InformationScreen is2 = new InformationScreen(i2);  

	        System.out.println("Starting test:\n");

	        gs1.drawText("\nScreen 1 (Refined Abstraction 1, Implementation 1):");
	        gs1.drawGreeting();

	        gs2.drawText("\nScreen 2 (Refined Abstraction 1, Implementation 2):");
	        gs2.drawGreeting();

	        is1.drawText("\nScreen 3 (Refined Abstraction 2, Implementation 1):");
	        is1.drawInfo();

	        is2.drawText("\nScreen 4 (Refined Abstraction 2, Implementation 2):");
	        is2.drawInfo();
	    }
	}
	
	class InformationScreen adds {
		 public InformationScreen(ScreenImplementation si) { super(si); }
	}
	
	class GreetingScreen adds {
		 public GreetingScreen(ScreenImplementation si) { super(si); }
	}
	
}