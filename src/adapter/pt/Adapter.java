template Adapter {
	
	inst Adaptee;
	
	class SystemOutPrinter adds implements Target.Writer {
		
		public void write(String s) {
			printToSystemOut(s);
		}	
	}
}