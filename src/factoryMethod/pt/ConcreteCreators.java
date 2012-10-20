import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 * Implements a <i>ConcreteCreator</i> that creates buttons.
 *
 * @author  Jan Hannemann
 * @author  Gregor Kiczales
 * @version 1.1, 02/11/04
 * 
 */
template ConcreteCreators {
	
	inst CreatorImplementation with GUIComponentCreatorImpl => ButtonCreator, MyWA => MyWAButton;
	inst CreatorImplementation with GUIComponentCreatorImpl => LabelCreator, MyWA => MyWALabel;
	
	class ButtonCreator adds {

	    /**
	     * Factory method that creates a button with label and <code>
	     * ActionListener</code>.
	     *
	     * @returns the created button
	     */

	    public JComponent createComponent() {
	        final JButton button = new JButton("Click me!");
	        button.addActionListener(new myActionListener(button));
	        return button;            
	    }

	    /**
	     * Returns a title explaining this example.
	     *
	     * @returns the title for the GUI frame
	     */

	    public String getTitle() {
	        return "Example 1: A JButton";
	    }
	}
	
	class myActionListener implements ActionListener {
		assumed myActionListener(JButton b);
		public myActionListener(JButton b) { this.b = b; }
		private JButton b;				
		public void actionPerformed(ActionEvent e) {
			b.setText("Thank you!");
		}
		
	}
	
	
	/**
	 * Implements a <i>ConcreteCreator</i> that creates labels.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 * 
	 * @see ButtonCreator
	 */ 

	class LabelCreator adds {

	    /**
	     * Factory method that creates a label
	     *
	     * @returns the created label
	     */

	    public JComponent createComponent() {
	        JLabel label = new JLabel("This is a JLabel.");
	        return label;            
	    }

	    /**
	     * Returns a title explaining this example.
	     *
	     * @returns the title for the GUI frame
	     */

	    public String getTitle() {
	        return "Example 2: A JLabel";
	    }
	}		
	
}