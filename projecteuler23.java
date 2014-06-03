import java.util.*;

public class Problem23 {

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
		Set<Integer> sortedSet = new HashSet<Integer>(sortedAbundant);
		int sum = 0;	
		for (int i = 0; i < 28123; i++) {
			boolean noSum = true;
			for(int a = 0; a < sortedAbundant.size(); a++){
				int diff = i - sortedAbundant.get(a);
				if(sortedSet.contains(diff)) noSum = false;
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
