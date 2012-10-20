import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent; 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;  
import java.awt.Point;

template CreatorImplementation {

	/**
	 * Defines the <i>GUIComponentCreator</i> interface with the 
	 * <i>factoryMethod()</i> method signature and the <i>anOperation()</i> 
	 * method that uses it. For details, see GoF, page 108.<p> 
	 *
	 * The factory method is <code>createComponent</code> and it creates
	 * A JComponent (a button or a label, in this case). The <i>anOperation()</i>
	 * method <code>showFrame()</code> uses the factory method to show a small
	 * GUI. 
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 * 
	 * @see ButtonCreator
	 * @see LabelCreator
	 */ 
	public class GUIComponentCreatorImpl implements Creator.GUIComponentCreator {

	    /**
	     * The factory method to be concretized by subclasses.
	     *
	     * @returns the created <i>ConcreteProduct</i>
	     */

	    public tabstract JComponent createComponent(); 

	    /**
	     * Another factory method to create a title for the GUI frame created
	     * by this class.
	     *
	     * @returns the title for the GUI frame
	     */

	    public tabstract String getTitle(); 

	    /** 
	     * the position for the next frame to be created (on the screen). This
	     * variable is used to make sure new frames appear staggered and don't 
	     * entirely overlap with existing frames.
	     */

	    private static Point lastFrameLocation = new Point(0, 0);

	    /** 
	     * Creates a <code>JFrame</code>, puts the <code>JComponent</code> that
	     * is created by the factory method into it and displays the frame. This
	     * Method also provides a <code>WindowListener</code>. 
	     */

	    public final void showFrame() {
	        JFrame frame = new JFrame(getTitle());

	   		frame.addWindowListener(new MyWA());

			JPanel panel = new JPanel();

			panel.add(createComponent());

			frame.getContentPane().add(panel);
			frame.pack();    
			frame.setLocation(lastFrameLocation);
			lastFrameLocation.translate(75, 75);
			frame.setVisible(true);  
	    }
	}
	
	class MyWA extends external WindowAdapter {
		assumed MyWA();
		public MyWA() { }
		public void windowClosing(WindowEvent e) {System.exit(0);}
	}
}