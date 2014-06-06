import java.util.Set;
import java.util.HashSet;
//answer is 748317
public class Problem37{
    
	public static Set<Integer> primes = new HashSet<Integer>();

	/**
	 * preliminary check if first and last digit of number is prime
	 * (reduces the number of candidates and speeds up program)
	 * @param n
	 * @return
	 */
	private static boolean firstCheck(int n){
		if(n == 2 || n == 3 || n == 5 || n == 7) return true;
		else return false;
	}

	/**
	 * checks if number is truncatable
	 * @param n
	 * @return
	 */
	public static boolean isTruncatable(int n){
		//split number into digits array
		int size = (int)Math.floor(Math.log10(n)) + 1;
		int[] digits = new int[size];
		for(int i = 0; i < size; i++){
			digits[i] = n % 10;
			n = n / 10;
		}
		
		//preliminary check, returns false if fails
		if(!firstCheck(digits[0]) || !firstCheck(digits[size - 1])) return false;

		//truncates left most digits and checks if it is in list of primes
		int lefttrunc = size;
		while(lefttrunc > 0){
			String s = "";
			for(int i = lefttrunc - 1; i >= 0; i--){
				s = s +"" +  digits[i];
			}
			int n1 = Integer.parseInt(s);
			if(!primes.contains(n1)) return false;

			lefttrunc--;
		}

		//truncates right most digits and checks if it is in list of primes
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
		
		//returns true if the tests passed
		return true;
	}

	public static boolean isPrime(int n){
    	for(int i = 3; i * i <= (n + 1); i+=2){
			if(n % i == 0) return false;
		}
		return true;
	}


	private static void doproblem(){
		int count = 0; 
		int sum = 0;
		
		//add single digit primes initially
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);

		//int to keep track of current counter
		int pcount = 11;
		
		//loop through array until 11 truncatable primes are found
		while(count < 11){
			if(isPrime(pcount)){
				primes.add(pcount);
				if(isTruncatable(pcount)){
					count++;
					sum += pcount;
				}
			}

			pcount+=2;
		}

		System.out.println("answer is: " + sum );
	}

	public static void main(String[] args){
		long startTime = System.nanoTime();
		doproblem();
		long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
	}
}
