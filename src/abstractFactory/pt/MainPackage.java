import javax.swing.*; 
import java.awt.event.*;

package MainPackage {
	
	inst Factories;
	
	/**
	 * Sets up and displays a new GUI given a concrete factory.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 01/20/04
	 * 
	 */
	public class Display extends external JFrame  { 

	    /**
	     * Sets up the frame with a label and a button created by the respective
	     * concrete factories. Both button and frame receive their appropriate 
	     * listeners to close the frame when either the button is clicked or
	     * the frame is closing.
	     *
	     * @param factory the factory to create GUI elements
	     */ 

		public Display(ComponentFactory factory) {
			super("New GUI"); 
			JLabel label = factory.createLabel(); 
			JButton button = factory.createButton("OK");
			button.addActionListener(new myActionListener(this));
			JPanel panel = new JPanel();
			panel.add(label);
			panel.add(button);
			this.getContentPane().add(panel);
			this.pack();
			this.setVisible(true); 
			this.addWindowListener(new myWindowListener(this));
		}
	}
	
	
	/**
	 * Adds a window listener that closes the frame on demand 
	 */
	class myWindowListener extends external WindowAdapter {

		Display display = null;

		protected myWindowListener(Display display) {
			super();
			this.display = display;   
		}

		public void windowClosing(WindowEvent e) {
			display.setVisible(false);
		}
	}

	/**
	 * Adds a button listener that closes the frame on demand 
	 */
	class myActionListener implements ActionListener {

	    Display display;

	    protected myActionListener(Display display) {
	        super();
	        this.display = display;
	    }

	    public void actionPerformed(ActionEvent e) { 
			display.setVisible(false);
		}
	}
	
	/**
	 * Implements the driver for the Abstract Factory design pattern example.<p>
	 * 
	 * Intent: <i>Provide an interface for creating families of related or 
	 * dependent objects without specifying their concrete classes.</i><p>
	 *
	 * As an example scenario, our abstract factory interface defines two
	 * factory methods <code>createLabel()</code> and <code>createButton()</code>
	 * that create related products (Swing GUI elements). 
	 *
	 * The driver is a swing GUI that allows the user to choose between the two 
	 * concrete factories <code>RegularFactory</code> and <code>FramedFactory
	 * </code>, and creates a new GUI with elements from the respective factory.
	 * <p>
	 * 
	 * <code>RegularFactory</code> creates standard Swing GUI elements, while
	 * <code>FramedFactory</code> produces elements which are framed.
	 *
	 * <P><i>This is the Java implementation. </i><p>
	 *
	 * We decided to implement <code>AbstractFactory</code> as an interace,
	 * not an abstract class. This has the following advantages and liabilities:
	 * <UL>
	 *   <LI> Concrete factories do not need to be subclasses of the abstract
	 *        factory. That way existing classes can be subclassed and just have
	 *        to implement the interface methods. This can be more flexible if
	 *        we want an existing class to become a factory (e.g. because we
	 *        want to make use of its functionality.
	 *   <LI> By defining the abstract factory as an interface we cannot attach
	 *        any (default) implementations to its methods, nor is it possible 
	 *        to include fields (such as the <code>name</code> field in this
	 *        example.
	 * </UL>
	 * 
	 */

	public class Main 
	{
		/**
		 * a concrete factory that creates regular GUI components
		 */

		private static ComponentFactory factory1 = new RegularFactory();

		/**
		 * a concrete factory that creates framed GUI components
		 */

		private static ComponentFactory factory2 = new FramedFactory();

	    /**
	     * stores the currently selected factory
	     */

		private static ComponentFactory factory = factory1;


	    /**
	     * Creates the initial GUI that allows the user to choose a factory
	     * and generate a new GUI with the elements that the respective
	     * factory provides.
	     *
	     * @return a <code>JPanel</code> containing the GUI
	     */

		private static JPanel createGUI()
		{
			ActionListener radioListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("factory1")) factory = factory1;
					else factory = factory2;
				}
			};

			JPanel panel = new JPanel();
			JRadioButton factoryButton1 = new JRadioButton("use Factory 1"); 
			JRadioButton factoryButton2 = new JRadioButton("use Factory 2");
			factoryButton1.setActionCommand("factory1");
			factoryButton2.setActionCommand("factory2");		
			factoryButton1.addActionListener(radioListener);
			factoryButton2.addActionListener(radioListener);		
			JButton create = new JButton("Create GUI");

			ButtonGroup choices = new ButtonGroup();

			choices.add(factoryButton1);
			choices.add(factoryButton2);

			create.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					Display display = new Display(factory);
				}
			});

			panel.add(factoryButton1);
			panel.add(factoryButton2);
			panel.add(create);

			return panel;
		}

	    /**
	     * Implements the driver for this design pattern example. It sets up
	     * the initial GUI.
	     */				

		public static void main(String[] args)
		{
			JFrame frame = new JFrame("Abstract Factory Demo");
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {System.exit(0);}
			});  

			frame.getContentPane().add(createGUI());

			frame.pack();
			frame.setVisible(true);
		}
	}
	
}