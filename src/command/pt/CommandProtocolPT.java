import java.util.WeakHashMap;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Iterator;

template CommandProtocolPT {
	
	
	public interface CommandReceiver { }    
	
	/**
	 * This interface is implemented by <i>Command</i> objects.
	 * 
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 */
	public interface Command { 

	    /**
	     * Executes the command.
	     *
	     * @param receiver the object this command is manipulating.
	     */
	    public void executeCommand(CommandReceiver receiver);

	    /**
	     * Queries the command's executable status. This interface method is
	     * optional (default: all commands are excutable); a default 
	     * implementation is provided by the abstract CommandProtocol aspect.
	     *
	     * @returns a boolean indicating whether the command is excutable.
	     */
	    public boolean isExecutable();
		
	}
	
	
	/**
	 * This interface is used by extending aspects to say what types
	 * can be Invokers (i.e. senders of an executeCommand() call).
	 * This role is assigned by concrete sub-aspects of the <code>CommandProtocol
	 * </code> pattern aspect.
	 * 
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/17/04
	 * 
	 * @see CommandProtocol
	 */
	public class CommandInvoker {
	
		///////////////////////////////////////
		// Command Execution via PC & advice //
		///////////////////////////////////////


	    /**
	     * The join points after which to execute the command.
	     * This replaces the normally scattered <i>Command.execute()</i> calls.
	     *
	     * @param invoker the object invoking the command
	     */

	    protected tabstract pointcut commandTrigger();
		
		// new decl instead of hashmaps etc:
		private Command command = null;
		

	    /**
	     * Calls <code>executeCommand()</code> when the command is triggered. 
	     *
	     * @param invoker the object invoking the command
	     */ 
/*	    advice executeCommand after commandTrigger() { 
	        Command command = getCommand(invoker);
	    	if (command != null) {
	    	    CommandReceiver receiver = getReceiver(command);
	        	command.executeCommand(receiver);
	        } else {
	            // Do nothing: This Invoker has no associated command
	        }
	    }
*/	
		////////////////////////////////
		// Invoker -> Command mapping //
		////////////////////////////////

	    /**
	     * stores the mapping between CommandInvokers and Commands
	     */
	    // We don't need this: private WeakHashMap mappingInvokerToCommand = new WeakHashMap();

	    /**
	     * Sets a new command for an invoker
	     *
	     * @param invoker the object which will invoke the command
	     * @param command the command to be set
	     * @return the former command
	     */   
	    public Object setCommand(Command command) { 
	    	return this.command = command;
	    }

	    /**
	     * Removes a command from an invoker
	     *
	     * @param invoker the object which will no longer invoke the command
	     * @param command the command to be removed
	     * @return the former command
	     */   

	    public Object removeCommand() { 
	    	return setCommand(null); 
	    }


	    /**
	     * Returns the command for an invoker
	     *
	     * @param invoker the object for which to return the command 
	     * @return the current command for the invoker
	     */   
	    public Command getCommand() { 
	    	return command;
	    }

		/////////////////////////////////
		// Command -> Receiver mapping //
		/////////////////////////////////

	   /**
	     * stores the mapping between Coammnds and Receivers
	     */


	    /**
	     * Sets a new receiver for a command
	     *
	     * @param command the command to be set
	     * @param receiver the object to be manipulated by the command's 
	     *        execute() method
	     * @return the former receiver
	     */   
	    public Object setReceiver(Command command, CommandReceiver receiver) { 
	    	return ReceiverMapping.mappingCommandToReceiver.put(command, receiver); 
	    }

	    /**
	     * Returns the receiver for a particular command
	     *
	     * @param invoker the object for which to return the command 
	     * @returns the current command for the invoker
	     */   
	    public CommandReceiver getReceiver(Command command) { 
	    	return (CommandReceiver) ReceiverMapping.mappingCommandToReceiver.get(command); 
	    }
	
		
	}


	class ReceiverMapping {
		
		static WeakHashMap mappingCommandToReceiver = new WeakHashMap();
		
	}


	// public class CommandProtocolImpl {
	// 
	// 
	// 
	// 
	// 	//////////////////////////////////
	// 	// setCommand() via PC & advice //
	// 	//////////////////////////////////
	// 
	// 	    /**
	// 	     * The join points after which to set a command for an invoker.
	// 	     * This replaces the normally scattered <i>Invoker.add(Command)</i> calls.
	// 	     * The pointcut is provided in addition to the setCommand() method above,
	// 	     * to allow all pattern code to be removed from concrete invokers. 
	// 	     *
	// 	     * This PC is non-abstract, to make it optional for sub-aspcects to define
	// 	     * it.
	// 	     *
	// 	     * @param invoker the invoker to attach the command to
	// 	     * @param command the command to be attached to the invoker
	// 	     */
	// 	    protected pointcut setCommandTrigger(CommandInvoker invoker, Command command);   
	// 
	// 
	// 	    /**
	// 	     * Calls <code>addCommand()</code> when a command should be set. 
	// 	     *
	// 	     * @param invoker the invoker to attach the command to
	// 	     * @param command the command to be attached to the invoker
	// 	     */ 
	// 	    after (CommandInvoker invoker, Command command): 
	// 	    	setCommandTrigger(invoker, command) {                          
	// 	    	if (invoker != null) {
	// 	        	setCommand(invoker, command);
	// 	    	} else {
	// 	    		// If the invoker is null, the command cannot be set. 
	// 	    		// Either ignore this case or throw an exception  
	// 	    	}
	// 	    }
	// 
	// 	/////////////////////////////////////
	// 	// removeCommand() via PC & advice //
	// 	/////////////////////////////////////
	// 
	// 	    /**
	// 	     * The join points after which to remove a command from an invoker.
	// 	     * This replaces the normally scattered <code>Invoker.remove(Command)
	// 	     * </code> calls.
	// 	     * 
	// 	     * The pointcut is provided in addition to the <code>removeCommand()
	// 	     * </code> method above, to allow all pattern code to be removed from 
	// 	     * concrete invokers.
	// 	     *
	// 	     * This PC is non-abstract, to make it optional for sub-aspcects to define
	// 	     * it.
	// 	     *
	// 	     * @param invoker the invoker to remove the command from
	// 	     */
	// 
	// 	    protected pointcut removeCommandTrigger(CommandInvoker invoker);   
	// 
	// 	    /**
	// 	     * Calls <code>removeCommand()</code> when a command should be removed. 
	// 	     *
	// 	     * @param invoker the invoker to remove the command from
	// 	     */ 
	// 
	// 	    after(CommandInvoker invoker): removeCommandTrigger(invoker) {                          
	// 	    	if (invoker != null) {
	// 	        	removeCommand(invoker);
	// 	    	} else {
	// 				// If the invoker is null, the command cannot be removed. 
	// 				// Either ignore this case or throw an exception  
	// 	    	}
	// 	    }
	// 
	// 	////////////////////////////////////////////
	// 	// Command default method implementations //
	// 	////////////////////////////////////////////
	// 
	// 	    /**
	// 	     * Provides a deault implementation for the isExecutable method defined
	// 	     * in the Command interface. 
	// 	     *
	// 	     * @return true (default implementation). Can be overwritten by concrete
	// 	     * aspects or even concrete commands.
	// 	     */ 
	// 
	// 	    public boolean Command.isExecutable() {
	// 	        return true;
	// 	    }
	//  }
	
}