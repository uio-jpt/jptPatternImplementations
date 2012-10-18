template ButtonCommands {
	
	inst CommandProtocolPT;
	
	public class ButtonCommand implements Command { 

	    private Printer printer = new Printer();

	    /**
	     * Implements a sample command. This one prints a short message to 
	     * <code>System.out</code> whenever it executes. The message is
	     * <quote>"ButtonCommand executed"</quote>. 
	     */              

		public void executeCommand(CommandReceiver receiver ) {
			printer.println("ButtonCommand executed");
		}
		
	    public boolean isExecutable() { return true; }  
	}
	
	public class ButtonCommand2 {}	
	
	public class Printer { 
		assumed Printer();
	    public void println(String s) {
	        System.out.println(s);
	    }
	}
	
	
	
}