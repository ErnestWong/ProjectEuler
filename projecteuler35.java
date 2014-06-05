import java.util.*;
// answer is 55
public class Problem35{

	/**
	* this method determines if a number is prime
	**/
    public static boolean isPrime(int n){
        for(int i = 3; i * i <= (n + 1); i += 2){
			if(n % i == 0) return false;
		}
		return true;
	}
	
	/**
	* method determines if number is a circular prime
	**/
	public static boolean isCircular(Set<Integer> hashset, int n){
		//number of digits in n calculated
		int size = (int)Math.floor(Math.log10(n)) + 1;
		
		//store all the digits in digits array
		int[] digits = new int[size];
		for(int i = 0; i < size; i++){
			digits[i] = n % 10;
			n = n / 10;
		}

		//outer for loop to keep track of how many rotations the number has completed
		for(int count = 0; count < size; count++){
		
			//shift all the digits by one (the last element becomes the first)
			//(i.e.: '123' -> '231')
			int tmp = digits[size - 1];
			for(int j = size - 2; j >= 0; j--){
				digits[j + 1] = digits[j];
			}
			digits[0] = tmp;

			//concatenate digits back to a number
			String str = "";
			for(int s = digits.length - 1; s >= 0; s--){
				str = str + "" + digits[s] + "";
			}
			int num = Integer.parseInt(str);
			
			//if the hashset of primes contains the number, then true, else return false
			if(!hashset.contains(num)) return false;
		}
		return true;
	}

	public static void doproblem(){
		
		//find all the primes below 1 million
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for(int i = 3; i < 1000000; i+=2){
			if(isPrime(i)) primes.add(i);
		}

		//transfer list to hashset for faster search
		Set<Integer> primeset = new HashSet<Integer>(primes);
		int count = 0;
		
		//loop through all the primes and keep track of the circular ones
		for(int j = 0; j < primes.size(); j++){
			if(isCircular(primeset, primes.get(j))) count++;
		}
        
        System.out.println("The answer is: " + count);
	}

	public static void main(String[] args){
		doproblem();
	}
}
