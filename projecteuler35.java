import java.util.*;

public class Problem35{
    public static boolean isPrime(int n){
    	for(int i = 3; i * i <= (n + 1); i +=2){
			if(n % i == 0) return false;
		}
		return true;
	}
	
	public static boolean isCircular(Set<Integer> hashset, int n){
		boolean isCircular = true;
		int size = (int)Math.floor(Math.log10(n)) + 1;
		int[] digits = new int[size];
		
		for(int i = 0; i < size; i++){
			digits[i] = n % 10;
			n = n / 10;
		}
		
		for(int count = 0; count < size; count++){
			int tmp = digits[size - 1];
			for(int j = 0; j < size - 1; j++){
				digits[j + 1] = digits[j];
			}
			digits[0] = tmp;
				
			String str = "";
			for(int s = 0; s < digits.length; s++){
				str = str + "" + digits[s] + "";
			}
			int num = Integer.parseInt(str);
			if(!hashset.contains(num)) return false;
		}
		return true;
	}
	
	public static void doproblem(){
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for(int i = 3; i < 1000000; i+=2){
			if(isPrime(i)) primes.add(i);
		}
	
	    System.out.println(primes.size());
		Set<Integer> primeset = new HashSet<Integer>(primes);
		int count = 0;
		for(int j = 0; j < primes.size(); j++){
			if(isCircular(primeset, primes.get(j))){
				count++;
				System.out.println(primes.get(j));
			}
		}
        System.out.println("answer is: " + count);
	}
	
	public static void main(String[] args){
		doproblem();
	}
}
