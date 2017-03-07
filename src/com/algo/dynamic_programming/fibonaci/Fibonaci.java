package com.algo.dynamic_programming.fibonaci;

/**
 *                						fib(n)
 *      			fib(n-1)            		 			fib(n-2)
 * 		fib(n-2)     		fib(n-3)  				fib(n-3)      		fib(n-4)
 * fib(n-3)    fib(n-4)   fib(n-4)  fib(n-5)	fib(n-4) fib(n-5) fib(n-5)    fib(n-6)
 * @author priyankasharma
 *
 */

public class Fibonaci {
	
	
	public long fib(long n) {
		if(n<=1) return 1;
		return fib(n-1) + fib(n-2);
	}
	
	
}
