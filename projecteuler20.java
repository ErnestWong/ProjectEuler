//answer is 648

import java.math.BigInteger;

public class Problem20{
    static void doproblem(){
        
        BigInteger one = BigInteger.valueOf(1);   //bigInteger constant for ONE 
		BigInteger sum = BigInteger.ZERO;         //initial sum of digits
		BigInteger num = BigInteger.valueOf(100); //number to hold factorial
		BigInteger count = BigInteger.valueOf(99);
        
        //find 100!
		while(count.compareTo(one) > 0){
			num = num.multiply(count);
			count = count.subtract(one);
		}
        
		//add sum of digits
		while(num.compareTo(BigInteger.ZERO) > 0){
			sum = sum.add(num.mod(BigInteger.TEN));
			num = num.divide(BigInteger.TEN);
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
