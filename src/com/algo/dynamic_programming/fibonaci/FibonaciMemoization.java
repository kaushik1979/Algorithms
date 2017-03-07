package com.algo.dynamic_programming.fibonaci;

import java.util.Map;


/**
 *                						fib(n) -calc
 *      			fib(n-1) -calc            		 			fib(n-2)
 * 		fib(n-2) -calc    		fib(n-3)-memo  				fib(n-3)      		fib(n-4)
 * fib(n-3) -calc    fib(n-4)-memo   fib(n-4)  fib(n-5)	fib(n-4) fib(n-5) fib(n-5)    fib(n-6)
 * @author priyankasharma
 *
 */

public class FibonaciMemoization {
	
	
	public long fib(long n, Map<Long, Long> memo) {
		
		if(memo.containsKey(n)) return memo.get(n);
		
		if(n<=1) return 1;
		
		long fib_val = fib(n-1, memo) + fib(n-2, memo);
		memo.put(n, fib_val);
		
		return fib_val;
	}
}
