template StringDecorators {
	
	class BracketDecorator {
		String decorateBracket(String s) {
	        s = "[" + s + "]";					// Decorates the string
	        return s;
	    }
	}

	class StarDecorator {
		String decorateStar(String s) {
	        s = "***" + s + "***";	 			// Decorates the string
	        return s;
	    }
	}
}