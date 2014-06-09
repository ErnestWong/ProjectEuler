//answer is 4782

import java.math.BigInteger;
public class Problem25{
    
	static void doproblem(){
        //big integer representing 1000 digits
		BigInteger lim10 = BigInteger.valueOf(10).pow(999);
		
        //start the fibonacci sequence (term start at 3)
		BigInteger x = BigInteger.valueOf(1);
		BigInteger y = BigInteger.valueOf(1);
		BigInteger z = x.add(y);
		int term = 3;
        
        //continue fib sequence until 1000 digits is reached
		while(z.compareTo(lim10) < 0){
			x = y;
			y = z;
			z = x.add(y);
			term++;
		}
		System.out.println("The answer is: " + term);
	}
    
    public static void main(String[] args){
        long startTime = System.nanoTime();
        doproblem();
    	long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
    }
}
