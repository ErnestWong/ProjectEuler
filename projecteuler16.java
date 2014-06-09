//answer is: 1366

import java.math.BigInteger;

public class Problem16{
    
    public static void doproblem(){
        //num: 2^1000, sum: stores sum of digits
        BigInteger num = BigInteger.valueOf(2).pow(1000);
    	BigInteger sum = BigInteger.valueOf(0);
        
        //biginteger versions of 0 and 10
    	BigInteger ten = BigInteger.valueOf(10);
        BigInteger zero = BigInteger.valueOf(0);
        
        //mod 10 then divide 10 of num to find digit
    	while(!num.equals(zero)){
    		sum = sum.add(num.mod(ten));
    		num = num.divide(ten);
           // System.out.println(num);
    	}
    	
    	System.out.println("The answer is: " + sum);
    }
    
    public static void main(String[] args){
        long startTime = System.nanoTime();
        doproblem();
    	long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
    } 
}
