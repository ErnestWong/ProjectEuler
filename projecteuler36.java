// answer is 872187

public class Problem36{
    
	//check if palindrome
	private static boolean isPalindrome(int n){
		//store digits of number in array
		int size = (int) Math.floor(Math.log10(n)) + 1;
		int[] array = new int[size];
		int index = 0;
		while(n > 0){
			int digit = n % 10;
			array[index] = digit;
			n = n / 10;
			index++;
		}

		//compare first and last element for equality; 
		//increment head and decrement tail if equal, else return false
		int head = 0;
		int tail = size -1;
		while(head < tail){
			if(array[head] != array[tail]) return false;

			head++;
			tail--;
		}
		return true;
	}
	
    //check if binary is palindrome
	static boolean isBinaryPalindrome(int n){
		String binary = Integer.toBinaryString(n);
		int head = 0;
		int tail = binary.length() - 1;
		
		while(head < tail){
			if(binary.charAt(head) != binary.charAt(tail)) return false;
			head++;
			tail--;
		}
		
		return true;
	}
    
	static void doproblem(){
		int sum = 0;
        //since no leading zeros can be palindrome, only have to check odd numbers
		for(int i = 1; i < 1000000; i+=2){
			if(isPalindrome(i)){
				if(isBinaryPalindrome(i)) sum += i;
			}
		}
		
		System.out.println("The answer is : " + sum);
	}
	
	public static void main(String[] args){
		long startTime = System.nanoTime();
        doproblem();
    	long endTime = System.nanoTime();
		double duration = (endTime - startTime) / Math.pow(10, 6);
		System.out.printf("%f ms", duration);
	}
}
