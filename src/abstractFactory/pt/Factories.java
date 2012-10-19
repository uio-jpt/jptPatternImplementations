import javax.swing.*; 
import javax.swing.border.*;
import java.awt.event.*;


template Factories {
	
	/**
	 * Defines the interface for creating products. The only factory methods are
	 * <code>createLabel()</code> and <code>createButton(..)</code>.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/20/04
	 * 
	 */
	public interface ComponentFactory {

	    /**
	     * Creates factory-specific <code>JLabel</code> products. 
	     *
	     * @return the factory-specific <code>JLabel</code>
	     */

		public JLabel createLabel(); 

	    /**
	     * Creates factory-specific <code>JButton</code> products. 
	     *
	     * @return the factory-specific <code>JButton</code>
	     */

		public JButton createButton(String label); 


	    /** 	
	     * Returns the name of the factory.
	     *
	     * @return the name of the factory
	     */

		public String getName();
	}
	
	
	/**
	 * This <i>Concrete Factory</i> implements the 
	 * <code>ComponentFactory</code> interface to provide 
	 * framed Swing GUI components.
	 * 
	 * @author Jan Hannemann
	 * @author Gregor Kiczales
	 * @version 1.1, 01/20/04
	 *
	 */
	public class FramedFactory implements ComponentFactory {

		/**
		 * Factory method to create framed <code>JLabel</code> objects. 
		 *
		 * @return the framed <code>JLabel</code>
		 */
		public JLabel createLabel() {
			JLabel label = new JLabel("This Label was created by " +getName());
			Border raisedbevel = BorderFactory.createRaisedBevelBorder();
			Border loweredbevel = BorderFactory.createLoweredBevelBorder();
			label.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

			return label;
		} 

		/**
		 * Factory method to create framed <code>JButton</code> objects. 
		 *
		 * @param  the label for the new <code>JButton</code>
		 * @return the framed <code>JButton</code>
		 */
	     public JButton createButton(String label) {
			JButton button = new JButton(label);
			Border raisedbevel = BorderFactory.createRaisedBevelBorder();
			Border loweredbevel = BorderFactory.createLoweredBevelBorder();
			button.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
			return button;
		}	

	    /** 	
	     * Returns the name of the factory.
	     *
	     * @return the name of the factory
	     */
 		public String getName() {
			return "Framed Factory";
		} 
	}
	
	/**
	 * This <i>Concrete Factory</i> implements the <code>ComponentFactory</code> 
	 * interface to provide regular Swing GUI components.
	 * 
	 * @author Jan Hannemann
	 * @author Gregor Kiczales
	 * @version 1.1, 01/20/04
	 *
	 */
	public class RegularFactory implements ComponentFactory {

		/**
		 * Factroy method to create regular <code>JLabel</code> objects. 
		 *
		 * @return the regular <code>JLabel</code>
		 */

		public JLabel createLabel() {
			return new JLabel("This Label was created by " +getName());
		}

		/**
		 * Factory method to create regular <code>JButton</code> objects. 
		 *
		 * @param  the label for the new <code>JButton</code>
		 * @return the regular <code>JButton</code>
		 */

		public JButton createButton(String label) {
			return new JButton(label);
		}
	    /** 	
	     * Returns the name of the factory.
	     *
	     * @return the name of the factory
	     */

	 	public String getName() {
			return ("Regular Factory");
		} 
	}
	
}