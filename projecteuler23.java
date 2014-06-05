import java.util.*;

//Answer: 4179871
public class Problem23 {
	
	/**
	 *method determines if number is abundant (sum of divisors greater than number)
	**/
	public static boolean isAbundant(int n) {
		int divisorsum = 0;

		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0)
				divisorsum += i;
		}

		if (divisorsum > n)
			return true;
		else
			return false;
	}

	/**
	 * returns list of sorted abundant numbers (upper bound is 28123)
	**/
	public static List<Integer> findAbundants() {
		List<Integer> abundant = new ArrayList<Integer>();

		for (int i = 1; i <= 28123; i++) {
			if (isAbundant(i))
				abundant.add(i);
		}

		Collections.sort(abundant);
		return abundant;
	}
	
	public static void doproblem() {
		List<Integer> sortedAbundant = findAbundants();
		
		//duplicate list to hashset for faster search
		Set<Integer> sortedSet = new HashSet<Integer>(sortedAbundant);
		int sum = 0;	
		
		//loop through all the numbers up to 28123 as possible numbers that cannot be
		//made from sum of abundant numbers
		for (int i = 0; i < 28123; i++) {
			boolean noSum = true;
			
			//loop through abundant numbers; if a+b = i, where a+b are abundant numbers,
			//then b = i-a should be found in the hashset. If it is not found, then false
			//Using this method with hashset reduces complexity to O(n)
			for(int a = 0; a < sortedAbundant.size(); a++){
				int diff = i - sortedAbundant.get(a);
				if(sortedSet.contains(diff)) 
					noSum = false;
			}

			if (noSum){
				sum += i;
			}
			
		}

		System.out.println("The answer is: " + sum);
	}

	public static void main(String[] args) {
		doproblem();
	}
}
