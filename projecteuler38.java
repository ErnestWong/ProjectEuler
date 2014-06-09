//answer is 932718654

import java.util.List;
import java.util.Set;
import java.util.HashSet;
public class Problem38 {
    
    //method to concatenate integer to existing string
    static String concat(String base, int num, int multBy){
		String ret = base + num * multBy;
		return ret;
	}
	
    //method to check if number is pandigital
	static boolean isPandigital(long n){
		Set<Integer>digits = new HashSet<Integer>();
		Set<Integer> correct = new HashSet<Integer>();
		int size = (int)Math.floor(Math.log10(n)) + 1;
		for(int i = 1; i <= size; i++){
			correct.add(i);
		}
		//convert a, b and product to digits and store in list
		while(n > 0){
			digits.add((int)(n % 10));
			n = n / 10;
		}
		
        if(digits.contains(0) || !digits.equals(correct)) 
			return false;
		else 
			return true;
	}
	static void doproblem(){
		long maxPand = 0;
        
        //max number i is 9999 because concatenation of any 5 digit number 
        //will result in a 10 digit number which is too large to be pandigital
		for(int i = 9999; i >= 2; i--){
			int concatsize = 0;
			int n = 1;
			String num = "";
			
			while(concatsize < 9){
				num = concat(num, i, n);
				concatsize = num.length();
				n++;
			}
			
            //return first pandigital number
			long pand = Long.parseLong(num);
			if(isPandigital(pand)){
                maxPand = pand;
                break;
			}
		}
		
		System.out.println("answer is: " + maxPand);
	}
    
    public static void main(String[] args){
        long startTime = System.nanoTime();
        doproblem();
		long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
    }
}
