import java.util.*;

template BasicExpressions {
	
	/**
	 * Declares the <i>AbstractExpression</i> interface for boolean expressions.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */

	public interface BooleanExpression {


	    /**
	     * Evaluates this expression in the given <i>VariableContext</i>
	     *
	     * @param c the context to evaluate the <i>Expression</i> in
	     * @return the boolean value of the <i>Expression</i>
	     */
		public boolean evaluate(VariableContext c);
	
	    
	}
	
	
	/**
	 * Implements AND expressions for booleans. This is a concrete boolean 
	 * <i>NonterminalExpression</i>
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */

	public class AndExpression implements BooleanExpression {

	    /**
	     * stores the first part of this AND <i>Expression</i>
	     */

		protected BooleanExpression expression1;

	    /**
	     * stores the second part of this AND <i>Expression</i>
	     */

		protected BooleanExpression expression2; 

	    /** 
	     * Creates a new AND <i>Expression</i> with the given parts
	     *
	     * @param op1 the first <i>Expression</i>
	     * @param op1 the second <i>Expression</i>
	     */	                    
		
		assumed AndExpression(BooleanExpression op1, BooleanExpression op2);
		public AndExpression(BooleanExpression op1, BooleanExpression op2) {
			this.expression1 = op1;
			this.expression2 = op2;
		}

	    /**
	     * Evaluates this <i>Expression</i> in the given <i>Context</i>
	     *
	     * @param c the context to evaluate the <i>Expression</i> in
	     * @return the boolean value of the <i>Expression</i>
	     */

	 	public boolean evaluate(VariableContext c) {
			return (expression1.evaluate(c) && expression2.evaluate(c)); 
		}
	}
	
	/**
	 * Implements boolean constants, a concrete boolean <i>TerminalExpression</i>
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */

	public class BooleanConstant implements BooleanExpression {  

	    /**
	     * the value of this constant
	     */

		protected boolean value;

	    /** 
	     * Creates a new constant with the given value  
	     *
	     * @param value the value this constant should represent
	     */	 
		assumed BooleanConstant(boolean value);
		public BooleanConstant(boolean value) {
			this.value = value;
		}

	    /**
	     * Evaluates this <i>Expression</i> in the given <i>Context</i>.
	     *
	     * @param c the context to evaluate the <i>Expression</i> in
	     * @return the boolean value of the <i>Expression</i>
	     */

		public boolean evaluate(VariableContext c) {
			return value;
		}
	}
	
	/**
	 * Implements an exception that gets raised when the interpreter
	 * runs into errors.
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */

	public class ExpressionException extends external RuntimeException {

	    /**
	     * Creates a new ExpressionException with the given message
	     *
	     * @param s the exception message
	     */

		assumed ExpressionException(String s);
		// public ExpressionException(String s) {
		// 	super(s);
		// }
	}
	
	/**
	 * Implements negation for booleans expressions. This is a concrete boolean
	 * <i>NonterminalExpression</i>
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */

	public class NotExpression implements BooleanExpression {

	    /** 
	     * the <i>Expression</i> this <i>Expression</i> negates
	     */

		protected BooleanExpression exp = null;

		/**
		 * Creates a new NOT <i>Expression</i> negating the argument expression   
		 *
		 * @param exp the <i>Expression</i> to negate  
		 */

		assumed NotExpression(BooleanExpression exp);
		public NotExpression(BooleanExpression exp) {
			this.exp = exp;
		}

	    /**
	     * Evaluates this <i>Expression</i> in the given 
	     * <i>Context</i>
	     *
	     * @param c the context to evaluate the <i>Expression</i> in
	     * @return the boolean value of the <i>Expression</i>
	     */

		public boolean evaluate(VariableContext c) {
			return (! exp.evaluate(c)); 
		}
	}
	
	/**
	 * Implements an OR <i>Expression</i> for booleans. 
	 * This is a concrete boolean <i>NonterminalExpression</i>
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */

	public class OrExpression implements BooleanExpression {

	    /**
	     * stores the first part of this OR <i>Expression</i>
	     */

		protected BooleanExpression expression1;

	    /**
	     * stores the second part of this OR <i>Expression</i>
	     */

		protected BooleanExpression expression2; 

	    /** 
	     * Creates a new OR <i>Expression</i> with the given parts
	     *
	     * @param op1 the first <i>Expression</i>
	     * @param op1 the second <i>Expression</i>
	     */	                    
		assumed OrExpression(BooleanExpression op1, BooleanExpression op2);
		public OrExpression(BooleanExpression op1, BooleanExpression op2) {
			this.expression1 = op1;
			this.expression2 = op2;
		}

	    /**
	     * Evaluates this <i>Expression</i> in the given <i>Context</i>
	     *
	     * @param c the context to evaluate the <i>Expression</i> in
	     * @return the boolean value of the <i>Expression</i>
	     */

		public boolean evaluate(VariableContext c) {
			return (expression1.evaluate(c) || expression2.evaluate(c)); 
		}
	}
	
	/**
	 * Implements a <i>VariableContext</i> for the interpretation of boolean 
	 * expressions<p>
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 * 
	 * @see BooleanExpression
	 */

	public class VariableContext { 

	    /**
	     * stores the mapping between variable names and values
	     */

		protected Hashtable assignments = new Hashtable();

	    /**
	     * Returns the current value for a variable
	     *
	     * @param name the name of the variable
	     * @returns the value of the variable
	     */

		public boolean lookup(String name) {
			Boolean value = (Boolean) assignments.get(name);
			if (value == null) {
				throw new ExpressionException("No variable \""+name+"\" declared.");
			}
			return value.booleanValue();
		}  

		/**
		 * Assigns a boolean value to a <code>VariableExpression</code>
		 *
		 * @param varExp the varaible expression to assign a value to
		 * @param bool the boolean value to assign 
		 */

		public void assign(VariableExpression varExp, boolean bool) {
			assignments.put(varExp.getName(), new Boolean(bool));
		}
	}
	
	/**
	 * Implements a variable expression for booleans. This is a concrete 
	 * boolean <i>NonterminalExpression</i>
	 * expression
	 *
	 * @author  Jan Hannemann
	 * @author  Gregor Kiczales
	 * @version 1.1, 02/11/04
	 */

	public class VariableExpression implements BooleanExpression {

	    /** 
	     * the name of the variable this object represents
	     */

		protected String name = null;  

		/**
		 * Creates a new <code>VariableExpression</code> with the given name   
		 *
		 * @param name the name of the new variable 
		 */
		assumed VariableExpression(String name);
		public VariableExpression(String name) {
			this.name = name;
		} 

		/**
		 * Accessor for the variable's name
		 *
		 * @return the name of the variable
		 */

		public String getName() {
			return name;
		}

	    /**
	     * Evaluates this <i>Expression</i> in the given <i>Context</i>
	     *
	     * @param c the context to evaluate the <i>Expression</i> in
	     * @return the boolean value of the <i>Expression</i>
	     */

		public boolean evaluate(VariableContext c) {
			return c.lookup(name);
		}

		// 	    /**
		// 	     * Replaces a variable with an <i>Expression</i>
		// 	     *
		// 	     * @param name the name of the variable
		// 	     * @param exp the <i>Expression</i> to replace the variable
		// 	     * @return a copy of this <i>Expression</i> with the variable replaced
		// 	     */
		// 
		// public BooleanExpression replace(String name, BooleanExpression exp) {
		// 	if (name.equals(this.name)) {
		// 		return exp.copy();
		// 	} else {
		// 		return new VariableExpression(this.name);
		// 	}
		// }
		// 
		// 	    /**
		// 	     * Copies this <i>Expression</i>
		// 	     *
		// 	     * @return the copied <i>Expression</i>
		// 	     */
		// 
		// public BooleanExpression copy() {
		// 	return new VariableExpression(name);
		// }		
	}
}