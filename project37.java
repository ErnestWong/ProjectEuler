import java.util.*;
public class Problem47{
    
	public static Set<Integer> primes = new HashSet<Integer>();
	
	private static boolean firstCheck(int n){
		if(n == 3 || n == 5 || n == 7) return true;
		else return false;
	}
	
	public static boolean isTruncatable(int n){
		int size = (int)Math.floor(Math.log10(n)) + 1;
		int[] digits = new int[size];
		for(int i = 0; i < size; i++){
			digits[i] = n % 10;
			n = n / 10;
		}
		if(!firstCheck(digits[0]) || !firstCheck(digits[size - 1])) return false;
		
		int lefttrunc = size;
		while(lefttrunc > 0){
			String s = "";
			for(int i = lefttrunc - 1; i >= 0; i--){
				s = s +"" +  digits[i];
			}
			int n1 = Integer.parseInt(s);
			if(!primes.contains(n)) return false;
			
			lefttrunc--;
		}
		
		int righttrunc = 0;
		while(righttrunc < size){
			String t = "";
			for(int j = size - 1; j >= righttrunc; j--){
				t = t + digits[j] + "";
			}
			int n2 = Integer.parseInt(t);
			if(!primes.contains(n2)) return false;
			righttrunc++;
		}
		return true;
	}
	
	public static boolean isPrime(int n){
    	for(int i = 3; i * i <= (n + 1); i +=2){
			if(n % i == 0) return false;
		}
		return true;
	}
	
	
	private static void doproblem(){
		int count = 0; 
		int sum = 0;
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		
		int pcount = 11;
		while(count < 4){
			if(isPrime(pcount)){
				primes.add(pcount);
				if(isTruncatable(pcount)){
					count++;
					sum += pcount;
				}
			}
			
			pcount++;
		}
		
		System.out.println("answer is: " + sum + " " + count);
	}
	
	public static void main(String[] args){
		doproblem();
	}
}
