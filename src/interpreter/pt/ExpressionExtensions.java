template ExpressionExtensions {
	
	inst BasicExpressions;

	interface BooleanExpression adds {

		/**
	     * Replaces a variable with an <i>Expression</i>
	     *
	     * @param name the name of the variable
	     * @param exp the <i>Expression</i> to replace the variable
	     * @return a copy of this <i>Expression</i> with the variable replaced
	     */

		public BooleanExpression replace(String name, BooleanExpression exp);


	    /**
	     * Copies this <i>Expression</i>
	     *
	     * @return the copied <i>Expression</i>
	     */
		public BooleanExpression copy();
	}	

	class AndExpression adds {

		public AndExpression(BooleanExpression op1, BooleanExpression op2) {
			tsuper[BasicExpressions.AndExpression](op1, op2);
		}

	    /**
	     * Replaces a variable with an <i>Expression</i>. 
	     *
	     * @param name the name of the variable
	     * @param exp the <i>Expression</i> to replace the variable
	     * @return a copy of this <i>Expression</i> with the variable replaced
	     */
		public BooleanExpression replace(String name, BooleanExpression exp) {
			return new AndExpression(expression1.replace(name, exp), expression2.replace(name,exp));
		}

	    /**
	     * Copies this <i>Expression</i>
	     *
	     * @return the copied <i>Expression</i>
	     */
		public BooleanExpression copy() {
			return new AndExpression(expression1.copy(), expression2.copy());
		}                                            

	}
	
	class BooleanConstant adds {

		public BooleanConstant(boolean value) {
			tsuper[BasicExpressions.BooleanConstant](value);
		}

	    /**
	     * Replaces a variable with an <i>Expression</i>. 
	     * Has no effect on constants.
	     *
	     * @param name the name of the variable
	     * @param exp the <i>Expression</i> to replace the variable
	     * @return the unchanged expression
	     */
		public BooleanExpression replace(String name, BooleanExpression exp) {
			return this;  
		}

	    /**
	     * Copies this <i>Expression</i>
	     *
	     * @return the copied <i>Expression</i>
	     */
		public BooleanExpression copy() {
			return new BooleanConstant(value);
		}
	}
	
	class OrExpression adds {

		public OrExpression(BooleanExpression op1, BooleanExpression op2) {
			tsuper[BasicExpressions.OrExpression](op1, op2);		
		}

	    /**
	     * Replaces a variable with an <i>Expression</i>. 
	     *
	     * @param name the name of the variable
	     * @param exp the <i>Expression</i> to replace the variable
	     * @return a copy of this <i>Expression</i> with the variable replaced
	     */
		public BooleanExpression replace(String name, BooleanExpression exp) {
			return new OrExpression(expression1.replace(name, exp), expression2.replace(name,exp));
		}

	    /**
	     * Copies this <i>Expression</i>
	     *
	     * @return the copied <i>Expression</i>
	     */
		public BooleanExpression copy() {
			return new OrExpression(expression1.copy(), expression2.copy());
		}
	}
	
	class VariableExpression adds {

		public VariableExpression(String name) {
			tsuper[BasicExpressions.VariableExpression](name);
		} 

	    /**
	     * Replaces a variable with an <i>Expression</i>. 
	     *
	     * @param name the name of the variable
	     * @param exp the <i>Expression</i> to replace the variable
	     * @return a copy of this <i>Expression</i> with the variable replaced
	     */
		public BooleanExpression replace(String name, BooleanExpression exp) {
			if (name.equals(this.name)) {
				return exp.copy();
			} else {
				return new VariableExpression(this.name);
			}
		}

	    /**
	     * Copies this <i>Expression</i>
	     *
	     * @return the copied <i>Expression</i>
	     */
		public BooleanExpression copy() {
			return new VariableExpression(name);
		}
	}
	
	
	class NotExpression adds {
		
		public NotExpression(BooleanExpression exp) {
			tsuper[BasicExpressions.NotExpression](exp);
		}

	    /**
	     * Replaces a variable with an <i>Expression</i>. 
	     *
	     * @param name the name of the variable
	     * @param exp the <i>Expression</i> to replace the variable
	     * @return a copy of this <i>Expression</i> with the variable replaced
	     */
		public BooleanExpression replace(String name, BooleanExpression exp) {
			return new NotExpression(this.exp.replace(name, exp));
		}

	    /**
	     * Copies this <i>Expression</i>
	     *
	     * @return the copied <i>Expression</i>
	     */

		public BooleanExpression copy() {
			return new NotExpression(exp.copy());
		}		
	}

}