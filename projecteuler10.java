
//Answer: 142913828922

//used my own implementation of Sieve of Eratosthenes algorithm
class ProjectEuler10 {


	public static int[] findPrimes(int n){
		//boolean array for all the numbers up to n, set default true
		boolean[]primes = new boolean[n + 1];
		for(int i = 2; i < primes.length; i++){
			primes[i] = true;
			
		}
		
		//count variable to find how many primes up to n
		int count = primes.length - 2;
		
		//up to sqrt(n), set multiples of j to false 
		for(int j = 2; j * j <= n; j++){
			if(primes[j]){
				
				for(int k = 2 * j; k <= n; k += j){
					
					if(primes[k]){
						primes[k] = false;
						count--;
						
					}
				}
			}
		}
		
		
		//find all the numbers still evaluated to true and add to array
		int[] arrayprime = new int[count];
		int index = 2;
		for(int c = 0; c < arrayprime.length; c++){
			while(!primes[index]) index++;
			arrayprime[c] = index;
			index++;
			
		}
		
		return arrayprime;
	}
	public static void main(String[] args){
		long startTime = System.nanoTime();
		int[] primes = findPrimes(2000000);
		
		long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
	
		long sum = 0;
		for(int i = 0; i < primes.length; i++){
			sum += (long)primes[i];
		}
		System.out.println(sum);
	}
}
