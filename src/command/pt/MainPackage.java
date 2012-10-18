import javax.swing.JFrame; 
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

package MainPackage {
	
	inst Button;
	inst ButtonCommands with CommandInvoker => Button;
	
	class ButtonCommand2 adds implements Command { 
		public boolean isExecutable() {return true;}
		public void executeCommand(CommandReceiver receiver) {
	        ((Printer) receiver).println("ButtonCommand number 2 executed");
	    }     
	}
	
	class Printer adds implements CommandReceiver {}
	
	public class Main extends external JFrame {

	    /**
	     * This example creates a simple GUI with three buttons. Each 
	     * button has a <i>Command</i> associated with it that is executed when 
	     * the button is pressed. Button1 and button3 have the same command, 
	     * button2 has a different one.
	     */

		public static void main(String[] args) {
	    	Button button1 = new Button("Button1");
	    	Button button2 = new Button("Button2");
	    	Button button3 = new Button("Button3"); 

	    	Command com1 = new ButtonCommand();
	    	Command com2 = new ButtonCommand2();

			JPanel pane = new JPanel();
			pane.add(button1);  
			button1.setCommand(com1);

			pane.add(button2);
			button2.setCommand(com2);
			button2.setReceiver(com2, new Printer());
			
			pane.add(button3);
			button3.setCommand(com1);
			
	        JFrame frame = new JFrame("Command Pattern Example");		
			
			frame.getContentPane().add(pane);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {System.exit(0);}
			});  
			frame.pack();
			frame.setVisible(true);	
		}
	}
	
	
	
	
	class Button adds {
		public Button(String label) { super(label); tsuper[Button.Button](label); }
		
		// implement tabstract pointcut from CommandInvoker
		pointcut void commandTrigger() { clicked(); }
		
		void clicked() { }
	}
	
	class MyActionListener adds {
		public MyActionListener(Button b) { tsuper[Button.MyActionListener](b); }
	}
}