package MainPackage {
	
	inst ConcreteCreators;
	
	/**
	 * Implements the driver for the FactoryMethod design pattern example.<p> 
	 *
	 * Intent: <i>Define an interface for creating an object, but let subclasses 
	 * decide which class to instantiate. Factory Method lets a class defer 
	 * instantiation to subclasses.</i><p>
	 *
	 * Participating objects are <code>ButtonCreator</code> and 
	 * <code>LabelCreator</code> as <i>ConcreteCreator</i>s. Both implement
	 * the <code>GUIComponentCreator</code> interface.<p>
	 *
	 * In this example, the factory method <code>createComponent</code> creates
	 * A JComponent (a button and a label, respectively). The <i>anOperation()</i>
	 * method <code>showFrame()</code> uses the factory method to show a little
	 * GUI. In one case, the created frame contains a button, in the other a
	 * simple label.
	 *
	 * <p><i>This is the Java version.</i><p>
	 *
	 * Since the <i>anOperation()</i> method requires an implementation, <i>
	 * GUIComponentCreator</i> has to be an abstract class (as opposed to an 
	 * interface). Consequently, all <i>ConcreteCreator</i>s have to be 
	 * subclasses of that class and cannot belong to a different inheritance 
	 * hierarchy.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 * 
	 * @see GUIComponentCreator
	 * @see ButtonCreator
	 * @see LabelCreator
	 */

	public class Main {

	    /**
	     * Implements the driver for the FactoryMethod design pattern example.<p> 
	     *
	     * In this example, the factory method <code>createComponent</code> 
	     * creates a JComponent (a button and a label, repsectively). The 
	     * <i>anOperation()</i> method <code>showFrame()</code> uses the factory 
	     * methods to show a little GUI. In one case, the created frame contains 
	     * a button, in the other a simple label.
	     */    

	    public static void main(String[] args) {

	        Creator.GUIComponentCreator creator1 = new ButtonCreator();
	        Creator.GUIComponentCreator creator2 = new LabelCreator();

	        creator1.showFrame();
	        creator2.showFrame();
	    }
	}
	
	
	class myActionListener adds {
		public myActionListener(JButton b) { super(); tsuper[ConcreteCreators.myActionListener](b); }
	}
	
	class MyWAButton adds {
		public MyWAButton() { super(); }
	}

	class MyWALabel adds {
		public MyWALabel() { super(); }
	}
	
	
}