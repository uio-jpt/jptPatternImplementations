package MediatorImplementation {

	inst GuiLib;	
	inst MediatorImplementation with Colleague => Button, Mediator => Label;
 

	class Button adds {
		
		/**
	     * Defines what changes on Colleagues cause their <i>Mediator</i> to be 
	     * notified (here: Button clicks)
	     *
	     * @param cs the colleague on which the change occured
	     */

		protected pointcut void change() { call(clicked); }

	    /**
	      * Defines how the <i>Mediator</i> is to be updated when a change
	      * to a <i>Colleague</i> occurs. Here, the label's text is set 
	      * depending on which button was clicked. The appropriate button's label 
	      * is also updated.
	      *
	      * @param c the colleague on which a change of interest occured
	      * @param m the mediator to be notifed of the change  
	      */

		protected void notifyMediator(Label l) {
			if (this == Main.button1) {
				label.setText("Button1 clicked"); 
			} else if (this == Main.button2) {
				label.setText("Button2 clicked");
			}
			button.setText("(Done)");
		}
	}
	
	public class Main {


	    static JFrame frame   = new JFrame("Mediator Demo"); 
	    static Button button1 = new Button("Button1");
	    static Button button2 = new Button("Button2");
	    static Label  label   = new Label ("Click a button!");

	    /**
	     * Implements the driver for the mediator example. It creates a small
	     * GUI with a label and two buttons. The buttons are <i>Colleague</i>s,
	     * the label is the <i>Mediator</i>. 
	     *
	     * Each button click causes the mediator to update itself and the
	     * calling button.
	     */ 

		public static void main(String[] args) {;


			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {System.exit(0);}
			});

			JPanel panel = new JPanel();

			panel.add(label);
			panel.add(button1);
			panel.add(button2); 

			frame.getContentPane().add(panel);
			frame.pack();
			frame.setVisible(true);  

		    button1.setMediator(label);    
		    button2.setMediator(label);    
		}
	}
}