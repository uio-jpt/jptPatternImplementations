package MainPackage {
    
    inst GuiWidgets;
    inst ChainOfResponsibilityProtocolPT with HandlerImpl => Button;
    inst ChainOfResponsibilityProtocolPT with HandlerImpl => Panel;
    inst ChainOfResponsibilityProtocolPT with HandlerImpl => Frame;
    
    
    public class Main {
    
        /**
         * Implements a GUI-motivated example for the Chain Of Responsibility design
         * pattern.<p> 
         *
         * In this implementation, the request is handled by the panel if the 
         * CTRL mask is active (i.e., if the CTRL key was pressed while the button 
         * was clicked). If the SHIFT mask is active, the frame handles the request.
         * Otherwise, the request is unhandled.      
         *
         * @param args command line parameters, unused
         */
    
        public static void main(String[] args) {
            Frame  frame  = new Frame("Chain of Responsibility pattern example");
            Panel  panel  = new Panel();
            Button button = new Button("Click me to see the pattern in action! Use <SHIFT>, <CTRL>, and <ALT> during clicks to see different behavior"); 
    
            button.setSuccessor(panel);
            panel.setSuccessor(frame);
    
            frame.getContentPane().add(panel);
            panel.add(button);
    
            frame.pack();
            frame.setVisible(true);  
        }
    }
            
    class Button adds {
        public Button(String label) {
            super(label);
            tsuper[GuiWidgets.Button](label);
        }
        
        public void doClick(Click click) {
             handleEvent(click);
        }
        
        public boolean acceptRequest(Request request) {
            System.out.println("Button is asked to accept the request...");
            if (request instanceof Click) {
                Click click = (Click) request;
                return (click.hasShiftMask());
            } 
            return false;
        } 
                
        public void handleRequest(Request request) {
            System.out.println("Button is handling the event.\n");
        }   
    }
    
    class Panel adds {
        public boolean acceptRequest(Request request) { 
            System.out.println("Panel is asked to accept the request...");
            if (request instanceof Click) {
                Click click = (Click) request;
                return (click.hasCtrlMask());
            } 
            return false;
        } 
    
        public void handleRequest(Request event) {
            System.out.println("Panel is handling the event.\n");
        }
        
    }
    
    class Frame adds {
        public Frame(String title) {
            super(title);
            tsuper[GuiWidgets.Frame](title);
        }
        
        public boolean acceptRequest(Request request) { 
            System.out.println("Frame is asked to accept the request...");
            if (request instanceof Click) {
                Click click = (Click) request;
                return (click.hasAltMask());
            } 
            return false;
        } 
            
        public void handleRequest(Request event) {
            System.out.println("Frame is handling the event.\n");
        }
    }
    
    class Click adds implements Request {
        public Click(ActionEvent description) {
            tsuper[GuiWidgets.Click](description);
        }
    }
    
    // Only necessary due to a current limitation in the compiler w.r.t. anonymous inner classes
    class MyActionListener adds {
        public MyActionListener(Button b) {
            tsuper[GuiWidgets.MyActionListener](b);
        }
    }
    
    // Only necessary due to a current limitation in the compiler w.r.t. anonymous inner classes    
    class MyWindowAdapter adds {
        public MyWindowAdapter() {}
    }
}