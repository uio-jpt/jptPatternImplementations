package MainPackage {
	
	inst ConcreteCreators;


	/**
	 * Implements the driver for the Builder design pattern example.<p> 
	 *
	 * Intent: <i>Separate the construction of a complex object from its 
	 * representation so that the same construction process can create different 
	 * representations</i><p>
	 *
	 * Participating objects are <code>TextCreator</code> and 
	 * <code>XMLCreator</code> as <i>Builder</i>s that implement the
	 * <code>Creator</code> interface.<p>
	 *
	 * In this example, <code>Main</code> acts as the <i>Director</i> that
	 * uses two different builders to build string representations of a
	 * person. <code>TextCreator</code> creates a text-like representation,
	 * <code>XMLCreator</code> an XML-like one.
	 *
	 * <p><i>This is the AspectJ version.</i><p>  
	 *
	 * The abstract class is now replaced by an interface. A concrete aspect
	 * declares the instance variable and default method implementations. 
	 * This frees the participants (<i>ConcreteBuilder</i>s) to be 
	 * subclasses of something else.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/26/04
	 * 
	 * @see Builder
	 * @see TextCreator
	 * @see XMLCreator
	 */

	public class Main {

	    /** 
	     * Builds a string representation of a person using a given builder.
	     *
	     * @param the builder to use.
	     */

	    protected static void build(CreatorInterface.Creator builder) {
	        builder.processType("Person");
	        builder.processAttribute("Name");
	        builder.processValue("James Brick");
	        builder.processAttribute("Age");
	        builder.processValue("33");
	        builder.processAttribute("Occupation");
	        builder.processValue("Builder"); 
	    }

	    /**
	     * Implements the driver for the Builder design pattern example.<p> 
	     *
	     * In this example, <code>Main</code> acts as the <i>Director</i> that
	     * uses two different builders to build string representations of a
	     * person. <code>TextCreator</code> creates a text-like representation,
	     * <code>XMLCreator</code> an XML-like one.
	     * 
	     * @param args the command-line parameters, unused.
	     */

	    public static void main(String[] args) {

	        CreatorInterface.Creator builder1 = new TextCreator();
	        CreatorInterface.Creator builder2 = new XMLCreator();

	        build(builder1);
	        build(builder2);

	        System.out.println(builder1.getRepresentation());
	        System.out.println(builder2.getRepresentation());
	    }
	}
}