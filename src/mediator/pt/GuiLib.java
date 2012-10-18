import javax.swing.*;

template GuiLib {
	
	public class Button extends JButton {

	    /**
	     * Creates a new <code>Button</code> object with the provided label.
	     *
	     * @param name the label for the new <code>Button</code> object 
	     */

	 	public Button(String name) {
			super(name);
			this.setActionCommand(name);
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clicked(); 
				}
			}); 
		}

		public void clicked() {}  
	}
	
	public class Label extends JLabel {

	    /**
	     * Creates a new <code>Label</code> object with the provided name.
	     *
	     * @param s the tag for the new <code>Label</code> object 
	     */

		public Label(String s) {
			super(s);
		}
	}
}