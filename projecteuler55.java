//answer is 249
public class Problem55{
    
	
	/**
	*method to check if num is lychrel
	*/
	static boolean isLychrel(long n){
		int count = 0;
		long sum = n;
		
    //sum must be palindrome within 50 iterations, otherwise return true
		while(count < 49){
			long reverse = reverse(sum);
			if(sum == reverse && sum != n) return false;
			else{
				sum += reverse;
				count++;
			}
		}
		
		return true;
	}
	
  	/**
	  *method to return reverse of num
	  */ 
	  static long reverse(long n){
		long reverse = 0;
		while(n > 0){
			reverse = reverse * 10;
			reverse += n % 10;
			n = n /10;
		}
		
		return reverse;
	}
	  
    static void doproblem(){
        int count = 0;
    	for(int i = 1; i < 10000; i++){
			if(isLychrel(i)){
				count++;
			}
		}
		
		System.out.println("The answer is: " + count);
	}
    
	public static void main(String[] args){
		long startTime = System.nanoTime();
        doproblem();
		long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
	}
}
