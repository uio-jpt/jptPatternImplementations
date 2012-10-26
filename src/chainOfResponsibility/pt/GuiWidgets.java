import javax.swing.*;
import java.awt.event.*;


template GuiWidgets {
    
    public class Button extends external JButton { 

        /** 
         * Creates a Button widget. An ActionListener is also added that calls
         * the <code>doClick(Click)</code> method when the button is pressed
         *
         * @param label the button label  
         */    
        public Button(String label) {
            this.addActionListener(new MyActionListener(this));
        }
        
        /** 
         * An empty method that is called when the button is clicked. This method
         * could also be defined in the concrete aspect.
         *
         * @param click the <code>Click</code> that was created when the 
         * button was clicked.  
         */    
        tabstract void doClick(Click click);
    
    }
    
    // Necessary due to compiler limitations; would have used anonymous class
    // if compiler support was implemented
    public class MyActionListener implements ActionListener {
        Button button;
        
        assumed MyActionListener(Button b);
        public MyActionListener(Button b) {
            button = b;
        }
        
        public void actionPerformed(ActionEvent ae) {
            button.doClick(new Click(ae));
        }
    }
    
    
    /** 
     * Represents a regular GUI frame. No pattern-specific modifications are
     * needed here. A WindowListener is added.
     *
     * @author  Jan Hannemann
     * @author  Gregor Kiczales
     * @version 1.1, 01/27/04
     *
     */
    public class Frame extends external JFrame {

        /** 
         * Creates a <code>Frame</code> with a given title that responds 
         * properly to <code>WindowClosing<code> events 
         *
         * @param title the frame title
         */  
        public Frame(String title) {
            this.addWindowListener(new MyWindowAdapter());
        }  
    }
    
    public class MyWindowAdapter extends external WindowAdapter {
        assumed MyWindowAdapter();
        
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }       
    }
    
    
    /** 
     * A regular GUI JPanel with no modifications
     *
     * @author  Jan Hannemann
     * @author  Gregor Kiczales
     * @version 1.1, 01/27/04
     *
     */
    public class Panel extends external JPanel {}
    
    

    /** 
     * Represents the <i>Request</i> in the <i>Chain of Responsibility</i>
     * pattern, which is a button click in this case. Provides methods for
     * accessing key masks associated with the click (to find out whether
     * the SHIFT, ALT, or CTRL keys were pressed during the click). 
     *
     * @author  Jan Hannemann
     * @author  Gregor Kiczales
     * @version 1.1, 01/27/04
     *
     */

    public class Click { 

        /**
         * the ActionEvent that describes this Click
         */
        protected ActionEvent description;

        /** 
         * Creates a <code>Click</code> described by the provided <code>
         * ActionEvent</code>. 
         *
         * @param description the ActionEvent that describes this Click
         */  
        assumed Click(ActionEvent description);
        public Click(ActionEvent description) {
            this.description = description; 
        }      

        /** 
         * Convenience method for inquiring whether SHIFT was pressed while
         * the click occured. 
         * 
         * @return whether the SHIFT key was pressed when the click occured
         */  
        public boolean hasShiftMask() {
            return ((description.getModifiers() & ActionEvent.SHIFT_MASK) != 0 );
        }

        /** 
         * Convenience method for inquiring whether ALT was pressed while
         * the click occured. 
         * 
         * @return whether the ALT key was pressed when the click occured
         */  
        public boolean hasAltMask() {
            return ((description.getModifiers() & ActionEvent.ALT_MASK) != 0 );
        }

        /** 
         * Convenience method for inquiring whether CTRL was pressed while
         * the click occured. 
         * 
         * @return whether the CTRL key was pressed when the click occured
         */  
        public boolean hasCtrlMask() {
            return ((description.getModifiers() & ActionEvent.CTRL_MASK) != 0 );
        }

    }
}