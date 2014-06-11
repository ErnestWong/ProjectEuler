// answer is : 9110846700

import java.math.BigInteger;

public class Problem48{
    static void doproblem(){
		BigInteger sum = BigInteger.ZERO;
		for(int i = 1; i < 1000; i++){
			BigInteger bigi = BigInteger.valueOf(i);
			sum = sum.add(bigi.pow(i));
		}
		
		String s = sum.toString();
		String ans = s.substring(s.length() - 10, s.length());
		System.out.println("The answer is: " + ans);
	}
	
	public static void main(String[] args){
		long startTime = System.nanoTime();
        doproblem();
    	long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
	}
}
