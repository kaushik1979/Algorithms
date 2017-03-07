package com.corejava;

public class SystemExitFinally {

	public static void main(String... argv) throws Exception {
		
		try {
			System.out.println("Throwing an exception");
			System.exit(1);
			throw new Exception("Throwing new exception ...");
		} catch(Exception e) {
			System.out.println("Caught an exception");
		} finally {
			System.out.println("Executing finally block ...");
		}
		
	}
	
}
