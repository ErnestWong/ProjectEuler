//anaswer is 40730
public class Problem34{
    
    //returns factorial
	static int factorial(int n){
		int prod = 1;
		for(int i = n; i > 1; i--){
			prod = prod *i;
		}
		return prod;
	}
	
    //determine whether factorial of sum of digits equals number
	static boolean isDigFact(int n){
		int sum = 0;
        int s = n;
		while(n > 0){
			sum += factorial(n % 10);
			n = n / 10;
		}
		
		if(s == sum) return true;
		else return false;
	}
	

	static void doproblem(){
		int sum = 0;
        //upper limit is 9!*7 since 9!*8 cannot make an 8 digits number
		for(int i = 3; i < 2540160; i++){
			if(isDigFact(i)) {
                sum += i;
                
			}    
		}
        System.out.println(sum);
	}
	
	public static void main(String[] args){
	    long startTime = System.nanoTime();
        doproblem();
    	long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
    }
    
}
