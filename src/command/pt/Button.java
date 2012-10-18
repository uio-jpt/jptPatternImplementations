import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


template Button {

	/**
	 * Implements a simple extension of JButton that supplies its own 
	 * ActionListener and calls its own <code>clicked()</code> method
	 * whenever the button is pressed.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/06/04
	 * 
	 */

	public class Button extends external javax.swing.JButton {

	    /**
	     * Creates a new button with the provided label
	     *
	     * @param name the label of the button
	     */

		public Button(String label) {
			this.setActionCommand(label);
			this.addActionListener(new MyActionListener(this));
		}

	    /**
	     * Stub method that is called whenever the button is pressed.
	     */

		tabstract void clicked();
	}
	
	// Made because of compiler limitation in the implemented version of PT
	// Without this restriction, an anonymous subclass would have been created instead
	class MyActionListener implements ActionListener {
		Button button;
		
		assumed MyActionListener(Button b);
		public MyActionListener(Button b) { button = b; }
		
		public void actionPerformed(ActionEvent e) {
			button.clicked(); 
		}
	}
}